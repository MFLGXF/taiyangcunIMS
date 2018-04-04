/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : fwx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-04 17:39:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `worker_name` char(10) NOT NULL,
  `worker_idcard` varchar(255) NOT NULL,
  `worker_post` char(32) NOT NULL,
  `worker_phone` char(30) NOT NULL,
  `join_time` date NOT NULL,
  `wages` char(10) DEFAULT NULL,
  `del_flag` char(2) NOT NULL,
  `ava_flag` char(2) NOT NULL COMMENT '0 离职 1在职 2休假',
  `create_time` date DEFAULT NULL,
  `worker_bank_card` varchar(32) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
