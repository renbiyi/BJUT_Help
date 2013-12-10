/*
 Navicat MySQL Data Transfer

 Source Server         : 172.18.4.82_8306
 Source Server Version : 50169
 Source Host           : 172.18.4.82
 Source Database       : bjut_help

 Target Server Version : 50169
 File Encoding         : utf-8

 Date: 12/10/2013 15:28:05 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(10) NOT NULL COMMENT 'user表外键',
  `message_id` int(10) NOT NULL COMMENT 'message表外键',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `is_read` tinyint(1) NOT NULL COMMENT '0-已读 1-未读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_message`
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(10) NOT NULL COMMENT 'user表外键',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `content` varchar(255) NOT NULL COMMENT '消息内容',
  `type` varchar(255) NOT NULL COMMENT '0-文字消息 1-语音消息',
  `expire` int(10) NOT NULL COMMENT '过期时间（单位：秒）',
  `longitude` decimal(8,5) NOT NULL COMMENT '经度',
  `latitude` decimal(8,5) NOT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_resource`
-- ----------------------------
DROP TABLE IF EXISTS `tb_resource`;
CREATE TABLE `tb_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url` varchar(255) NOT NULL COMMENT 'url',
  `auth` varchar(255) NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
--  Records of `tb_resource`
-- ----------------------------
BEGIN;
INSERT INTO `tb_resource` VALUES ('1', '/demo/**', 'ROLE_USER');
COMMIT;

-- ----------------------------
--  Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_role`
-- ----------------------------
BEGIN;
INSERT INTO `tb_role` VALUES ('1', 'ROLE_ADMIN'), ('2', 'ROLE_USER');
COMMIT;

-- ----------------------------
--  Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_user`
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES ('1', 'zhanghao', '1e19be6365d97385f9c623ec0efb354c', '1'), ('3', 'hujiyun', '3f5917e2b6a6fc116b8d63f0f16c7323', '1'), ('4', 'majikun', '487e33aec5da39ea69f08c62f19223e1', '1'), ('5', 'renbiyi', '4628ad60cf1099d001c65f8c6528d32d', '1'), ('6', 'cuijian', '8df77c1d646f1f942cde57a2a285fd84', '1');
COMMIT;

-- ----------------------------
--  Table structure for `tb_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_role` VALUES ('1', '1', '1'), ('2', '4', '1'), ('3', '1', '2'), ('4', '5', '2'), ('5', '6', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
