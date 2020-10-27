package com.authority.manager.config;

import com.authority.manager.functions.model.SysTestMybatisUser;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * @Auther: yls
 * @Date: 2020/09/13 09:51
 * @Description: 批处理接口：将csv的文件导入到数据库中
 * @Version 1.0
 */
@Configuration
public class CsvBatchJobConfig {
    /**
     * 用来构建job
     */
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    /**
     * 用来构建step
     */
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    /**
     * 持久化
     */
    @Autowired
    DataSource dataSource;

    /**
     * 功能描述: 数据读逻辑
     * 〈配置一个ItemReader：
     *      JdbcPaingItemReader：读取数据库中的数据
     *      StaxEventItemReader：用来读取XML数据
     *      FlatFileItemReader：加载一个普通文件（csv,txt等）
     *  〉
     * @author : yls
     * @date : 2020/09/13 14:55
     * @return : org.springframework.batch.item.file.FlatFileItemReader<com.authority.manager.functions.model.User>
     */
    @Bean
    @StepScope
    FlatFileItemReader<SysTestMybatisUser> itemReader(){
        FlatFileItemReader<SysTestMybatisUser> reader = new FlatFileItemReader<>();
        //设置从第几行开始
        reader.setLinesToSkip(0);
        //设置文件的路径：classPath对应项目的 /src/main/resources
        reader.setResource(new ClassPathResource("data.csv"));
        reader.setLineMapper(new DefaultLineMapper<SysTestMybatisUser>(){{
            /**
             * 设置文件的表头，分隔符
             */
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setNames("username","address","gender","age","email");
                setDelimiter(",");
            }});
            /**
             * 设置对应的实体类
             */
            setFieldSetMapper(new BeanWrapperFieldSetMapper<SysTestMybatisUser>(){{
                setTargetType(SysTestMybatisUser.class);
            }});
        }});
        return reader;
    }

    /**
     * 功能描述:数据写逻辑
     * 〈配置一个ItemWriter：
     *      StaxEventItemWriter：用来写出为XML数据
     *      FlatFileItemWriter：写出为普通文件（csv,txt等）
     *
     *      JpaItemWriter：jpa写出
     *      Neo4jItemWriter：Neo4j写出
     *      MongoItemWriter：MongoDB数据库写出
     *      HibernateItemWriter: hibernate写出
     *      JdbcBatchItemWriter：jdbc利用sql写入关系型数据库
     *  〉
     * @author : yls
     * @date : 2020/09/13 15:00
     * @param
     * @return : org.springframework.batch.item.database.JdbcBatchItemWriter
     */
    @Bean
    JdbcBatchItemWriter jdbcBatchItemWriter(){
        JdbcBatchItemWriter writer = new JdbcBatchItemWriter();
        writer.setDataSource(dataSource);
        writer.setSql("insert into sys_test_mybatis_user(username,address,gender,age,email) "+
                "value(:username,:address,:gender,:age,:email)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
        return writer;
    }

    /**
     * 功能描述:
     * 〈配置一个Step；Step通过stepBuilderFactory进行配置〉
     * @author : yls
     * @date : 2020/09/13 15:05
     * @param
     * @return : org.springframework.batch.core.Step
     */
    @Bean
    Step csvStep(){
        return stepBuilderFactory
                //名称
                .get("csvStep")
                //每读到2条数据执行一次write操作
                .<SysTestMybatisUser, SysTestMybatisUser>chunk(2)
                //配置reader
                .reader(itemReader())
                //配置writer
                .writer(jdbcBatchItemWriter())
                .build();
    }

    /**
     * 功能描述:
     * 〈构建一个Job：通过jobBuilderFactory构建一个job〉
     * @author : yls
     * @date : 2020/09/13 15:08
     * @param
     * @return : org.springframework.batch.core.Job
     */
    @Bean
    Job csvJob(){
        return jobBuilderFactory
                //，名称
                .get("csvJob")
                //每次运行都以新的id运行，确保这次运行了下次还会运行
                .incrementer(new RunIdIncrementer())
                //配置job的Step
                .start(csvStep())
                .build();
    }
}
