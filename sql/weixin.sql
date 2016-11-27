/*
Navicat MySQL Data Transfer

Source Server         : 120.27.53.171-wx
Source Server Version : 50173
Source Host           : 120.27.53.171:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-11-27 21:33:09
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
INSERT INTO `account` VALUES ('1', 'http://wx.aqd123.com/shop/images/avatar.jpg', 'Cheng', '4', 'WELL', '18600536683', '1', '1070', '3430', '451', '0', '1.95.244.24', 'NO', '--', '2016-09-20 10:03:47', '2016-11-27 12:54:18', 'NORMAL');
INSERT INTO `account` VALUES ('9c3e4044b97140a98f8d12c34bf99efa', 'http://wx.aqd123.com/shop/images/avatar.jpg', 'chengzhx76', '1', 'WELL', '18600536689', '1', '200', '0', '0', '0', '1.95.244.24', 'NO', '--', '2016-11-26 17:21:12', '2016-11-26 17:21:12', 'NORMAL');
INSERT INTO `account` VALUES ('b42f14ce73d24541be4152b7d09cf855', 'http://wx.aqd123.com/shop/images/avatar.jpg', null, '1', 'WELL', '18600536687', '123456', '200', '0', '0', '0', '1.95.244.24', 'NO', '--', '2016-11-26 16:57:36', '2016-11-26 20:27:59', 'NORMAL');

-- ----------------------------
-- Table structure for account_level
-- ----------------------------
DROP TABLE IF EXISTS `account_level`;
CREATE TABLE `account_level` (
  `id` varchar(255) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `need_ronus_point` int(11) DEFAULT NULL,
  `next_level_need_point` int(11) DEFAULT NULL,
  `reduct_percent` double(3,2) DEFAULT NULL COMMENT '折扣 如 0.02打98折',
  `consume_scale` varchar(12) DEFAULT NULL COMMENT '积分比 如 1:100 一百个积分等于一元',
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
INSERT INTO `account_level` VALUES ('1', '1', '一级', '0', '200', '0.00', '1000:1', '0', '1', '初始化帐户级别；1000个积分可以换1块钱；0折扣；一月0次免运费机会', '2016-07-12 16:36:04', '2016-07-12 16:36:08', 'NORMAL');
INSERT INTO `account_level` VALUES ('2', '2', '二级', '200', '600', '0.00', '1000:1', '1', '1', '二级账户；1000个积分可以换1块钱；0折扣；一月1次免运费机会', '2016-11-19 21:42:16', '2016-11-19 21:42:19', 'NORMAL');
INSERT INTO `account_level` VALUES ('3', '3', '三级', '600', '1200', '0.02', '900:1', '2', '1', '三级账户；900个积分可以换1块钱；98折；一月2次免运费机会', '2016-11-20 02:01:53', '2016-11-20 02:01:56', 'NORMAL');
INSERT INTO `account_level` VALUES ('4', '4', '四级', '1200', '2500', '0.03', '700:1', '3', '1', '四级账户；700个积分可以换1块钱；97折；一月3次免运费机会', '2016-11-21 13:00:21', '2016-11-21 13:00:27', 'NORMAL');

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
INSERT INTO `admin` VALUES ('1', 'cheng', '5cdefe986d7fa0d363930c4062b776bd30a33a3cec47a34291a8bd27', '程', '18600536683', '/img/logo.jpg', '1.95.97.65', '2016-11-17 23:17:55', '1.95.240.33', '2016-10-30 21:50:09', '备注', '2016-01-28 15:47:10', '2016-11-17 23:17:55', 'NORMAL');

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
INSERT INTO `bonus_point_record` VALUES ('4b6ca8d3d5e040bdbd9ab0e3f108762f', '1', '1070', '75', '75', '1145', 'EARNING', null, '下单获取75积分', '--', '2016-11-20 22:39:33', '2016-11-20 22:39:33', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('41699d0f2024474a9d44062dae5ab2d0', '1', '1145', '65', '65', '1210', 'EARNING', null, '下单获取65积分', '--', '2016-11-20 22:45:55', '2016-11-20 22:45:55', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('08393c414c5e4877a299b65c39c55bea', '1', '1210', '50', '50', '1260', 'EARNING', null, '下单获取50积分', '--', '2016-11-20 23:07:30', '2016-11-20 23:07:30', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('f67560fb447340c89b96444abc866826', '1', '1260', '10', '10', '1270', 'EARNING', null, '下单获取10积分', '--', '2016-11-20 23:13:28', '2016-11-20 23:13:28', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('5d90c309355644baa140a87270522c46', '1', '1270', '0', '0', '1270', 'EARNING', null, '下单获取0积分', '--', '2016-11-20 23:48:16', '2016-11-20 23:48:16', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b1eecc5cc29a440394928c1c3678c50f', '1', '1270', '5', '5', '1275', 'EARNING', null, '下单获取5积分', '--', '2016-11-20 23:57:13', '2016-11-20 23:57:13', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('953cd8f89b954e199529cc667d51d788', '1', '1275', '5', '5', '1280', 'EARNING', null, '下单获取5积分', '--', '2016-11-20 23:57:33', '2016-11-20 23:57:33', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('481407ba96bc4a1c99b204913371bc0a', '1', '1280', '15', '15', '1295', 'EARNING', null, '下单获取15积分', '--', '2016-11-21 00:03:38', '2016-11-21 00:03:38', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('f5c5e513b7b042c69b2d34dadd1b4c60', '1', '1295', '10', '10', '1305', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:05:10', '2016-11-21 00:05:10', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('793dda954b2b45c7b0ebc1222a4cabb5', '1', '1305', '5', '5', '1310', 'EARNING', null, '下单获取5积分', '--', '2016-11-21 00:06:30', '2016-11-21 00:06:30', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('823ab97dad6141b3ab13f124646092d2', '1', '1310', '35', '35', '1345', 'EARNING', null, '下单获取35积分', '--', '2016-11-21 00:21:36', '2016-11-21 00:21:36', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('fe6df70eaaf34c609f94c8721f8ac079', '1', '1345', '5', '5', '1350', 'EARNING', null, '下单获取5积分', '--', '2016-11-21 00:23:22', '2016-11-21 00:23:22', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('9a6b25623d6f419ba34fe5729f2514f3', '1', '1350', '5', '5', '1355', 'EARNING', null, '下单获取5积分', '--', '2016-11-21 00:23:56', '2016-11-21 00:23:56', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('daeca90cc3e94fb6a7d523bad6ed845b', '1', '1355', '10', '10', '1365', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:30:44', '2016-11-21 00:30:44', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e9742ea50672499eaec4034375f700af', '1', '1365', '10', '10', '1375', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:31:51', '2016-11-21 00:31:51', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('286b590b5b9f436584a4e63e87acd998', '1', '1375', '10', '10', '1385', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:32:40', '2016-11-21 00:32:40', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8584adfa783b4b4c8a288ec527b9fe9a', '1', '1385', '15', '15', '1400', 'EARNING', null, '下单获取15积分', '--', '2016-11-21 00:34:32', '2016-11-21 00:34:32', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('a7922246efa84ff3b77dc8cb951a367a', '1', '1400', '0', '0', '1400', 'EARNING', null, '下单获取0积分', '--', '2016-11-21 00:34:48', '2016-11-21 00:34:48', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('d83afacfbec14c4d8ac3b61581e09b99', '1', '1400', '5', '5', '1405', 'EARNING', null, '下单获取5积分', '--', '2016-11-21 00:36:28', '2016-11-21 00:36:28', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('6b5cbd44253b48218b0861e42f772af0', '1', '1405', '0', '0', '1405', 'EARNING', null, '下单获取0积分', '--', '2016-11-21 00:36:37', '2016-11-21 00:36:37', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('42b9c295dffa44aa91848d2365474815', '1', '1405', '0', '0', '1405', 'EARNING', null, '下单获取0积分', '--', '2016-11-21 00:37:23', '2016-11-21 00:37:23', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('af731be2150a4aaf99e22ff2a306b7c2', '1', '1405', '10', '10', '1415', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:38:37', '2016-11-21 00:38:37', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('d4a9d559d77b41f7b13248cefcba5808', '1', '1415', '10', '10', '1425', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:39:19', '2016-11-21 00:39:19', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e23f8f7c32a343c2a63f0ade7cffc596', '1', '1425', '10', '10', '1435', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:40:14', '2016-11-21 00:40:14', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ef12bb53a7304ac492264151103b2575', '1', '1435', '10', '10', '1445', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:41:10', '2016-11-21 00:41:10', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('36af3dd628cb4fa8a92d6af9a1055391', '1', '1445', '10', '10', '1455', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:46:04', '2016-11-21 00:46:04', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ec7c817248c249b3ba183c1342751820', '1', '1455', '10', '10', '1465', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 00:46:29', '2016-11-21 00:46:29', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b79cb350fcae402ca8ee3dfd651795ef', '1', '1465', '20', '20', '1485', 'EARNING', null, '下单获取20积分', '--', '2016-11-21 00:49:26', '2016-11-21 00:49:26', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('5b9b2f9f14da47ae8aa07a98ee33a6df', '1', '1485', '20', '20', '1505', 'EARNING', null, '下单获取20积分', '--', '2016-11-21 01:23:14', '2016-11-21 01:23:14', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('06e5197d71f34a53918910907c707908', '1', '1505', '105', '105', '1610', 'EARNING', null, '下单获取105积分', '--', '2016-11-21 01:26:53', '2016-11-21 01:26:53', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b656306e212041a0ae5b55cca19bd8b6', '1', '1610', '50', '50', '1660', 'EARNING', null, '下单获取50积分', '--', '2016-11-21 01:27:48', '2016-11-21 01:27:48', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b880135798c3413a82072f07f4662cbe', '1', '1660', '60', '60', '1720', 'EARNING', null, '下单获取60积分', '--', '2016-11-21 01:29:01', '2016-11-21 01:29:01', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b5218845db644fa9b2e55c6d76089c09', '1', '1720', '45', '45', '1765', 'EARNING', null, '下单获取45积分', '--', '2016-11-21 11:57:31', '2016-11-21 11:57:31', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('41468b0b9a7741599881b10a4d2b56a6', '1', '1765', '15', '15', '1780', 'EARNING', null, '下单获取15积分', '--', '2016-11-21 11:59:19', '2016-11-21 11:59:19', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('c73064e5016343638874a7e53f37c994', '1', '1780', '10', '10', '1790', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 12:02:44', '2016-11-21 12:02:44', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e139b64d970145ae95bd22136918593f', '1', '1790', '10', '10', '1800', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 12:03:05', '2016-11-21 12:03:05', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('0539dda2a17544cba94fb61f42d7c813', '1', '1800', '15', '15', '1815', 'EARNING', null, '下单获取15积分', '--', '2016-11-21 12:57:36', '2016-11-21 12:57:36', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ffecb4e5d82249379292cc6c95317ec1', '1', '1815', '70', '70', '1885', 'EARNING', null, '下单获取70积分', '--', '2016-11-21 22:59:45', '2016-11-21 22:59:45', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('293713490c26498f9185ed8e5e720431', '1', '1885', '50', '50', '1935', 'EARNING', null, '下单获取50积分', '--', '2016-11-21 23:17:11', '2016-11-21 23:17:11', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('3251f2a9e76f45899dc50a93cb8d9893', '1', '1935', '50', '50', '1985', 'EARNING', null, '下单获取50积分', '--', '2016-11-21 23:21:47', '2016-11-21 23:21:47', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e774ade2700f4c0397cda306fab69313', '1', '1985', '45', '45', '2030', 'EARNING', null, '下单获取45积分', '--', '2016-11-21 23:40:00', '2016-11-21 23:40:00', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('e23451f3f20944f7ac197f4d3fb8665a', '1', '2030', '50', '50', '2080', 'EARNING', null, '下单获取50积分', '--', '2016-11-21 23:45:49', '2016-11-21 23:45:49', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('6e7de97a6f1545ee9b0d90f39b9470bf', '1', '2080', '25', '25', '2105', 'EARNING', null, '下单获取25积分', '--', '2016-11-21 23:53:49', '2016-11-21 23:53:49', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('99515e6e25954cff95310f06e7349f9a', '1', '2105', '15', '15', '2120', 'EARNING', null, '下单获取15积分', '--', '2016-11-21 23:57:16', '2016-11-21 23:57:16', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ff537a5d22684ebf8d1330b98b73c5c7', '1', '2120', '15', '15', '2135', 'EARNING', null, '下单获取15积分', '--', '2016-11-21 23:57:44', '2016-11-21 23:57:44', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('b902a1bda8c9454684e7145b8cc1290f', '1', '2135', '10', '10', '2145', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 23:58:11', '2016-11-21 23:58:11', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('a9f199208c8e4437851b58c4a6ea2c45', '1', '2145', '10', '10', '2155', 'EARNING', null, '下单获取10积分', '--', '2016-11-21 23:59:03', '2016-11-21 23:59:03', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('a533b563f2944e03b34c5360bce00213', '1', '2155', '515', '515', '2670', 'EARNING', null, '下单获取515积分', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('adb8772779b445ac8d24decdd826cbd3', '1', '2670', '305', '305', '2975', 'EARNING', null, '下单获取305积分', '--', '2016-11-22 00:36:34', '2016-11-22 00:36:34', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('1afabd9c13264d229ef683fe810147b3', '1', '2975', '35', '35', '3010', 'EARNING', null, '下单获取35积分', '--', '2016-11-22 13:13:42', '2016-11-22 13:13:42', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('6b4e5e40fde6441da1c29e6818e8d4c3', '1', '3010', '100', '100', '3110', 'EARNING', null, '下单获取100积分', '--', '2016-11-23 01:39:46', '2016-11-23 01:39:46', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8e7b51c36cb946b4876bb5bc7016278f', '1', '3110', '30', '30', '3140', 'EARNING', null, '下单获取30积分', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('c075dd7f938a4beea17ce1ac9b6bd264', '1', '3140', '30', '30', '3170', 'EARNING', null, '下单获取30积分', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('ab6dce5dbc7d4dddb54861edf39b2f73', '1', '3140', '50', '50', '3190', 'EARNING', null, '下单获取50积分', '--', '2016-11-24 00:00:26', '2016-11-24 00:00:26', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('d240db07b68c41ab843eed3e48aeefdb', '1', '3190', '0', '0', '3190', 'EARNING', null, '下单获取0积分', '--', '2016-11-24 00:01:00', '2016-11-24 00:01:00', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('4d1dc72186fc4521bb958cef45fa7715', '1', '3190', '145', '145', '3335', 'EARNING', null, '下单获取145积分', '--', '2016-11-26 14:19:46', '2016-11-26 14:19:46', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('bb050cfac69144dd96db4a041f055ce2', '1', '3335', '55', '55', '3390', 'EARNING', null, '下单获取55积分', '--', '2016-11-27 00:20:24', '2016-11-27 00:20:24', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('19aa046994f5444281645951919bb55c', '1', '3390', '10', '10', '3400', 'EARNING', null, '下单获取10积分', '--', '2016-11-27 12:54:18', '2016-11-27 12:54:18', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('a0f16ad31bd84777a8e97171ff7bbde6', '1', '0', '30', '30', '30', 'EARNING', null, '下单获取30积分', '--', '2016-11-20 01:55:12', '2016-11-20 01:55:12', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('6dd686c97a414e86a29382a656ca8328', '1', '30', '5', '5', '35', 'EARNING', null, '下单获取5积分', '--', '2016-11-20 01:55:59', '2016-11-20 01:55:59', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('5747c264ec2c49c4b8b323f239d91881', '1', '35', '300', '300', '335', 'EARNING', null, '下单获取300积分', '--', '2016-11-20 01:59:27', '2016-11-20 01:59:27', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('4856378220a742f7b54c595d3d4d5f68', '1', '335', '10', '10', '345', 'EARNING', null, '下单获取10积分', '--', '2016-11-20 02:42:28', '2016-11-20 02:42:28', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('8e0d07ab4d104576a7a7691a8b6f14b9', '1', '345', '270', '270', '615', 'EARNING', null, '下单获取270积分', '--', '2016-11-20 16:10:20', '2016-11-20 16:10:20', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('81dbb04fb0f6495ca6da7281edbf7e89', '1', '615', '415', '415', '1030', 'EARNING', null, '下单获取415积分', '--', '2016-11-20 18:18:00', '2016-11-20 18:18:00', 'NORMAL');
INSERT INTO `bonus_point_record` VALUES ('bc40dd38c0e647b39a51d91e74181835', '1', '1030', '40', '40', '1070', 'EARNING', null, '下单获取40积分', '--', '2016-11-20 20:31:19', '2016-11-20 20:31:19', 'NORMAL');

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
INSERT INTO `cash_record` VALUES ('1', '1', '0', '111', '111', '20000', 'EXPENSE', '1', '1', '--', '2016-10-13 11:31:24', '2016-10-13 11:31:29', 'NORMAL');
INSERT INTO `cash_record` VALUES ('2766d2c54c0d4cc6bf05a5c34e244437', '1', '14904.5', '994.7', null, '13909.8', 'EXPENSE', null, '结果', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c3f30f722c0141e2b13ca147962b87ad', '1', '13909.8', '986.2', null, '12923.6', 'EXPENSE', null, '结果', '--', '2016-11-09 07:48:40', '2016-11-09 07:48:40', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c32e7b1be4ae437d8ac0d1d472232db7', '1', '13909.8', '977.2', null, '12932.6', 'EXPENSE', null, '结果', '--', '2016-11-09 22:05:09', '2016-11-09 22:05:09', 'NORMAL');
INSERT INTO `cash_record` VALUES ('bfd56e9858aa4fe18d5226230e7f6c70', '1', '12932.6', '953.2', null, '11979.4', 'EXPENSE', null, '结果', '--', '2016-11-11 00:25:26', '2016-11-11 00:25:26', 'NORMAL');
INSERT INTO `cash_record` VALUES ('9e0d6a4080e64e428be95ee28a997fd9', '1', '11979.4', '920.2', null, '11059.2', 'EXPENSE', null, '结果', '--', '2016-11-11 01:30:22', '2016-11-11 01:30:22', 'NORMAL');
INSERT INTO `cash_record` VALUES ('1528868fb8d5442ebfa640a0eaac3df1', '1', '11059.2', '914.7', null, '10144.5', 'EXPENSE', null, '结果', '--', '2016-11-11 01:31:12', '2016-11-11 01:31:12', 'NORMAL');
INSERT INTO `cash_record` VALUES ('b09d3a7f4e2f41aaa85ea805a0da72f8', '1', '10144.5', '909.7', null, '9234.8', 'EXPENSE', null, '结果', '--', '2016-11-11 01:37:41', '2016-11-11 01:37:41', 'NORMAL');
INSERT INTO `cash_record` VALUES ('3351dadc0a974125a276ab84d9106a4d', '1', '9234.8', '903.2', null, '8331.6', 'EXPENSE', null, '结果', '--', '2016-11-11 10:57:27', '2016-11-11 10:57:27', 'NORMAL');
INSERT INTO `cash_record` VALUES ('6595bada9879424db6d898da7673462a', '1', '8331.6', '899.2', null, '7432.4', 'EXPENSE', null, '结果', '--', '2016-11-11 13:11:27', '2016-11-11 13:11:27', 'NORMAL');
INSERT INTO `cash_record` VALUES ('5807d4c61f804ee6aee777459f30cbd4', '1', '20000', '1034.7', null, '18965.3', 'EXPENSE', null, '结果', '--', '2016-11-06 18:16:31', '2016-11-06 18:16:31', 'NORMAL');
INSERT INTO `cash_record` VALUES ('db2ab49acf9c47d1b45130934b0ae84a', '1', '18965.3', '1027.2', null, '17938.1', 'EXPENSE', null, '结果', '--', '2016-11-06 18:16:51', '2016-11-06 18:16:51', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c5a23033c9b9426abea46844e336f8e1', '1', '17938.1', '1019.2', null, '16918.9', 'EXPENSE', null, '结果', '--', '2016-11-06 18:24:53', '2016-11-06 18:24:53', 'NORMAL');
INSERT INTO `cash_record` VALUES ('122b22e0b2944bc59474a2d622bd67f9', '1', '16918.9', '1011.2', null, '15907.7', 'EXPENSE', null, '结果', '--', '2016-11-06 18:25:11', '2016-11-06 18:25:11', 'NORMAL');
INSERT INTO `cash_record` VALUES ('490124417b994882b34c7dc8585d442c', '1', '15907.7', '1003.2', null, '14904.5', 'EXPENSE', null, '结果', '--', '2016-11-06 18:25:46', '2016-11-06 18:25:46', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0d126e8b69e244eb928eaec3f8e2ec78', '1', '7432.4', '896.2', null, '6536.2', 'EXPENSE', null, '结果', '--', '2016-11-11 13:50:54', '2016-11-11 13:50:54', 'NORMAL');
INSERT INTO `cash_record` VALUES ('2d87b35236774dbab24a88af9f3c2e10', '1', '6536.2', '891.2', null, '5645.0', 'EXPENSE', null, '结果', '--', '2016-11-12 14:28:40', '2016-11-12 14:28:40', 'NORMAL');
INSERT INTO `cash_record` VALUES ('6830a64eacc440bb891c6abe57bfdcfe', '1', '5645.0', '884.5', null, '4760.5', 'EXPENSE', null, '结果', '--', '2016-11-12 21:53:07', '2016-11-12 21:53:07', 'NORMAL');
INSERT INTO `cash_record` VALUES ('3815ed39162d4feea1b99bea300c993c', '1', '4760.5', '881.3', null, '3879.2', 'EXPENSE', null, '结果', '--', '2016-11-12 21:56:57', '2016-11-12 21:56:57', 'NORMAL');
INSERT INTO `cash_record` VALUES ('f9887dbe9ea14a2c87d09b91a8a1cc88', '1', '3879.2', '878.1', null, '3001.1', 'EXPENSE', null, '结果', '--', '2016-11-12 22:13:34', '2016-11-12 22:13:34', 'NORMAL');
INSERT INTO `cash_record` VALUES ('af9a5e56f54b4091a8b9014c5111e68e', '1', '3001.1', '870.6', null, '2130.5', 'EXPENSE', null, '结果', '--', '2016-11-12 22:24:11', '2016-11-12 22:24:11', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0a64434113c84f83a60e09c03f55f9cf', '1', '2130.5', '865.6', null, '1264.9', 'EXPENSE', null, '结果', '--', '2016-11-12 22:26:24', '2016-11-12 22:26:24', 'NORMAL');
INSERT INTO `cash_record` VALUES ('057b9576f9864a659967c333dcfd1458', '1', '1264.9', '861.6', null, '403.3', 'EXPENSE', null, '结果', '--', '2016-11-12 23:40:15', '2016-11-12 23:40:15', 'NORMAL');
INSERT INTO `cash_record` VALUES ('71a7294200e445ed91e943940d437868', '1', '403.3', '5.0', null, '398.3', 'EXPENSE', null, '结果', '--', '2016-11-13 21:24:15', '2016-11-13 21:24:15', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c8e9a5461296438d977052f076386196', '1', '398.3', '5.5', null, '392.8', 'EXPENSE', null, '结果', '--', '2016-11-14 17:24:49', '2016-11-14 17:24:49', 'NORMAL');
INSERT INTO `cash_record` VALUES ('cd6d80f3301946f0bf784206923dbe7b', '1', '392.8', '4.0', null, '388.8', 'EXPENSE', null, '结果', '--', '2016-11-16 17:51:50', '2016-11-16 17:51:50', 'NORMAL');
INSERT INTO `cash_record` VALUES ('a009df4469fc49e2bae5a66c5cd6eb0f', '1', '388.8', '4.0', null, '384.8', 'EXPENSE', null, '结果', '--', '2016-11-17 14:52:14', '2016-11-17 14:52:14', 'NORMAL');
INSERT INTO `cash_record` VALUES ('9b3536e6ca0f46029c602d2a5e1e8124', '1', '384.8', '4.0', null, '380.8', 'EXPENSE', null, '结果', '--', '2016-11-17 16:09:14', '2016-11-17 16:09:14', 'NORMAL');
INSERT INTO `cash_record` VALUES ('4c62b3a221034da3bf4c6110eae225bb', '1', '380.8', '3.5', null, '377.3', 'EXPENSE', null, '结果', '--', '2016-11-17 16:09:55', '2016-11-17 16:09:55', 'NORMAL');
INSERT INTO `cash_record` VALUES ('cabfd473107f41f9b60970474395c8b4', '1', '377.3', '3.0', null, '374.3', 'EXPENSE', null, '结果', '--', '2016-11-17 16:23:51', '2016-11-17 16:23:51', 'NORMAL');
INSERT INTO `cash_record` VALUES ('27f73a82ca2d40efb06b5c51f8a201bb', '1', '374.3', '4.5', null, '369.8', 'EXPENSE', null, '结果', '--', '2016-11-17 16:45:00', '2016-11-17 16:45:00', 'NORMAL');
INSERT INTO `cash_record` VALUES ('1092410df27343118c456af9bb0f3865', '1', '369.8', '8.5', null, '361.3', 'EXPENSE', null, '结果', '--', '2016-11-17 23:32:29', '2016-11-17 23:32:29', 'NORMAL');
INSERT INTO `cash_record` VALUES ('dcceb4f4db734715aeaa07450b422097', '1', '361.3', '3.5', null, '357.8', 'EXPENSE', null, '结果', '--', '2016-11-18 20:48:20', '2016-11-18 20:48:20', 'NORMAL');
INSERT INTO `cash_record` VALUES ('e85bd1de5b3741e5bdbbf3c3e4f2b581', '1', '357.8', '3.5', null, '354.3', 'EXPENSE', null, '结果', '--', '2016-11-18 20:59:17', '2016-11-18 20:59:17', 'NORMAL');
INSERT INTO `cash_record` VALUES ('e5a82c5c5ad84eaf866f3cddd8410b1e', '1', '354.3', '5.0', null, '349.3', 'EXPENSE', null, '结果', '--', '2016-11-18 22:40:56', '2016-11-18 22:40:56', 'NORMAL');
INSERT INTO `cash_record` VALUES ('8b7da8a7a707497792e5e4a1a9aaf748', '1', '349.3', '5.0', null, '344.3', 'EXPENSE', null, '结果', '--', '2016-11-18 22:43:46', '2016-11-18 22:43:46', 'NORMAL');
INSERT INTO `cash_record` VALUES ('e60f80f4ef394f4cb10f199254af8209', '1', '344.3', '41.0', null, '303.3', 'EXPENSE', null, '结果', '--', '2016-11-18 22:46:41', '2016-11-18 22:46:41', 'NORMAL');
INSERT INTO `cash_record` VALUES ('6dd0ee70f42542ab9c5f189be07e28f8', '1', '303.3', '3.0', null, '300.3', 'EXPENSE', null, '结果', '--', '2016-11-18 23:56:39', '2016-11-18 23:56:39', 'NORMAL');
INSERT INTO `cash_record` VALUES ('cc3eb6209c8f4f168c1ae602222aa945', '1', '300.3', '3.5', null, '296.8', 'EXPENSE', null, '结果', '--', '2016-11-19 00:02:08', '2016-11-19 00:02:08', 'NORMAL');
INSERT INTO `cash_record` VALUES ('1c3fc888c16a4f06a5c7ac4c33387e11', '1', '296.8', '2.5', null, '294.3', 'EXPENSE', null, '结果', '--', '2016-11-19 00:13:20', '2016-11-19 00:13:20', 'NORMAL');
INSERT INTO `cash_record` VALUES ('e640d2bcbfdf4ec79eceaaece92d8207', '1', '294.3', '2.5', null, '291.8', 'EXPENSE', null, '结果', '--', '2016-11-19 00:14:19', '2016-11-19 00:14:19', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0707791360674b72bc55cec506d94fc8', '1', '291.8', '3.0', null, '288.8', 'EXPENSE', null, '结果', '--', '2016-11-19 00:31:25', '2016-11-19 00:31:25', 'NORMAL');
INSERT INTO `cash_record` VALUES ('65f65e26beab4e3780d2fe7d413ff55b', '1', '288.8', '4.0', null, '284.8', 'EXPENSE', null, '结果', '--', '2016-11-19 00:52:45', '2016-11-19 00:52:45', 'NORMAL');
INSERT INTO `cash_record` VALUES ('fb52abef72d44a61bbbd056ef10890e8', '1', '284.8', '3.0', null, '281.8', 'EXPENSE', null, '结果', '--', '2016-11-19 02:36:35', '2016-11-19 02:36:35', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c3c69e10e1f3467fae839432e302c703', '1', '281.8', '4.0', null, '277.8', 'EXPENSE', null, '结果', '--', '2016-11-19 03:27:17', '2016-11-19 03:27:17', 'NORMAL');
INSERT INTO `cash_record` VALUES ('d9baf4686ad54af497b14ea9cd8e7de4', '1', '277.8', '4.0', null, '273.8', 'EXPENSE', null, '结果', '--', '2016-11-19 10:26:47', '2016-11-19 10:26:47', 'NORMAL');
INSERT INTO `cash_record` VALUES ('7757fe24018643efb90afb0e54724568', '1', '273.8', '5.5', null, '268.3', 'EXPENSE', null, '结果', '--', '2016-11-19 16:10:51', '2016-11-19 16:10:51', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0b85d7d18e9c4a3ca9eebc18fb965b1c', '1', '268.3', '2', null, '266.3', 'EXPENSE', null, '下单花费2元', '--', '2016-11-19 23:29:56', '2016-11-19 23:29:56', 'NORMAL');
INSERT INTO `cash_record` VALUES ('6e7106570b474a1f986f477cb28328bb', '1', '266.3', '3.0', null, '263.3', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-19 23:33:13', '2016-11-19 23:33:13', 'NORMAL');
INSERT INTO `cash_record` VALUES ('ccdfdf1711404fc3a96caa5294c94b52', '1', '263.3', '3.0', null, '260.3', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-20 01:40:50', '2016-11-20 01:40:50', 'NORMAL');
INSERT INTO `cash_record` VALUES ('0657bcbde6f048a896d297218933619f', '1', '260.3', '4.0', null, '256.3', 'EXPENSE', null, '下单花费4.0元', '--', '2016-11-20 01:41:35', '2016-11-20 01:41:35', 'NORMAL');
INSERT INTO `cash_record` VALUES ('55c2793fad9145b9be3fc369759d6031', '1', '256.3', '3.0', null, '253.3', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-20 01:46:12', '2016-11-20 01:46:12', 'NORMAL');
INSERT INTO `cash_record` VALUES ('f8800901b861499d89eae6da96b433d2', '1', '253.3', '6.0', null, '247.3', 'EXPENSE', null, '下单花费6.0元', '--', '2016-11-20 01:50:07', '2016-11-20 01:50:07', 'NORMAL');
INSERT INTO `cash_record` VALUES ('ab7f323ebf114bc099091908db051120', '1', '247.3', '5.0', null, '242.3', 'EXPENSE', null, '下单花费5.0元', '--', '2016-11-20 01:55:12', '2016-11-20 01:55:12', 'NORMAL');
INSERT INTO `cash_record` VALUES ('b35453036d1e41e386a36fd4f50aa734', '1', '242.3', '2.5', null, '239.8', 'EXPENSE', null, '下单花费2.5元', '--', '2016-11-20 01:55:59', '2016-11-20 01:55:59', 'NORMAL');
INSERT INTO `cash_record` VALUES ('d4d382f6d62641468f606a530a94fb17', '1', '239.8', '30.0', null, '209.8', 'EXPENSE', null, '下单花费30.0元', '--', '2016-11-20 01:59:27', '2016-11-20 01:59:27', 'NORMAL');
INSERT INTO `cash_record` VALUES ('4074b0252f884c82a12f50091032ff09', '1', '209.8', '3.0', null, '206.8', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-20 02:42:28', '2016-11-20 02:42:28', 'NORMAL');
INSERT INTO `cash_record` VALUES ('c96eb8987ae5418ca816f30f332ca8b6', '1', '206.8', '27.5', null, '179.3', 'EXPENSE', null, '下单花费27.5元', '--', '2016-11-20 16:10:20', '2016-11-20 16:10:20', 'NORMAL');
INSERT INTO `cash_record` VALUES ('92bbdc7684ef4aef954b63efcd5b0cab', '1', '179.3', '6.0', null, '173.3', 'EXPENSE', null, '下单花费6.0元', '--', '2016-11-20 20:31:19', '2016-11-20 20:31:19', 'NORMAL');
INSERT INTO `cash_record` VALUES ('1011372eba2c48f0a7af58b9ab5da1de', '1', '173.3', '7.5', null, '165.8', 'EXPENSE', null, '下单花费7.5元', '--', '2016-11-20 22:39:33', '2016-11-20 22:39:33', 'NORMAL');
INSERT INTO `cash_record` VALUES ('1e50056d6c9744439f69b9bd852bb34d', '1', '165.8', '7.0', null, '158.8', 'EXPENSE', null, '下单花费7.0元', '--', '2016-11-20 22:45:55', '2016-11-20 22:45:55', 'NORMAL');
INSERT INTO `cash_record` VALUES ('ac8128ae6a694ccabb2a19f3aa27ddb4', '1', '158.8', '5.0', null, '153.8', 'EXPENSE', null, '下单花费5.0元', '--', '2016-11-20 23:07:30', '2016-11-20 23:07:30', 'NORMAL');
INSERT INTO `cash_record` VALUES ('3d61aa03ac74423ba8164902ccbdde42', '1', '153.8', '3.0', null, '150.8', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-21 00:39:19', '2016-11-21 00:39:19', 'NORMAL');
INSERT INTO `cash_record` VALUES ('58798e1ca8d24a26a4b1498858176c22', '1', '150.8', '3.0', null, '147.8', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-21 00:40:14', '2016-11-21 00:40:14', 'NORMAL');
INSERT INTO `cash_record` VALUES ('e48b2819d09d420d8558245cb8b1f6d4', '1', '147.8', '3.5', null, '144.3', 'EXPENSE', null, '下单花费3.5元', '--', '2016-11-21 12:57:36', '2016-11-21 12:57:36', 'NORMAL');
INSERT INTO `cash_record` VALUES ('7804064d91ee43f89829f227ade849c1', '1', '144.3', '3.0', null, '141.3', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-21 23:58:11', '2016-11-21 23:58:11', 'NORMAL');
INSERT INTO `cash_record` VALUES ('5d85e911d15b4a34941fb826e5628803', '1', '141.3', '3.0', null, '138.3', 'EXPENSE', null, '下单花费3.0元', '--', '2016-11-21 23:59:03', '2016-11-21 23:59:03', 'NORMAL');
INSERT INTO `cash_record` VALUES ('7d2b1864e7d24b248285565349ea19d8', '1', '138.3', '56.5', null, '81.8', 'EXPENSE', null, '下单花费56.5元', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `cash_record` VALUES ('fc885bf1fa1e4004966c4256784b06c7', '1', '81.8', '30.5', null, '51.3', 'EXPENSE', null, '下单花费30.5元', '--', '2016-11-22 00:36:34', '2016-11-22 00:36:34', 'NORMAL');
INSERT INTO `cash_record` VALUES ('7568b06f9f874c4ead1e592271df932c', '1', '51.3', '5.0', null, '46.3', 'EXPENSE', null, '下单花费5.0元', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `cash_record` VALUES ('5b4d0cfe2ad64f0396467203a316183a', '1', '51.3', '5.0', null, '46.3', 'EXPENSE', null, '下单花费5.0元', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `cash_record` VALUES ('68208def8edb43449d3c414384a31bc8', '1', '46.3', '5.0', null, '41.3', 'EXPENSE', null, '下单花费5.0元', '--', '2016-11-24 00:00:26', '2016-11-24 00:00:26', 'NORMAL');
INSERT INTO `cash_record` VALUES ('bc684dc0fe094e5e86516c31543b8c01', '1', '41.3', '2', null, '39.3', 'EXPENSE', null, '下单花费2.0元', '--', '2016-11-24 00:01:00', '2016-11-24 00:01:00', 'NORMAL');

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
INSERT INTO `coupon_code` VALUES ('1', '1', '123456789', '1', '1', '--', '2016-11-08 13:47:52', '2016-11-27 00:20:24', 'NORMAL');
INSERT INTO `coupon_code` VALUES ('2', '2', 'wwwwwqwdqdwq', '1', '1', '--', '2016-11-08 13:53:32', '2016-11-22 00:34:02', 'NORMAL');

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
INSERT INTO `coupon_record` VALUES ('c945afc5274d4869b275da0cf390bcd0', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-17 23:32:29', '2016-11-17 23:32:29', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('085c2ab2b8604a3082b622c8669f3bea', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-18 22:40:56', '2016-11-18 22:40:56', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('ee451138462040638cba3102c8053672', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-18 22:46:41', '2016-11-18 22:46:41', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('a49c6a9e12124538bc22647156e009a7', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-19 22:36:07', '2016-11-19 22:36:07', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('638104e449014aa8ba66cc6ad3ecc81e', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-19 22:44:56', '2016-11-19 22:44:56', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('75acaf057d634862ad77bc0820ff0494', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-19 22:53:40', '2016-11-19 22:53:40', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('5ea1ed4e78704fe3a449d34a9d11dc79', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-19 22:56:04', '2016-11-19 22:56:04', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('cbd21b3061ad46bcbd358ae7d7119060', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-19 23:01:29', '2016-11-19 23:01:29', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('05c56d8a6a514bf1858dbb9619ed1bc1', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-20 16:10:20', '2016-11-20 16:10:20', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('7caf63430c714e479afda9d1c228fdc1', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-20 22:45:55', '2016-11-20 22:45:55', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('37b1dbd72f4540f480c5e0b9f97f3190', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 01:26:53', '2016-11-21 01:26:53', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('b7c71f07f7b2427ca8dc2d7e1f5f4ccf', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 01:27:48', '2016-11-21 01:27:48', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('45f2ae1e64d4468787291871faca1756', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 01:29:01', '2016-11-21 01:29:01', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('e1be988d5e6a43ddb5bc5c0adc1799d3', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 22:59:45', '2016-11-21 22:59:45', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('77f8e4e2e1f84807bdb9d146fde65fcb', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 23:17:11', '2016-11-21 23:17:11', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('491bdc9564404771bf3ee646eaf73059', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 23:21:47', '2016-11-21 23:21:47', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('84e6f37251ae4992afb3f7da6cc1ca97', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-21 23:40:00', '2016-11-21 23:40:00', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('ef4ae910626f439491a122607ff2218b', '1', '2', '支出', null, '消费一张优惠券金额为5.0', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('530f051a5815491c93206ef13b0120cc', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-23 01:39:46', '2016-11-23 01:39:46', 'NORMAL');
INSERT INTO `coupon_record` VALUES ('93abf1a13bf8455a905151853ce16610', '1', '1', '支出', null, '消费一张优惠券金额为0.5', '--', '2016-11-27 00:20:24', '2016-11-27 00:20:24', 'NORMAL');

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
INSERT INTO `flow_status` VALUES ('1', '未付款', '', '2', 'ONLINE', '1', '正常流程', '2016-11-15 23:14:02', '2016-11-15 23:14:04', 'NORMAL');
INSERT INTO `flow_status` VALUES ('2', '已付款', '1', '3', 'ONLINE', '2', '正常流程', '2016-11-15 23:14:51', '2016-11-15 23:14:54', 'NORMAL');
INSERT INTO `flow_status` VALUES ('3', '拣货中', '2', '4', 'ONLINE', '3', '正常流程', '2016-11-15 23:15:41', '2016-11-15 23:15:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('4', '配送中', '3', '5', 'ONLINE', '4', '正常流程', '2016-11-15 23:16:41', '2016-11-15 23:16:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('5', '派件中', '4', '6', 'ONLINE', '5', '正常流程', '2016-11-15 23:17:14', '2016-11-15 23:17:20', 'NORMAL');
INSERT INTO `flow_status` VALUES ('6', '已送达', '5', '', 'ONLINE', '6', '正常流程', '2016-11-15 23:17:16', '2016-11-15 23:17:23', 'NORMAL');
INSERT INTO `flow_status` VALUES ('7', '货到付款', '', '8', 'OFFLINE', '1', '正常流程', '2016-11-15 23:15:41', '2016-11-15 23:15:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('8', '拣货中', '7', '9', 'OFFLINE', '2', '正常流程', '2016-11-16 22:27:47', '2016-11-16 22:27:50', 'NORMAL');
INSERT INTO `flow_status` VALUES ('9', '配送中', '8', '10', 'OFFLINE', '3', '正常流程', '2016-11-15 23:16:41', '2016-11-15 23:16:44', 'NORMAL');
INSERT INTO `flow_status` VALUES ('10', '派件中', '9', '11', 'OFFLINE', '4', '正常流程', '2016-11-15 23:17:14', '2016-11-15 23:17:20', 'NORMAL');
INSERT INTO `flow_status` VALUES ('11', '已送达', '10', '', 'OFFLINE', '5', '正常流程', '2016-11-15 23:17:16', '2016-11-15 23:17:23', 'NORMAL');
INSERT INTO `flow_status` VALUES ('12', '已失效', null, null, null, '1', '失败的流程', '2016-11-17 16:49:30', '2016-11-17 16:49:32', 'NORMAL');
INSERT INTO `flow_status` VALUES ('13', '已退款', null, null, null, '2', '失败的流程', '2016-11-17 16:50:07', '2016-11-17 16:50:11', 'NORMAL');
INSERT INTO `flow_status` VALUES ('14', '未送达', null, null, null, '3', '失败的流程', '2016-11-17 16:55:33', '2016-11-17 16:55:36', 'NORMAL');

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
INSERT INTO `member` VALUES ('1', '1', '1', null, '18600536683', null, null, null, 'MAN', null, null, null, null, null, null, null, null, null, null, null, null, 'NORMAL');
INSERT INTO `member` VALUES ('02a42a8619f3462ca9d87f871e4c7bf2', 'b42f14ce73d24541be4152b7d09cf855', null, null, '18600536687', null, null, null, 'UNKNOW', null, '0', '0', '0', null, null, null, null, null, '2016-11-26 16:57:36', '2016-11-26 16:57:36', '--', 'NORMAL');

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
  `order_status` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `pay_way` varchar(16) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('be5d8827c2354419bcf221d42fdf6553', '1', '33231469', null, null, '4.5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '2', '5', '0', '', '274200', '05308911051', null, '2016-11-21 23:40:00', null, null, '123456789', '1', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-21 23:40:00', '2016-11-21 23:40:00', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('85d95e8ad5fd4d06908b2a86e4869635', '1', '21412883', null, '8.5', '6', '-2.5', null, '18600536683', '黄楼村南头', '今天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '0', '9', '0', '', null, null, null, '2016-11-17 23:32:29', null, null, '123456789', '1', '7', '0', '0', null, '1', 'ONGOING', '--', '2016-11-17 23:32:29', '2016-11-17 23:32:29', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('e33fd89cec9c4a478061905c72a77c2a', '1', '64782083', null, '3.5', '3.5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '2', '0', '', '274200', '05308911051', null, '2016-11-18 20:48:20', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-18 20:48:20', '2016-11-18 20:48:20', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('482cdf60d033421887776d53a3951c8a', '1', '25258853', null, '3.5', '3.5', '0', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '2', '0', '', '274200', '05308911051', null, '2016-11-18 20:59:17', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-18 20:59:17', '2016-11-18 20:59:17', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('45a02081f5d9402f9d4ad3a6f09c3284', '1', '80995325', null, '5', '2.5', '-2.5', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '0', '5', '0', '', '274200', '05308911051', null, '2016-11-18 22:40:56', null, null, '123456789', '1', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-18 22:40:56', '2016-11-18 22:40:56', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('4c99fe3abd04494f8c954e47699dc1c1', '1', '17337896', null, '3.5', '3.5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '0', '2', '2', '0', '啦啦啦啦', '274200', '05308911051', null, '2016-11-17 16:09:55', null, null, null, '0', '7-8-9-10-14', '0', '0', null, '0', 'CANCELED', '--', '2016-11-17 16:09:55', '2016-11-17 16:09:55', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('7d46579c57d0416883f5d6110a379d71', '1', '16750448', null, '3', '3', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-17 16:22:31', null, null, null, '0', '1-2-3-4-5-6', '0', '0', null, '0', 'ONGOING', '--', '2016-11-17 16:22:35', '2016-11-17 16:22:35', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('871bda6c48ca4b5f88ee59338960fcf5', '1', '47402059', null, null, '5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '2', '2', '5', '0', '', '274200', '05308911051', null, '2016-11-21 23:45:49', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-21 23:45:49', '2016-11-21 23:45:49', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('5a9e114f3aa64a8da090d7d224247cff', '1', '35815122', null, null, '4.5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '', '274200', '05308911051', null, '2016-11-21 23:53:49', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-21 23:53:49', '2016-11-21 23:53:49', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('f3878d7c5bf145ad8082f7f95d09a6a5', '1', '06448107', null, null, '3.5', '0', null, '1860000001', '孙寺', '今天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '2', '0', '', '274200', '05308911051', null, '2016-11-21 23:57:16', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-21 23:57:16', '2016-11-21 23:57:16', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('d8f3ada21fd64333beb15ef7c7bf6f4c', '1', '41189458', null, null, '3.5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '0', '2', '2', '0', '', '274200', '05308911051', null, '2016-11-21 23:57:44', null, null, null, '0', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-21 23:57:44', '2016-11-21 23:57:44', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('dd730ec7772d4c8aba2525c31e08dced', '1', '50751194', null, '3', '3', '3', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-21 23:58:11', null, null, null, '0', '1-2', '0', '0', null, '0', 'ONGOING', '--', '2016-11-21 23:58:11', '2016-11-21 23:58:11', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('a70c715169c14eac92d645de4709c516', '1', '55941406', null, '3', '3', '3', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '0', '2', '1', '0', '', '274200', '05308911051', null, '2016-11-21 23:59:03', null, null, null, '0', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-21 23:59:03', '2016-11-21 23:59:03', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('82f4f04dabc74037b95be0aedbe8997a', '1', '46299589', null, '56.5', '51.5', '56.5', null, '1860000001', '孙寺', '明天10:00-18:00', '支付宝', null, null, null, null, null, null, 'NORMAL', '2', '2', '57', '0', '', '274200', '05308911051', null, '2016-11-22 00:34:02', null, null, 'wwwwwqwdqdwq', '5', '1-2', '0', '0', null, '0', 'ONGOING', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('98a735bb8a13422394551fa944b0a7c0', '1', '14528930', null, '30.5', '30.5', '30.5', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '2', '2', '31', '0', '', '274200', '05308911051', null, '2016-11-22 00:36:34', null, null, null, '0', '1-2', '0', '0', null, '0', 'ONGOING', '--', '2016-11-22 00:36:34', '2016-11-22 00:36:34', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('f77599f0d01c409fb9bd69c98c17df0d', '1', '05654801', null, null, '5.5', '0', null, '1860000001', '孙寺', '今天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '0', '2', '4', '0', '', '274200', '05308911051', null, '2016-11-22 13:13:42', null, null, null, '0', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-22 13:13:42', '2016-11-22 13:13:42', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('02b7a9e577254f709fc6afb16e6ae00e', '1', '58927163', null, null, '10', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '2', '11', '0', '', '274200', '05308911051', null, '2016-11-23 01:39:46', null, null, '123456789', '1', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-23 01:39:46', '2016-11-23 01:39:46', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('03807d9304a945bfa8d82db7c0d59d86', '1', '63718652', null, '5', '5', '5', null, '13900000001', '单县', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '', '274200', '05308600000', null, '2016-11-23 23:58:33', null, null, null, '0', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('971d9d6a4258402299cffcfecdffed3c', '1', '33226048', null, '5', '5', '5', null, '13900000001', '单县', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '0', '2', '3', '0', '', '274200', '05308600000', null, '2016-11-23 23:58:33', null, null, null, '0', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('907cea6ce49443fabeafd0e366cbbb77', '1', '72580291', null, '5', '5', '5', null, '1860000001', '孙寺', '明天10:00-18:00', 'cheng', null, null, null, null, null, null, 'NORMAL', '2', '2', '5', '0', '', '274200', '05308911051', null, '2016-11-24 00:00:26', null, null, null, '0', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-24 00:00:26', '2016-11-24 00:00:26', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('cf4c9b11baf0450795e16eba88b6f9b0', '1', '87240530', null, '2', '2', '2', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '0', '2', '0', '0', '', '274200', '05308911051', null, '2016-11-24 00:01:00', null, null, null, '0', '1-2', '0', '0', null, '0', 'ONGOING', '--', '2016-11-24 00:01:00', '2016-11-24 00:01:00', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('fddab9948f4743149d8f6caaeb4aeace', '1', '08574631', null, null, '14.5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '2', '2', '15', '0', '', '274200', '05308911051', null, '2016-11-26 14:19:46', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-26 14:19:46', '2016-11-26 14:19:46', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('82d13c36d06747888d55602e9ccb6890', '1', '50031248', null, null, '5.5', '0', null, '13900000001', '单县', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '2', '6', '0', '', '274200', '05308600000', null, '2016-11-27 00:20:24', null, null, '123456789', '1', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-27 00:20:24', '2016-11-27 00:20:24', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('b228ef205bc24c7aac56fc242a60d044', '1', '39345731', null, null, '3', '0', null, '13900000001', '单县', '明天10:00-18:00', '支付宝', null, null, null, null, null, null, 'NORMAL', '0', '2', '1', '0', '', '274200', '05308600000', null, '2016-11-27 12:54:18', null, null, null, '0', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-27 12:54:18', '2016-11-27 12:54:18', 'NORMAL', 'ONLINE');
INSERT INTO `order_info` VALUES ('84d0bf11cde446e183608a598566e281', '1', '59798007', null, null, '5', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '0', '8', '0', '', '274200', '05308911051', null, '2016-11-21 22:59:45', null, null, '123456789', '1', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-21 22:59:45', '2016-11-21 22:59:45', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('d37f2fc07f4c49099404eb91e481cb31', '1', '90994901', null, null, '3', '0', null, '13900000001', '单县', '明天10:00-18:00', '货到付款', null, null, null, null, null, null, 'NORMAL', '2', '0', '6', '0', '', '274200', '05308600000', null, '2016-11-21 23:17:11', null, null, '123456789', '1', '7', '0', '0', null, '0', 'ONGOING', '--', '2016-11-21 23:17:11', '2016-11-21 23:17:11', 'NORMAL', 'OFFLINE');
INSERT INTO `order_info` VALUES ('db49769d66de47de80f174d39f535ce5', '1', '75238422', null, null, '3', '0', null, '1860000001', '孙寺', '明天10:00-18:00', '微信', null, null, null, null, null, null, 'NORMAL', '2', '0', '6', '0', '', '274200', '05308911051', null, '2016-11-21 23:21:47', null, null, '123456789', '1', '1', '0', '0', null, '0', 'WAIT_PAY', '--', '2016-11-21 23:21:47', '2016-11-21 23:21:47', 'NORMAL', 'ONLINE');

-- ----------------------------
-- Table structure for order_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_product_detail`;
CREATE TABLE `order_product_detail` (
  `id` varchar(255) NOT NULL,
  `order_info_id` varchar(255) DEFAULT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `subtotal` decimal(10,0) DEFAULT NULL,
  `market_price` decimal(10,0) DEFAULT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `deal_price` decimal(10,0) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `is_comment` tinyint(4) DEFAULT NULL,
  `is_gift` tinyint(4) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product_detail
-- ----------------------------
INSERT INTO `order_product_detail` VALUES ('00a6e640f54e4013afab643e76dd4857', null, '69405561', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:08:14', '2016-11-17 16:08:14', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('297e78a567834625b3dc4f9dbaaa247e', null, '69405561', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:08:14', '2016-11-17 16:08:14', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3891a53d59824e8885b991053667ee5a', null, '09371692', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:09:14', '2016-11-17 16:09:14', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('4c142936ad71476cafd27c35b2628e90', null, '09371692', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:09:14', '2016-11-17 16:09:14', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('278c64990a604dfd889809de9aa9f4e0', null, '17337896', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:09:55', '2016-11-17 16:09:55', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('beaea4be2f3d4e6e997bf63011bea660', null, '17337896', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:09:55', '2016-11-17 16:09:55', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('32479169be9340a9a61e92f654033375', null, '16750448', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:23:50', '2016-11-17 16:23:50', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('5fbc2b26ddb343f1bd841ec65a08e545', '3f5f34dd86934d3bb54526fd54797623', '49127573', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:45:00', '2016-11-17 16:45:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('b92eefafcb2041b398112f5a1a044e3e', '3f5f34dd86934d3bb54526fd54797623', '49127573', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 16:45:00', '2016-11-17 16:45:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('da9363611080419f97e6d35ff2ed17e4', '85d95e8ad5fd4d06908b2a86e4869635', '21412883', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 23:32:29', '2016-11-17 23:32:29', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('fe6c44109bca4d31ab89469737022c5a', '85d95e8ad5fd4d06908b2a86e4869635', '21412883', '花卷', '16', '8', '1', '1', '1', '1', '0', '0', '--', '2016-11-17 23:32:29', '2016-11-17 23:32:29', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('13478b8cab2a40d286312abb63926cd0', 'e33fd89cec9c4a478061905c72a77c2a', '64782083', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 20:48:20', '2016-11-18 20:48:20', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('00861e411ac64cbd8da55baf54bac6e7', '482cdf60d033421887776d53a3951c8a', '25258853', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 20:59:17', '2016-11-18 20:59:17', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('430d51765d01492881f619abac1a3c7f', '45a02081f5d9402f9d4ad3a6f09c3284', '80995325', '大馍', '10', '5', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 22:40:56', '2016-11-18 22:40:56', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('5fa2ac5903b54719b45d3856741a6e8c', 'a551579396324483a59779a5695cbf0e', '26534794', '花卷', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 22:43:46', '2016-11-18 22:43:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('66e75e75d2c240d1a624a3ffe5cee345', 'a551579396324483a59779a5695cbf0e', '26534794', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 22:43:46', '2016-11-18 22:43:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('726022ffa9574654ae5521fc5ab89282', '12d8cbc264f84030bcd87caeae629de2', '58853726', '吃的', '41', '41', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 22:46:41', '2016-11-18 22:46:41', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('cd27eed67fe34402930dcba45c73c759', 'e41f285deea045fa97fc103c6a5dd891', '62168951', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 23:56:39', '2016-11-18 23:56:39', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('a44b0516997c497784c37b3b0058f302', 'e41f285deea045fa97fc103c6a5dd891', '62168951', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-18 23:56:39', '2016-11-18 23:56:39', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3de2d367feb647dd8eaf065608bac489', '3eded5cf32ef420e8c52b21b11512451', '48781431', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:02:08', '2016-11-19 00:02:08', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('01bb9701e25249eab6b6eb4789ce6634', '3eded5cf32ef420e8c52b21b11512451', '48781431', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:02:08', '2016-11-19 00:02:08', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('1dbdc19588224b14a75dfa1df76d4f79', '232209c6626a4e7099356fafc0670f89', '40130898', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:06:18', '2016-11-19 00:06:18', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('aec9615495a848e8a3dc624ae42a2707', 'bd9c718f941d4f0198f2d1cfa47bfe4f', '01185033', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:13:20', '2016-11-19 00:13:20', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f6b6070550a74769832836398e451557', '815fa2a70eb140b78c8dadc66a9be164', '82293845', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:14:19', '2016-11-19 00:14:19', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('192a86c5748a4e7993947420e167eef3', '61d0b45564ab4c148d5a66f63639e02c', '97628461', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:23:25', '2016-11-19 00:23:25', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('5328626f5a634b0fabd09117d4d5b05e', '3073752bb03d4355b4e8476268b8b514', '36820844', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:30:46', '2016-11-19 00:30:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('289ca303edf3477883981126559f28f6', '68371cc47ff54986a39f7ae7f06370f2', '46867928', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:31:25', '2016-11-19 00:31:25', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3a61e8136d6245eb9ccce345fb73f931', '84debacf2a1645c49f15387f20e5741b', '81688512', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:50:26', '2016-11-19 00:50:26', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6c47a533530a40c5a472a73a85578ed2', '84debacf2a1645c49f15387f20e5741b', '81688512', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:50:26', '2016-11-19 00:50:26', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c38846bd1fbb4b81a2c6b636bba09b08', '9c92748255d443958be2362e2f3c2870', '20315397', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:52:45', '2016-11-19 00:52:45', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('54bd4cfa00224bac8936650d49183c1d', '9c92748255d443958be2362e2f3c2870', '20315397', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:52:45', '2016-11-19 00:52:45', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('ef2f4f42dbf442669d0aa7edb4b22b70', '9c92748255d443958be2362e2f3c2870', '20315397', '吃的', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 00:52:45', '2016-11-19 00:52:45', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6954bde2912444ae89a00edddf9f01e0', 'd98a386254174cda916b1bb1a3d1482a', '83842084', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 02:36:35', '2016-11-19 02:36:35', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('1cf0b5af792f4eacbb5ba5500c227a10', 'd98a386254174cda916b1bb1a3d1482a', '83842084', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 02:36:35', '2016-11-19 02:36:35', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('d2c5e05b908b4463994d3ef96d250921', 'b9b80453330d47de9e46d6d4b214bb8c', '11138972', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 03:27:17', '2016-11-19 03:27:17', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('7bdc5e1eda444aa893a9921d7aeb7cf1', 'b9b80453330d47de9e46d6d4b214bb8c', '11138972', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 03:27:17', '2016-11-19 03:27:17', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8031cfed0619416ea98d567fb75600b3', 'd4425781b0ca4c6e9346dafc393680b2', '85170198', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 10:26:47', '2016-11-19 10:26:47', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('09188439b0c045aeac8e5aa6b164f496', 'd4425781b0ca4c6e9346dafc393680b2', '85170198', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 10:26:47', '2016-11-19 10:26:47', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('940842765e5d46fa86f0efe57b084ca3', 'a206e56d221e48f9ac2dfa3962bc205c', '12160075', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 16:10:50', '2016-11-19 16:10:50', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('b5af110aad6c46159aa3d9fba234dafa', 'a206e56d221e48f9ac2dfa3962bc205c', '12160075', '花卷', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 16:10:50', '2016-11-19 16:10:50', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e20ea1ae05d142818d738c00cf1ebd86', '1291b2839a6a497e94712898096735aa', '64069245', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 22:44:56', '2016-11-19 22:44:56', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e185012372cf4dbdb0a7a99a8cd7767f', '1291b2839a6a497e94712898096735aa', '64069245', '吃的', '8', '8', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 22:44:56', '2016-11-19 22:44:56', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e030c7aef71a4ecfb32b78c790d5330a', '1291b2839a6a497e94712898096735aa', '64069245', '大馍', '6', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 22:44:56', '2016-11-19 22:44:56', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e0cda93d8e404ebe90c6d48af452c7e1', 'c6a9c149ec44451db9f996fcc9e4a94b', '61227246', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 23:27:59', '2016-11-19 23:27:59', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8e5e30c904144e59a014ef86123a31f9', 'c6a9c149ec44451db9f996fcc9e4a94b', '61227246', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 23:27:59', '2016-11-19 23:27:59', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('bb132b8b30404788a2f84560339bafbe', 'd094a069c7ac4e49abb6c4c73a5bc930', '23566398', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 23:32:00', '2016-11-19 23:32:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('eb25002a85e14cb39ba9db21428882d8', 'd094a069c7ac4e49abb6c4c73a5bc930', '23566398', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 23:32:00', '2016-11-19 23:32:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('b735930d79914dbab0332a82003c6557', '3bec7ca539424dfc8caf9657836b8986', '64618776', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 23:33:13', '2016-11-19 23:33:13', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('846e863986794202a0087be4da5211fa', '3bec7ca539424dfc8caf9657836b8986', '64618776', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-19 23:33:13', '2016-11-19 23:33:13', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0141b89437a447ff9166f763bbda2d6f', '623aaba6a86b4c7bbd86aa85b913652f', '19080203', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:25:39', '2016-11-20 01:25:39', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8b05ce84cfe04e0ebb710d5fed160a3b', '623aaba6a86b4c7bbd86aa85b913652f', '19080203', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:25:39', '2016-11-20 01:25:39', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('808c7f74fc9e4546b31d9febc405399b', '178e6c112ecd496cacbe32026caaa55c', '34822068', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:40:49', '2016-11-20 01:40:49', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3fe7ae003502484e8680de7f678a762c', '178e6c112ecd496cacbe32026caaa55c', '34822068', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:40:49', '2016-11-20 01:40:49', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('7a36faded4454050a3f37d09c52ed51d', 'a8174dcb61294624b3acfdfbaca92c87', '01202488', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:41:35', '2016-11-20 01:41:35', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c46fb9558fc04afba262ca6f3bef6840', 'a8174dcb61294624b3acfdfbaca92c87', '01202488', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:41:35', '2016-11-20 01:41:35', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f583ba584ffd4cf8b2ce99ca92048ab0', 'a1db15212e904057b6e6de3aeddefd62', '03597319', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:46:12', '2016-11-20 01:46:12', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('00e2940bf0bb4da69c40ea95bcf42d8d', 'a1db15212e904057b6e6de3aeddefd62', '03597319', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:46:12', '2016-11-20 01:46:12', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8ef382d336304bb8ac55ee869a07858c', 'e8171363dfa64af4b4ad55c7da387da3', '26838468', '吃的', '4', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:50:07', '2016-11-20 01:50:07', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('9d87e7014bd64e11abb8b504a37b2d30', 'e8171363dfa64af4b4ad55c7da387da3', '26838468', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:50:07', '2016-11-20 01:50:07', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('cc5108e4ad2842c2a7c3fa4ab17652b4', 'e8171363dfa64af4b4ad55c7da387da3', '26838468', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:50:07', '2016-11-20 01:50:07', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('28b557135983463f8602c15544e14373', '01e3573a1b304e91a758482a7561eea7', '57824378', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:55:12', '2016-11-20 01:55:12', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('307fc1aa44fb4302aecb3bcc1c034a7c', '01e3573a1b304e91a758482a7561eea7', '57824378', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:55:12', '2016-11-20 01:55:12', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('586065dd8d1e4019ae1ecb1320ff3b2d', 'a7db5d010d68444d84847d12f561062a', '21789281', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:55:59', '2016-11-20 01:55:59', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3d034299bbfc47a79cd06f37df0884fa', '755365a52d2144c2964bfe3c495e3df9', '53964179', '吃的', '30', '30', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 01:59:27', '2016-11-20 01:59:27', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('849e8f711bea42c1806ff5ae56b089d8', '4e4189785d134b3fb8aa91cac4fc3eee', '22441979', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 02:42:28', '2016-11-20 02:42:28', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('b807adb89caf47b29bf585fdee3d4462', '4e4189785d134b3fb8aa91cac4fc3eee', '22441979', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 02:42:28', '2016-11-20 02:42:28', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0dc4de6d8a7c4243a04038e359a22cb7', 'cc13ced9cf6145ba9824661b9a4783fa', '67011262', '大馍', '21', '11', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 16:10:20', '2016-11-20 16:10:20', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('130c18520deb4a668fd9cdf220795201', 'cc13ced9cf6145ba9824661b9a4783fa', '67011262', '花卷', '26', '13', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 16:10:20', '2016-11-20 16:10:20', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('878eb33a47894a25b9550d50cc7ae670', 'cc13ced9cf6145ba9824661b9a4783fa', '67011262', '吃的', '4', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 16:10:20', '2016-11-20 16:10:20', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c557615281c449ecaa595aa345e1f219', 'fc1f95d4f07042d38970f6fb2a7c18d5', '09787843', '花卷', '48', '24', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 18:18:00', '2016-11-20 18:18:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('189c0617c90348fbb9df5fdf49704106', 'fc1f95d4f07042d38970f6fb2a7c18d5', '09787843', '大馍', '35', '18', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 18:18:00', '2016-11-20 18:18:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('1544bd3fc15a4ccda3cf5852341df75f', '0e9b36493a0a48fea9346a029ed04db0', '94781590', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 20:31:19', '2016-11-20 20:31:19', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('961dc13efa944b0ba0f9df3de48a4777', '0e9b36493a0a48fea9346a029ed04db0', '94781590', '大馍', '5', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 20:31:19', '2016-11-20 20:31:19', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c68a066b383c4588ac0c2b5265ec4fb0', 'a026563c7e36458eb338992f7674d994', '92080001', '大馍', '7', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 22:39:33', '2016-11-20 22:39:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('9853073f1dda462284e3fa891ed38c72', 'a026563c7e36458eb338992f7674d994', '92080001', '花卷', '8', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 22:39:33', '2016-11-20 22:39:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e1d0d55e3a16440a8bcd695661d9e528', '11be5c34c7fd42cca7de78b7ca1d10fd', '13155766', '吃的', '7', '7', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 22:45:55', '2016-11-20 22:45:55', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3a598977d3a24889bb50a98eddbfbc6d', '63764307f9374ca28e8521c66a4babbb', '39049775', '花卷', '7', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 23:07:30', '2016-11-20 23:07:30', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0b219c61e5514ebaa38be6034fdc4b9a', '63764307f9374ca28e8521c66a4babbb', '39049775', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 23:07:30', '2016-11-20 23:07:30', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e12f8cfcba3c4b00ab184e778a542884', '0b3593550c8144ed8d808b5248ea593c', '94396186', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 23:13:28', '2016-11-20 23:13:28', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f137ec8b1c0740de8ead7824eb5963be', 'e94e307300e64ab395187f9d1a09a4de', '75600846', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 23:57:12', '2016-11-20 23:57:12', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6f93a649bc2446e48994c25c3796d967', 'ca97327f3d1e4a4abcc00446dbd80bcc', '62475690', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-20 23:57:33', '2016-11-20 23:57:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('776b8b5aaa4645ea91b7d379d51c21b6', '34b71341fad64ce99f98099ae47b7917', '71564772', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:03:38', '2016-11-21 00:03:38', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f013b7adface4d958f5060d938b0e0d6', '34b71341fad64ce99f98099ae47b7917', '71564772', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:03:38', '2016-11-21 00:03:38', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('ef9502d2a8f245c5a005673d0ee953fa', '5797a2a3c0b842fb9b020f49b367599e', '02151998', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:05:10', '2016-11-21 00:05:10', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f041aa3f51f94186b077328a0fdee1bd', 'f296dd04534141ef9b8b72f9d9c53183', '54443832', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:06:30', '2016-11-21 00:06:30', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('166568b7e24b4bfebdd48e6f26029775', '5c650f17afe74e67a2d0b60a9019c6b3', '19348049', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:21:36', '2016-11-21 00:21:36', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0e68ffe0a6a246dbb06b9e3a7a704712', '5c650f17afe74e67a2d0b60a9019c6b3', '19348049', '大馍', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:21:36', '2016-11-21 00:21:36', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8f9f4cbd55dc48b4bb3be22eba267cbf', '9a086c7e627b4d1196d1886eefc30c4c', '94337238', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:23:22', '2016-11-21 00:23:22', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0e72841dc64742f9aee1afa8fbc49fa2', '91ab3c68925f40f4803a9ac339ab28cf', '35089701', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:23:56', '2016-11-21 00:23:56', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('90d62ccd457147c3a0c16c033b7ad3b7', 'b415fbd58bf94b619b4649cfe0d9280d', '44445520', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:30:44', '2016-11-21 00:30:44', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('63fdcee463404498a0aaba41be388848', '21956076370b452eba596416d250b2b1', '56549090', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:31:51', '2016-11-21 00:31:51', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('47ab061775f140b29baa2338b9f1e1f8', '506a978553de417fb1a26d3655125135', '63331256', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:32:40', '2016-11-21 00:32:40', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('94247c8dfd1b465e9c70f3a66073c4b8', '4ce1ecaaafc44e618ecb42e7d63ad8cf', '32076413', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:34:32', '2016-11-21 00:34:32', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('239698b09a5c4303a4b97a6f9a811444', 'a32836907004405492067fed2df10d74', '24496896', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:36:28', '2016-11-21 00:36:28', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('84c6142929a947a19170d978d20212ec', 'd1df871ce8114d5ba8709d50d1cd3386', '46954093', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:38:37', '2016-11-21 00:38:37', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f505fd8c4bdb4cbb9ec2d28eef5b5433', 'f79065a88f0546d4bdef87d25a366d00', '43966855', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:39:19', '2016-11-21 00:39:19', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('03067a135f124244bf47fbe690cc52c4', '0c65a0377bea4b579f9f50661cb62944', '77521665', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:40:14', '2016-11-21 00:40:14', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('9fc02f9c9e9c4f09b2a0a4913676ae24', 'baa8692c79d34fb680ae8c6e02d80556', '05551276', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:41:10', '2016-11-21 00:41:10', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c0b47382b0614678adc9399244c38045', '0b1b1d58b85641fd8a6cbb15e5aeb284', '89763655', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:46:04', '2016-11-21 00:46:04', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6cdb8f25c1a747018e75d1e337f98dfe', '0b1b1d58b85641fd8a6cbb15e5aeb284', '89763655', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:46:04', '2016-11-21 00:46:04', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('7c7893e444eb496a8c1652e948ac5c8a', '988c110df3734a88bad8e0d1f8432eeb', '60787235', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:46:29', '2016-11-21 00:46:29', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('4a8c228192554616acdceec40409a0dd', '988c110df3734a88bad8e0d1f8432eeb', '60787235', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:46:29', '2016-11-21 00:46:29', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3d39079b4e974e9a9eb2ee6a974eb875', 'ad59864810c643b5a30d77fb65326ccd', '00615828', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:49:26', '2016-11-21 00:49:26', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('5de0b3cf584c4fe7808af384e081ed43', 'ad59864810c643b5a30d77fb65326ccd', '00615828', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 00:49:26', '2016-11-21 00:49:26', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6c6d9976a55743499aa6f506ba1d3372', 'c46860db83ff485abe8883cded2d4648', '37664380', '大馍', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:23:14', '2016-11-21 01:23:14', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('71ccf4cb81a74d1bb3a6f3839b943183', '238f7c9f9e78489f8e9d01355378b748', '78075424', '吃的', '4', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:26:53', '2016-11-21 01:26:53', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('1db59a4aedea427ca7d44b4ae80b0c61', '238f7c9f9e78489f8e9d01355378b748', '78075424', '花卷', '11', '6', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:26:53', '2016-11-21 01:26:53', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('09743603c91b4e2685dfd2bc352faff0', '238f7c9f9e78489f8e9d01355378b748', '78075424', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:26:53', '2016-11-21 01:26:53', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8a568b79f083477596d36e3db239e462', 'bf2b708bf2cc4ea390d93c109bc40ad9', '78603807', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:27:48', '2016-11-21 01:27:48', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('5928e266984d455f8818c7b7fb1e716a', 'bf2b708bf2cc4ea390d93c109bc40ad9', '78603807', '吃的', '3', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:27:48', '2016-11-21 01:27:48', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('d0daa93f642e426b9fb46f3586b18178', 'bf2b708bf2cc4ea390d93c109bc40ad9', '78603807', '花卷', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:27:48', '2016-11-21 01:27:48', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('8c48997fce254f7c8c555ee7aa1abe78', '8046fdd6a46f419eb3e56a5520658f5e', '75207954', '吃的', '6', '6', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:29:01', '2016-11-21 01:29:01', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('08265dcbbb9b43b6beb343de70fc5c34', '8046fdd6a46f419eb3e56a5520658f5e', '75207954', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 01:29:01', '2016-11-21 01:29:01', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('e9053cfbcd8242d3a4935cb67d6b79a3', '5ef282e949f9451486ef488c6b22e4b6', '89305950', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 11:57:31', '2016-11-21 11:57:31', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('9218eada09b54cc2ac6b1c8cb96eb6ec', '5ef282e949f9451486ef488c6b22e4b6', '89305950', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 11:57:31', '2016-11-21 11:57:31', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('bd1c96bb8ab247cca4cad76f3776e92d', '5ef282e949f9451486ef488c6b22e4b6', '89305950', '吃的', '2', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 11:57:31', '2016-11-21 11:57:31', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('db7740554fb14c1784055c2e44314d0c', 'b584e5fdc62349a3afb13c090b0b34cc', '24359081', '花卷', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 11:59:19', '2016-11-21 11:59:19', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('fdeb365a7a4942fa80ed40931f268b7a', 'b584e5fdc62349a3afb13c090b0b34cc', '24359081', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 11:59:19', '2016-11-21 11:59:19', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('28764b72d6814536a74998ae3c7b746c', '5ba0edd31e9e47f98feb6080813dd0bf', '81741166', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 12:02:44', '2016-11-21 12:02:44', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f3757539b7fe4bbaa555d77d559a1316', '5ba0edd31e9e47f98feb6080813dd0bf', '81741166', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 12:02:44', '2016-11-21 12:02:44', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('be42cf4297b347508cb8b0a3f102fbf8', 'f6f72630fa814498b4a7a263eccf0c7b', '81158995', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 12:03:05', '2016-11-21 12:03:05', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6d9e8ce58dd34eb29b59c1306de021c4', 'f6f72630fa814498b4a7a263eccf0c7b', '81158995', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 12:03:05', '2016-11-21 12:03:05', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0555d55459ea4c33a410ef6f2fea9021', 'ad8f5ef00d034c14939eccf56b46d899', '22990924', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 12:57:36', '2016-11-21 12:57:36', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('55c323c1658d47f2ad94f2f662fda239', 'ad8f5ef00d034c14939eccf56b46d899', '22990924', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 12:57:36', '2016-11-21 12:57:36', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('a9a21493727a45918914d6e212c157ae', '84d0bf11cde446e183608a598566e281', '59798007', '大馍', '5', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 22:59:45', '2016-11-21 22:59:45', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('106c93bc94a84d8393102ab414985acb', '84d0bf11cde446e183608a598566e281', '59798007', '花卷', '10', '5', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 22:59:45', '2016-11-21 22:59:45', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('f0fed99fa894497592c99d684c88db1f', 'd37f2fc07f4c49099404eb91e481cb31', '90994901', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:17:11', '2016-11-21 23:17:11', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('818ef47417ec4106bc16f09099c6f5d2', 'd37f2fc07f4c49099404eb91e481cb31', '90994901', '花卷', '9', '5', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:17:11', '2016-11-21 23:17:11', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('493ef9abf2334c61ac32f45e7bff6a4d', 'db49769d66de47de80f174d39f535ce5', '75238422', '花卷', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:21:47', '2016-11-21 23:21:47', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('cc3bdab7b56e4fedaf70fe9dddf27590', 'db49769d66de47de80f174d39f535ce5', '75238422', '大馍', '7', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:21:47', '2016-11-21 23:21:47', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('878a790ab4b44fcf8b1903b2ff8e607c', 'be5d8827c2354419bcf221d42fdf6553', '33231469', '花卷', '5', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:40:00', '2016-11-21 23:40:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('1c828f42d4234463bd3b5c6c9794e7ff', 'be5d8827c2354419bcf221d42fdf6553', '33231469', '大馍', '5', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:40:00', '2016-11-21 23:40:00', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('3d8dc340ad50469897677c41587b5469', '871bda6c48ca4b5f88ee59338960fcf5', '47402059', '大馍', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:45:49', '2016-11-21 23:45:49', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('adad6e3279144c3bb0008cedd299a503', '871bda6c48ca4b5f88ee59338960fcf5', '47402059', '花卷', '6', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:45:49', '2016-11-21 23:45:49', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('75cc504985c44ee4a49e23f7a4067838', '5a9e114f3aa64a8da090d7d224247cff', '35815122', '花卷', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:53:49', '2016-11-21 23:53:49', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('80822db96c344ccfb08de6de62b777a7', '5a9e114f3aa64a8da090d7d224247cff', '35815122', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:53:49', '2016-11-21 23:53:49', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('95c1baca293142cba7ff31f5df960865', 'f3878d7c5bf145ad8082f7f95d09a6a5', '06448107', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:57:16', '2016-11-21 23:57:16', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('76caff76f1894df7ace633fd0c69aa95', 'd8f3ada21fd64333beb15ef7c7bf6f4c', '41189458', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:57:44', '2016-11-21 23:57:44', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('077e742cc1a446778de25d7fb042b799', 'dd730ec7772d4c8aba2525c31e08dced', '50751194', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:58:11', '2016-11-21 23:58:11', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('b36c0922795c4921bbf03a35a07d0a47', 'a70c715169c14eac92d645de4709c516', '55941406', '大馍', '2', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-21 23:59:03', '2016-11-21 23:59:03', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('134bf1b5a56a4f00a99ef417509823df', '82f4f04dabc74037b95be0aedbe8997a', '46299589', '大馍', '101', '51', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('eb122daf1b0243b6b24907e169b4bc4e', '82f4f04dabc74037b95be0aedbe8997a', '46299589', '花卷', '8', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c5a64f78c06941589521304dcad4f015', '82f4f04dabc74037b95be0aedbe8997a', '46299589', '吃的', '2', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('fd5e8c139ec342548cd61b9f991779d7', '98a735bb8a13422394551fa944b0a7c0', '14528930', '花卷', '5', '3', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 00:36:34', '2016-11-22 00:36:34', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('042bb6aa52be4cb6b3c6b7f98d0e3e0a', '98a735bb8a13422394551fa944b0a7c0', '14528930', '大馍', '56', '28', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 00:36:34', '2016-11-22 00:36:34', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('71c481266010476fa0ade5be674d4334', 'f77599f0d01c409fb9bd69c98c17df0d', '05654801', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 13:13:42', '2016-11-22 13:13:42', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('c255d9c382044fb68fb353817ae4ee3f', 'f77599f0d01c409fb9bd69c98c17df0d', '05654801', '大馍', '4', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-22 13:13:42', '2016-11-22 13:13:42', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('0338c1101443465a9181ca0550a34564', '02b7a9e577254f709fc6afb16e6ae00e', '58927163', '花卷', '12', '6', '1', '1', '1', '1', '0', '0', '--', '2016-11-23 01:39:46', '2016-11-23 01:39:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('869778217fc0463194438b74549a2556', '02b7a9e577254f709fc6afb16e6ae00e', '58927163', '大馍', '9', '5', '1', '1', '1', '1', '0', '0', '--', '2016-11-23 01:39:46', '2016-11-23 01:39:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('916b76bed8a346db9f10b05970eae185', '03807d9304a945bfa8d82db7c0d59d86', '63718652', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('46014141c2df482a92b191bf6472242f', '03807d9304a945bfa8d82db7c0d59d86', '63718652', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('183d08d91e15419c9af38e35d7aed207', '971d9d6a4258402299cffcfecdffed3c', '33226048', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('4c39ab0ce2a6451088b841f86e334b5a', '971d9d6a4258402299cffcfecdffed3c', '33226048', '大馍', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('764d166496e9410fa1fca805e29fa47a', '907cea6ce49443fabeafd0e366cbbb77', '72580291', '花卷', '9', '5', '1', '1', '1', '1', '0', '0', '--', '2016-11-24 00:00:26', '2016-11-24 00:00:26', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('b3b8393897de49118aa46d6d4c3a86d3', '907cea6ce49443fabeafd0e366cbbb77', '72580291', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-24 00:00:26', '2016-11-24 00:00:26', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('9c8f16b3cd744e43b72a3345d1856642', 'fddab9948f4743149d8f6caaeb4aeace', '08574631', '大馍', '11', '6', '1', '1', '1', '1', '0', '0', '--', '2016-11-26 14:19:46', '2016-11-26 14:19:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('6b829c10f36c401493bcf2fe9cc997f7', 'fddab9948f4743149d8f6caaeb4aeace', '08574631', '花卷', '18', '9', '1', '1', '1', '1', '0', '0', '--', '2016-11-26 14:19:46', '2016-11-26 14:19:46', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('ba34172677974898b8ae1c41369e7683', '82d13c36d06747888d55602e9ccb6890', '50031248', '吃的', '4', '4', '1', '1', '1', '1', '0', '0', '--', '2016-11-27 00:20:24', '2016-11-27 00:20:24', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('cd371b970d0947b0875bf9bcfeb747d6', '82d13c36d06747888d55602e9ccb6890', '50031248', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-27 00:20:24', '2016-11-27 00:20:24', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('2ca951626fbc41f6b68ada2be79780b2', '82d13c36d06747888d55602e9ccb6890', '50031248', '花卷', '3', '2', '1', '1', '1', '1', '0', '0', '--', '2016-11-27 00:20:24', '2016-11-27 00:20:24', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('4a57272b31db414f857d6666791a1ffd', 'b228ef205bc24c7aac56fc242a60d044', '39345731', '花卷', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-27 12:54:18', '2016-11-27 12:54:18', 'NORMAL');
INSERT INTO `order_product_detail` VALUES ('25f253619caf4a73b79863f8740ebca9', 'b228ef205bc24c7aac56fc242a60d044', '39345731', '大馍', '1', '1', '1', '1', '1', '1', '0', '0', '--', '2016-11-27 12:54:18', '2016-11-27 12:54:18', 'NORMAL');

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
INSERT INTO `product` VALUES ('1', '大馍', '0.5', '0.5', '001', '馍', '1', '1', '1', '1', '99518', '推荐', '5', '0.25g/个', '好吃的', '2016-06-29 10:11:16', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `product` VALUES ('2', '花卷', '0.5', '0.5', '002', '卷子', '1', '1', '1', '1', '99596', '推荐', '5', '0.25g/个', '好吃的', '2016-06-29 16:38:03', '2016-11-13 19:00:25', 'NORMAL');
INSERT INTO `product` VALUES ('3', '糖包', '0.6', '0.6', '003', '糖包', '1', '1', '1', '1', '0', '推荐', '5', '0.25g/个', '好吃的', '2016-06-29 16:38:57', '2016-11-13 18:58:39', 'NORMAL');
INSERT INTO `product` VALUES ('4', '吃的', '1.0', '1.0', '004', '好吃的', '2', '1', '0', '1', '-3', '特别', '5', '0.25g/个', '好', '2016-10-30 17:54:17', '2016-11-13 19:00:25', 'NORMAL');

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
INSERT INTO `product_focus` VALUES ('66f98567291c4e27bb78ee2389e5d8c8', '1', '1', '--', '2016-10-17 16:35:01', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('aaacfb2b0c9e4728b8b91bc6d4e3d16a', '1', '1', '--', '2016-10-17 18:47:48', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('dd80daf896354be1b57f761be5b700ef', '1', '1', '--', '2016-11-01 09:36:20', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('4612cb7a5d9f4789a28ef05bccec0df8', '1', '1', '--', '2016-11-01 09:40:17', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('07a94da9a0dc4a158096b5a027073a11', '1', '1', '--', '2016-11-01 09:40:24', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('9524251991594936ab8a2a5702e92522', '1', '1', '--', '2016-11-01 09:40:41', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('2fe700d1505242abb99c882673edeab8', '1', '1', '--', '2016-11-01 09:43:00', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('532d211672c2404aa658f061f796dde9', '1', '1', '--', '2016-11-01 09:43:54', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('dd2690cbe3c145728c0308fb53617167', '1', '1', '--', '2016-11-01 09:44:21', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('7183dff335ff4e24ab2526c95f2b5fae', '1', '1', '--', '2016-11-01 09:44:25', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('c70c042e18974ce39637a76dee79b59b', '1', '1', '--', '2016-11-01 09:44:26', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('ef2fea1132354711a38f724e7f893e01', '1', '1', '--', '2016-11-01 09:44:28', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('1b7bcb09b3b94bb0b277bf0d9f8f084e', '1', '1', '--', '2016-11-01 09:44:28', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('735d8c987f3e4195aec91797f115c614', '1', '1', '--', '2016-11-01 09:44:29', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('32f0473eb9974a83a69e1c51bd2fbff1', '1', '1', '--', '2016-11-01 09:44:29', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('c013bfcad1aa4d968f0706a5ea40d197', '1', '1', '--', '2016-11-01 09:44:29', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('b725ace4a9744ea1b80ef693bd13495d', '1', '1', '--', '2016-11-01 09:44:30', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('f4a990e68aa54286b5fa5c72d21bc8ca', '1', '1', '--', '2016-11-01 09:44:30', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('da210f27180740ea917a314112584978', '1', '1', '--', '2016-11-01 09:44:31', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('effe9fe176da40c5b4b95fc49dfbfa2d', '1', '1', '--', '2016-11-01 09:44:31', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('d0e601904dae4d76b0dc04710812ee24', '1', '1', '--', '2016-11-01 10:02:12', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('b5de20a5bcf848b29970858d0759ba5a', '1', '1', '--', '2016-11-01 10:18:18', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('a54cf40171bc4e93a864854dc7a671c7', '1', '1', '--', '2016-11-01 10:18:29', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('a33ef6a6de814928a86ea95a4729adba', '1', '1', '--', '2016-11-01 10:19:27', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('1906b7184c9340038c0ae2c5751a4cf1', '1', '1', '--', '2016-11-01 10:22:51', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('b6124bab1e694b16a24812bc71abbf21', '1', '1', '--', '2016-11-01 10:22:53', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('7328c884c82f4b23ad13847bdb4e10b7', '1', '1', '--', '2016-11-01 10:22:56', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('783381a3bb6b40bd9d5ba760449ac043', '1', '1', '--', '2016-11-01 10:22:58', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('64a89c8c9ced4800a9cf219d43741dfa', '1', '1', '--', '2016-11-01 11:08:33', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('e1e790b7fbae489ba1e9c99cb72c05d9', '1', '1', '--', '2016-11-01 11:08:35', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('317a0f81fa014417ab63479e480c8100', '1', '1', '--', '2016-11-01 11:08:37', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('f46f63b8393b4c9084e11f356679b775', '1', '1', '--', '2016-11-01 11:37:51', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('0c10611d098146d5869b5afc9990c6ec', '1', '1', '--', '2016-11-01 19:17:12', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('bd459bf996e748ac8bd474bedda824cc', '1', '1', '--', '2016-11-01 21:27:49', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('783c061f2f9645edab283d03572bc844', '1', '1', '--', '2016-11-01 21:27:51', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('803aa3b0592746c9b443ce9b7d9b5da0', '1', '1', '--', '2016-11-01 21:27:53', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('3c3fc9aea9e641348f35c56b963c7e67', '1', '1', '--', '2016-11-02 16:03:59', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('de5dd489a6384014a3db5c4efb2f0f75', '1', '1', '--', '2016-11-02 16:04:02', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('17d6c0a2343a4432a7aa323dac08f0cf', '1', '1', '--', '2016-11-02 20:40:10', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('972900d9f2a64056837c77491043b425', '1', '1', '--', '2016-11-02 20:40:13', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('9320ce1074484907afd8d240414a7de8', '1', '1', '--', '2016-11-02 20:40:14', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('99f60c4c1c8c4da59fe7f68e99e37a8b', '1', '1', '--', '2016-11-02 20:40:17', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('baab596f5f3b403ba39e3140f8005309', '1', '1', '--', '2016-11-02 20:40:20', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('759388e28b924a9ba0b2b062138c2d81', '1', '1', '--', '2016-11-02 20:40:22', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('5afcd8ea611d437690cc8d972c9030fa', '1', '1', '--', '2016-11-03 22:18:47', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('e9e86261b29840d58914c58914fc7921', '1', '1', '--', '2016-11-05 01:51:50', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('4c73a23ed9104ea68ee59ca6235269ac', '1', '1', '--', '2016-11-05 01:51:53', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('91cdb07b52564723945cc36d34ae59c4', '1', '1', '--', '2016-11-13 18:55:16', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('25277e1ce5da4356906e79b5a6324700', '1', '1', '--', '2016-11-20 03:01:23', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('f351a48ee330473fb8aa7ca604bd44c4', '1', '1', '--', '2016-11-20 15:11:11', '2016-11-26 13:03:06', 'DELETE');
INSERT INTO `product_focus` VALUES ('20f76424ffe24561a880c309cf098a22', '1', '1', '--', '2016-11-26 13:03:08', '2016-11-26 13:03:08', 'NORMAL');

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
INSERT INTO `sms_history` VALUES ('b41eab67dda84711ae15de9623651e8b', '18600536684', '尊敬的用户，您的验证码为3851，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '61.148.243.49', '3851', '--', '2016-11-20 20:04:00', '2016-11-20 20:04:00', 'NORMAL');
INSERT INTO `sms_history` VALUES ('83a6af54e79942e8b828d6c761e351d6', '18600536684', '尊敬的用户，您的验证码为4174，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '61.148.243.49', '4174', '--', '2016-11-20 20:04:00', '2016-11-20 20:04:00', 'NORMAL');
INSERT INTO `sms_history` VALUES ('6229a90aea134aef9a54b8accf29bb08', '18600536683', '尊敬的用户，您的验证码为4831，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.184', '4831', '--', '2016-11-20 22:39:33', '2016-11-20 22:39:33', 'NORMAL');
INSERT INTO `sms_history` VALUES ('55f842d5d1cd42589c1a8670aea1f1c5', '18600536683', '您于11月20日10时48分余额消费7.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-20 22:48:54', '2016-11-20 22:48:54', 'NORMAL');
INSERT INTO `sms_history` VALUES ('f867dfbf295e42399c40fe02fdb1bc09', '18600536683', '您于11月20日11时07分使用余额消费5.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-20 23:07:30', '2016-11-20 23:07:30', 'NORMAL');
INSERT INTO `sms_history` VALUES ('451e0929d1da43c0bfe9cc878a7050c2', '18600536683', '您于11月21日12时39分使用余额消费3.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-21 00:39:19', '2016-11-21 00:39:19', 'NORMAL');
INSERT INTO `sms_history` VALUES ('5aac6ffdddca4aa18e11705213b2208a', '18600536683', '您于11月21日12时40分使用余额消费3.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-21 00:40:14', '2016-11-21 00:40:14', 'NORMAL');
INSERT INTO `sms_history` VALUES ('dd083bb5bc8f4f9188a9a5f9f94fb7a7', '18600536681', '尊敬的用户，您的验证码为0649，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.184', '0649', '--', '2016-11-21 01:24:39', '2016-11-21 01:24:39', 'NORMAL');
INSERT INTO `sms_history` VALUES ('8530b0ab3b5d413ba58a8e6bacf2951a', '18600536683', '您于11月21日12时57分使用余额消费3.5元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '210.74.5.16', null, '--', '2016-11-21 12:57:36', '2016-11-21 12:57:36', 'NORMAL');
INSERT INTO `sms_history` VALUES ('91086a24d533462a8a6291a11c00e5b9', '18600536683', '您于11月21日11时58分使用余额消费3.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-21 23:58:11', '2016-11-21 23:58:11', 'NORMAL');
INSERT INTO `sms_history` VALUES ('dc046cfafd7b45e4b3ca4f4903bd7be6', '18600536683', '您于11月21日11时59分使用余额消费3.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-21 23:59:03', '2016-11-21 23:59:03', 'NORMAL');
INSERT INTO `sms_history` VALUES ('ee44dd19167f48b09eaeadf5c2c71b3f', '18600536681', '尊敬的用户，您的验证码为9455，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.184', '9455', '--', '2016-11-22 00:11:53', '2016-11-22 00:11:53', 'NORMAL');
INSERT INTO `sms_history` VALUES ('7fd2a542135b48d1ba2b4d127c657697', '18600536681', '尊敬的用户，您的验证码为5488，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.184', '5488', '--', '2016-11-22 00:27:16', '2016-11-22 00:27:16', 'NORMAL');
INSERT INTO `sms_history` VALUES ('3b0b568ce04b4b07886d44e98fba26e9', '18600536681', '尊敬的用户，您的验证码为6752，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.183', '6752', '--', '2016-11-22 00:27:16', '2016-11-22 00:27:16', 'NORMAL');
INSERT INTO `sms_history` VALUES ('a0e4b842fe2e4f99968d1f7693ace9e7', '18600536681', '尊敬的用户，您的验证码为5660，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.184', '5660', '--', '2016-11-22 00:27:28', '2016-11-22 00:27:28', 'NORMAL');
INSERT INTO `sms_history` VALUES ('084f9823d47b425c941a932ffcccc8f2', '18600536682', '尊敬的用户，您的验证码为8664，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.184', '8664', '--', '2016-11-22 00:27:53', '2016-11-22 00:27:53', 'NORMAL');
INSERT INTO `sms_history` VALUES ('0d71b4b3bb8b46058d4a3f46c47d1893', '18600536683', '您于11月22日12时34分使用余额消费56.5元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-22 00:34:02', '2016-11-22 00:34:02', 'NORMAL');
INSERT INTO `sms_history` VALUES ('cf36b42d8ee044caaf20fa05509e1183', '18600536683', '您于11月22日12时36分使用余额消费30.5元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.244.184', null, '--', '2016-11-22 00:36:34', '2016-11-22 00:36:34', 'NORMAL');
INSERT INTO `sms_history` VALUES ('c91ebff39a3f4f04815a82fb14b853ea', '18600536683', '您于11月23日11时58分使用余额消费5.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.78.51', null, '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `sms_history` VALUES ('f7f066adcc1b46d295ad01b6760a04f0', '18600536683', '您于11月23日11时58分使用余额消费5.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.78.51', null, '--', '2016-11-23 23:58:33', '2016-11-23 23:58:33', 'NORMAL');
INSERT INTO `sms_history` VALUES ('ff7dbb56b14a4c69a782d63ed7d81bf2', '18600536683', '您于11月24日12时00分使用余额消费5.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.78.51', null, '--', '2016-11-24 00:00:26', '2016-11-24 00:00:26', 'NORMAL');
INSERT INTO `sms_history` VALUES ('266429719d3c4ffa8498d21390c51f66', '18600536683', '您于11月24日12时01分使用余额消费2.0元，如有疑问请致电18600536683', '0', 'NOTICE_CASH_COMSUME', 'system', null, '1.95.78.51', null, '--', '2016-11-24 00:01:00', '2016-11-24 00:01:00', 'NORMAL');
INSERT INTO `sms_history` VALUES ('8ffb0ca54f724fcca45c3af8be8615b1', '18600536686', '尊敬的用户，您的验证码为9633，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.24', '9633', '--', '2016-11-26 16:52:41', '2016-11-26 16:52:41', 'NORMAL');
INSERT INTO `sms_history` VALUES ('98a47985ecf6414f8070871513f6b2b8', '18600536686', '尊敬的用户，您的验证码为0090，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.24', '0090', '--', '2016-11-26 16:53:16', '2016-11-26 16:53:16', 'NORMAL');
INSERT INTO `sms_history` VALUES ('c9629955308f4b349f6b0e4925063de2', '18600536687', '尊敬的用户，您的验证码为8096，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.24', '8096', '--', '2016-11-26 16:54:41', '2016-11-26 16:54:41', 'NORMAL');
INSERT INTO `sms_history` VALUES ('7af5d90f245747779a2338e22cd413f7', '18600536689', '尊敬的用户，您的验证码为7093，本验证码有效时间10分钟，请勿告知他人', '10', 'VALIDATE', 'system', null, '1.95.244.24', '7093', '--', '2016-11-26 17:17:00', '2016-11-26 17:17:00', 'NORMAL');

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
INSERT INTO `sms_template` VALUES ('2', 'NOTICE_CASH_COMSUME', '您于[DATE]使用余额消费[AMOUNT]元，如有疑问请致电18600536683', null, '1', '资金消费', '2016-11-20 21:51:56', '2016-11-20 21:51:59', 'NORMAL');

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
