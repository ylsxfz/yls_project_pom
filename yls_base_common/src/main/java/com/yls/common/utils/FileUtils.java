package com.yls.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author yls
 * @Description 文件相关操作
 * @Date 2020/4/5 9:29
 **/
public class FileUtils {

	/**
	 * @Description下载文件
	 * @param response 请求
	 * @param file 文件
	 * @param newFileName 新的文件名
	 */
	public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
		try {
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			BufferedInputStream bis = new BufferedInputStream(is);
			int length = 0;
			byte[] temp = new byte[1 * 1024 * 10];
			while ((length = bis.read(temp)) != -1) {
				bos.write(temp, 0, length);
			}
			bos.flush();
			bis.close();
			bos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
