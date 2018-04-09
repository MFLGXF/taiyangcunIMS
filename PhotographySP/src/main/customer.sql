/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : fwx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-09 16:23:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` char(32) NOT NULL,
  `name` char(10) NOT NULL,
  `phone` tinytext NOT NULL,
  `is_vip` char(2) NOT NULL,
  `del_flag` char(2) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('377df5f59e824f0baac9e55678186dcc', '马福龙', '13555439642', '1', '0', '2018-04-08');
INSERT INTO `customer` VALUES ('9a228053f3494c0e863a2f2ac6f38676', '陈锐', '13555439642', '0', '0', '2018-04-08');
