/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : zy

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-05-13 20:30:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` char(32) NOT NULL,
  `username` char(64) NOT NULL,
  `password` char(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('09bbcf90af8b48f6a4ded9b54e1da38c', 'admin', 'admin');

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` char(32) NOT NULL,
  `bus_loginname` char(32) NOT NULL,
  `bus_password` char(64) NOT NULL,
  `bus_name` char(64) NOT NULL,
  `bus_img` varchar(255) NOT NULL,
  `bus_license` char(64) NOT NULL,
  `bus_address` char(100) NOT NULL,
  `is_check` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('4bfb4e88d6f34d6d9bd85858f78d1742', 'opzoon', '123123', '汉柏科技', '4957248c-6c73-48a0-afbd-1d56d56d93ae3aa9ab64034f78f0c01457067e310a55b2191ce8.jpg', '00000001', '天津', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userImg` varchar(255) DEFAULT NULL COMMENT '用户照片URL',
  `goods_id` varchar(255) DEFAULT NULL COMMENT '产品id',
  `reply_id` varchar(255) DEFAULT NULL COMMENT '留言人id',
  `reply_name` varchar(255) DEFAULT NULL COMMENT '留言人名称',
  `be_reply_id` varchar(255) DEFAULT NULL COMMENT '回复人id',
  `be_reply_name` varchar(255) DEFAULT NULL COMMENT '回复人名称',
  `browse` varchar(255) DEFAULT NULL COMMENT '浏览器名称',
  `osname` varchar(255) DEFAULT NULL COMMENT '操作系统名称',
  `content` varchar(255) DEFAULT NULL COMMENT '留言内容',
  `time` varchar(255) DEFAULT NULL COMMENT '留言时间',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `delete_flag` int(10) unsigned zerofill DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('6', 'assets/img/img.jpg', '0d792a04d1fc4d62852ab95466f20255', '0c37f2483c49416ca5e4f6ba2a3b7d89', '马福龙', null, null, 'Chrome', '操作系统：win10', 'hello', '2018-05-13 14:42:58', null, null);
INSERT INTO `comment` VALUES ('7', 'assets/img/img.jpg', '0d792a04d1fc4d62852ab95466f20255', 'c4823b18acc7481ab4464c80e3068403', '马福龙', null, null, 'Chrome', '操作系统：win10', '你在说什么', '2018-05-13 14:56:58', null, null);
INSERT INTO `comment` VALUES ('8', null, '0d792a04d1fc4d62852ab95466f20255', 'f1ff812294764eb5bd78872597c6687a', '陈锐1', '0c37f2483c49416ca5e4f6ba2a3b7d89', '马福龙', 'Chrome', '操作系统：win10', '你猜', '2018-05-13 14:59:17', null, null);
INSERT INTO `comment` VALUES ('9', 'assets/img/img.jpg', '59f21a0f7cea410e9d6e1a0b5b09c319', 'bed05033fd84464fbf6872181a9a03d1', '陈锐1', null, null, 'Chrome', '操作系统：win10', '你话真多', '2018-05-13 15:18:21', null, null);
INSERT INTO `comment` VALUES ('10', 'assets/img/img.jpg', '59f21a0f7cea410e9d6e1a0b5b09c319', 'a417746c3785462586e3eddf4fede255', '陈锐1', null, null, 'Chrome', '操作系统：win10', '都来评论几句吧', '2018-05-13 15:19:46', null, null);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` char(32) NOT NULL,
  `goods_name` char(64) NOT NULL,
  `goods_type` char(32) NOT NULL,
  `goods_img` varchar(255) NOT NULL,
  `goods_place` char(64) NOT NULL,
  `goods_producer` char(64) NOT NULL,
  `del_flag` char(10) NOT NULL,
  `goods_price` char(10) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('0d792a04d1fc4d62852ab95466f20255', '香炉', '工艺品', '3ce4ee16-8c04-4cdf-bb35-238e5f4e93a2微信截图_20180504235723.png', '武汉', 'opzoon', '0', '200', '2018-05-05');
INSERT INTO `goods` VALUES ('59f21a0f7cea410e9d6e1a0b5b09c319', '卫龙', '食品类型', 'b718ffed-ea9f-42d6-8632-ce6492fdff80微信截图_20180504221950.png', '湖南', 'opzoon', '0', '0.5', '2018-05-04');
INSERT INTO `goods` VALUES ('5cdbb9a6574345e8abaf0ec1ba025f4c', '草莓', '食品类型', 'e339611f-4d9a-4c1f-ad12-da561762c4b4微信截图_20180504235656.png', '丹东', 'opzoon', '0', '20', '2018-05-03');
INSERT INTO `goods` VALUES ('7d6d73a6f12f41e5a3915b6c044e5f8e', '资金壶', '工艺品', 'a08b3e2c-4d85-47f2-b49e-3db3ba38f865微信截图_20180504235723.png', '成都', 'opzoon', '0', '200', '2018-05-01');
INSERT INTO `goods` VALUES ('e381d8f2f28a40679183028b116a9e9b', '汉白玉大象', '工艺品', '716363d3-63ae-42e6-9c66-9f38c97789be微信截图_20180504235246.png', '缅甸', 'opzoon', '0', '100000', '2018-05-02');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` char(10) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` char(64) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `role` char(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('01a20518d3f948a48ff5b1429ca034b0', '123.com', '马福龙', null, '1912858362@qq.com', null, 'User', null);
INSERT INTO `user` VALUES ('76c7a6d5f64e4ba982051b74f6ae684a', '123', 'curry', null, '1912858362@qq.com', null, 'User', null);
INSERT INTO `user` VALUES ('a49e473b08644d3c9dff5c094b60f772', '123123', '陈锐1', '13555439642', '1111111@qq.com', '07daa2f1-664e-4a85-8c92-ea73a364b48217-074627_998.jpg', 'User', '13555439642');
