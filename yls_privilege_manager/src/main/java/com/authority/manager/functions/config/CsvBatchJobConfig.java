package com.authority.manager.functions.config;

import com.authority.manager.functions.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
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
 * @Description:
 * @Version 1.0
 */
@Configuration
public class CsvBatchJobConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    DataSource dataSource;

    @Bean
    @StepScope
    FlatFileItemReader<User> itemReader(){
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("data.csv"));
        reader.setLineMapper(new DefaultLineMapper<User>(){{
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setNames("id","username","address","gender");
                setDelimiter(",");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>(){{
                setTargetType(User.class);
            }});
        }});
        return reader;
    }

    @Bean
    JdbcBatchItemWriter jdbcBatchItemWriter(){
        JdbcBatchItemWriter writer = new JdbcBatchItemWriter();
        writer.setDataSource(dataSource);
        writer.setSql("insert into user(id,username,address,gender) "+
                "value(:id,:username,:address,:gender)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
        return writer;
    }

    @Bean
    Step csvStep(){
        return stepBuilderFactory.get("csvStep")
                .<User,User>chunk(2)
                .reader(itemReader())
                .writer(jdbcBatchItemWriter())
                .build();
    }

    @Bean
    Job csvJob(){
        return jobBuilderFactory.get("csvJob")
                .start(csvStep())
                .build();
    }
}
