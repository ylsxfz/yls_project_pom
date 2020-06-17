
package com.yls.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @Author yls
 * @Description 文件合并的工具类
 * @Date 2020/3/26 14:13
 * @return
 **/
public class FileProcessUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessUtils.class);
	
    public static  void  main(String[] args) throws IOException {
       //定义输出目录
        String FileOut="F:\\FY5_test\\1f54363274ae468ea313690242d93ad7.csv";
        String FileInput = "F:\\FY5_test\\1f54363274ae468ea313690242d93ad7";
        try {
			fileCommine(FileInput, FileOut,"asfasdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * @Author yls
     * @Description 合并文件
     * @Date 2020/3/26 14:13
     * @param fileInputPath 源文件路径
     * @param fileOutPath 目标文件路径
     * @param columns 表头
     * @return void
     **/
	public static void fileCommine(String fileInputPath,String fileOutPath,String columns) throws Exception {
		//读取目录下的每个文件或者文件夹，并读取文件的内容写到目标文字中去
		File inputFile = new File(fileInputPath);
        File[] list = inputFile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				if (!name.endsWith(".crc")) {
					return true;
				}
				return false;
			}
		});
        BufferedWriter bw=new BufferedWriter(new FileWriter(fileOutPath));
        int fileCount = 0;
        int folderConut= 0;
        for(File file : list){
            if(file.isFile()){
                fileCount++;
                BufferedReader br = new BufferedReader(new FileReader(file));
                /**
                 * 写入表头
                 */
                bw.write(columns);
                bw.newLine();
                
                /**
                 * 写入文件内容
                 */
                String line;
                while((line=br.readLine())!=null) {
                    bw.write(line);
                    bw.newLine();
                }
                br.close();
            }else {
                folderConut++;
            }
        }
        bw.close();
        //删除文件
        delFileOrFolder(inputFile);
        LOGGER.info("合并"+fileInputPath+"目录下文件个数为"+fileCount);
	}
	
	/**
	 * @Author yls
	 * @Description 删除文件夹以及文件夹下面的所有文件
	 * @Date 2020/3/26 14:14
	 * @param file 文件
	 * @return boolean
	 **/
	public static boolean delFileOrFolder(File file)throws Exception{
		if (!file.exists()) {
			return false;
		}
		
		if (file.isFile()) {
			return file.delete();
		}else {
			for (File delFile : file.listFiles()) {
				delFileOrFolder(delFile);
			}
		}
		return file.delete();
	}

}
