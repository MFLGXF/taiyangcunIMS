/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : zy

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-01 23:30:46
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
INSERT INTO `business` VALUES ('4bfb4e88d6f34d6d9bd85858f78d1742', 'opzoon', '123123', '汉柏科技', '4957248c-6c73-48a0-afbd-1d56d56d93ae3aa9ab64034f78f0c01457067e310a55b2191ce8.jpg', '00000001', '天津', '0');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

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
