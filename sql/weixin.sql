/*
Navicat MySQL Data Transfer

Source Server         : 120.27.53.171--wx
Source Server Version : 50173
Source Host           : 120.27.53.171:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-09-19 10:25:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
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
INSERT INTO `account` VALUES ('08f1a907ed5e4d7680fb5aa559925467', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:33:01', '2016-07-12 18:33:01', 'NORMAL');
INSERT INTO `account` VALUES ('10fdd56f2f0f4a1b89ac9e22770db859', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:22:02', '2016-07-12 18:22:02', 'NORMAL');
INSERT INTO `account` VALUES ('17ead34100a34b6eab41998c7e0b3ea7', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:19:59', '2016-07-12 18:19:59', 'NORMAL');
INSERT INTO `account` VALUES ('36e9820b365b4585ada816e387328e69', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:37:02', '2016-07-12 18:37:02', 'NORMAL');
INSERT INTO `account` VALUES ('37ace3a6d0c3416192a90cf3339df26b', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:30:15', '2016-07-12 18:30:15', 'NORMAL');
INSERT INTO `account` VALUES ('bbe76ee9b432466a93ceee835eb6ab6a', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:39:39', '2016-07-12 18:39:39', 'NORMAL');
INSERT INTO `account` VALUES ('d4b3f9dc7096471db2b89c3566137296', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:24:15', '2016-07-12 18:24:15', 'NORMAL');
INSERT INTO `account` VALUES ('e1731aa57ad7406fbde258a816715769', '1', 'WELL', '18600536683', '123456', '0', '0', '0', '0', '127.0.0.1', 'NO', '--', '2016-07-12 18:35:31', '2016-07-12 18:35:31', 'NORMAL');

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
INSERT INTO `ad` VALUES ('1', '名字1', 'http://122.9.35.24/moblie/static/images/ad/swiper-1.jpg', 'http://www.baidu.com', '120', '120', '1', '1', '首页图片1', '2016-06-29 15:24:44', '2016-06-29 15:24:48', 'NORMAL');
INSERT INTO `ad` VALUES ('2', '名字2', 'http://122.9.35.24/moblie/static/images/ad/swiper-2.jpg', 'http://www.baidu.com', '120', '120', '2', '1', '首页图片2', '2016-06-29 16:34:26', '2016-06-29 16:34:29', 'NORMAL');
INSERT INTO `ad` VALUES ('3', '名字3', 'http://122.9.35.24/moblie/static/images/ad/swiper-3.jpg', 'http://www.baidu.com', '120', '120', '3', '1', '首页图片3', '2016-06-30 18:07:05', '2016-06-30 18:07:08', 'NORMAL');

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
INSERT INTO `admin` VALUES ('1', 'cheng', '5cdefe986d7fa0d363930c4062b776bd30a33a3cec47a34291a8bd27', '程', '18600536683', '/img/logo.jpg', '192.168.1.103', '2016-04-18 18:57:52', '0:0:0:0:0:0:0:1', '2016-04-18 15:21:04', '备注', '2016-01-28 15:47:10', '2016-04-18 18:57:52', 'NORMAL');

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
  `address` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arayacak_address
-- ----------------------------

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
INSERT INTO `member` VALUES ('1', '1', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `member` VALUES ('bad8d84ebf7445c39156158426ae356e', '08f1a907ed5e4d7680fb5aa559925467', null, 'Chen', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `member` VALUES ('2129333011c64d0e8b3b12c3385ccd5f', '36e9820b365b4585ada816e387328e69', null, 'Cheng', null, '18600536683', null, null, null, 'NO', null, '0', '0', '0', null, null, null, null, null, '2016-07-12 18:37:02', '2016-07-12 18:37:02', '--', 'NORMAL');
INSERT INTO `member` VALUES ('4710c0e0a4a34118824594499da1f33b', 'bbe76ee9b432466a93ceee835eb6ab6a', null, 'Cheng', null, '18600536683', null, null, null, 'NO', null, '0', '0', '0', null, null, null, null, null, '2016-07-12 18:40:09', '2016-07-12 18:40:09', '--', 'NORMAL');

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
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
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
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` varchar(255) NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `relate_oid` int(11) DEFAULT NULL,
  `amount_payable` varchar(255) DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `sale_price_total` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `delivery_time_id` int(11) DEFAULT NULL,
  `pay_id` int(11) DEFAULT NULL,
  `delivery_type_id` int(11) DEFAULT NULL,
  `arayacak_address` varchar(255) DEFAULT NULL,
  `arayacak_delivery_time_id` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `pay_status` varchar(255) DEFAULT NULL,
  `order_status_customer_id` int(11) DEFAULT NULL,
  `order_status_system_id` int(11) DEFAULT NULL,
  `order_type` varchar(255) DEFAULT NULL,
  `freight_reduce` varchar(255) DEFAULT NULL,
  `freight_payable` varchar(255) DEFAULT NULL,
  `product_total_price` decimal(10,0) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `remark_system` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `exchange_oid` int(11) DEFAULT NULL,
  `custom_pice` varchar(255) DEFAULT NULL,
  `coupon_code` varchar(255) DEFAULT NULL,
  `coupon_reducePrice` decimal(10,0) DEFAULT NULL,
  `cash_reduce_price` decimal(10,0) DEFAULT NULL,
  `bonus_point_reduce_price` decimal(10,0) DEFAULT NULL,
  `is_free_account_level` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
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
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------

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
INSERT INTO `picture` VALUES ('1', '1', 'http://122.9.35.24/moblie/static/images/product/zm.jpg', '120', '120', '1', '首页商品图片', '2016-06-29 10:10:09', '2016-06-29 10:10:12', 'NORMAL');
INSERT INTO `picture` VALUES ('2', '2', 'http://122.9.35.24/moblie/static/images/product/hj.jpg', '120', '120', '1', '首页商品图片', '2016-06-29 16:40:31', '2016-06-29 16:40:33', 'NORMAL');
INSERT INTO `picture` VALUES ('3', '3', 'http://122.9.35.24/moblie/static/images/product/tb.jpg', '120', '120', '1', '首页商品图片', '2016-06-29 16:46:38', '2016-06-29 16:46:40', 'NORMAL');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `market_price` decimal(10,1) DEFAULT NULL,
  `sale_price` decimal(10,1) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `key_words` varchar(255) DEFAULT NULL,
  `product_type_id` varchar(255) DEFAULT NULL,
  `is_alive` tinyint(4) DEFAULT NULL,
  `is_index` tinyint(4) DEFAULT NULL,
  `modify_admin_id` varchar(255) DEFAULT NULL,
  `units_in_stock` int(11) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
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
INSERT INTO `product` VALUES ('1', '大馍', '0.5', '0.5', '001', '馍', '1', '1', '1', '1', '99999', '推荐', '0.5/个', '好吃的', '2016-06-29 10:11:16', '2016-06-29 10:11:19', 'NORMAL');
INSERT INTO `product` VALUES ('2', '花卷', '0.5', '0.5', '002', '卷子', '1', '1', '1', '1', '99999', '推荐', '0.5/个', '好吃的', '2016-06-29 16:38:03', '2016-06-29 16:38:05', 'NORMAL');
INSERT INTO `product` VALUES ('3', '糖包', '0.6', '0.6', '003', '糖包', '1', '1', '1', '1', '99999', '推荐', '0.5/个', '好吃的', '2016-06-29 16:38:57', '2016-06-29 16:38:59', 'NORMAL');

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
INSERT INTO `product_type` VALUES ('1', '主营食品', null, '2016-06-29 10:11:40', '2016-06-29 10:11:42', 'NORMAL');

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
