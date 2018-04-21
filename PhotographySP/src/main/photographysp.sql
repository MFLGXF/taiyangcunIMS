/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : photographysp

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-04-21 23:31:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `balance_and_payment`
-- ----------------------------
DROP TABLE IF EXISTS `balance_and_payment`;
CREATE TABLE `balance_and_payment` (
  `id` varchar(32) NOT NULL,
  `bp_name` varchar(200) NOT NULL DEFAULT '收支名称',
  `bp_type` varchar(200) NOT NULL COMMENT '收支类型',
  `bp_time` datetime NOT NULL,
  `bp_count` int(11) DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of balance_and_payment
-- ----------------------------
INSERT INTO `balance_and_payment` VALUES ('197e1a8058374017a9f897dc418fa938', '桌椅', '支出', '2018-04-21 00:00:00', '100', null);
INSERT INTO `balance_and_payment` VALUES ('e46df0fdadd94e6c8cc5a8b29fb9fd96', '对方过后', '支出', '2018-04-20 00:00:00', '800', null);

-- ----------------------------
-- Table structure for `clothes`
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

-- ----------------------------
-- Table structure for `customer`
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

-- ----------------------------
-- Table structure for `device`
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

-- ----------------------------
-- Table structure for `economy`
-- ----------------------------
DROP TABLE IF EXISTS `economy`;
CREATE TABLE `economy` (
  `id` varchar(32) NOT NULL,
  `e_name` varchar(200) NOT NULL,
  `e_photographyer` int(11) DEFAULT NULL COMMENT '摄影师数量',
  `e_modelling` int(11) DEFAULT NULL COMMENT '是否需要化妆or造型',
  `e_location` varchar(200) DEFAULT NULL COMMENT '内景或者外景',
  `e_discription` text COMMENT '套系描述',
  `product_ids` text COMMENT '关联的产品的id串',
  `delete_flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of economy
-- ----------------------------
INSERT INTO `economy` VALUES ('a1429156f3f14005a6aabbe9cfbeb2bf', '天使的肩膀', '1', '1', '外景', '在巴黎进行拍摄', '相框2,相框3,相框5,相框9,相框11', '0');
INSERT INTO `economy` VALUES ('d414b72e842e4a96bf117c7d44e0309c', '马福海', '1', '1', '外景', '马大头', null, '0');
INSERT INTO `economy` VALUES ('f9452fe926ed4b9abdc79ff56511087a', '你是谁', '2', '1', '普通布景', '我是你爹', null, '0');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(32) NOT NULL,
  `discount_id` varchar(32) NOT NULL,
  `card_number` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `member_level` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `card_money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('136ffa0685ad4ec0955e07d1fe64ba7a', '53d828b9cd414cae8a27f463a1949194', '630121199301265316', '张三', '1', '26', '银卡', '15222525617', null);

-- ----------------------------
-- Table structure for `member_discount`
-- ----------------------------
DROP TABLE IF EXISTS `member_discount`;
CREATE TABLE `member_discount` (
  `id` varchar(32) NOT NULL,
  `card_type_name` varchar(200) DEFAULT NULL COMMENT '会员类型名称',
  `discount` int(11) DEFAULT NULL COMMENT '优惠折扣',
  `discription` text COMMENT '优惠方案',
  `level` int(11) DEFAULT NULL COMMENT '会员等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_discount
-- ----------------------------
INSERT INTO `member_discount` VALUES ('53d828b9cd414cae8a27f463a1949194', '银卡', '9', '价格按照九折计算', '1');

-- ----------------------------
-- Table structure for `performance`
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
  `id` varchar(32) NOT NULL,
  `worker_id` varchar(32) NOT NULL COMMENT '员工id',
  `worker_name` varchar(200) DEFAULT NULL,
  `p_rating_num` int(11) NOT NULL COMMENT '绩效评分',
  `p_content` text COMMENT '绩效内容',
  `p_time` datetime DEFAULT NULL COMMENT '绩效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of performance
-- ----------------------------
INSERT INTO `performance` VALUES ('444966688fb1420ca19083c46de8d3d3', '2', '冯文秀', '99', '售出物品', '2018-04-24 00:00:00');

-- ----------------------------
-- Table structure for `photo`
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
INSERT INTO `photo` VALUES ('0744b19362744334bc1492355e30da5e', '写真-201804212157471291 (2).jpg', '2018-04-21', '写真', '0', 'F:\\temp\\project2\\taiyangcunIMS\\PhotographySP\\src\\main\\webapp\\upload\\写真-201804212157471291 (2).jpg', '麻烦了', '你好');
INSERT INTO `photo` VALUES ('33fbdc7fadf54d6897ce363e0452ae41', '写真-201804041645375893aa9ab64034f78f0c01457067e310a55b2191ce8.jpg', '2018-04-04', '写真', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\写真-201804041645375893aa9ab64034f78f0c01457067e310a55b2191ce8.jpg', '陈锐', '冯文秀');
INSERT INTO `photo` VALUES ('507f6e40fc1c4477b8edbcaf3cc466c2', '婚庆-201804041648489793833ab18972bd407af88f2b078899e510eb309c2 (1).png', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-201804041648489793833ab18972bd407af88f2b078899e510eb309c2 (1).png', 'admin', '请问');
INSERT INTO `photo` VALUES ('517481a232934caea41bcc756f991c77', '其他-201804041650368695-13050GZ122.jpg', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368695-13050GZ122.jpg', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('5e8c4c60bfc746b5866f7dd5fded0fff', '风景-201804041648252105-13050GZ021.gif', '2018-04-04', '风景', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\风景-201804041648252105-13050GZ021.gif', '测试', '冯文秀');
INSERT INTO `photo` VALUES ('6986551ab7014bc588d5fae56acd0bc3', '其他-201804041650368785-1210311U119.gif', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368785-1210311U119.gif', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('76a737b49e0545e5a5dc72d3415a9702', '写真-201804212158013551 (5).png', '2018-04-21', '写真', '0', 'F:\\temp\\project2\\taiyangcunIMS\\PhotographySP\\src\\main\\webapp\\upload\\写真-201804212158013551 (5).png', '麻烦了', '你好');
INSERT INTO `photo` VALUES ('b1c651d2141942eab4338c372bc6909a', '其他-201804041650368445-13050GZ017.jpg', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368445-13050GZ017.jpg', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('ba6fb910dd30480b8a74f1cd799c7274', '其他-201804041650369115-1502130QG7-51.jpg', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650369115-1502130QG7-51.jpg', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('d4cacf4679204dafb934a503f7759d78', '婚庆-20180404164848977561ec93d70cf3bc7724858a0d200baa1cc112acd.jpg', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-20180404164848977561ec93d70cf3bc7724858a0d200baa1cc112acd.jpg', 'admin', '请问');
INSERT INTO `photo` VALUES ('d56e7d6d947149bcbc73ada06333ba54', '风景-201804041648251475-13050GT046.jpg', '2018-04-04', '风景', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\风景-201804041648251475-13050GT046.jpg', '测试', '冯文秀');
INSERT INTO `photo` VALUES ('df9f92ad3da747c2a141dc2dc01e8e84', '婚庆-2018040416484894473b0d933c895d14311802d6f70f082025baf079b.jpg', '2018-04-04', '婚庆', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\婚庆-2018040416484894473b0d933c895d14311802d6f70f082025baf079b.jpg', 'admin', '请问');
INSERT INTO `photo` VALUES ('e56fae6f3bd9486e96ea10f23654200d', '风景-201804041648252055-13050GZ017.jpg', '2018-04-04', '风景', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\风景-201804041648252055-13050GZ017.jpg', '测试', '冯文秀');
INSERT INTO `photo` VALUES ('f0d8534e710d49948f883d11c0661e2a', '其他-201804041650368155-13050GZ015-50.gif', '2018-04-04', '其他', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\其他-201804041650368155-13050GZ015-50.gif', '阿斯顿发', 'wer');
INSERT INTO `photo` VALUES ('f1f4aeceed9445319aeaf0282e6c3f6b', '写真-201804212158013511 (5).png', '2018-04-21', '写真', '0', 'F:\\temp\\project2\\taiyangcunIMS\\PhotographySP\\src\\main\\webapp\\upload\\写真-201804212158013511 (5).png', '麻烦了', '你好');
INSERT INTO `photo` VALUES ('fabb81e85d174be6b66c159ef4e642c5', '写真-20180404164537678004b.jpg', '2018-04-04', '写真', '0', 'G:\\ChenruiWork\\PhotographySP\\src\\main\\webapp\\upload\\写真-20180404164537678004b.jpg', '陈锐', '冯文秀');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(32) NOT NULL,
  `p_name` varchar(200) NOT NULL COMMENT '产品名称',
  `is_rent` int(11) DEFAULT NULL COMMENT '是否是出租的产品（0：用户自购，1：公司出租）',
  `p_price` int(11) NOT NULL COMMENT '产品价格',
  `p_category` varchar(200) NOT NULL COMMENT '产品类别',
  `discription` text COMMENT '产品描述',
  `delete_flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('43a810fabbcf4d35b41d023ec1c48fbf', '相框5', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('6fc818009cb048fca9618b39a783953d', '相框9', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('785c653bcc394e0ab152c6ccdf3f5c71', '相框11', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('ac044034bc6c4684be6b7862b279834b', '相框7', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('b401b9f3a60c473a9679648a70f7385d', '相框6', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('b525f3e044444777911c47cfc79201a8', '相框8', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('c1048ba2fb2e499d9d82c91dc0081a67', '金色相框', '1', '99', '光碟', null, '0');
INSERT INTO `product` VALUES ('e6a48d0b47754c1a9eb94958046ed6ee', '相框10', '0', '90', '光碟', null, '0');
INSERT INTO `product` VALUES ('fd1b601fad774180b72c26f73dc9fe24', '相框4', '0', '90', '光碟', null, '0');

-- ----------------------------
-- Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` varchar(32) NOT NULL,
  `pc_name` varchar(200) NOT NULL COMMENT '产品类型名称',
  `discription` text COMMENT '描述',
  `delete_flag` int(11) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('53c5d1a0f84e4db79da6f5755ed6e830', '光碟', '相片将会以幻灯片形式放进光碟中', '0');
INSERT INTO `product_category` VALUES ('8b7e82af102e4fecb170b349caf3e181', '相册', '相册相关的分类', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `password` varchar(200) NOT NULL COMMENT '用户密码',
  `username` varchar(100) NOT NULL COMMENT '用户姓名',
  `email` varchar(100) NOT NULL COMMENT '用户邮件',
  `phone` varchar(100) DEFAULT NULL COMMENT '用户电话',
  `imgurl` varchar(100) DEFAULT NULL COMMENT '用户头像存储的位置',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'e10adc3949ba59abbe56e057f20f883e', 'fengwenxiu', '1912858362@qq.com', '15222525617', null, '0');

-- ----------------------------
-- Table structure for `worker`
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('1', '冯文秀', '230881199412230116', '店长', '13555439642', '2018-04-08', '2555', '1', '1', null, '6228480402564890099', 'ddcc16af-d3d0-4315-95dc-a63cad38a87a3aa9ab64034f78f0c01457067e310a55b2191ce8.jpg');
INSERT INTO `worker` VALUES ('2', '冯文秀', '230881199412230116', '店长', '13555439642', '2018-04-08', '2555', '0', '1', null, '6228480402564890099', '446d5743-909a-4ae9-871e-98e7c2103cce3aa9ab64034f78f0c01457067e310a55b2191ce8.jpg');
INSERT INTO `worker` VALUES ('3', '谷大狗', '230881199412230116', '保洁', '13555439642', '2018-04-08', '1900', '1', '1', null, '6228480402564890099', 'b6b2e0d9-174e-4d27-aa40-ad8d0f534b583aa9ab64034f78f0c01457067e310a55b2191ce8.jpg');
INSERT INTO `worker` VALUES ('4', '谷大狗', '230881199412230116', '保洁', '13555439642', '2018-04-08', '1900', '1', '1', null, '6228480402564890099', '6cfd1265-00e2-4225-bf4c-efa7770cbecf3aa9ab64034f78f0c01457067e310a55b2191ce8.jpg');
INSERT INTO `worker` VALUES ('5', '谷大狗', '230881199412230116', '长春', '13555439642', '2018-04-08', '1900', '1', '1', null, '6228480402564890099', '9fa47dbb-27b5-4f57-822b-167d786f6d93004b.jpg');
INSERT INTO `worker` VALUES ('6', '谷大狗', '230881199412230116', '长春', '13555439642', '2018-04-08', '1900', '0', '1', null, '6228480402564890099', '5e1a25ed-66db-45c8-bd0a-457f57ec118317-074627_998.jpg');
INSERT INTO `worker` VALUES ('7', '陈锐', '230881199412230116', '摄影师', '13555439642', '2018-04-09', '1900', '0', '1', null, '6228480402564890018', '209fc782-7d79-484a-b239-e4d1abc9c555593672099351f.jpg');
