/*
Navicat MySQL Data Transfer

Source Server         : 120.27.53.171-wx
Source Server Version : 50173
Source Host           : 120.27.53.171:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-11-15 23:26:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `account_level_id` varchar(255) DEFAULT NULL,
  `credit` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `bonus_point_upgrade` int(11) DEFAULT NULL,
  `bonus_point_usable` int(11) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `is_employee` tinyint(4) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `source_from` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'http://wx.aqd123.com/moblie/static/images/product/zm.jpg', 'Cheng', '1', 'WELL', '18600536683', '123456', '0', '0', '831.4', '0', '127.0.0.1', 'NO', '--', '2016-09-20 10:03:47', '2016-11-14 17:24:49', 'NORMAL');

-- ----------------------------
-- Table structure for account_level
-- ----------------------------
DROP TABLE IF EXISTS `account_level`;
CREATE TABLE `account_level` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `need_ronus_point` int(11) DEFAULT NULL,
  `point_every_level` int(11) DEFAULT NULL,
  `reduct_percent` double DEFAULT NULL,
  `consume_scale` varchar(255) DEFAULT NULL,
  `free_frequency` int(11) DEFAULT NULL,
  `is_enable` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_level
-- ----------------------------
INSERT INTO `account_level` VALUES ('1', '一级', '0', '0', '1', '100:1', '0', '1', '初始化帐户级别', '2016-07-12 16:36:04', '2016-07-12 16:36:08', 'NORMAL');
INSERT INTO `account_level` VALUES ('2', '二级', '200', '400', '0.97', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `is_enable` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES ('1', '名字1', 'http://wx.aqd123.com/moblie/static/images/ad/swiper-1.jpg', 'http://www.baidu.com', '120', '120', '1', '1', '首页图片1', '2016-06-29 15:24:44', '2016-06-29 15:24:48', 'NORMAL');
INSERT INTO `ad` VALUES ('2', '名字2', 'http://wx.aqd123.com/moblie/static/images/ad/swiper-2.jpg', 'http://www.baidu.com', '120', '120', '2', '1', '首页图片2', '2016-06-29 16:34:26', '2016-06-29 16:34:29', 'NORMAL');
INSERT INTO `ad` VALUES ('3', '名字3', 'http://wx.aqd123.com/moblie/static/images/ad/swiper-3.jpg', 'http://www.baidu.com', '120', '120', '3', '1', '首页图片3', '2016-06-30 18:07:05', '2016-06-30 18:07:08', 'NORMAL');

-- ----------------------------
-- Table structure for ad_join_position
-- ----------------------------
DROP TABLE IF EXISTS `ad_join_position`;
CREATE TABLE `ad_join_position` (
  `id` varchar(255) NOT NULL,
  `ad_id` int(11) DEFAULT NULL,
  `ad_position_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_join_position
-- ----------------------------
INSERT INTO `ad_join_position` VALUES ('1', '1', '1', '2016-06-29 15:25:44', '2016-06-29 15:25:47', 'NORMAL');
INSERT INTO `ad_join_position` VALUES ('2', '2', '1', '2016-06-29 16:36:11', '2016-06-29 16:36:13', 'NORMAL');
INSERT INTO `ad_join_position` VALUES ('3', '3', '1', '2016-06-30 19:41:44', '2016-06-30 19:41:47', 'NORMAL');

-- ----------------------------
-- Table structure for ad_position
-- ----------------------------
DROP TABLE IF EXISTS `ad_position`;
CREATE TABLE `ad_position` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_position
-- ----------------------------
INSERT INTO `ad_position` VALUES ('1', '首页', 'INDEX', '首页展示的图片', '2016-06-29 15:25:27', '2016-06-29 15:25:29', 'NORMAL');

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
INSERT INTO `admin` VALUES ('1', 'cheng', '5cdefe986d7fa0d363930c4062b776bd30a33a3cec47a34291a8bd27', '程', '18600536683', '/img/logo.jpg', '1.95.240.33', '2016-10-30 21:50:09', '0:0:0:0:0:0:0:1', '2016-10-25 14:22:48', '备注', '2016-01-28 15:47:10', '2016-10-30 21:50:09', 'NORMAL');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `admin_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`admin_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for arayacak_address
-- ----------------------------
DROP TABLE IF EXISTS `arayacak_address`;
CREATE TABLE `arayacak_address` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `village` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arayacak_address
-- ----------------------------
INSERT INTO `arayacak_address` VALUES ('1', '好吃馍店', '1', '1', '1', '1', '1', '刘楼村西头', '自提点1', '2016-11-02 16:36:19', '2016-11-02 16:36:21', 'NORMAL');
INSERT INTO `arayacak_address` VALUES ('2', '大众馍店', '1', '1', '1', '1', '2', '黄楼村南头', '自提点2', '2016-11-02 16:37:09', '2016-11-02 16:37:13', 'NORMAL');
INSERT INTO `arayacak_address` VALUES ('3', '城西馍店', '1', '1', '1', '2', '1', '文亭街西头', '城关自提点', '2016-11-03 14:30:00', '2016-11-03 14:30:02', 'NORMAL');
INSERT INTO `arayacak_address` VALUES ('4', '批发街馍店', '1', '1', '1', '2', '1', '批发街中间路北', '批发街自提点', '2016-11-03 14:31:36', '2016-11-03 14:31:39', 'NORMAL');

-- ----------------------------
-- Table structure for arayacak_delivery_time
-- ----------------------------
DROP TABLE IF EXISTS `arayacak_delivery_time`;
CREATE TABLE `arayacak_delivery_time` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arayacak_delivery_time
-- ----------------------------

-- ----------------------------
-- Table structure for behavior
-- ----------------------------
DROP TABLE IF EXISTS `behavior`;
CREATE TABLE `behavior` (
  `id` varchar(255) NOT NULL,
  `behavior_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of behavior
-- ----------------------------
INSERT INTO `behavior` VALUES ('83f3553b85b14f89af11bfe4a9481a4f', 'CASH', '70548275', null, '--', '2016-10-12 12:07:01', '2016-10-12 12:07:01', 'NORMAL');
INSERT INTO `behavior` VALUES ('15b305bcf7034e8782d2c79aaa0d3db6', 'CASH', '02288732', null, '--', '2016-10-12 13:54:05', '2016-10-12 13:54:05', 'NORMAL');
INSERT INTO `behavior` VALUES ('bd8601ce9452495f91edd75f5795c6a4', 'CASH', '43473491', null, '--', '2016-10-13 10:15:34', '2016-10-13 10:15:34', 'NORMAL');
INSERT INTO `behavior` VALUES ('8155db2240824efcae8f8a66d2e23a17', 'CASH', '28152547', null, '--', '2016-10-13 10:17:38', '2016-10-13 10:17:38', 'NORMAL');
INSERT INTO `behavior` VALUES ('8f274eaf59e1482db64139bcf59de9cb', 'CASH', '00933862', null, '--', '2016-10-13 11:17:34', '2016-10-13 11:17:34', 'NORMAL');
INSERT INTO `behavior` VALUES ('5198886d73a8476ea4035fbd06f29a39', 'CASH', '07753186', null, '--', '2016-10-13 11:20:04', '2016-10-13 11:20:04', 'NORMAL');
INSERT INTO `behavior` VALUES ('dcaed9f53fed4664adfb09566806adc7', 'CASH', '85845262', null, '--', '2016-10-13 11:21:10', '2016-10-13 11:21:10', 'NORMAL');
INSERT INTO `behavior` VALUES ('44058c8dfe8c4c078607c6c6b5f171bc', 'CASH', '04553268', null, '--', '2016-10-13 11:29:58', '2016-10-13 11:29:58', 'NORMAL');
INSERT INTO `behavior` VALUES ('5a35c77e84144b669be34ea554a67158', 'CASH', '29522347', null, '--', '2016-10-13 11:32:08', '2016-10-13 11:32:08', 'NORMAL');
INSERT INTO `behavior` VALUES ('710b8062bdb54844803067de1b78e7bc', 'CASH', '19902742', null, '--', '2016-10-13 11:43:06', '2016-10-13 11:43:06', 'NORMAL');
INSERT INTO `behavior` VALUES ('061998b72cc04322b68b7dc50a6bcd29', 'CASH', '14458117', null, '--', '2016-10-17 15:34:54', '2016-10-17 15:34:54', 'NORMAL');
INSERT INTO `behavior` VALUES ('10685ac96a1e42fb8743d3c9e0dbde85', 'CASH', '80301769', null, '--', '2016-11-06 00:27:07', '2016-11-06 00:27:07', 'NORMAL');
INSERT INTO `behavior` VALUES ('47598bf5df534940ad1490ccb7ab118c', 'CASH', '09133902', null, '--', '2016-11-06 00:31:06', '2016-11-06 00:31:06', 'NORMAL');
INSERT INTO `behavior` VALUES ('6e89eef7b081461da3bd25517acfcbde', 'CASH', '08292455', null, '--', '2016-11-06 00:32:32', '2016-11-06 00:32:32', 'NORMAL');
INSERT INTO `behavior` VALUES ('d3a53a20055344bba72a87d42e8e72a1', 'CASH', '67016531', null, '--', '2016-11-06 00:35:17', '2016-11-06 00:35:17', 'NORMAL');
INSERT INTO `behavior` VALUES ('17f2d6f34f8e448f83311735a0ef3b19', 'CASH', '81893558', null, '--', '2016-11-06 00:36:34', '2016-11-06 00:36:34', 'NORMAL');
INSERT INTO `behavior` VALUES ('d82a8156764a4fafbe76d7a4a3bcf7cb', 'CASH', '29580650', null, '--', '2016-11-06 00:36:53', '2016-11-06 00:36:53', 'NORMAL');
INSERT INTO `behavior` VALUES ('4a82deaac6e545559d36aec7b38c1581', 'CASH', '74041111', null, '--', '2016-11-06 00:39:08', '2016-11-06 00:39:08', 'NORMAL');
INSERT INTO `behavior` VALUES ('3a77a4473d4c4e64a6cf9bda02c3d2fa', 'CASH', '63842497', null, '--', '2016-11-06 00:45:20', '2016-11-06 00:45:20', 'NORMAL');
INSERT INTO `behavior` VALUES ('0dafe568daf94103ad3525219ed15a2d', 'CASH', '下单', '52488484', '--', '2016-11-06 17:47:03', '2016-11-06 17:47:03', 'NORMAL');
INSERT INTO `behavior` VALUES ('e90a746d619844e89c61699bf21947e7', 'CASH', '下单', '05932460', '--', '2016-11-06 17:49:41', '2016-11-06 17:49:41', 'NORMAL');
INSERT INTO `behavior` VALUES ('dd1486b0febf40da8a9e4ddbd8d21394', 'CASH', '下单', '28041969', '--', '2016-11-06 17:51:21', '2016-11-06 17:51:21', 'NORMAL');
INSERT INTO `behavior` VALUES ('4e7dd142907a4e609a3d9c2a617373c2', 'CASH', '下单', '87269926', '--', '2016-11-06 17:56:43', '2016-11-06 17:56:43', 'NORMAL');
INSERT INTO `behavior` VALUES ('b592d3ea560a42ed90825eb62c4ccf9a', 'CASH', '下单', '88001282', '--', '2016-11-06 17:58:11', '2016-11-06 17:58:11', 'NORMAL');
INSERT INTO `behavior` VALUES ('30f2474268fa4e8f8cfc5b1bd07dbc93', 'CASH', '下单', '72176421', '--', '2016-11-06 17:58:37', '2016-11-06 17:58:37', 'NORMAL');
INSERT INTO `behavior` VALUES ('c2a0f45cfd9d4749a72b3b120bbaf4f0', 'CASH', '下单', '66107843', '--', '2016-11-06 18:04:27', '2016-11-06 18:04:27', 'NORMAL');
INSERT INTO `behavior` VALUES ('cf3a8deac4c14ae3ac60f67a227da5ec', 'CASH', '下单', '81584739', '--', '2016-11-06 18:16:30', '2016-11-06 18:16:30', 'NORMAL');
INSERT INTO `behavior` VALUES ('da0cf6eebc414d38964aaadf7eb79d3c', 'CASH', '下单', '67440119', '--', '2016-11-06 18:16:50', '2016-11-06 18:16:50', 'NORMAL');
INSERT INTO `behavior` VALUES ('54f43f6904634caf8503b2a1a8a27612', 'CASH', '下单', '57835249', '--', '2016-11-06 18:24:53', '2016-11-06 18:24:53', 'NORMAL');
INSERT INTO `behavior` VALUES ('40a49efba395463eadf83bc615b6bd8b', 'CASH', '下单', '33475119', '--', '2016-11-06 18:25:11', '2016-11-06 18:25:11', 'NORMAL');
INSERT INTO `behavior` VALUES ('89b7c9ca8fd04a2dac6561a064c6779b', 'CASH', '下单', '37709392', '--', '2016-11-06 18:25:46', '2016-11-06 18:25:46', 'NORMAL');
INSERT INTO `behavior` VALUES ('ae216418a1624583890cd77b9f73f1c5', 'CASH', '下单', '87514247', '--', '2016-11-06 22:01:22', '2016-11-06 22:01:22', 'NORMAL');
INSERT INTO `behavior` VALUES ('1d0e1a9f12f74a799e0f911dce0fb0f8', 'CASH', '下单', '12168331', '--', '2016-11-06 22:01:27', '2016-11-06 22:01:27', 'NORMAL');

-- ----------------------------
-- Table structure for bonus_point_record
-- ----------------------------
DROP TABLE IF EXISTS `bonus_point_record`;
CREATE TABLE `bonus_point_record` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `before_bonus_points` varchar(255) DEFAULT NULL,
  `tx_bonus_points` varchar(255) DEFAULT NULL,
  `frozen_bonus_points` varchar(255) DEFAULT NULL,
  `after_bonus_points` varchar(255) DEFAULT NULL,
  `tx_type` varchar(255) DEFAULT NULL,
  `behavior_id` varchar(255) DEFAULT NULL,
  `tx_result` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bonus_point_record
-- ----------------------------
INSERT INTO `bonus_point_record` VALUES ('d8009517998e4f1993e141989e92ca48', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-10-13 11:21:13', '2016-10-13 11:21:13', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('3012e0c14a3245dcaa34e8ad036379c1', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-10-13 11:30:19', '2016-10-13 11:30:19', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('5f72e1faf728454692a05e415ead2ad5', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-10-13 11:32:52', '2016-10-13 11:32:52', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b52d4dccce1d4d36967efe212f349209', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-10-13 11:43:15', '2016-10-13 11:43:15', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('eddc0c8fa81e4f77b18340991b1288e5', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-10-17 15:34:54', '2016-10-17 15:34:54', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8d003f8828fc478c81713c67eed28eb6', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:27:07', '2016-11-06 00:27:07', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('69213f81bcff4b4a8d1960430421c54c', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:31:06', '2016-11-06 00:31:06', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('6dc4e93523aa498380d18278b0ab6ece', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:32:32', '2016-11-06 00:32:32', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ed575989962b4896acafc1bdc39bb212', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:35:18', '2016-11-06 00:35:18', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('46bceeae3e48486d8bf4a1f975a8bfbc', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:36:34', '2016-11-06 00:36:34', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8a47b48f9de648409325274dfe52ffa1', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:36:53', '2016-11-06 00:36:53', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('cc926e578bcf425eb78cf11161d7d6b9', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:39:09', '2016-11-06 00:39:09', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('5cbce7ba4bfb4d50bffea02c3fdbd31c', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 00:45:20', '2016-11-06 00:45:20', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('af315ae02c654d2eac59429e5ea7948d', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 17:47:03', '2016-11-06 17:47:03', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('2c662303be074b70b6056b23405e963a', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 17:49:41', '2016-11-06 17:49:41', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ed567ccb8fcd4544a9e51957a8f21f67', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 17:51:33', '2016-11-06 17:51:33', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('80856733ef6545ccbf2d2cac1a40a665', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 17:56:49', '2016-11-06 17:56:49', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('17fd05e63d3c4b85b04b288511f535b0', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 17:58:24', '2016-11-06 17:58:24', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('4db266c4bd194190affdcda30f2dce9a', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 17:58:37', '2016-11-06 17:58:37', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('164824022be545eb9f40a5059fe8d793', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 18:04:27', '2016-11-06 18:04:27', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8f7573c6c2db44e08a2564197f397d55', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 18:16:30', '2016-11-06 18:16:30', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('947dc714f43d4f7a9f4f584bdd5dea42', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 18:16:51', '2016-11-06 18:16:51', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ea287e5daa2f47f0bf414b31502dfccf', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 18:24:53', '2016-11-06 18:24:53', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('c24c820453e745c483ceffdf428acd4f', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 18:25:11', '2016-11-06 18:25:11', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('627e10db4c344cd98c85d156519e8555', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 18:25:46', '2016-11-06 18:25:46', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('4c035e681b8c47e3b9b427a52c728334', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 22:01:23', '2016-11-06 22:01:23', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('36ba1fa2b31343b58529a8eebdb7b3da', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-06 22:01:27', '2016-11-06 22:01:27', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('6c659db5ca3343aaaef659fee602c52d', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8fbaa6c8f5dd41108d0b99d833d8b1cd', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('50843e06f9a54602b9e9f01edcc8c185', null, '0', '10', '10', '10', '0', null, '结果', '--', '2016-11-09 22:05:09', '2016-11-09 22:05:09', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ed4f1cb1b0af4a069415b4f97b9d9a96', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:20:07', '2016-11-10 21:20:07', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('31de8a07c17a4adfbe947aaad1f57631', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:21:41', '2016-11-10 21:21:41', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ca71291e38c24303853d5784770e1b3b', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:22:29', '2016-11-10 21:22:29', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e8500be63bcd4cd4a7a59a0b6bfe7440', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:22:46', '2016-11-10 21:22:46', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('3e0ac9b09121463fb684b9288bc80748', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:23:23', '2016-11-10 21:23:23', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('f4a1633e8f8e41baaa8e3f830d12ba05', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:23:42', '2016-11-10 21:23:42', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8b5f31f0475b4c049b53fc9d4aeca9d9', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:24:18', '2016-11-10 21:24:18', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('5c1a0dfaac1e4fc0b8ade2e5e7c76cc9', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:24:40', '2016-11-10 21:24:40', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('19a44c18b83a4e5b894615375b9c2490', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 21:25:03', '2016-11-10 21:25:03', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('bbc949090d19454e982e2882df597052', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-10 22:58:37', '2016-11-10 22:58:37', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8e5723794a5b4b2bbadba8a85dae12c0', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 00:25:26', '2016-11-11 00:25:26', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e0bf8e2f8c6f4d069c8d4828cb28f0bb', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 01:30:21', '2016-11-11 01:30:21', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('eed96fab2e3a4504bcc28414971870bc', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 01:31:12', '2016-11-11 01:31:12', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('cb0db2dd4eed4755a8d756fee10f859c', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 01:37:41', '2016-11-11 01:37:41', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('2f0faec56ae44338a99cc08518669844', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 10:57:27', '2016-11-11 10:57:27', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e8c163ebd0c9453aab91faf06e16d7f3', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 13:11:27', '2016-11-11 13:11:27', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e92cec4cc514403a8c8bb0bff747c912', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-11 13:50:54', '2016-11-11 13:50:54', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('c38216e9751a4b53916bdc0180dc7fac', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 14:28:40', '2016-11-12 14:28:40', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('d1f11b9f6a114a9b9ea8826e5d1aac51', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 21:53:07', '2016-11-12 21:53:07', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('281c880b2925409187d70ea4d2189e03', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 21:56:57', '2016-11-12 21:56:57', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('bc88e6150e344d66adec2382e5f15eee', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 22:13:34', '2016-11-12 22:13:34', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('39ad78066a1e497695cd5f3a053e9030', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 22:24:11', '2016-11-12 22:24:11', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('bdaa1b1c38af47c79b5e05cc227631d6', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 22:26:24', '2016-11-12 22:26:24', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8d83f9a2077843c191eda91b19a53894', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 22:38:26', '2016-11-12 22:38:26', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('9351b73668e14295b2d18c8d17ce0bf5', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-12 23:40:15', '2016-11-12 23:40:15', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('c1f5909f3bcb4e6784e9d68e93f74035', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 10:32:26', '2016-11-13 10:32:26', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('fb83de216c42437c8f43fa768cfcca1b', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 18:58:39', '2016-11-13 18:58:39', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8806fcea774e43e4af9fd32f2c1f5295', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 19:00:25', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8b196899ad8a40b8a1b865581d1d038f', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 20:59:56', '2016-11-13 20:59:56', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('f57c2ea99a6a43048bd651c56d46b2fb', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 21:03:40', '2016-11-13 21:03:40', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e581f328ead643babf274f1424586553', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 21:10:13', '2016-11-13 21:10:13', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('2d6e92d8893047bb974f1057878fcd57', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 21:12:03', '2016-11-13 21:12:03', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('d09c3a958ad54a1abcfddd558c23b351', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-13 21:24:15', '2016-11-13 21:24:15', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('0ddea42e9af546bcbecbd66109e609ac', null, '0', '10', '10', '10', '0', null, '下单获取10积分', '--', '2016-11-14 17:24:49', '2016-11-14 17:24:49', 'NORMAL');

-- ----------------------------
-- Table structure for cash_record
-- ----------------------------
DROP TABLE IF EXISTS `cash_record`;
CREATE TABLE `cash_record` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `before_money` varchar(255) DEFAULT NULL,
  `tx_money` varchar(255) DEFAULT NULL,
  `frozen_money` varchar(255) DEFAULT NULL,
  `after_bonus_points` varchar(255) DEFAULT NULL,
  `tx_type` varchar(255) DEFAULT NULL,
  `behavior_id` varchar(255) DEFAULT NULL,
  `tx_result` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cash_record
-- ----------------------------
INSERT INTO `cash_record` VALUES ('1', '1', '0', '111', '111', '20000', '111', '1', '1', '--', '2016-10-13 11:31:24', '2016-10-13 11:31:29', 'NORMAL');
INSERT INTO `cash_record` VALUES ('2766d2c54c0d4cc6bf05a5c34e244437', '1', '14904.5', '994.7', null, '13909.8', '支出', null, '结果', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c3f30f722c0141e2b13ca147962b87ad', '1', '13909.8', '986.2', null, '12923.6', '支出', null, '结果', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c32e7b1be4ae437d8ac0d1d472232db7', '1', '13909.8', '977.2', null, '12932.6', '支出', null, '结果', '--', '2016-11-09 22:05:09', '2016-11-09 22:05:09', 'NORMAL');
INSERT INTO `cash_record` VALUES ('bfd56e9858aa4fe18d5226230e7f6c70', '1', '12932.6', '953.2', null, '11979.4', '支出', null, '结果', '--', '2016-11-11 00:25:26', '2016-11-11 00:25:26', 'NORMAL');
INSERT INTO `cash_record` VALUES ('9e0d6a4080e64e428be95ee28a997fd9', '1', '11979.4', '920.2', null, '11059.2', '支出', null, '结果', '--', '2016-11-11 01:30:22', '2016-11-11 01:30:22', 'NORMAL');
INSERT INTO `cash_record` VALUES ('1528868fb8d5442ebfa640a0eaac3df1', '1', '11059.2', '914.7', null, '10144.5', '支出', null, '结果', '--', '2016-11-11 01:31:12', '2016-11-11 01:31:12', 'NORMAL');
INSERT INTO `cash_record` VALUES ('b09d3a7f4e2f41aaa85ea805a0da72f8', '1', '10144.5', '909.7', null, '9234.8', '支出', null, '结果', '--', '2016-11-11 01:37:41', '2016-11-11 01:37:41', 'NORMAL');
INSERT INTO `cash_record` VALUES ('3351dadc0a974125a276ab84d9106a4d', '1', '9234.8', '903.2', null, '8331.6', '支出', null, '结果', '--', '2016-11-11 10:57:27', '2016-11-11 10:57:27', 'NORMAL');
INSERT INTO `cash_record` VALUES ('6595bada9879424db6d898da7673462a', '1', '8331.6', '899.2', null, '7432.4', '支出', null, '结果', '--', '2016-11-11 13:11:27', '2016-11-11 13:11:27', 'NORMAL');
INSERT INTO `cash_record` VALUES ('5807d4c61f804ee6aee777459f30cbd4', '1', '20000', '1034.7', null, '18965.3', '支出', null, '结果', '--', '2016-11-06 18:16:31', '2016-11-06 18:16:31', 'NORMAL');
INSERT INTO `cash_record` VALUES ('db2ab49acf9c47d1b45130934b0ae84a', '1', '18965.3', '1027.2', null, '17938.1', '支出', null, '结果', '--', '2016-11-06 18:16:51', '2016-11-06 18:16:51', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c5a23033c9b9426abea46844e336f8e1', '1', '17938.1', '1019.2', null, '16918.9', '支出', null, '结果', '--', '2016-11-06 18:24:53', '2016-11-06 18:24:53', 'NORMAL');
INSERT INTO `cash_record` VALUES ('122b22e0b2944bc59474a2d622bd67f9', '1', '16918.9', '1011.2', null, '15907.7', '支出', null, '结果', '--', '2016-11-06 18:25:11', '2016-11-06 18:25:11', 'NORMAL');
INSERT INTO `cash_record` VALUES ('490124417b994882b34c7dc8585d442c', '1', '15907.7', '1003.2', null, '14904.5', '支出', null, '结果', '--', '2016-11-06 18:25:46', '2016-11-06 18:25:46', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0d126e8b69e244eb928eaec3f8e2ec78', '1', '7432.4', '896.2', null, '6536.2', '支出', null, '结果', '--', '2016-11-11 13:50:54', '2016-11-11 13:50:54', 'NORMAL');
INSERT INTO `cash_record` VALUES ('2d87b35236774dbab24a88af9f3c2e10', '1', '6536.2', '891.2', null, '5645.0', '支出', null, '结果', '--', '2016-11-12 14:28:40', '2016-11-12 14:28:40', 'NORMAL');
INSERT INTO `cash_record` VALUES ('6830a64eacc440bb891c6abe57bfdcfe', '1', '5645.0', '884.5', null, '4760.5', '支出', null, '结果', '--', '2016-11-12 21:53:07', '2016-11-12 21:53:07', 'NORMAL');
INSERT INTO `cash_record` VALUES ('3815ed39162d4feea1b99bea300c993c', '1', '4760.5', '881.3', null, '3879.2', '支出', null, '结果', '--', '2016-11-12 21:56:57', '2016-11-12 21:56:57', 'NORMAL');
INSERT INTO `cash_record` VALUES ('f9887dbe9ea14a2c87d09b91a8a1cc88', '1', '3879.2', '878.1', null, '3001.1', '支出', null, '结果', '--', '2016-11-12 22:13:34', '2016-11-12 22:13:34', 'NORMAL');
INSERT INTO `cash_record` VALUES ('af9a5e56f54b4091a8b9014c5111e68e', '1', '3001.1', '870.6', null, '2130.5', '支出', null, '结果', '--', '2016-11-12 22:24:11', '2016-11-12 22:24:11', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0a64434113c84f83a60e09c03f55f9cf', '1', '2130.5', '865.6', null, '1264.9', '支出', null, '结果', '--', '2016-11-12 22:26:24', '2016-11-12 22:26:24', 'NORMAL');
INSERT INTO `cash_record` VALUES ('057b9576f9864a659967c333dcfd1458', '1', '1264.9', '861.6', null, '403.3', '支出', null, '结果', '--', '2016-11-12 23:40:15', '2016-11-12 23:40:15', 'NORMAL');
INSERT INTO `cash_record` VALUES ('71a7294200e445ed91e943940d437868', '1', '403.3', '5.0', null, '398.3', '支出', null, '结果', '--', '2016-11-13 21:24:15', '2016-11-13 21:24:15', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c8e9a5461296438d977052f076386196', '1', '398.3', '5.5', null, '392.8', '支出', null, '结果', '--', '2016-11-14 17:24:49', '2016-11-14 17:24:49', 'NORMAL');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(64) NOT NULL,
  `order_detail_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `useful` varchar(255) DEFAULT NULL,
  `useless` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `product_score` varchar(255) DEFAULT NULL,
  `delivery_score` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '1', '-', '很好吃！', '1', '0', '0', '99', '96', '备注', '2016-10-10 14:03:23', '2016-10-10 14:03:29', 'NORMAL');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `face_value` varchar(255) DEFAULT NULL,
  `delay_day` varchar(255) DEFAULT NULL,
  `is_free` tinyint(4) DEFAULT NULL,
  `is_reuse` tinyint(4) DEFAULT NULL,
  `enough_money` varchar(255) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `include_group` varchar(255) DEFAULT NULL,
  `exclude_group` varchar(255) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES ('1', '馍店代金券', 'LUCKYMONEY', '0.5', '0', '0', '0', '5', '0', '', '', '2016-11-08 13:50:28', '2016-11-30 13:50:31', '--', '2016-11-08 13:50:44', '2016-11-08 13:50:46', 'NORMAL');
INSERT INTO `coupon` VALUES ('2', '红包', 'LUCKYMONEY', '5', '0', '0', '0', '50', '0', '', '', '2016-11-08 13:52:43', '2016-11-08 13:52:45', '--', '2016-11-08 13:52:49', '2016-11-08 13:52:52', 'NORMAL');

-- ----------------------------
-- Table structure for coupon_code
-- ----------------------------
DROP TABLE IF EXISTS `coupon_code`;
CREATE TABLE `coupon_code` (
  `id` varchar(255) NOT NULL,
  `coupon_id` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `is_used` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_code
-- ----------------------------
INSERT INTO `coupon_code` VALUES ('1', '1', '123456789', '1', '1', '--', '2016-11-08 13:47:52', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `coupon_code` VALUES ('2', '2', 'wwwwwqwdqdwq', '1', '1', '--', '2016-11-08 13:53:32', '2016-11-12 22:38:26', 'NORMAL');

-- ----------------------------
-- Table structure for coupon_history
-- ----------------------------
DROP TABLE IF EXISTS `coupon_history`;
CREATE TABLE `coupon_history` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `tx_behavior` varchar(255) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `is_send_used` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_history
-- ----------------------------

-- ----------------------------
-- Table structure for coupon_record
-- ----------------------------
DROP TABLE IF EXISTS `coupon_record`;
CREATE TABLE `coupon_record` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `coupon_code_id` varchar(255) DEFAULT NULL,
  `tx_type` varchar(255) DEFAULT NULL,
  `behavior_id` varchar(255) DEFAULT NULL,
  `tx_result` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_record
-- ----------------------------
INSERT INTO `coupon_record` VALUES ('acec1e84f17040a79a3b20cfb975a598', null, '1', '支出', null, '结果', '--', '2016-10-13 11:30:22', '2016-10-13 11:30:22', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('222d133a3af94da49f0d2634f6931a82', null, '1', '支出', null, '结果', '--', '2016-10-13 11:32:55', '2016-10-13 11:32:55', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('a751b07417bb4444ba6a5387440774d0', null, '1', '支出', null, '结果', '--', '2016-10-13 11:43:15', '2016-10-13 11:43:15', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('a64e829ad3a44430a1e6e4b2975babfd', null, '1', '支出', null, '结果', '--', '2016-10-17 15:34:54', '2016-10-17 15:34:54', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('600ce6aa01584900b597cec072036537', null, '1', '支出', null, '结果', '--', '2016-11-06 00:27:08', '2016-11-06 00:27:08', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('4677536171b841fb8f4e3e3c9860206b', null, '1', '支出', null, '结果', '--', '2016-11-06 00:31:06', '2016-11-06 00:31:06', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('1ea0c3dd27ba412b8a629af2bf80d13b', null, '1', '支出', null, '结果', '--', '2016-11-06 00:32:32', '2016-11-06 00:32:32', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('865d61bdef3e4703ba6ae64a4c853b16', null, '1', '支出', null, '结果', '--', '2016-11-06 00:35:18', '2016-11-06 00:35:18', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('ea8f1b3004ff4e3884d1c712d3df036d', null, '1', '支出', null, '结果', '--', '2016-11-06 00:36:34', '2016-11-06 00:36:34', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('d6255031ddf2463db4f141044b021b8b', null, '1', '支出', null, '结果', '--', '2016-11-06 00:36:53', '2016-11-06 00:36:53', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('3b6597dbbc4347798f4b3bb021c85511', null, '1', '支出', null, '结果', '--', '2016-11-06 00:39:09', '2016-11-06 00:39:09', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('ac31ef0fa92f41049101507293dc2549', null, '1', '支出', null, '结果', '--', '2016-11-06 00:45:20', '2016-11-06 00:45:20', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('85fe7a3d8faf4516985aa0c6cc576e1d', null, '1', '支出', null, '结果', '--', '2016-11-06 17:47:03', '2016-11-06 17:47:03', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('e4ed80eec63b4ab4a4c88b4c930fa497', null, '1', '支出', null, '结果', '--', '2016-11-06 17:49:41', '2016-11-06 17:49:41', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('e469f2e5535747a99f7120ad2112a3fc', null, '1', '支出', null, '结果', '--', '2016-11-06 17:51:41', '2016-11-06 17:51:41', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('4f2f3bcc78984344868ad5edf8bdbc62', null, '1', '支出', null, '结果', '--', '2016-11-06 17:57:00', '2016-11-06 17:57:00', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('1cabad6934cf42679c278fad259773e1', null, '1', '支出', null, '结果', '--', '2016-11-06 17:58:26', '2016-11-06 17:58:26', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('cb49bf66ead34bbe856a2c833f9282fe', null, '1', '支出', null, '结果', '--', '2016-11-06 17:58:41', '2016-11-06 17:58:41', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('25f9b518c607460cba2e14567cdbb841', null, '1', '支出', null, '结果', '--', '2016-11-06 18:04:28', '2016-11-06 18:04:28', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('40777784f88049f382c21c1f1e033ecd', null, '1', '支出', null, '结果', '--', '2016-11-06 18:16:30', '2016-11-06 18:16:30', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('28b88481484a4b3c9a29df9e99d80557', null, '1', '支出', null, '结果', '--', '2016-11-06 18:16:51', '2016-11-06 18:16:51', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('2ca369e1c5f642d1a1f533c813456bb7', null, '1', '支出', null, '结果', '--', '2016-11-06 18:24:53', '2016-11-06 18:24:53', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('82396a04dd3345f9b5ac3de11b3a2f5c', null, '1', '支出', null, '结果', '--', '2016-11-06 18:25:11', '2016-11-06 18:25:11', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('f92fdd4727374aeeb1f398b432274f9f', null, '1', '支出', null, '结果', '--', '2016-11-06 18:25:46', '2016-11-06 18:25:46', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('205b1e169ca34261af743e33a0bc75b7', null, '1', '支出', null, '结果', '--', '2016-11-06 22:01:23', '2016-11-06 22:01:23', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('a1a1a2fad1084c7882eafeae77935ae0', null, '1', '支出', null, '结果', '--', '2016-11-06 22:01:27', '2016-11-06 22:01:27', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('507a74db73d842b680e08fb53b7eb52a', '1', '1', '支出', null, '结果', '--', '2016-11-09 22:05:09', '2016-11-09 22:05:09', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('9012077c63474f32beec9b08224327bd', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:17:53', '2016-11-10 21:17:53', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('6d7a4f8cb11e4172a3b66203506314bf', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:20:07', '2016-11-10 21:20:07', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('a2d7d26306294fffbfa51d7c15ac2337', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:21:41', '2016-11-10 21:21:41', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('4f5f46fdb6a44f2d96081448e5190d39', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:22:29', '2016-11-10 21:22:29', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('38b3a979c49e42c6b0ae8feca8b5b668', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:22:46', '2016-11-10 21:22:46', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('d229b577b3ac42369d1572a8f84c40c0', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:23:23', '2016-11-10 21:23:23', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('c369ba2efb3b49ee9e427d73ba6dddae', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:23:42', '2016-11-10 21:23:42', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('0cf60125c8a042bd81c6015ada0b848f', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:24:18', '2016-11-10 21:24:18', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('23e0d369e3cc4457a2f3e949970c3764', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:24:40', '2016-11-10 21:24:40', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('dd52c5719bd74a17b8085524ea031cf7', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 21:25:03', '2016-11-10 21:25:03', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('5c460cacc10e41b88194ffb56b5d8934', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-10 22:58:37', '2016-11-10 22:58:37', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('51342392fc0c4cfa88a3f29251cf2a77', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-11 00:25:26', '2016-11-11 00:25:26', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('134341c7e1914748960f035c6b4f7674', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-11 10:57:27', '2016-11-11 10:57:27', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('90660e6b2e434263abf874288b584c8d', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-12 14:28:40', '2016-11-12 14:28:40', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('75a46fc492f24e1ea2919e497717596f', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-12 22:24:11', '2016-11-12 22:24:11', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('3c095de2c80c4718bb6f3e75d3a6126b', '1', '2', '支出', null, '消费一张优惠券金额为5.0', '--', '2016-11-12 22:38:26', '2016-11-12 22:38:26', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('6255e19309bc4195930e269b4d40aca1', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-13 19:00:25', '2016-11-13 19:00:25', 'NORMAL');

-- ----------------------------
-- Table structure for delivery_address
-- ----------------------------
DROP TABLE IF EXISTS `delivery_address`;
CREATE TABLE `delivery_address` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `region_province_id` varchar(255) DEFAULT NULL,
  `region_country_id` varchar(255) DEFAULT NULL,
  `region_city_id` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `tag` varchar(8) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `is_default` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_address
-- ----------------------------
INSERT INTO `delivery_address` VALUES ('1', '1', '1', '1', '1', '收货人1', '孙寺', '1860000001', 'MAN', '家', '05308911051', null, '274200', '1', '--', '2016-10-11 11:39:18', '2016-10-11 11:39:20', 'NORMAL');
INSERT INTO `delivery_address` VALUES ('2', '1', '1', '1', '6', '收货人2', '单县', '13900000001', 'WOMAN', '公司', '05308600000', null, '274200', '0', '--', '2016-10-11 11:40:30', '2016-10-11 11:40:33', 'NORMAL');

-- ----------------------------
-- Table structure for delivery_time
-- ----------------------------
DROP TABLE IF EXISTS `delivery_time`;
CREATE TABLE `delivery_time` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_time
-- ----------------------------
INSERT INTO `delivery_time` VALUES ('1', '明天10:00-18:00', '--', '2016-10-10 14:07:01', '2016-10-10 14:06:59', 'NORMAL');
INSERT INTO `delivery_time` VALUES ('2', '今天10:00-18:00', '--', '2016-10-10 14:10:14', '2016-10-10 14:10:16', 'NORMAL');

-- ----------------------------
-- Table structure for delivery_type
-- ----------------------------
DROP TABLE IF EXISTS `delivery_type`;
CREATE TABLE `delivery_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_type
-- ----------------------------

-- ----------------------------
-- Table structure for email_template
-- ----------------------------
DROP TABLE IF EXISTS `email_template`;
CREATE TABLE `email_template` (
  `id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `is_enable` tinyint(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_template
-- ----------------------------

-- ----------------------------
-- Table structure for flow_status
-- ----------------------------
DROP TABLE IF EXISTS `flow_status`;
CREATE TABLE `flow_status` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pre_status_id` varchar(255) DEFAULT NULL,
  `next_status_id` varchar(255) DEFAULT NULL,
  `pay_way` varchar(255) DEFAULT NULL,
  `order_by` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_status
-- ----------------------------
INSERT INTO `flow_status` VALUES ('1', '未付款', '', '2', 'ONLINE', '1', '--', '2016-11-15 23:14:02', '2016-11-15 23:14:04', 'NORMAL');
INSERT INTO `flow_status` VALUES ('2', '已付款', '1', '3', 'ONLINE', '2', '--', '2016-11-15 23:14:51', '2016-11-15 23:14:54', 'NORMAL');
INSERT INTO `flow_status` VALUES ('3', '拣货中', '2', '4', 'ONLINE', '3', '--', '2016-11-15 23:15:41', '2016-11-15 23:15:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('4', '配送中', '3', '5', 'ONLINE', '4', '--', '2016-11-15 23:16:41', '2016-11-15 23:16:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('5', '派件中', '4', '6', 'ONLINE', '5', '--', '2016-11-15 23:17:14', '2016-11-15 23:17:20', 'NORMAL');
INSERT INTO `flow_status` VALUES ('6', '已送达', '5', '', 'ONLINE', '6', '--', '2016-11-15 23:17:16', '2016-11-15 23:17:23', 'NORMAL');
INSERT INTO `flow_status` VALUES ('7', '货到付款', '', '8', 'OFFLINE', '1', '--', '2016-11-15 23:15:41', '2016-11-15 23:15:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('', '拣货中', null, null, null, null, null, null, null, null);
INSERT INTO `flow_status` VALUES ('9', '配送中', '8', '10', 'OFFLINE', '3', '--', '2016-11-15 23:16:41', '2016-11-15 23:16:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('10', '派件中', '9', '11', 'OFFLINE', '4', '--', '2016-11-15 23:17:14', '2016-11-15 23:17:20', 'NORMAL');
INSERT INTO `flow_status` VALUES ('11', '已送达', '10', '', 'OFFLINE', '5', '--', '2016-11-15 23:17:16', '2016-11-15 23:17:23', 'NORMAL');

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
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `employer` tinyint(4) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `region_province_id` int(11) DEFAULT NULL,
  `region_city_id` int(11) DEFAULT NULL,
  `region_country_id` int(11) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `income_month` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '1', '1', 'Cheng', null, '18600536683', null, null, null, 'MAN', null, null, null, null, null, null, null, null, null, null, null, null, 'NORMAL');
INSERT INTO `member` VALUES ('bad8d84ebf7445c39156158426ae356e', '08f1a907ed5e4d7680fb5aa559925467', null, 'Chen', null, '18600536683', null, null, null, 'MAN', null, null, null, null, null, null, null, null, null, null, null, null, 'NORMAL');
INSERT INTO `member` VALUES ('2129333011c64d0e8b3b12c3385ccd5f', '36e9820b365b4585ada816e387328e69', null, 'Cheng', null, '18600536683', null, null, null, 'MAN', null, '0', '0', '0', null, null, null, null, null, '2016-07-12 18:37:02', '2016-07-12 18:37:02', '--', 'NORMAL');
INSERT INTO `member` VALUES ('4710c0e0a4a34118824594499da1f33b', 'bbe76ee9b432466a93ceee835eb6ab6a', null, 'Cheng', null, '18600536683', null, null, null, 'MAN', null, '0', '0', '0', null, null, null, null, null, '2016-07-12 18:40:09', '2016-07-12 18:40:09', '--', 'NORMAL');
INSERT INTO `member` VALUES ('8641e5226a40445994843069a86972df', 'ad90aeda385243278c07099c5bb67e31', null, 'Cheng', null, '18600536683', null, null, null, 'MAN', null, '0', '0', '0', null, null, null, null, null, '2016-09-20 10:03:47', '2016-09-20 10:03:47', '--', 'NORMAL');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '通告1', '微信端上线了，敬请使用 ~ ~', 'http://www.zhihu.com', '备注', '2016-06-29 16:03:56', '2016-06-29 16:03:58', 'NORMAL');
INSERT INTO `notice` VALUES ('2', '通告2', '兑换【饿了么】畅享美食红包 消耗20金币', 'http://www.baidu.com', '备注', '2016-06-29 16:32:02', '2016-06-29 16:32:08', 'NORMAL');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `relate_oid` varchar(11) DEFAULT NULL,
  `balance_offset` double DEFAULT NULL,
  `amount_payable` double DEFAULT NULL,
  `amount_paid` double DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `delivery_time` varchar(255) DEFAULT NULL,
  `pay` varchar(11) DEFAULT NULL,
  `delivery_type_id` varchar(11) DEFAULT NULL,
  `arayacak_address` varchar(255) DEFAULT NULL,
  `arayacak_delivery_time` varchar(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `pay_status` varchar(255) DEFAULT NULL,
  `order_type` varchar(255) DEFAULT NULL,
  `freight_reduce` varchar(255) DEFAULT NULL,
  `freight_payable` varchar(255) DEFAULT NULL,
  `product_total_price` decimal(10,0) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `remark_customer` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `exchange_oid` int(11) DEFAULT NULL,
  `custom_pice` varchar(255) DEFAULT NULL,
  `coupon_code` varchar(255) DEFAULT NULL,
  `coupon_reduce_price` decimal(10,0) DEFAULT NULL,
  `flow_status` varchar(255) DEFAULT NULL,
  `bonus_point_reduce_price` decimal(10,0) DEFAULT NULL,
  `is_free_account_level` varchar(255) DEFAULT NULL,
  `comment_id` varchar(255) DEFAULT NULL,
  `since` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1700b55803cc44dfa08bac0028bee46f', '1', '14458117', null, '6', '6.2', '0.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '4', '0', '备注', '274200', '05308911051', null, '2016-10-17 15:34:54', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-10-17 15:34:54', '2016-10-17 15:34:54', 'NORMAL');
INSERT INTO `order_info` VALUES ('85f567341bea41de84759327276abba6', '1', '75070930', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-12 10:36:43', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-12 10:36:46', '2016-10-12 10:36:46', 'NORMAL');
INSERT INTO `order_info` VALUES ('32f58e9a08284be79f90ac9cd340e614', '1', '76190870', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-12 11:58:28', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-12 11:58:30', '2016-10-12 11:58:30', 'NORMAL');
INSERT INTO `order_info` VALUES ('897b4eb21eb54bb2b8d02552a5fc93a7', '1', '70548275', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-12 12:07:01', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-12 12:07:03', '2016-10-12 12:07:03', 'NORMAL');
INSERT INTO `order_info` VALUES ('0bd953a731b84a1d8b688fe7b8de7023', '1', '02288732', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-12 13:54:04', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-12 13:54:08', '2016-10-12 13:54:08', 'NORMAL');
INSERT INTO `order_info` VALUES ('9aee1dc1e67d4235b86a89d943b3f1d5', '1', '56014411', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 09:58:33', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 09:58:38', '2016-10-13 09:58:38', 'NORMAL');
INSERT INTO `order_info` VALUES ('3e3c33dd5de0476e92e408e4ee9cbd02', '1', '43473491', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 10:15:30', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 10:15:34', '2016-10-13 10:15:34', 'NORMAL');
INSERT INTO `order_info` VALUES ('4555830ca5344244a3265005c184d513', '1', '28152547', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 10:17:34', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 10:17:38', '2016-10-13 10:17:38', 'NORMAL');
INSERT INTO `order_info` VALUES ('8a21d39d985d4876adf42af849977eb2', '1', '00933862', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 11:17:30', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 11:17:34', '2016-10-13 11:17:34', 'NORMAL');
INSERT INTO `order_info` VALUES ('8d5420008e094013b6b0a92c95241190', '1', '07753186', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 11:20:00', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 11:20:04', '2016-10-13 11:20:04', 'NORMAL');
INSERT INTO `order_info` VALUES ('e0a7c8746c0548fb9342bc0733bbc757', '1', '85845262', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 11:21:06', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 11:21:10', '2016-10-13 11:21:10', 'NORMAL');
INSERT INTO `order_info` VALUES ('6d2c19644c5740da8dd77c028e4b5cb5', '1', '04553268', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 11:29:54', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 11:29:58', '2016-10-13 11:29:58', 'NORMAL');
INSERT INTO `order_info` VALUES ('e24136415c1c4986b1de4cd6d5f416e7', '1', '29522347', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 11:32:04', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 11:32:08', '2016-10-13 11:32:08', 'NORMAL');
INSERT INTO `order_info` VALUES ('db158022b44b4c14ab11e1028c145e01', '1', '19902742', null, null, '3.2', '3.2', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '备注', '274200', '05308911051', null, '2016-10-13 11:43:01', null, null, '122355', null, '已支付', '1', '0', null, null, '--', '2016-10-13 11:43:06', '2016-10-13 11:43:06', 'NORMAL');
INSERT INTO `order_info` VALUES ('7b3017a7ceb1418691d52417060206d6', '1', '80301769', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:27:05', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:27:07', '2016-11-06 00:27:07', 'NORMAL');
INSERT INTO `order_info` VALUES ('fea7792e99ba4d4c8e85e457369ea65e', '1', '09133902', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:31:04', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:31:06', '2016-11-06 00:31:06', 'NORMAL');
INSERT INTO `order_info` VALUES ('ab96857bdaf949978295a2e1b876fa0d', '1', '08292455', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:32:30', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:32:31', '2016-11-06 00:32:31', 'NORMAL');
INSERT INTO `order_info` VALUES ('a92378fa93364348b6ed1f2df606a443', '1', '67016531', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:35:16', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:35:17', '2016-11-06 00:35:17', 'NORMAL');
INSERT INTO `order_info` VALUES ('494e0dabba474219aabb7e1e2de27853', '1', '81893558', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:36:32', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:36:34', '2016-11-06 00:36:34', 'NORMAL');
INSERT INTO `order_info` VALUES ('0a8b3611e51143aaaba4bb107f9a111d', '1', '29580650', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:36:51', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:36:53', '2016-11-06 00:36:53', 'NORMAL');
INSERT INTO `order_info` VALUES ('c9ca49cc68024a71a494927835875d34', '1', '74041111', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:39:07', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:39:08', '2016-11-06 00:39:08', 'NORMAL');
INSERT INTO `order_info` VALUES ('9720f64bd755497b991330ca30058180', '1', '63842497', null, '6', '8.5', '2.5', '收货人1', '1860000001', '孙寺', '2016年9月29日', '1', '1', null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '7', '0', '备注', '274200', '05308911051', null, '2016-11-06 00:45:18', null, null, '122355', '0', '已支付', '0', '0', null, null, '--', '2016-11-06 00:45:19', '2016-11-06 00:45:19', 'NORMAL');
INSERT INTO `order_info` VALUES ('d95640b83e07412a9260a8365b48dd1d', '1', '48655015', null, '1079.7', '5.5', '-1074.2', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', 'kkkkk', '274200', '05308911051', null, '2016-11-06 17:18:14', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 17:18:15', '2016-11-06 17:18:15', 'NORMAL');
INSERT INTO `order_info` VALUES ('d245603ef6724f0caf759481b4609306', '1', '40765728', null, '1072.2', '5.5', '-1066.7', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', 'ooooooo', '274200', '05308911051', null, '2016-11-06 17:29:02', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 17:29:03', '2016-11-06 17:29:03', 'NORMAL');
INSERT INTO `order_info` VALUES ('37b32ec0f9064caa8b57c45ed906552d', '1', '13209256', null, null, '5.5', '5.5', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', 'llll', '274200', '05308911051', null, '2016-11-06 17:30:10', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 17:30:11', '2016-11-06 17:30:11', 'NORMAL');
INSERT INTO `order_info` VALUES ('b7f495c499024a0c863f9ed763afdd78', '1', '05107417', null, '1064.7', '5.5', '-1059.2', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', 'oooo', '274200', '05308911051', null, '2016-11-06 17:36:42', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:36:43', '2016-11-06 17:36:43', 'NORMAL');
INSERT INTO `order_info` VALUES ('444d1871491b40ba88984da876997125', '1', '15795669', null, '1057.2', '5.5', '-1051.7', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', 'iiii', '274200', '05308911051', null, '2016-11-06 17:41:50', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 17:41:51', '2016-11-06 17:41:51', 'NORMAL');
INSERT INTO `order_info` VALUES ('ccfaf5e04e16420e9f2240defeba6be7', '1', '52488484', null, '1049.7', '5.5', '-1044.2', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', 'kkkk', '274200', '05308911051', null, '2016-11-06 17:47:02', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:47:03', '2016-11-06 17:47:03', 'NORMAL');
INSERT INTO `order_info` VALUES ('60c43c556c064192a994b3ee0bd41106', '1', '05932460', null, null, '5.5', '5.5', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', 'iiiii', '274200', '05308911051', null, '2016-11-06 17:49:40', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:49:41', '2016-11-06 17:49:41', 'NORMAL');
INSERT INTO `order_info` VALUES ('a47cd86c02064601b75976ad531727ca', '1', '28041969', null, null, '5.5', '5.5', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', 'pppp', '274200', '05308911051', null, '2016-11-06 17:51:20', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:51:21', '2016-11-06 17:51:21', 'NORMAL');
INSERT INTO `order_info` VALUES ('0f47b5855afa4acc82a1f515a0667d7f', '1', '87269926', null, null, '5.5', '5.5', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-06 17:56:42', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:56:43', '2016-11-06 17:56:43', 'NORMAL');
INSERT INTO `order_info` VALUES ('5de2e123ef5042958d5501d2f12f73eb', '1', '88001282', null, null, '5.5', '5.5', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-06 17:58:10', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:58:11', '2016-11-06 17:58:11', 'NORMAL');
INSERT INTO `order_info` VALUES ('1738658a14eb483c8ad349defd5d6d69', '1', '72176421', null, null, '5.5', '5.5', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-06 17:58:36', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 17:58:37', '2016-11-06 17:58:37', 'NORMAL');
INSERT INTO `order_info` VALUES ('530ccea412424e5588363ddad14f55ad', '1', '66107843', null, '1042.2', '5.5', '-1036.7', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', 'yyyyy', '274200', '05308911051', null, '2016-11-06 18:04:26', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 18:04:27', '2016-11-06 18:04:27', 'NORMAL');
INSERT INTO `order_info` VALUES ('7fcb590e0e0a469dbec7de7d9b62f581', '1', '81584739', null, '1034.7', '5.5', '-1029.2', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', 'jjj', '274200', '05308911051', null, '2016-11-06 18:16:29', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 18:16:30', '2016-11-06 18:16:30', 'NORMAL');
INSERT INTO `order_info` VALUES ('db82b9122c2542b7a9adf4b488006821', '1', '67440119', null, '1027.2', '5.5', '-1021.7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', 'kkkk', '274200', '05308911051', null, '2016-11-06 18:16:49', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 18:16:50', '2016-11-06 18:16:50', 'NORMAL');
INSERT INTO `order_info` VALUES ('08b63a7ac837452b80d24a28cd7595c4', '1', '57835249', null, '1019.2', '6', '-1013.2', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', '哈哈哈哈', '274200', '05308911051', null, '2016-11-06 18:24:53', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 18:24:53', '2016-11-06 18:24:53', 'NORMAL');
INSERT INTO `order_info` VALUES ('ef35931a2b9c439cb65421effb35ab9c', '1', '33475119', null, '1011.2', '6', '-1005.2', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', '哈哈哈哈', '274200', '05308911051', null, '2016-11-06 18:25:11', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 18:25:11', '2016-11-06 18:25:11', 'NORMAL');
INSERT INTO `order_info` VALUES ('dd115a830d964aebb7fbfddf72b88ce6', '1', '37709392', null, '1003.2', '6', '-997.2', null, '1860000001', '孙寺', '今天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-06 18:25:46', null, null, '122355', '0', '货到付款', '0', '0', null, '0', '--', '2016-11-06 18:25:46', '2016-11-06 18:25:46', 'NORMAL');
INSERT INTO `order_info` VALUES ('5be25434913d4b84980e6a5262f41e71', '1', '87514247', null, null, '6', '6', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-06 22:01:22', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 22:01:22', '2016-11-06 22:01:22', 'NORMAL');
INSERT INTO `order_info` VALUES ('e7937172b3b84288858c00f0556df09d', '1', '12168331', null, null, '6', '6', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-06 22:01:27', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-06 22:01:27', '2016-11-06 22:01:27', 'NORMAL');
INSERT INTO `order_info` VALUES ('7e264011cc434cbc8d1c01c70eb4cecf', '1', '88375775', null, '994.7', '6.5', '-988.2', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '9', '0', '', '274200', '05308911051', null, '2016-11-09 07:48:40', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `order_info` VALUES ('75724f29223b4f82b1f7639eda5d68a5', '1', '93294353', null, '986.2', '6.5', '-979.7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '9', '0', '', '274200', '05308911051', null, '2016-11-09 07:48:40', null, null, '122355', '0', null, '0', '0', null, '0', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `order_info` VALUES ('bfc5988788b94b359f95e52bbc7ead00', '1', '04350188', null, '977.2', '6.5', '-970.7', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '9', '0', '>_<https://i', '274200', '05308911051', null, '2016-11-09 22:05:09', null, null, '122355', '1', null, '0', '0', null, '0', '--', '2016-11-09 22:05:09', '2016-11-09 22:05:09', 'NORMAL');
INSERT INTO `order_info` VALUES ('bd61217b363e41f5931097f75279d360', '1', '85871366', null, null, '7', '7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:20:07', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:20:07', '2016-11-10 21:20:07', 'NORMAL');
INSERT INTO `order_info` VALUES ('54b61429673c4ca6a1fac982f17c047d', '1', '47558531', null, null, '7', '7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:21:41', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:21:41', '2016-11-10 21:21:41', 'NORMAL');
INSERT INTO `order_info` VALUES ('ed401fa425ad4b6eb20bf2f642dd7123', '1', '40806580', null, null, '7', '7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:22:29', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:22:29', '2016-11-10 21:22:29', 'NORMAL');
INSERT INTO `order_info` VALUES ('a26323007afd41e89eb3a5091ef4a3c8', '1', '76253554', null, null, '7', '7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:22:46', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:22:46', '2016-11-10 21:22:46', 'NORMAL');
INSERT INTO `order_info` VALUES ('5805b78784e941d983ceaa15e0ccaed0', '1', '22285654', null, null, '7', '7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:23:23', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:23:23', '2016-11-10 21:23:23', 'NORMAL');
INSERT INTO `order_info` VALUES ('ab8aec9692b94989a671e2f4bdb62db2', '1', '04213662', null, null, '7', '7', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:23:42', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:23:42', '2016-11-10 21:23:42', 'NORMAL');
INSERT INTO `order_info` VALUES ('8016cf6019cd41628deafe2106cc263a', '1', '91266795', null, null, '7', '7', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:24:18', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:24:18', '2016-11-10 21:24:18', 'NORMAL');
INSERT INTO `order_info` VALUES ('cd1640e0c5744b36bfecc2ebb0f4b9b9', '1', '46767264', null, null, '7', '7', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:24:40', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:24:40', '2016-11-10 21:24:40', 'NORMAL');
INSERT INTO `order_info` VALUES ('8aef6d5fa8a7454dbfdd0ba6bb972c3f', '1', '33419965', null, null, '7', '7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '10', '0', '', '274200', '05308911051', null, '2016-11-10 21:25:03', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-10 21:25:03', '2016-11-10 21:25:03', 'NORMAL');
INSERT INTO `order_info` VALUES ('f1a7ee9f7b804706825204f35013dd81', '1', '43110273', null, null, '8', '8', null, '1860000001', '孙寺', '今天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '11', '0', '', '274200', '05308911051', null, '2016-11-10 22:58:37', null, null, '123456789', '1', '货到付款', '0', '0', null, '0', '--', '2016-11-10 22:58:37', '2016-11-10 22:58:37', 'NORMAL');
INSERT INTO `order_info` VALUES ('b6e39874e3964c698fe470680556a138', '1', '36397347', null, '953.2', '8.5', '-944.7', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '11', '0', '', '274200', '05308911051', null, '2016-11-11 00:25:26', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-11 00:25:26', '2016-11-11 00:25:26', 'NORMAL');
INSERT INTO `order_info` VALUES ('e9d459c8dd6449a3bc98dbf5e10a1a4c', '1', '54922623', null, '920.2', '3', '-917.2', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-11 01:30:21', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-11 01:30:21', '2016-11-11 01:30:21', 'NORMAL');
INSERT INTO `order_info` VALUES ('4082eaa8ef154e37a38312b18da11ab9', '1', '43239788', null, '914.7', '3.5', '-911.2', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '6', '0', '', '274200', '05308911051', null, '2016-11-11 01:31:12', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-11 01:31:12', '2016-11-11 01:31:12', 'NORMAL');
INSERT INTO `order_info` VALUES ('ddfddf735014466b8ae213f9bbf940b9', '1', '15675596', null, '909.7', '5', '-904.7', null, '1860000001', '孙寺', '今天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '3', '0', '', '274200', '05308911051', null, '2016-11-11 01:37:41', null, null, null, '0', '货到付款', '0', '0', null, '0', '--', '2016-11-11 01:37:41', '2016-11-11 01:37:41', 'NORMAL');
INSERT INTO `order_info` VALUES ('dc65756807d742919df901f83b194063', '1', '36500437', null, '903.2', '4', '-899.2', null, '13900000001', '单县', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '7', '0', '', '274200', '05308600000', null, '2016-11-11 10:57:27', null, null, '123456789', '1', '未付款', '0', '0', null, '0', '--', '2016-11-11 10:57:27', '2016-11-11 10:57:27', 'NORMAL');
INSERT INTO `order_info` VALUES ('55e65f822692432c9156f62df53a6f11', '1', '99821966', null, '899.2', '4', '-895.2', null, '1860000001', '孙寺', '明天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '2', '0', '', '274200', '05308911051', null, '2016-11-11 13:11:27', null, null, null, '0', '货到付款', '0', '0', null, '0', '--', '2016-11-11 13:11:27', '2016-11-11 13:11:27', 'NORMAL');
INSERT INTO `order_info` VALUES ('f83e000821ed466980605060a55989f7', '1', '90331433', null, '896.2', '3', '-893.2', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-11 13:50:54', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-11 13:50:54', '2016-11-11 13:50:54', 'NORMAL');
INSERT INTO `order_info` VALUES ('67b70518bbe549f28f4ba2568e473c1a', '1', '67494811', null, '891.2', '2.5', '-888.7', null, '1860000001', '孙寺', '今天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '5', '0', '下午吃饭要吃', '274200', '05308911051', null, '2016-11-12 14:28:40', null, null, '123456789', '1', '货到付款', '0', '0', null, '0', '--', '2016-11-12 14:28:40', '2016-11-12 14:28:40', 'NORMAL');
INSERT INTO `order_info` VALUES ('050baf246b344c6e8b86f6c3388bfba0', '1', '35625787', null, '884.5', '6.7', '-877.8', null, '1860000001', '孙寺', '明天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '5', '0', '好吃', '274200', '05308911051', null, '2016-11-12 21:53:07', null, null, null, '0', '货到付款', '0', '0', null, '0', '--', '2016-11-12 21:53:07', '2016-11-12 21:53:07', 'NORMAL');
INSERT INTO `order_info` VALUES ('c21fbb1b176b44a7874da6a50c8f2118', '1', '53219450', null, '881.3', '3.2', '-878.1', null, '13900000001', '单县', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '1', '0', '我的https://item.taobao.com/item.htm?spm=a230r.1.14.244.9tBaI8&id=523089294735&ns=1&abbucket=11#d', '274200', '05308600000', null, '2016-11-12 21:56:57', null, null, null, '0', '货到付款', '0', '0', null, '0', '--', '2016-11-12 21:56:57', '2016-11-12 21:56:57', 'NORMAL');
INSERT INTO `order_info` VALUES ('665babd0bc024505a306654ecef78506', '1', '62911929', null, '878.1', '3.2', '-874.9', null, '1860000001', '孙寺', '明天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '1', '0', '^_^', '274200', '05308911051', null, '2016-11-12 22:13:34', null, null, null, '0', '货到付款', '0', '0', null, '0', '--', '2016-11-12 22:13:34', '2016-11-12 22:13:34', 'NORMAL');
INSERT INTO `order_info` VALUES ('94bad131eab942578a3c6d295c1083ce', '1', '13668822', null, '870.6', '5', '-865.6', null, '13900000001', '单县', '今天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '8', '0', '好好', '274200', '05308600000', null, '2016-11-12 22:24:11', null, null, '123456789', '1', '货到付款', '0', '0', null, '0', '--', '2016-11-12 22:24:11', '2016-11-12 22:24:11', 'NORMAL');
INSERT INTO `order_info` VALUES ('463ae856043644959265bc3a69e379dc', '1', '69299428', null, '865.6', '5', '-860.6', null, '1860000001', '孙寺', '今天10:00-18:00', '货到付款', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '3', '0', '', '274200', '05308911051', null, '2016-11-12 22:26:24', null, null, null, '0', '货到付款', '0', '0', null, '0', '--', '2016-11-12 22:26:24', '2016-11-12 22:26:24', 'NORMAL');
INSERT INTO `order_info` VALUES ('48f73dd2eee24f379099aca2428a7e9e', '1', '66353257', null, null, '46', '46', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '53', '0', '', '274200', '05308911051', null, '2016-11-12 22:38:26', null, null, 'wwwwwqwdqdwq', '5', '未付款', '0', '0', null, '0', '--', '2016-11-12 22:38:26', '2016-11-12 22:38:26', 'NORMAL');
INSERT INTO `order_info` VALUES ('ee439a15edac4776a8ece5c609d2ca49', '1', '37881859', null, '861.6', '4', '-857.6', null, '18600536683', '批发街中间路北', '明天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '0', '2', '2', '0', '', null, null, null, '2016-11-12 23:40:15', null, null, null, '0', '货到付款', '0', '0', null, '1', '--', '2016-11-12 23:40:15', '2016-11-12 23:40:15', 'NORMAL');
INSERT INTO `order_info` VALUES ('5ae68443834848ef99554fce3938cce7', '1', '15932315', null, null, '6', '6', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '4', '0', '', '274200', '05308911051', null, '2016-11-13 10:32:26', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 10:32:26', '2016-11-13 10:32:26', 'NORMAL');
INSERT INTO `order_info` VALUES ('2a6a4e5892754eed9af5fdbc3cf6c5cd', '1', '90123151', null, '853.9', '5.7', '-848.2', null, '13900000001', '单县', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '8', '0', '', '274200', '05308600000', null, '2016-11-13 18:58:39', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 18:58:39', '2016-11-13 18:58:39', 'NORMAL');
INSERT INTO `order_info` VALUES ('3b201596b54c4a03a36387faec233b00', '1', '35637484', null, null, '24.5', '24.5', null, '1860000001', '孙寺', '明天10:00-18:00', 'cheng', null, null, null, null, null, null, 'FREIGHTCOLLECT', 'NORMAL', '2', '0', '27', '0', '', '274200', '05308911051', null, '2016-11-13 19:00:25', null, null, '123456789', '1', '货到付款', '0', '0', null, '0', '--', '2016-11-13 19:00:25', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `order_info` VALUES ('df915e73cf1640f8989030d0cbf4b1c5', '1', '03187357', null, '847.9', '4', '-843.9', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '2', '0', '6', '0', '', '274200', '05308911051', null, '2016-11-13 20:59:56', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 20:59:56', '2016-11-13 20:59:56', 'NORMAL');
INSERT INTO `order_info` VALUES ('1d79d6eaf31d4a4a8f6c3e23c1659e93', '1', '50792906', null, '844.9', '3', '-841.9', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-13 21:03:40', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 21:03:40', '2016-11-13 21:03:40', 'NORMAL');
INSERT INTO `order_info` VALUES ('4eff909630964aeeb53138df11a1961c', '1', '71343301', null, '841.9', '3', '-838.9', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-13 21:10:13', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 21:10:13', '2016-11-13 21:10:13', 'NORMAL');
INSERT INTO `order_info` VALUES ('45af6f7816cf495489a3be68e9b98413', '1', '30004304', null, null, '4', '4', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '2', '0', '', '274200', '05308911051', null, '2016-11-13 21:12:02', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 21:12:02', '2016-11-13 21:12:02', 'NORMAL');
INSERT INTO `order_info` VALUES ('8fbb086564bb4eb187aa38fd13f4080b', '1', '45482397', null, '5', '5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '3', '0', '', '274200', '05308911051', null, '2016-11-13 21:24:15', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-13 21:24:15', '2016-11-13 21:24:15', 'NORMAL');
INSERT INTO `order_info` VALUES ('cfcd0d35ff464bf8a002d7b5aec00bd9', '1', '56359466', null, '5.5', '5.5', '0', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NONPAYMENT', 'NORMAL', '0', '2', '4', '0', '', '274200', '05308911051', null, '2016-11-14 17:24:49', null, null, null, '0', '未付款', '0', '0', null, '0', '--', '2016-11-14 17:24:49', '2016-11-14 17:24:49', 'NORMAL');

-- ----------------------------
-- Table structure for order_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_product_detail`;
CREATE TABLE `order_product_detail` (
  `id` varchar(255) NOT NULL,
  `order_info_id` varchar(255) DEFAULT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `subtotal` varchar(255) DEFAULT NULL,
  `market_price` decimal(10,0) DEFAULT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `deal_price` decimal(10,0) DEFAULT NULL,
  `discount_rate` varchar(255) DEFAULT NULL,
  `is_posted` varchar(255) DEFAULT NULL,
  `is_comment` varchar(255) DEFAULT NULL,
  `is_gift` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product_detail
-- ----------------------------

-- ----------------------------
-- Table structure for order_return
-- ----------------------------
DROP TABLE IF EXISTS `order_return`;
CREATE TABLE `order_return` (
  `id` varchar(255) NOT NULL,
  `access_id` int(11) DEFAULT NULL,
  `return_id` int(11) DEFAULT NULL,
  `order_info_oid` int(11) DEFAULT NULL,
  `order_info_id` int(11) DEFAULT NULL,
  `refund_payable` varchar(255) DEFAULT NULL,
  `refund_paid` int(11) DEFAULT NULL,
  `sale_price_tatal` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `return_status_id` int(11) DEFAULT NULL,
  `freight` varchar(255) DEFAULT NULL,
  `product_total_price` decimal(10,0) DEFAULT NULL,
  `remark_system` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `return_reason_id` int(11) DEFAULT NULL,
  `custom_return_reason` varchar(255) DEFAULT NULL,
  `refund_type_id` int(11) DEFAULT NULL,
  `custom_price` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_return
-- ----------------------------

-- ----------------------------
-- Table structure for order_return_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_return_detail`;
CREATE TABLE `order_return_detail` (
  `id` varchar(255) NOT NULL,
  `return_oid` varchar(255) DEFAULT NULL,
  `no` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `subtatal` varchar(255) DEFAULT NULL,
  `market_price` decimal(10,0) DEFAULT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `deal_price` decimal(10,0) DEFAULT NULL,
  `discount_rate` varchar(255) DEFAULT NULL,
  `is_gift` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_return_detail
-- ----------------------------

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pay_way` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `order_by` int(11) DEFAULT NULL,
  `recommend` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('1', '支付宝', 'ONLINE', 'icon-11', '2', '0', '--', '2016-10-10 14:35:24', '2016-10-10 14:35:27', 'NORMAL');
INSERT INTO `pay` VALUES ('2', '微信', 'ONLINE', 'icon-14', '1', '1', '--', '2016-10-10 14:36:05', '2016-10-10 14:36:07', 'NORMAL');
INSERT INTO `pay` VALUES ('3', '货到付款', 'OFFLINE', 'icon-5', '3', '0', '--', '2016-10-10 14:36:35', '2016-10-10 14:36:37', 'NORMAL');
INSERT INTO `pay` VALUES ('c8d230d02ea44c7db9103ab8976262e1', 'cheng', 'OFFLINE', 'icon-5', '4', '0', '--', '2016-10-18 16:16:33', '2016-10-18 16:16:33', 'NORMAL');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(64) CHARACTER SET utf8 NOT NULL,
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
INSERT INTO `permission` VALUES ('1', '用户查看', 'sys:user:view', '查看用户列表', '2016-05-19 16:41:40', '2016-05-19 16:41:42', 'NORMAL');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` varchar(255) NOT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `is_default` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('', '2', 'http://wx.aqd123.com/moblie/static/images/product/d-1.jpg', '-1', '-1', '0', '商品大图', '2016-10-31 13:34:50', '2016-10-31 13:34:53', 'NORMAL');
INSERT INTO `picture` VALUES ('1', '1', 'http://wx.aqd123.com/moblie/static/images/product/zm.jpg', '120', '120', '1', '首页商品图片', '2016-06-29 10:10:09', '2016-06-29 10:10:12', 'NORMAL');
INSERT INTO `picture` VALUES ('10', '4', 'http://wx.aqd123.com/moblie/static/images/product/d-1.jpg', '-1', '-1', '0', '商品大图', '2016-10-31 13:34:50', '2016-10-31 13:34:53', 'NORMAL');
INSERT INTO `picture` VALUES ('2', '2', 'http://wx.aqd123.com/moblie/static/images/product/hj.jpg', '120', '120', '1', '首页商品图片', '2016-06-29 16:40:31', '2016-06-29 16:40:33', 'NORMAL');
INSERT INTO `picture` VALUES ('3', '3', 'http://wx.aqd123.com/moblie/static/images/product/tb.jpg', '120', '120', '1', '首页商品图片', '2016-06-29 16:46:38', '2016-06-29 16:46:40', 'NORMAL');
INSERT INTO `picture` VALUES ('4', '4', 'http://wx.aqd123.com/moblie/static/images/product/tb.jpg', '120', '120', '1', '精品', '2016-10-30 17:56:46', '2016-10-30 17:56:49', 'NORMAL');
INSERT INTO `picture` VALUES ('5', '1', 'http://wx.aqd123.com/moblie/static/images/product/d-1.jpg', '-1', '-1', '0', '商品大图', '2016-10-31 13:34:50', '2016-10-31 13:34:53', 'NORMAL');
INSERT INTO `picture` VALUES ('6', '1', 'http://wx.aqd123.com/moblie/static/images/product/d-2.jpg', '-1', '-1', '0', '大图', '2016-10-31 13:35:29', '2016-10-31 13:35:33', 'NORMAL');
INSERT INTO `picture` VALUES ('7', '1', 'http://wx.aqd123.com/moblie/static/images/product/d-3.jpg', '-1', '-1', '0', '大图', '2016-10-31 13:35:29', '2016-10-31 13:35:33', 'NORMAL');
INSERT INTO `picture` VALUES ('8', '2', 'http://wx.aqd123.com/moblie/static/images/product/d-1.jpg', '-1', '-1', '0', '商品大图', '2016-10-31 13:34:50', '2016-10-31 13:34:53', 'NORMAL');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `market_price` decimal(10,1) DEFAULT NULL,
  `sale_price` decimal(10,1) DEFAULT NULL,
  `no` varchar(255) DEFAULT '',
  `key_words` varchar(255) DEFAULT NULL,
  `type_id` varchar(255) DEFAULT NULL,
  `is_alive` tinyint(4) DEFAULT NULL,
  `is_index` tinyint(4) DEFAULT NULL,
  `modify_admin_id` varchar(255) DEFAULT NULL,
  `units_in_stock` int(11) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `give_away` int(11) DEFAULT NULL,
  `unit_desc` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '大馍', '0.5', '0.5', '001', '馍', '1', '1', '1', '1', '99924', '推荐', '5', '0.25g/个', '好吃的', '2016-06-29 10:11:16', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `product` VALUES ('2', '花卷', '0.5', '0.5', '002', '卷子', '1', '1', '1', '1', '99942', '推荐', '5', '0.25g/个', '好吃的', '2016-06-29 16:38:03', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `product` VALUES ('3', '糖包', '0.6', '0.6', '003', '糖包', '1', '1', '1', '1', '0', '推荐', '5', '0.25g/个', '好吃的', '2016-06-29 16:38:57', '2016-11-13 18:58:39', 'NORMAL');
INSERT INTO `product` VALUES ('4', '吃的', '1.0', '1.0', '004', '好吃的', '2', '1', '0', '1', '42', '特别', '5', '0.25g/个', '好', '2016-10-30 17:54:17', '2016-11-13 19:00:25', 'NORMAL');

-- ----------------------------
-- Table structure for product_focus
-- ----------------------------
DROP TABLE IF EXISTS `product_focus`;
CREATE TABLE `product_focus` (
  `id` varchar(255) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_focus
-- ----------------------------
INSERT INTO `product_focus` VALUES ('66f98567291c4e27bb78ee2389e5d8c8', '1', '3', '--', '2016-10-17 16:35:01', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('aaacfb2b0c9e4728b8b91bc6d4e3d16a', '1', '3', '--', '2016-10-17 18:47:48', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('dd80daf896354be1b57f761be5b700ef', '1', '3', '--', '2016-11-01 09:36:20', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('4612cb7a5d9f4789a28ef05bccec0df8', '1', '3', '--', '2016-11-01 09:40:17', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('07a94da9a0dc4a158096b5a027073a11', '1', '3', '--', '2016-11-01 09:40:24', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('9524251991594936ab8a2a5702e92522', '1', '3', '--', '2016-11-01 09:40:41', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('2fe700d1505242abb99c882673edeab8', '1', '3', '--', '2016-11-01 09:43:00', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('532d211672c2404aa658f061f796dde9', '1', '3', '--', '2016-11-01 09:43:54', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('dd2690cbe3c145728c0308fb53617167', '1', '3', '--', '2016-11-01 09:44:21', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('7183dff335ff4e24ab2526c95f2b5fae', '1', '3', '--', '2016-11-01 09:44:25', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('c70c042e18974ce39637a76dee79b59b', '1', '3', '--', '2016-11-01 09:44:26', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('ef2fea1132354711a38f724e7f893e01', '1', '3', '--', '2016-11-01 09:44:28', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('1b7bcb09b3b94bb0b277bf0d9f8f084e', '1', '3', '--', '2016-11-01 09:44:28', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('735d8c987f3e4195aec91797f115c614', '1', '3', '--', '2016-11-01 09:44:29', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('32f0473eb9974a83a69e1c51bd2fbff1', '1', '3', '--', '2016-11-01 09:44:29', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('c013bfcad1aa4d968f0706a5ea40d197', '1', '3', '--', '2016-11-01 09:44:29', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('b725ace4a9744ea1b80ef693bd13495d', '1', '3', '--', '2016-11-01 09:44:30', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('f4a990e68aa54286b5fa5c72d21bc8ca', '1', '3', '--', '2016-11-01 09:44:30', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('da210f27180740ea917a314112584978', '1', '3', '--', '2016-11-01 09:44:31', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('effe9fe176da40c5b4b95fc49dfbfa2d', '1', '3', '--', '2016-11-01 09:44:31', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('d0e601904dae4d76b0dc04710812ee24', '1', '3', '--', '2016-11-01 10:02:12', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('b5de20a5bcf848b29970858d0759ba5a', '1', '3', '--', '2016-11-01 10:18:18', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('a54cf40171bc4e93a864854dc7a671c7', '1', '3', '--', '2016-11-01 10:18:29', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('a33ef6a6de814928a86ea95a4729adba', '1', '3', '--', '2016-11-01 10:19:27', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('1906b7184c9340038c0ae2c5751a4cf1', '1', '3', '--', '2016-11-01 10:22:51', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('b6124bab1e694b16a24812bc71abbf21', '1', '3', '--', '2016-11-01 10:22:53', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('7328c884c82f4b23ad13847bdb4e10b7', '1', '3', '--', '2016-11-01 10:22:56', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('783381a3bb6b40bd9d5ba760449ac043', '1', '3', '--', '2016-11-01 10:22:58', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('64a89c8c9ced4800a9cf219d43741dfa', '1', '3', '--', '2016-11-01 11:08:33', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('e1e790b7fbae489ba1e9c99cb72c05d9', '1', '3', '--', '2016-11-01 11:08:35', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('317a0f81fa014417ab63479e480c8100', '1', '3', '--', '2016-11-01 11:08:37', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('f46f63b8393b4c9084e11f356679b775', '1', '3', '--', '2016-11-01 11:37:51', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('0c10611d098146d5869b5afc9990c6ec', '1', '3', '--', '2016-11-01 19:17:12', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('bd459bf996e748ac8bd474bedda824cc', '1', '3', '--', '2016-11-01 21:27:49', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('783c061f2f9645edab283d03572bc844', '1', '3', '--', '2016-11-01 21:27:51', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('803aa3b0592746c9b443ce9b7d9b5da0', '1', '3', '--', '2016-11-01 21:27:53', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('3c3fc9aea9e641348f35c56b963c7e67', '1', '3', '--', '2016-11-02 16:03:59', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('de5dd489a6384014a3db5c4efb2f0f75', '1', '3', '--', '2016-11-02 16:04:02', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('17d6c0a2343a4432a7aa323dac08f0cf', '1', '3', '--', '2016-11-02 20:40:10', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('972900d9f2a64056837c77491043b425', '1', '3', '--', '2016-11-02 20:40:13', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('9320ce1074484907afd8d240414a7de8', '1', '3', '--', '2016-11-02 20:40:14', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('99f60c4c1c8c4da59fe7f68e99e37a8b', '1', '3', '--', '2016-11-02 20:40:17', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('baab596f5f3b403ba39e3140f8005309', '1', '3', '--', '2016-11-02 20:40:20', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('759388e28b924a9ba0b2b062138c2d81', '1', '3', '--', '2016-11-02 20:40:22', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('5afcd8ea611d437690cc8d972c9030fa', '1', '3', '--', '2016-11-03 22:18:47', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('e9e86261b29840d58914c58914fc7921', '1', '3', '--', '2016-11-05 01:51:50', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('4c73a23ed9104ea68ee59ca6235269ac', '1', '3', '--', '2016-11-05 01:51:53', '2016-11-13 18:55:21', 'DELETE');
INSERT INTO `product_focus` VALUES ('91cdb07b52564723945cc36d34ae59c4', '1', '3', '--', '2016-11-13 18:55:16', '2016-11-13 18:55:21', 'DELETE');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '主营食品', '--', '2016-06-29 10:11:40', '2016-06-29 10:11:42', 'NORMAL');
INSERT INTO `product_type` VALUES ('2', '粮油调味', '--', '2016-10-29 21:31:01', '2016-10-29 21:31:04', 'NORMAL');
INSERT INTO `product_type` VALUES ('3', '日用清洁', '--', '2016-10-29 21:31:27', '2016-10-29 21:31:30', 'NORMAL');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------

-- ----------------------------
-- Table structure for refund_type
-- ----------------------------
DROP TABLE IF EXISTS `refund_type`;
CREATE TABLE `refund_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refund_type
-- ----------------------------

-- ----------------------------
-- Table structure for return_reason
-- ----------------------------
DROP TABLE IF EXISTS `return_reason`;
CREATE TABLE `return_reason` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return_reason
-- ----------------------------

-- ----------------------------
-- Table structure for return_status
-- ----------------------------
DROP TABLE IF EXISTS `return_status`;
CREATE TABLE `return_status` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return_status
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `enname` varchar(32) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'Super Administrator', null, '超级管理员:超级管理员拥有系统全部的权限', '2016-05-19 16:37:15', '2016-05-19 16:37:18', 'NORMAL');

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
INSERT INTO `role_permission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sms_history
-- ----------------------------
DROP TABLE IF EXISTS `sms_history`;
CREATE TABLE `sms_history` (
  `id` varchar(64) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `user_ip` varchar(255) DEFAULT NULL,
  `validate` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_history
-- ----------------------------
INSERT INTO `sms_history` VALUES ('54bdd170993e46e5a18ba00a3fcc5fc5', '18600536683', '尊敬的用户，您的验证码为7367，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', '0', '127.0.0.1', '7367', '--', '2016-07-11 19:48:13', '2016-07-11 19:48:13', 'NORMAL');
INSERT INTO `sms_history` VALUES ('adfada563b524959a877dd88d1ffe3f8', '18600536683', '尊敬的用户，您的验证码为5298，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '5298', '--', '2016-07-11 19:49:33', '2016-07-11 19:49:33', 'NORMAL');
INSERT INTO `sms_history` VALUES ('1d3c318b06624686a29a5fa2cc6ed33e', '18600536683', '尊敬的用户，您的验证码为2878，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '2878', '--', '2016-07-11 19:51:21', '2016-07-11 19:51:21', 'NORMAL');
INSERT INTO `sms_history` VALUES ('b28e214a87c94a2d9e3d6caca2ea6d51', '18600536683', '尊敬的用户，您的验证码为2877，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '2877', '--', '2016-07-11 20:30:40', '2016-07-11 20:30:40', 'NORMAL');
INSERT INTO `sms_history` VALUES ('24381a51fb8a491daf61a323468aa8ee', '18600536683', '尊敬的用户，您的验证码为9158，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '9158', '--', '2016-07-12 10:21:08', '2016-07-12 10:21:08', 'NORMAL');
INSERT INTO `sms_history` VALUES ('74763c7ffdcf400eae9424b31aff6dd1', '18600536683', '尊敬的用户，您的验证码为1287，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '1287', '--', '2016-07-12 10:34:10', '2016-07-12 10:34:10', 'NORMAL');
INSERT INTO `sms_history` VALUES ('3140775641c6475882ed1ca9393dfb17', '18600536683', '尊敬的用户，您的验证码为1276，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '1276', '--', '2016-07-12 10:37:48', '2016-07-12 10:37:48', 'NORMAL');
INSERT INTO `sms_history` VALUES ('f034b9585e4e41baabf86c9d57b19606', '18600536683', '尊敬的用户，您的验证码为5384，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '5384', '--', '2016-07-12 11:04:48', '2016-07-12 11:04:48', 'NORMAL');
INSERT INTO `sms_history` VALUES ('e86149af290648108f5d4fdb4d0285c8', '18600536683', '尊敬的用户，您的验证码为5138，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.1', '5138', '--', '2016-07-12 11:11:05', '2016-07-12 11:11:05', 'NORMAL');
INSERT INTO `sms_history` VALUES ('e01665a042584448a0259b718c7d06a6', '18600536683', '????????????9502?????????10?????????', '10', 'VALIDATE', 'system', null, '127.0.0.2', '9502', '--', '2016-09-20 11:05:09', '2016-09-20 11:05:09', 'NORMAL');
INSERT INTO `sms_history` VALUES ('4b1ca7e9443043d18313df99f7a968a3', '18600536683', '尊敬的用户，您的验证码为0393，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '127.0.0.2', '0393', '--', '2016-09-20 11:08:28', '2016-09-20 11:08:28', 'NORMAL');
INSERT INTO `sms_history` VALUES ('0c55a56bd7db433998cb18950839ca3e', '18600536691', '尊敬的用户，您的验证码为0826，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.89.148', '0826', '--', '2016-11-14 22:38:27', '2016-11-14 22:38:27', 'NORMAL');
INSERT INTO `sms_history` VALUES ('e659e3e0c85740298d301067e365b593', '18600536691', '尊敬的用户，您的验证码为3342，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.89.148', '3342', '--', '2016-11-14 22:38:27', '2016-11-14 22:38:27', 'NORMAL');
INSERT INTO `sms_history` VALUES ('cb373c4b35c94b10b917b505245ca310', '18600536691', '尊敬的用户，您的验证码为3230，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.89.148', '3230', '--', '2016-11-14 22:38:27', '2016-11-14 22:38:27', 'NORMAL');
INSERT INTO `sms_history` VALUES ('37d923fc675442469abd5957e1d8e8d9', '18600536691', '尊敬的用户，您的验证码为8449，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.89.148', '8449', '--', '2016-11-14 22:39:08', '2016-11-14 22:39:08', 'NORMAL');

-- ----------------------------
-- Table structure for sms_template
-- ----------------------------
DROP TABLE IF EXISTS `sms_template`;
CREATE TABLE `sms_template` (
  `id` varchar(64) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `is_enable` tinyint(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_template
-- ----------------------------
INSERT INTO `sms_template` VALUES ('1', 'VALIDATE', '尊敬的用户，您的验证码为[MSGCODE]，本验证码有效时间[TIMEOUT]分钟，请勿告知他人', '10', '1', '验证码短信', '2016-07-11 18:22:28', '2016-07-11 18:22:31', 'NORMAL');

-- ----------------------------
-- Table structure for system_param
-- ----------------------------
DROP TABLE IF EXISTS `system_param`;
CREATE TABLE `system_param` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `copyright` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_param
-- ----------------------------

-- ----------------------------
-- Table structure for town
-- ----------------------------
DROP TABLE IF EXISTS `town`;
CREATE TABLE `town` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of town
-- ----------------------------
INSERT INTO `town` VALUES ('1', '孙寺', '--', '2016-11-03 14:25:47', '2016-11-03 14:25:49', 'NORMAL');
INSERT INTO `town` VALUES ('2', '成武镇', '--', '2016-11-03 14:32:27', '2016-11-03 14:32:29', 'NORMAL');

-- ----------------------------
-- Table structure for village
-- ----------------------------
DROP TABLE IF EXISTS `village`;
CREATE TABLE `village` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of village
-- ----------------------------
