/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : yls_privilege_management

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 09/09/2020 08:54:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `label` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'admin', '2018-09-23 19:52:54', 0, NULL, NULL, '主题色', 'theme', '主题色', 0, 'color', '#14889A');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序值',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 'admin', '2018-09-23 19:35:22', 0, NULL, NULL, '轻尘集团', 0, -1);
INSERT INTO `sys_dept` VALUES (2, 'admin', '2018-09-23 19:35:55', 0, NULL, NULL, '牧尘集团', 1, -1);
INSERT INTO `sys_dept` VALUES (3, 'admin', '2018-09-23 19:36:24', 0, NULL, NULL, '三国集团', 2, -1);
INSERT INTO `sys_dept` VALUES (4, 'admin', '2018-09-23 19:37:03', 0, NULL, NULL, '上海分公司', 0, 2);
INSERT INTO `sys_dept` VALUES (5, 'admin', '2018-09-23 19:37:17', 0, NULL, NULL, '北京分公司', 1, 1);
INSERT INTO `sys_dept` VALUES (6, 'admin', '2018-09-23 19:37:28', 0, NULL, NULL, '北京分公司', 1, 2);
INSERT INTO `sys_dept` VALUES (7, 'admin', '2018-09-23 19:38:00', 0, NULL, NULL, '技术部', 0, 5);
INSERT INTO `sys_dept` VALUES (8, 'admin', '2018-09-23 19:38:10', 0, NULL, NULL, '技术部', 0, 4);
INSERT INTO `sys_dept` VALUES (9, 'admin', '2018-09-23 19:38:17', 0, NULL, NULL, '技术部', 0, 6);
INSERT INTO `sys_dept` VALUES (10, 'admin', '2018-09-23 19:38:45', 0, NULL, NULL, '市场部', 0, 5);
INSERT INTO `sys_dept` VALUES (11, 'admin', '2018-09-23 19:39:01', 0, NULL, NULL, '市场部', 0, 6);
INSERT INTO `sys_dept` VALUES (12, 'admin', '2018-09-23 19:40:42', 0, NULL, NULL, '魏国', 0, 3);
INSERT INTO `sys_dept` VALUES (13, 'admin', '2018-09-23 19:40:54', 0, NULL, NULL, '蜀国', 1, 3);
INSERT INTO `sys_dept` VALUES (14, 'admin', '2018-09-23 19:41:04', 0, NULL, NULL, '吴国', 2, 3);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `label` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, 'admin', '2018-09-23 19:52:54', 0, NULL, NULL, '性别', '男', '性别', 0, 'sex', 'male');
INSERT INTO `sys_dict` VALUES (2, 'admin', '2018-09-23 19:53:17', 0, NULL, NULL, '性别', '女', '性别', 1, 'sex', 'female');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键id',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `method` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `operation` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `time` bigint(20) NULL DEFAULT NULL COMMENT '时间',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键id',
  `create_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录时间',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
INSERT INTO `sys_login_log` VALUES (1, '2020-09-06 22:56:15', '0:0:0:0:0:0:0:1', NULL, 'login', 'admin');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级id',
  `perms` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排列',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, NULL, NULL, 0, NULL, NULL, 'el-icon-setting', '系统管理', 0, 0, NULL, 0, NULL);
INSERT INTO `sys_menu` VALUES (2, NULL, NULL, 0, NULL, NULL, 'el-icon-service', '用户管理', 1, 1, NULL, 1, '/sys/user');
INSERT INTO `sys_menu` VALUES (3, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 2, 'sys:user:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (4, NULL, NULL, 0, NULL, NULL, NULL, '新增', 0, 2, 'sys:user:add', 2, NULL);
INSERT INTO `sys_menu` VALUES (5, NULL, NULL, 0, NULL, NULL, NULL, '修改', 0, 2, 'sys:user:edit', 2, NULL);
INSERT INTO `sys_menu` VALUES (6, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 2, 'sys:user:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (7, NULL, NULL, 0, NULL, NULL, 'el-icon-news', '机构管理', 2, 1, NULL, 1, '/sys/dept');
INSERT INTO `sys_menu` VALUES (8, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 7, 'sys:dept:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (9, NULL, NULL, 0, NULL, NULL, NULL, '新增', 0, 7, 'sys:dept:add', 2, NULL);
INSERT INTO `sys_menu` VALUES (10, NULL, NULL, 0, NULL, NULL, NULL, '修改', 0, 7, 'sys:dept:edit', 2, NULL);
INSERT INTO `sys_menu` VALUES (11, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 7, 'sys:dept:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (12, NULL, NULL, 0, NULL, NULL, 'el-icon-view', '角色管理', 4, 1, NULL, 1, '/sys/role');
INSERT INTO `sys_menu` VALUES (13, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 12, 'sys:role:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (14, NULL, NULL, 0, NULL, NULL, NULL, '新增', 0, 12, 'sys:role:add', 2, NULL);
INSERT INTO `sys_menu` VALUES (15, NULL, NULL, 0, NULL, NULL, NULL, '修改', 0, 12, 'sys:role:edit', 2, NULL);
INSERT INTO `sys_menu` VALUES (16, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 12, 'sys:role:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (17, NULL, NULL, 0, NULL, NULL, 'el-icon-menu', '菜单管理', 5, 1, NULL, 1, '/sys/menu');
INSERT INTO `sys_menu` VALUES (18, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 17, 'sys:menu:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (19, NULL, NULL, 0, NULL, NULL, NULL, '新增', 0, 17, 'sys:menu:add', 2, NULL);
INSERT INTO `sys_menu` VALUES (20, NULL, NULL, 0, NULL, NULL, NULL, '修改', 0, 17, 'sys:menu:edit', 2, NULL);
INSERT INTO `sys_menu` VALUES (21, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 17, 'sys:menu:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (22, NULL, NULL, 0, NULL, NULL, 'el-icon-edit-outline', '字典管理', 7, 1, NULL, 1, '/sys/dict');
INSERT INTO `sys_menu` VALUES (23, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 22, 'sys:dict:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (24, NULL, NULL, 0, NULL, NULL, NULL, '新增', 0, 22, 'sys:dict:add', 2, NULL);
INSERT INTO `sys_menu` VALUES (25, NULL, NULL, 0, NULL, NULL, NULL, '修改', 0, 22, 'sys:dict:edit', 2, NULL);
INSERT INTO `sys_menu` VALUES (26, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 22, 'sys:dict:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (27, NULL, NULL, 0, NULL, NULL, 'el-icon-edit-outline', '系统配置', 7, 1, NULL, 1, '/sys/config');
INSERT INTO `sys_menu` VALUES (28, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 27, 'sys:config:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (29, NULL, NULL, 0, NULL, NULL, NULL, '新增', 0, 27, 'sys:config:add', 2, NULL);
INSERT INTO `sys_menu` VALUES (30, NULL, NULL, 0, NULL, NULL, NULL, '修改', 0, 27, 'sys:config:edit', 2, NULL);
INSERT INTO `sys_menu` VALUES (31, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 27, 'sys:config:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (32, NULL, NULL, 0, 'admin', '2018-09-23 19:32:28', 'el-icon-info', '登录日志', 8, 1, NULL, 1, '/sys/loginlog');
INSERT INTO `sys_menu` VALUES (33, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 32, 'sys:loginlog:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (34, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 32, 'sys:loginlog:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (35, NULL, NULL, 0, 'admin', '2018-09-23 19:32:28', 'el-icon-info', '操作日志', 8, 1, NULL, 1, '/sys/log');
INSERT INTO `sys_menu` VALUES (36, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 35, 'sys:log:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (37, NULL, NULL, 0, NULL, NULL, NULL, '删除', 0, 35, 'sys:log:delete', 2, NULL);
INSERT INTO `sys_menu` VALUES (38, 'admin', '2018-12-27 10:57:29', 0, 'admin', '2019-01-10 17:31:04', 'el-icon-info', '系统监控', 4, 0, '', 0, '');
INSERT INTO `sys_menu` VALUES (39, NULL, NULL, 0, 'admin', '2018-12-27 11:03:45', 'el-icon-warning', '数据监控', 0, 38, NULL, 1, 'http://127.0.0.1:8001/druid/login.html');
INSERT INTO `sys_menu` VALUES (40, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 39, 'sys:druid:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (41, 'admin', '2018-11-02 20:02:15', 0, 'admin', '2018-12-27 11:03:53', 'el-icon-view', '服务监控', 1, 38, NULL, 1, 'http://127.0.0.1:8000/');
INSERT INTO `sys_menu` VALUES (42, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 41, 'sys:monitor:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (43, 'admin', '2018-12-27 11:05:48', 0, 'admin', '2018-12-27 11:06:39', 'el-icon-service', '服务治理', 2, 0, '', 0, '');
INSERT INTO `sys_menu` VALUES (44, 'admin', '2018-11-03 11:06:48', 0, 'admin', '2018-12-27 11:08:11', ' el-icon-view', '注册中心', 0, 43, NULL, 1, 'http://127.0.0.1:8500');
INSERT INTO `sys_menu` VALUES (45, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 44, 'sys:consul:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (46, NULL, NULL, 0, 'admin', '2018-12-27 11:04:18', 'el-icon-document', '接口文档', 3, 0, NULL, 1, 'http://127.0.0.1:8001/swagger-ui.html');
INSERT INTO `sys_menu` VALUES (47, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 46, 'sys:swagger:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (48, 'admin', '2018-11-15 14:39:30', 0, 'admin', '2018-11-15 14:56:18', 'el-icon-star-on', '代码生成', 5, 0, '', 1, '/generator/generator');
INSERT INTO `sys_menu` VALUES (49, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 48, 'sys:generator:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (50, 'admin', '2018-11-15 14:39:30', 0, 'admin', '2018-11-15 14:56:18', 'el-icon-view', '在线用户', 5, 0, '', 1, '/sys/online');
INSERT INTO `sys_menu` VALUES (51, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 50, 'sys:online:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (52, NULL, NULL, 0, 'admin', '2018-11-15 14:39:43', 'el-icon-picture-outline', '使用案例', 6, 0, NULL, 0, NULL);
INSERT INTO `sys_menu` VALUES (53, NULL, NULL, 0, NULL, NULL, 'el-icon-edit', '国际化', 1, 52, NULL, 1, '/demo/i18n');
INSERT INTO `sys_menu` VALUES (54, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 53, 'sys:dict:view', 2, NULL);
INSERT INTO `sys_menu` VALUES (55, NULL, NULL, 0, NULL, NULL, 'el-icon-picture', '换皮肤', 2, 52, NULL, 1, '/demo/theme');
INSERT INTO `sys_menu` VALUES (56, NULL, NULL, 0, NULL, NULL, NULL, '查看', 0, 55, 'sys:dict:view', 2, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '2019-01-19 11:11:11', 0, 'admin', '2019-01-19 19:07:18', 'admin', '超级管理员');
INSERT INTO `sys_role` VALUES (2, 'admin', '2019-01-19 11:11:11', 0, 'admin', '2019-01-19 11:39:28', 'mng', '项目经理');
INSERT INTO `sys_role` VALUES (3, 'admin', '2019-01-19 11:11:11', 0, 'admin', '2019-01-19 11:39:28', 'dev', '开发人员');
INSERT INTO `sys_role` VALUES (4, 'admin', '2019-01-19 11:11:11', 0, 'admin', '2019-01-19 11:11:11', 'test', '测试人员');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键id',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门的关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (1, 1, 1, 'admin', '2019-01-11 08:30:37', NULL, 'admin', '2019-01-11 08:30:25');
INSERT INTO `sys_role_dept` VALUES (2, 2, 2, 'admin', '2019-01-11 08:31:01', NULL, 'admin', '2019-01-11 08:31:04');
INSERT INTO `sys_role_dept` VALUES (3, 3, 3, 'admin', '2019-01-11 08:31:18', NULL, 'admin', '2019-01-11 08:31:21');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键id',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 623 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单的关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (431, 1, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (432, 2, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (433, 9, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (434, 3, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (435, 13, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (436, 4, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (437, 17, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (438, 5, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (439, 21, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (440, 7, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (441, 31, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (442, 8, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (443, 6, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (444, 35, 8, 'admin', '2018-09-23 19:55:08', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (469, 1, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (470, 2, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (471, 3, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (472, 4, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (473, 5, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (474, 6, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (475, 7, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (476, 8, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (477, 9, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (478, 10, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (479, 11, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (480, 12, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (481, 13, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (482, 14, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (483, 15, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (484, 16, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (485, 17, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (486, 18, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (487, 19, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (488, 20, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (489, 21, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (490, 22, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (491, 23, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (492, 24, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (493, 25, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (494, 26, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (495, 27, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (496, 28, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (497, 29, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (498, 30, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (499, 31, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (500, 32, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (501, 33, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (502, 34, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (503, 35, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (504, 36, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (505, 37, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (506, 43, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (507, 44, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (508, 45, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (509, 46, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (510, 47, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (511, 38, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (512, 39, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (513, 40, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (514, 41, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (515, 42, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (516, 48, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (517, 49, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (518, 50, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (519, 51, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (520, 52, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (521, 53, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (522, 54, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (523, 55, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (524, 56, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (572, 1, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (573, 2, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (574, 3, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (575, 4, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (576, 5, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (577, 6, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (578, 7, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (579, 8, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (580, 12, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (581, 13, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (582, 17, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (583, 18, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (584, 22, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (585, 23, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (586, 24, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (587, 25, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (588, 26, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (589, 27, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (590, 28, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (591, 29, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (592, 30, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (593, 31, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (594, 32, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (595, 33, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (596, 35, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (597, 36, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (598, 43, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (599, 44, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (600, 45, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (601, 38, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (602, 39, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (603, 40, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (604, 41, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (605, 42, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (606, 50, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (607, 51, 3, 'admin', '2019-01-22 14:45:28', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (608, 1, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (609, 2, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (610, 3, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (611, 7, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (612, 8, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (613, 17, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (614, 18, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (615, 32, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (616, 33, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (617, 35, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (618, 36, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (619, 46, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (620, 47, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (621, 50, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (622, 51, 4, 'admin', '2019-01-22 14:46:44', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `nick_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '2018-08-14 11:11:11', 0, 'admin', '2018-08-14 11:11:11', NULL, 4, 'admin@qq.com', '13612345678', 'admin', '超管', 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (22, 'admin', '2018-09-23 19:43:00', 0, 'admin', '2019-01-10 11:41:13', NULL, 7, 'test@qq.com', '13889700023', 'liubei', '刘备', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (23, 'admin', '2018-09-23 19:43:44', 0, 'admin', '2018-09-23 19:43:52', NULL, 7, 'test@qq.com', '13889700023', 'zhaoyun', '赵云', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (24, 'admin', '2018-09-23 19:44:23', 0, 'admin', '2018-09-23 19:44:29', NULL, 11, 'test@qq.com', '13889700023', 'zhugeliang', '诸葛亮', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 7);
INSERT INTO `sys_user` VALUES (25, 'admin', '2018-09-23 19:45:32', 0, 'admin', '2019-01-10 17:59:14', NULL, 8, 'test@qq.com', '13889700023', 'caocao', '曹操', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (26, 'admin', '2018-09-23 19:45:48', 0, 'admin', '2018-09-23 19:45:57', NULL, 10, 'test@qq.com', '13889700023', 'dianwei', '典韦', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (27, 'admin', '2018-09-23 19:46:09', 0, 'admin', '2018-09-23 19:46:17', NULL, 8, 'test@qq.com', '13889700023', 'xiahoudun', '夏侯惇', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (28, 'admin', '2018-09-23 19:46:38', 0, 'admin', '2018-11-04 15:33:17', NULL, 10, 'test@qq.com', '13889700023', 'xunyu', '荀彧', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (29, 'admin', '2018-09-23 19:46:54', 0, 'admin', '2018-09-23 19:47:03', NULL, 10, 'test@qq.com', '13889700023', 'sunquan', '孙权', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (30, 'admin', '2018-09-23 19:47:28', 0, 'admin', '2018-09-23 19:48:04', NULL, 11, 'test@qq.com', '13889700023', 'zhouyu', '周瑜', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (31, 'admin', '2018-09-23 19:47:44', 0, 'admin', '2018-09-23 19:47:58', NULL, 11, 'test@qq.com', '13889700023', 'luxun', '陆逊', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);
INSERT INTO `sys_user` VALUES (32, 'admin', '2018-09-23 19:48:38', 0, 'admin', '2018-09-23 19:49:02', NULL, 11, 'test@qq.com', '13889700023', 'huanggai', '黄盖', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` tinyint(4) NULL DEFAULT NULL COMMENT '删除标记，1：未删除，0：已删除',
  `last_update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次更新者',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (2, 1, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (26, 3, 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (33, 2, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (34, 2, 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (35, 2, 9, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (36, 3, 10, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (37, 2, 11, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (38, 3, 12, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (39, 2, 15, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (41, 3, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (42, 2, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (43, 4, 7, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (45, 2, 18, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (46, 3, 17, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (47, 4, 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (48, 2, 21, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (57, 2, 31, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (58, 2, 30, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (59, 3, 32, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (73, 8, 33, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (74, 8, 25, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (75, 2, 25, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (80, 2, 22, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (81, 3, 23, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (82, 4, 24, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (83, 3, 26, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (85, 2, 29, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (86, 4, 28, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (87, 3, 27, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
