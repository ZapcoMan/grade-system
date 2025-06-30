/*
 Navicat Premium Data Transfer

 Source Server         : localhostMysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3307
 Source Schema         : mycode

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 14/05/2025 14:39:40
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
INSERT INTO `admin` VALUES (1, 'admin1', 'e10adc3949ba59abbe56e057f20f883e', 'ADMIN', '管理员1', 'http://localhost:9991/files/download/1742634810445_ea6db5914b063f9a02599e693ce03a42.jpg');
INSERT INTO `admin` VALUES (7, 'admin2', 'e10adc3949ba59abbe56e057f20f883e', 'ADMIN', '管理员2', 'http://localhost:9991/files/download/1742375044354_a71653afa6162e44fe6417f3df576d97.jpg');

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
