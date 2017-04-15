/*
Navicat MySQL Data Transfer

Source Server         : local-db
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : svw

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-30 21:34:21
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'JavaEE', ' spring-boot + mysql', '2017-03-30 21:24:47', 'zhiliao');
INSERT INTO `book` VALUES ('2', 'mq', 'spring-boot + mysql + mq', '2017-03-30 21:27:26', 'zhiliao');
