/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : fwx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-09 16:23:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `id` char(32) NOT NULL,
  `sex` char(4) NOT NULL,
  `style` char(10) NOT NULL,
  `size` char(10) NOT NULL,
  `price` int(10) NOT NULL,
  `usename` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('4c4e64827b1e4ffb9e8f0b13531a57f9', '女', '婚纱005', 'XXL', '1704', null);
INSERT INTO `clothes` VALUES ('8a9bcbfebd6a4f84a4ab50f5d6f752ea', '女', '婚纱005', 'XXL', '1704', null);
INSERT INTO `clothes` VALUES ('906b785c678243b999fc34a678859897', '女', '婚纱003', 'L', '1702', null);
INSERT INTO `clothes` VALUES ('93b0541b9384462d955c39edd102a7ad', '女', '婚纱006', 'XS', '1705', null);
INSERT INTO `clothes` VALUES ('a653058f0b394c26adbbe16c244c91de', '女', '婚纱001', 'S', '1700', null);
INSERT INTO `clothes` VALUES ('c71454a3eced48beae20f61a324f3690', '女', '婚纱002', 'M', '1701', null);
INSERT INTO `clothes` VALUES ('caec27e953e749e3aa881a6e9a81f431', '女', '婚纱004', 'XL', '1703', null);
INSERT INTO `clothes` VALUES ('d284265f936b4a7db6cd5c66caaadc98', '女', '婚纱002', 'M', '1701', null);
INSERT INTO `clothes` VALUES ('e0ca3fc48c234111bf7e4f6213684100', '女', '婚纱004', 'XL', '1703', null);
INSERT INTO `clothes` VALUES ('e7e860ff15a54be5a6d3dec9349e9993', '女', '婚纱003', 'L', '1702', null);
INSERT INTO `clothes` VALUES ('e9cbd2937875456a8047f9d5202fdfd2', '女', '婚纱006', 'XS', '1705', null);
INSERT INTO `clothes` VALUES ('fb99e117de264dd889dda3ed81bbb2d5', '女', '婚纱001', 'S', '1700', null);
