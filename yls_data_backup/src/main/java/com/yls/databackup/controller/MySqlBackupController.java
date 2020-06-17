package com.yls.databackup.controller;


import com.yls.databackup.constants.BackupConstants;
import com.yls.databackup.datasource.BackupDataSourceProperties;
import com.yls.databackup.service.MysqlBackupService;
import com.yls.databackup.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 系统数据备份还原
 * @author Louis
 * @date Jan 15, 2019
 */
@RestController
@RequestMapping("/backup")
public class MySqlBackupController {

	@Autowired
	MysqlBackupService mysqlBackupService;
	@Autowired
	BackupDataSourceProperties properties;

	@GetMapping("/backup")
	public HttpResult backup() {
		String backupFodlerName = BackupConstants.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(BackupConstants.DATE_FORMAT)).format(new Date());
		return backup(backupFodlerName);
	}

	private HttpResult backup(String backupFodlerName) {
		String host = properties.getHost();
		String userName = properties.getUserName();
		String password = properties.getPassword();
		String database = properties.getDatabase();
		String backupFolderPath = BackupConstants.BACKUP_FOLDER + backupFodlerName + File.separator;
		String fileName = BackupConstants.BACKUP_FILE_NAME;
		try {
			boolean success = mysqlBackupService.backup(host, userName, password, backupFolderPath, fileName, database);
			if(!success) {
				HttpResult.error("数据备份失败");
			}
		} catch (Exception e) {
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}
	
	@GetMapping("/restore")
	public HttpResult restore(@RequestParam String name) throws IOException {
		String host = properties.getHost();
		String userName = properties.getUserName();
		String password = properties.getPassword();
		String database = properties.getDatabase();
		String restoreFilePath = BackupConstants.RESTORE_FOLDER + name;
		try {
			mysqlBackupService.restore(restoreFilePath, host, userName, password, database);
		} catch (Exception e) {
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}
	
	@GetMapping("/findRecords")
	public HttpResult findBackupRecords() {
		if(!new File(BackupConstants.DEFAULT_RESTORE_FILE).exists()) {
			// 初始默认备份文件
			backup(BackupConstants.DEFAULT_BACKUP_NAME);
		}
		List<Map<String, String>> backupRecords = new ArrayList<>();
		File restoreFolderFile = new File(BackupConstants.RESTORE_FOLDER);
		if(restoreFolderFile.exists()) {
			for(File file:restoreFolderFile.listFiles()) {
				Map<String, String> backup = new HashMap<>();
				backup.put("name", file.getName());
				backup.put("title", file.getName());
				if(BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
					backup.put("title", "系统默认备份");
				}
				backupRecords.add(backup);
			}
		}
		// 排序，默认备份最前，然后按时间戳排序，新备份在前面
		backupRecords.sort((o1, o2) -> BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1
				: BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 : o2.get("name").compareTo(o1.get("name")));
		return HttpResult.ok(backupRecords);
	}
	
	@GetMapping("/delete")
	public HttpResult deleteBackupRecord(@RequestParam String name) {
		if(BackupConstants.DEFAULT_BACKUP_NAME.equals(name)) {   	
			return HttpResult.error("系统默认备份无法删除!");
		}
		String restoreFilePath = BackupConstants.BACKUP_FOLDER + name;
		try {
			deleteFile(new File(restoreFilePath));
		} catch (Exception e) {
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}


	/**
	 * 递归删除文件
	 * @param file
	 */
	public static void deleteFile(File file) {
		// 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
		if(file.isDirectory()) {
			// 获取子文件/目录
			File[] subFiles = file.listFiles();
			// 遍历该目录
			for (File subFile : subFiles) {
				// 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除.
				// 如果这是一个非空目录, 多次递归清空其内容后再删除
				deleteFile(subFile);
			}
		}
		// 删除空目录或文件
		file.delete();
	}

}
