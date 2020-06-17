package com.yls.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author yls
 * @Description IO相关工具类
 * @Date 2020/4/5 9:30
 **/
public class IOUtils {

	/**
	 * @Description 关闭对象，连接
	 * @param closeable
	 */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
