/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : zy

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-13 22:49:32
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
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('4', '工艺品');
INSERT INTO `category` VALUES ('5', '食品类型');
INSERT INTO `category` VALUES ('6', '建材用品');

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
  `qrcode` varchar(255) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('0ee98af303604a9c8dff50a1a914554d', '卫龙辣条', '食品类型', '4638d284-4df0-498f-a4c2-087328e741c6微信截图_20180504221950.png', '湖南', 'opzoon', '0', '0.5', '2018-05-13', 'qr3650cdf4-395a-4f4c-b9be-e2746af1ed27.jpg', '卫龙辣条好吃不贵');
INSERT INTO `goods` VALUES ('a9645d1d71b845da85f8eef6c7aedf55', '象牙大象', '工艺品', 'b6fe85fb-715a-4961-af43-85f569b2e446微信截图_20180504235246.png', '缅甸', 'opzoon', '0', '56666', '2018-05-13', 'qr20d12684-9ee2-4e1d-a107-5b0141a4f963.jpg', '假的');
INSERT INTO `goods` VALUES ('c30978c0bf634662ba0b68cf922e7bb1', '丹东草莓', '食品类型', 'eb52bfcb-cbfd-4c59-aa7b-c7af2e229c55微信截图_20180504235656.png', '丹东', 'opzoon', '0', '22', '2018-05-13', 'qr2e585429-e5c0-45af-8afa-44ff60a99890.jpg', '超级甜');
INSERT INTO `goods` VALUES ('cfd8116461624b82bf9654d943f04936', '紫金香炉', '工艺品', 'f1f54d54-366e-4808-960c-62ec4a2070bb微信截图_20180504235723.png', '义乌', 'opzoon', '0', '66', '2018-05-13', 'qra5129ff4-3cf0-4383-b45e-debff7c08ddf.jpg', '义乌出品必属精品');

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
