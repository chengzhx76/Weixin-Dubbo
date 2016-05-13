/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-05-13 17:49:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(64) NOT NULL,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `realname` varchar(16) DEFAULT NULL,
  `mobile` varchar(16) DEFAULT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `login_ip` varchar(16) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `old_login_ip` varchar(16) DEFAULT NULL,
  `old_login_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'cheng', '5cdefe986d7fa0d363930c4062b776bd30a33a3cec47a34291a8bd27', null, null, '/img/logo.jpg', '192.168.1.103', '2016-04-18 18:57:52', '0:0:0:0:0:0:0:1', '2016-04-18 15:21:04', '备注', '2016-01-28 15:47:10', '2016-04-18 18:57:52', 'NORMAL');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `user_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin_role
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` varchar(64) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `remote_addr` varchar(64) DEFAULT NULL,
  `request_uri` varchar(128) DEFAULT NULL,
  `method` varchar(16) DEFAULT NULL,
  `params` varchar(128) DEFAULT NULL,
  `user_agent` varchar(128) DEFAULT NULL,
  `exception` varchar(256) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('c3b65476d02a4ea2b73d963760e6f4d9', 'ACCESS', null, '0:0:0:0:0:0:0:1', null, 'GET', '', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0', '', 'cheng', null, null, 'NORMAL');
INSERT INTO `log` VALUES ('39a1ed65627448d0a9c61291bc560da7', 'ACCESS', null, '0:0:0:0:0:0:0:1', null, 'GET', '', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0', '', 'cheng', null, null, 'NORMAL');
INSERT INTO `log` VALUES ('c7f665813b0f4ccb9288495218167d22', 'ACCESS', null, '0:0:0:0:0:0:0:1', null, 'GET', '', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0', '', 'cheng', null, null, 'NORMAL');
INSERT INTO `log` VALUES ('ec0b5ef6ce1f44579aaee60532bbfc23', 'ACCESS', null, '0:0:0:0:0:0:0:1', '/web/', 'GET', '', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0', '', 'cheng', null, null, 'NORMAL');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(64) CHARACTER SET utf8 NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `resource_url` varchar(128) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `precode` varchar(32) CHARACTER SET utf8 NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(16) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` varchar(64) NOT NULL,
  `permission_id` varchar(64) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
