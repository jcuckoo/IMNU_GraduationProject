/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : db_film

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-04-16 19:19:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_authority
-- ----------------------------
DROP TABLE IF EXISTS `tb_authority`;
CREATE TABLE `tb_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `serial_number` int(11) NOT NULL,
  `menu_href` varchar(128) DEFAULT NULL,
  `menu_img` varchar(128) DEFAULT NULL,
  `menu_type` varchar(8) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `menu_position` varchar(8) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `parent_id` (`parent_id`) USING BTREE,
  CONSTRAINT `tb_authority_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `tb_authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_authority
-- ----------------------------
INSERT INTO `tb_authority` VALUES ('1', '首页', '1', '/index.html', null, '1', null, '1');
INSERT INTO `tb_authority` VALUES ('2', '影视库', '2', '/film/list.html', null, '1', null, '1');
INSERT INTO `tb_authority` VALUES ('3', 'vip获取/联系我们', '3', '/aboutus.html', null, '1', null, '1');
INSERT INTO `tb_authority` VALUES ('4', '电影管理', '1', '/manage/film/list.do', '/static/images/menulogo/dygl.png', '1', null, '2');
INSERT INTO `tb_authority` VALUES ('5', '用户管理', '2', '/manage/user/list.do', '/static/images/menulogo/yhgl.png', '1', null, '2');
INSERT INTO `tb_authority` VALUES ('6', '电影类别管理', '3', '/manage/filmType/list.do', '/static/images/menulogo/dylbgl.png', '1', null, '2');

-- ----------------------------
-- Table structure for tb_film
-- ----------------------------
DROP TABLE IF EXISTS `tb_film`;
CREATE TABLE `tb_film` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `summary` varchar(128) NOT NULL,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  `groom` tinyint(255) NOT NULL DEFAULT '0',
  `score` int(255) NOT NULL,
  `click_count` int(255) NOT NULL DEFAULT '0',
  `vip` tinyint(255) NOT NULL DEFAULT '0',
  `status` int(255) NOT NULL DEFAULT '0',
  `video_url` varchar(64) NOT NULL,
  `cover_img` varchar(64) DEFAULT NULL,
  `type_id` bigint(20) NOT NULL,
  `creator_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_film
-- ----------------------------
INSERT INTO `tb_film` VALUES ('13', '游戏', 'lol', '<p>lol</p>', '2019-03-07 19:48:57', '1', '4', '6', '1', '1', '/video/20190307/98bf64a9b63e422d8aa39793136d35e6.mp4', '', '2', '10');
INSERT INTO `tb_film` VALUES ('14', '歌曲', 'demo', '<p>demo</p>', '2019-03-07 19:53:42', '0', '2', '11', '0', '1', '/video/20190307/85469e69f7f341349503e4be6b70d912.mp4', '', '1', '10');
INSERT INTO `tb_film` VALUES ('15', 'cat', 'demo1', '<p>demo1</p>', '2019-03-07 19:54:41', '0', '1', '15', '1', '1', '/video/20190307/c4e099f55737491ba33d24fb9fb317c6.mp4', '', '3', '10');

-- ----------------------------
-- Table structure for tb_filmtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_filmtype`;
CREATE TABLE `tb_filmtype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_filmtype
-- ----------------------------
INSERT INTO `tb_filmtype` VALUES ('1', '喜剧电影', '2019-02-06 15:26:04', '喜剧电影，让你开心时刻保持开心！');
INSERT INTO `tb_filmtype` VALUES ('2', '动画电影', '2019-02-08 21:36:27', '优良动画，童年');
INSERT INTO `tb_filmtype` VALUES ('3', '电影', '2019-02-09 12:17:57', 'demo');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '管理员', '2019-02-05 16:25:43');
INSERT INTO `tb_role` VALUES ('2', '普通用户', '2019-02-06 16:30:53');
INSERT INTO `tb_role` VALUES ('3', 'VIP用户', '2019-02-06 16:37:16');

-- ----------------------------
-- Table structure for tb_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_authority`;
CREATE TABLE `tb_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  KEY `authority_id` (`authority_id`) USING BTREE,
  CONSTRAINT `tb_role_authority_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `tb_role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `tb_authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_role_authority
-- ----------------------------
INSERT INTO `tb_role_authority` VALUES ('1', '1', '4');
INSERT INTO `tb_role_authority` VALUES ('2', '1', '5');
INSERT INTO `tb_role_authority` VALUES ('3', '1', '6');
INSERT INTO `tb_role_authority` VALUES ('4', '2', '4');
INSERT INTO `tb_role_authority` VALUES ('5', '3', '4');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `truename` varchar(16) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `user_type` varchar(8) NOT NULL,
  `mobile` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('10', 'root', '414260f6c00571452ab65383c47255c0', '管理员', '2019-01-30 19:16:03', null, '1', '管理员', '15935745612');
INSERT INTO `tb_user` VALUES ('11', 'tang1', '414260f6c00571452ab65383c47255c0', '用户一', '2019-02-01 07:21:41', '2019-02-02 14:44:21', '3', 'VIP用户', '15935745611');
INSERT INTO `tb_user` VALUES ('12', 'tang2', '414260f6c00571452ab65383c47255c0', '用户二', '2019-02-02 08:19:57', null, '2', '普通用户', '15935745610');
