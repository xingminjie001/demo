/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.32.16.hdm-duer
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 192.168.32.16:3306
 Source Schema         : lc_device

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 23/06/2020 18:04:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'abc' COMMENT '姓名',
  `age` int(11)  COMMENT '年龄',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '123456' COMMENT '密码',
  `create_time` datetime(0)  COMMENT '创建时间',
  `update_time` datetime(0)  ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
