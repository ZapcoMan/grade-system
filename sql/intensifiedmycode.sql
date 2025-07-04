/*
 Navicat Premium Data Transfer

 Source Server         : localhostMysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3307
 Source Schema         : intensifiedmycode

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 01/07/2025 15:40:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id(主键)',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号(唯一)',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'ADMIN' COMMENT '身份',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_index`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin1', 'e10adc3949ba59abbe56e057f20f883e', 'ADMIN', '管理员1', 'http://localhost:9991/files/download/1751298690385_1751296265210__5_百乐城_来自小红书网页版.jpg');
INSERT INTO `admin` VALUES (7, 'admin2', 'e10adc3949ba59abbe56e057f20f883e', 'ADMIN', '管理员2', 'http://localhost:9991/files/download/1742375044354_a71653afa6162e44fe6417f3df576d97.jpg');

-- ----------------------------
-- Table structure for audit_log
-- ----------------------------
DROP TABLE IF EXISTS `audit_log`;
CREATE TABLE `audit_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `details` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit_log
-- ----------------------------
INSERT INTO `audit_log` VALUES (1, 'anonymousUser', '登录', '用户', '0:0:0:0:0:0:0:1', '[Account(id=null, username=admin1, password=123456, role=ADMIN, name=null, token=null, avatar=null, newpassword=null, new2password=null)]', '2025-06-30 12:40:09');
INSERT INTO `audit_log` VALUES (2, 'anonymousUser', '登录', '用户', '0:0:0:0:0:0:0:1', '[Account(id=null, username=admin1, password=123456, role=ADMIN, name=null, token=null, avatar=null, newpassword=null, new2password=null)]', '2025-06-30 21:56:52');
INSERT INTO `audit_log` VALUES (3, 'admin1', '更新管理员信息', '管理员', '0:0:0:0:0:0:0:1', '[Account(id=1, username=admin1, password=e10adc3949ba59abbe56e057f20f883e, role=ADMIN, name=管理员1, token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxLUFETUlOIiwiZXhwIjoxNzUxMzc4MjEyfQ.2AGtJZ-LhozoJjzZLQxT8q9MjURdWJHPHXscBsqtCYo, avatar=http://localhost:9999/files/download/1751296265210__5_百乐城_来自小红书网页版.jpg, newpassword=null, new2password=null)]', '2025-06-30 23:40:57');
INSERT INTO `audit_log` VALUES (4, 'admin1', '分页查询管理员', '管理员', '0:0:0:0:0:0:0:1', '[1, 5, Account(id=null, username=null, password=null, role=null, name=null, token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxLUFETUlOIiwiZXhwIjoxNzUxMzc4MjEyfQ.2AGtJZ-LhozoJjzZLQxT8q9MjURdWJHPHXscBsqtCYo, avatar=null, newpassword=null, new2password=null)]', '2025-06-30 23:44:57');
INSERT INTO `audit_log` VALUES (5, 'admin1', '分页查询管理员', '管理员', '0:0:0:0:0:0:0:1', '[1, 5, Account(id=null, username=null, password=null, role=null, name=null, token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxLUFETUlOIiwiZXhwIjoxNzUxMzc4MjEyfQ.2AGtJZ-LhozoJjzZLQxT8q9MjURdWJHPHXscBsqtCYo, avatar=null, newpassword=null, new2password=null)]', '2025-06-30 23:44:57');
INSERT INTO `audit_log` VALUES (6, 'anonymousUser', '文件下载', '文件', '0:0:0:0:0:0:0:1', '[1742375044354_a71653afa6162e44fe6417f3df576d97.jpg, org.springframework.web.context.request.async.StandardServletAsyncWebRequest$LifecycleHttpServletResponse@33e966ab]', '2025-06-30 23:44:58');


-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'UNREAD',
  `created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `read_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id(主键)',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号(唯一)',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '身份',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_index`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'student1', '123456', 'USER', '学生1', 'http://localhost:9991/files/download/1742899004787_微信图片_202503251834051.jpg');
INSERT INTO `user` VALUES (2, 'student2', '123456', 'USER', '学生2', 'http://localhost:9991/files/download/1742899025437_微信图片_202503251834052.jpg');
INSERT INTO `user` VALUES (3, 'student3', '123456', 'USER', '学生3', 'http://localhost:9991/files/download/1742899019835_微信图片_202503251834053.jpg');
INSERT INTO `user` VALUES (5, 'student4', '123456', 'USER', '学生4', 'http://localhost:9991/files/download/1742899014576_微信图片_20250325183349.jpg');
INSERT INTO `user` VALUES (6, 'student5', '123456', 'USER', '学生5', 'http://localhost:9991/files/download/1742375243400_a71653afa6162e44fe6417f3df576d97.jpg');

SET FOREIGN_KEY_CHECKS = 1;
