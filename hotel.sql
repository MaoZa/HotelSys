/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-05-09 18:06:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dinner_table`
-- ----------------------------
DROP TABLE IF EXISTS `dinner_table`;
CREATE TABLE `dinner_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tablename` varchar(10) DEFAULT NULL,
  `tablestatus` int(1) DEFAULT '0',
  `presettime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dinner_table
-- ----------------------------
INSERT INTO `dinner_table` VALUES ('1', '纽约', '0', null);
INSERT INTO `dinner_table` VALUES ('2', '巴黎', '0', null);
INSERT INTO `dinner_table` VALUES ('3', '丹麦', '0', null);
INSERT INTO `dinner_table` VALUES ('4', '伦敦', '0', null);

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foodname` varchar(20) DEFAULT NULL,
  `price` double(5,1) DEFAULT NULL,
  `vipprice` double(5,1) DEFAULT NULL,
  `fooddesc` varchar(200) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `foodcategoryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foodcategoryid` (`foodcategoryid`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`foodcategoryid`) REFERENCES `food_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '白灼虾', '36.0', '25.0', '粤菜白灼虾，大件！', 'detail/style/images/baizhuoxia.jpg', '1');
INSERT INTO `food` VALUES ('2', '白切鸡', '68.0', '50.0', '白切鸡，味美！', 'detail/style/images/baiqieji.jpg', '1');
INSERT INTO `food` VALUES ('3', '烤乳猪', '680.0', '500.0', null, 'detail/style/images/kaoruzhu.JPG', '2');
INSERT INTO `food` VALUES ('4', '	烧鹅', '88.0', '68.0', null, 'detail/style/images/shaoe.jpg', '3');
INSERT INTO `food` VALUES ('5', '	猪肉荷兰豆', '28.0', '15.0', null, 'detail/style/images/helandou.jpg', '4');
INSERT INTO `food` VALUES ('6', '	黄埔炒蛋', '18.0', '12.0', null, 'detail/style/images/huangbuchaodan.jpg', '3');
INSERT INTO `food` VALUES ('7', '	狗肉煲', '78.0', '65.0', null, 'detail/style/images/guotourou.jpg', '4');
INSERT INTO `food` VALUES ('8', '鲫鱼汤', '35.0', '30.0', null, 'detail/style/images/baizhuoxia.jpg', '2');

-- ----------------------------
-- Table structure for `food_category`
-- ----------------------------
DROP TABLE IF EXISTS `food_category`;
CREATE TABLE `food_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food_category
-- ----------------------------
INSERT INTO `food_category` VALUES ('1', '粤菜');
INSERT INTO `food_category` VALUES ('2', '川菜');
INSERT INTO `food_category` VALUES ('3', '	湘菜');
INSERT INTO `food_category` VALUES ('4', '	东北菜');

-- ----------------------------
-- Table structure for `food_order`
-- ----------------------------
DROP TABLE IF EXISTS `food_order`;
CREATE TABLE `food_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordernumber` varchar(15) DEFAULT NULL,
  `ordercreatetime` datetime DEFAULT NULL,
  `totalprice` double(10,2) DEFAULT NULL,
  `orderstatus` int(1) DEFAULT '0',
  `dinnertableid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dinnertableid` (`dinnertableid`),
  CONSTRAINT `food_order_ibfk_1` FOREIGN KEY (`dinnertableid`) REFERENCES `dinner_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food_order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foodid` int(11) DEFAULT NULL,
  `foodorderid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foodid` (`foodid`),
  KEY `foodorderid` (`foodorderid`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`foodid`) REFERENCES `food` (`id`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`foodorderid`) REFERENCES `food_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
