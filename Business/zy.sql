/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : zy

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-05 11:32:09
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
  `phone` varchar(255) NOT NULL,
  `email` char(64) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `role` char(10) NOT NULL,
  `username` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('a49e473b08644d3c9dff5c094b60f772', '123123', '陈锐', '13555439642', '1111111@qq.com', '07daa2f1-664e-4a85-8c92-ea73a364b48217-074627_998.jpg', 'User', '13555439642');
