/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : fwx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-09 16:23:45
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
