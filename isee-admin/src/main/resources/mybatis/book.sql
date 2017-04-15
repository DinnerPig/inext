/*
Navicat MySQL Data Transfer

Source Server         : local-db
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : isee

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-15 16:13:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(125) NOT NULL,
  `description` varchar(512) NOT NULL,
  `put_time` datetime NOT NULL,
  `author` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'JavaEE', ' spring-boot + mysql', '2017-03-30 21:24:47', 'zhiliao');
INSERT INTO `book` VALUES ('2', 'mq', 'spring-boot + mysql + mq', '2017-03-30 21:27:26', 'zhiliao');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(255) NOT NULL,
  `product_type` varchar(255) NOT NULL,
  `observer` varchar(255) DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) NOT NULL,
  `level_type` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', 'V1', '视频', '1000', '视频V1等级');
INSERT INTO `level` VALUES ('2', 'V2', '图片', '2000', '图片V2等级');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `terminal_no` varchar(255) DEFAULT NULL,
  `level` varchar(255) NOT NULL,
  `level_type` varchar(255) NOT NULL,
  `level_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '11C1B04A', 'V1', '视频', '视频V1等级');
INSERT INTO `member` VALUES ('2', '11C1B04A', 'V1', '小说', '小说V1等级');

-- ----------------------------
-- Table structure for novels_product
-- ----------------------------
DROP TABLE IF EXISTS `novels_product`;
CREATE TABLE `novels_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `level` varchar(255) NOT NULL,
  `try_chapter` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of novels_product
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `terminal_no` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) NOT NULL,
  `product_type` varchar(255) NOT NULL,
  `product_desc` varchar(255) DEFAULT NULL,
  `origin_amount` varchar(255) NOT NULL,
  `actual_income` varchar(255) NOT NULL,
  `channel_fee` varchar(255) NOT NULL,
  `channel_rate` double NOT NULL,
  `create_time` datetime NOT NULL,
  `pay_time` datetime DEFAULT NULL,
  `pay_status` varchar(255) DEFAULT NULL,
  `pay_status_desc` varchar(255) DEFAULT NULL,
  `pay_version` varchar(255) DEFAULT NULL,
  `sdk_version` varchar(255) DEFAULT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for owners
-- ----------------------------
DROP TABLE IF EXISTS `owners`;
CREATE TABLE `owners` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of owners
-- ----------------------------
INSERT INTO `owners` VALUES ('1', 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO `owners` VALUES ('2', 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO `owners` VALUES ('3', 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO `owners` VALUES ('4', 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT INTO `owners` VALUES ('5', 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT INTO `owners` VALUES ('6', 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT INTO `owners` VALUES ('7', 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT INTO `owners` VALUES ('8', 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT INTO `owners` VALUES ('9', 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT INTO `owners` VALUES ('10', 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

-- ----------------------------
-- Table structure for pets
-- ----------------------------
DROP TABLE IF EXISTS `pets`;
CREATE TABLE `pets` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `type_id` int(4) unsigned NOT NULL,
  `owner_id` int(4) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `owner_id` (`owner_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `pets_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `owners` (`id`),
  CONSTRAINT `pets_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pets
-- ----------------------------
INSERT INTO `pets` VALUES ('1', 'Leo', '2000-09-07', '1', '1');
INSERT INTO `pets` VALUES ('2', 'Basil', '2002-08-06', '6', '2');
INSERT INTO `pets` VALUES ('3', 'Rosy', '2001-04-17', '2', '3');
INSERT INTO `pets` VALUES ('4', 'Jewel', '2000-03-07', '2', '3');
INSERT INTO `pets` VALUES ('5', 'Iggy', '2000-11-30', '3', '4');
INSERT INTO `pets` VALUES ('6', 'George', '2000-01-20', '4', '5');
INSERT INTO `pets` VALUES ('7', 'Samantha', '1995-09-04', '1', '6');
INSERT INTO `pets` VALUES ('8', 'Max', '1995-09-04', '1', '6');
INSERT INTO `pets` VALUES ('9', 'Lucky', '1999-08-06', '5', '7');
INSERT INTO `pets` VALUES ('10', 'Mulligan', '1997-02-24', '2', '8');
INSERT INTO `pets` VALUES ('11', 'Freddy', '2000-03-09', '5', '9');
INSERT INTO `pets` VALUES ('12', 'Lucky', '2000-06-24', '2', '10');
INSERT INTO `pets` VALUES ('13', 'Sly', '2002-06-08', '1', '10');

-- ----------------------------
-- Table structure for picture_product
-- ----------------------------
DROP TABLE IF EXISTS `picture_product`;
CREATE TABLE `picture_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `snapshot_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture_product
-- ----------------------------

-- ----------------------------
-- Table structure for specialties
-- ----------------------------
DROP TABLE IF EXISTS `specialties`;
CREATE TABLE `specialties` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialties
-- ----------------------------
INSERT INTO `specialties` VALUES ('3', 'dentistry');
INSERT INTO `specialties` VALUES ('1', 'radiology');
INSERT INTO `specialties` VALUES ('2', 'surgery');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) NOT NULL,
  `sys_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '3', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$SSjv4WZiPLLjBrNetMaFi.HGFhKJBHdRDuvkoBSUtO5wkZ1uXEPMu', '2017-04-15 15:45:10');
INSERT INTO `sys_user` VALUES ('2', 'abel', 'abel', '2017-04-15 15:45:10');
INSERT INTO `sys_user` VALUES ('3', 'dinner', '$2a$10$nK6PgQ.dgbTOTjbtAL9fF.yq7IoOALAtz15/uHCgw2cXhyM1HCwyG', '2017-04-15 15:45:10');
INSERT INTO `sys_user` VALUES ('4', 'zhi', '$2a$10$/isp1lWTwEpeAaJ.u.Z7geIQAkDV4VNAu7D1XA.v96TNk.yJc5TV.', '2017-04-15 15:46:06');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('5', 'bird');
INSERT INTO `types` VALUES ('1', 'cat');
INSERT INTO `types` VALUES ('2', 'dog');
INSERT INTO `types` VALUES ('6', 'hamster');
INSERT INTO `types` VALUES ('3', 'lizard');
INSERT INTO `types` VALUES ('4', 'snake');

-- ----------------------------
-- Table structure for version
-- ----------------------------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_version` varchar(255) NOT NULL,
  `pay_version` varchar(255) NOT NULL,
  `update_type` varchar(255) NOT NULL,
  `update_url` varchar(255) NOT NULL,
  `is_switch` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of version
-- ----------------------------

-- ----------------------------
-- Table structure for vets
-- ----------------------------
DROP TABLE IF EXISTS `vets`;
CREATE TABLE `vets` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vets
-- ----------------------------
INSERT INTO `vets` VALUES ('1', 'James', 'Carter');
INSERT INTO `vets` VALUES ('2', 'Helen', 'Leary');
INSERT INTO `vets` VALUES ('3', 'Linda', 'Douglas');
INSERT INTO `vets` VALUES ('4', 'Rafael', 'Ortega');
INSERT INTO `vets` VALUES ('5', 'Henry', 'Stevens');
INSERT INTO `vets` VALUES ('6', 'Sharon', 'Jenkins');

-- ----------------------------
-- Table structure for vet_specialties
-- ----------------------------
DROP TABLE IF EXISTS `vet_specialties`;
CREATE TABLE `vet_specialties` (
  `vet_id` int(4) unsigned NOT NULL,
  `specialty_id` int(4) unsigned NOT NULL,
  UNIQUE KEY `vet_id` (`vet_id`,`specialty_id`),
  KEY `specialty_id` (`specialty_id`),
  CONSTRAINT `vet_specialties_ibfk_1` FOREIGN KEY (`vet_id`) REFERENCES `vets` (`id`),
  CONSTRAINT `vet_specialties_ibfk_2` FOREIGN KEY (`specialty_id`) REFERENCES `specialties` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vet_specialties
-- ----------------------------
INSERT INTO `vet_specialties` VALUES ('2', '1');
INSERT INTO `vet_specialties` VALUES ('5', '1');
INSERT INTO `vet_specialties` VALUES ('3', '2');
INSERT INTO `vet_specialties` VALUES ('4', '2');
INSERT INTO `vet_specialties` VALUES ('3', '3');

-- ----------------------------
-- Table structure for video_product
-- ----------------------------
DROP TABLE IF EXISTS `video_product`;
CREATE TABLE `video_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(255) NOT NULL,
  `title` varchar(1000) NOT NULL,
  `url` varchar(1000) NOT NULL,
  `snapshot_url` varchar(1000) DEFAULT NULL,
  `default_play_time` int(11) NOT NULL,
  `is_second_open` char(1) DEFAULT NULL,
  `Create_Time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` varchar(1) NOT NULL,
  `picture_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_product
-- ----------------------------
INSERT INTO `video_product` VALUES ('1', '427357f0ac7448ab8fe132f5197041fc', '视频-demo', 'http://v.pptv.com/show/CT4XlPxia0hBz8f0.html?vfm=bdvppzq&frp=v.baidu.com%2Ftv_intro%2F&bl=jp_video', 'http://v.pptv.com/show/CT4XlPxia0hBz8f0.html?vfm=bdvppzq&frp=v.baidu.com%2Ftv_intro%2F&bl=jp_video', '5000', '1', '2017-04-10 20:19:46', '1', null);
INSERT INTO `video_product` VALUES ('2', '4c95bc1c82d1447082aa413ca55d195c', '001', 'D://test//video//4c95bc1c82d1447082aa413ca55d195c.png', '', '5000', '1', '2017-04-11 11:40:31', '0', null);
INSERT INTO `video_product` VALUES ('3', 'a4cb0a099f644c46ad98f2e4a76915a7', '001', 'D://test//video//a4cb0a099f644c46ad98f2e4a76915a7', '', '5000', '1', '2017-04-12 19:37:15', '1', null);
INSERT INTO `video_product` VALUES ('4', '065ca9c8c94a4bf292c3462dbe00ed88', '103', 'D://test//video//065ca9c8c94a4bf292c3462dbe00ed88', '', '5000', '1', '2017-04-12 19:43:40', '1', null);

-- ----------------------------
-- Table structure for visits
-- ----------------------------
DROP TABLE IF EXISTS `visits`;
CREATE TABLE `visits` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `pet_id` int(4) unsigned NOT NULL,
  `visit_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pet_id` (`pet_id`),
  CONSTRAINT `visits_ibfk_1` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visits
-- ----------------------------
INSERT INTO `visits` VALUES ('1', '7', '2010-03-04', 'rabies shot');
INSERT INTO `visits` VALUES ('2', '8', '2011-03-04', 'rabies shot');
INSERT INTO `visits` VALUES ('3', '8', '2009-06-04', 'neutered');
INSERT INTO `visits` VALUES ('4', '7', '2008-09-04', 'spayed');
