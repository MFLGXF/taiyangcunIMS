/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : fwx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-09 16:23:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` char(32) NOT NULL,
  `device_name` char(32) NOT NULL,
  `device_no` char(32) NOT NULL,
  `device_status` char(10) NOT NULL,
  `device_price` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('09bbcf90af8b48f6a4ded9b54e1da38c', '单反相机', 'DF-001', '维修中', '5200');
