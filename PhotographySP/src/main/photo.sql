/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : fwx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-04 17:39:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` char(32) NOT NULL,
  `photo_name` text NOT NULL,
  `photo_time` date NOT NULL,
  `photo_type` char(10) NOT NULL,
  `del_flag` char(2) NOT NULL,
  `photo_url` text NOT NULL,
  `user_name` char(32) NOT NULL,
  `create_name` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('02295e312c93428dacf37be57c346275', '婚庆-201804041648490074546fdc394c233eb013aacaf7b5e5f4a775b7d8e.jpg', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-201804041648490074546fdc394c233eb013aacaf7b5e5f4a775b7d8e.jpg', 'admin', '请问');
INSERT INTO `photo` VALUES ('06e13ad17d5f463794b096c32de1c789', '婚庆-2018040416484887133.jpg', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-2018040416484887133.jpg', 'admin', '请问');
INSERT INTO `photo` VALUES ('33fbdc7fadf54d6897ce363e0452ae41', '写真-201804041645375893aa9ab64034f78f0c01457067e310a55b2191ce8.jpg', '2018-04-04', '写真', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\写真-201804041645375893aa9ab64034f78f0c01457067e310a55b2191ce8.jpg', '陈锐', '冯文秀');
INSERT INTO `photo` VALUES ('507f6e40fc1c4477b8edbcaf3cc466c2', '婚庆-201804041648489793833ab18972bd407af88f2b078899e510eb309c2 (1).png', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-201804041648489793833ab18972bd407af88f2b078899e510eb309c2 (1).png', 'admin', '请问');
INSERT INTO `photo` VALUES ('517481a232934caea41bcc756f991c77', '其他-201804041650368695-13050GZ122.jpg', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368695-13050GZ122.jpg', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('5e8c4c60bfc746b5866f7dd5fded0fff', '风景-201804041648252105-13050GZ021.gif', '2018-04-04', '风景', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\风景-201804041648252105-13050GZ021.gif', '测试', '冯文秀');
INSERT INTO `photo` VALUES ('6986551ab7014bc588d5fae56acd0bc3', '其他-201804041650368785-1210311U119.gif', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368785-1210311U119.gif', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('b1c651d2141942eab4338c372bc6909a', '其他-201804041650368445-13050GZ017.jpg', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368445-13050GZ017.jpg', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('ba6fb910dd30480b8a74f1cd799c7274', '其他-201804041650369115-1502130QG7-51.jpg', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650369115-1502130QG7-51.jpg', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('d4cacf4679204dafb934a503f7759d78', '婚庆-20180404164848977561ec93d70cf3bc7724858a0d200baa1cc112acd.jpg', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-20180404164848977561ec93d70cf3bc7724858a0d200baa1cc112acd.jpg', 'admin', '请问');
INSERT INTO `photo` VALUES ('d56e7d6d947149bcbc73ada06333ba54', '风景-201804041648251475-13050GT046.jpg', '2018-04-04', '风景', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\风景-201804041648251475-13050GT046.jpg', '测试', '冯文秀');
INSERT INTO `photo` VALUES ('df9f92ad3da747c2a141dc2dc01e8e84', '婚庆-2018040416484894473b0d933c895d14311802d6f70f082025baf079b.jpg', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-2018040416484894473b0d933c895d14311802d6f70f082025baf079b.jpg', 'admin', '请问');
INSERT INTO `photo` VALUES ('e56fae6f3bd9486e96ea10f23654200d', '风景-201804041648252055-13050GZ017.jpg', '2018-04-04', '风景', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\风景-201804041648252055-13050GZ017.jpg', '测试', '冯文秀');
INSERT INTO `photo` VALUES ('f0d8534e710d49948f883d11c0661e2a', '其他-201804041650368155-13050GZ015-50.gif', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368155-13050GZ015-50.gif', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('fabb81e85d174be6b66c159ef4e642c5', '写真-20180404164537678004b.jpg', '2018-04-04', '写真', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\写真-20180404164537678004b.jpg', '陈锐', '冯文秀');
