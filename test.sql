/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : cloud_manufacturing

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/07/2020 15:48:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'superuser', 'superuser');

-- ----------------------------
-- Table structure for consignee
-- ----------------------------
DROP TABLE IF EXISTS `consignee`;
CREATE TABLE `consignee`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tel` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of consignee
-- ----------------------------
INSERT INTO `consignee` VALUES (1, 'testConsignee', 'testConsignee', '李铖良', '3332776039@qq.com', '经销商', '15071707098', '湖北省黄冈市');
INSERT INTO `consignee` VALUES (2, 'testConsignee2', 'testCOnsignee2', '李木子', 'sample@qq.com', '经销商', 'sampleTel', 'sample');
INSERT INTO `consignee` VALUES (3, 'testConsignee3', 'testConsignee3', '李莉', 'sample1@qq.com', '经销商', 'sampleTel2', 'sample');
INSERT INTO `consignee` VALUES (4, 'test3', 'test3', 'test3', 'test3', '经销商', 'test3', ' ');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `etId` int(11) NULL DEFAULT NULL,
  `oid` int(11) NULL DEFAULT NULL,
  `fid` int(11) NULL DEFAULT NULL,
  `equipmentId` int(11) NOT NULL AUTO_INCREMENT,
  `equipmentSpecification` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `equipmentStatus` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rentalStatus` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `equipmentName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`equipmentId`) USING BTREE,
  INDEX `equipment_type`(`etId`) USING BTREE,
  INDEX `equipment_order_key`(`oid`) USING BTREE,
  INDEX `equipment_factory_key`(`fid`) USING BTREE,
  CONSTRAINT `equipment_equipmentType_key` FOREIGN KEY (`etId`) REFERENCES `equipment_type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `equipment_factory_key` FOREIGN KEY (`fid`) REFERENCES `factory` (`factoryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `equipment_order_key` FOREIGN KEY (`oid`) REFERENCES `order` (`orderId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (1, NULL, 1, 1, '100t', '闲置', '工厂私有', '纺织机床');
INSERT INTO `equipment` VALUES (1, NULL, 1, 2, '300t', '闲置', '工厂私有', '铁器车床');
INSERT INTO `equipment` VALUES (2, NULL, 2, 3, '100人', '闲置', '工厂租借', '流水线员工');
INSERT INTO `equipment` VALUES (3, NULL, 2, 4, '300摄氏度', '闲置', '个人私有', '万能烤箱');
INSERT INTO `equipment` VALUES (4, NULL, 2, 5, '100瓶', '闲置', '个人私有', '可乐魔法池');

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type`  (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equipment_type
-- ----------------------------
INSERT INTO `equipment_type` VALUES (1, '机床');
INSERT INTO `equipment_type` VALUES (2, '流水线车床');
INSERT INTO `equipment_type` VALUES (3, '烤箱');
INSERT INTO `equipment_type` VALUES (4, '可乐魔法器');

-- ----------------------------
-- Table structure for factory
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory`  (
  `uid` int(11) NULL DEFAULT NULL,
  `factoryId` int(11) NOT NULL AUTO_INCREMENT,
  `factoryName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `factoryInfo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `factoryStatus` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`factoryId`) USING BTREE,
  INDEX `factory_manager_key`(`uid`) USING BTREE,
  CONSTRAINT `factory_manager_key` FOREIGN KEY (`uid`) REFERENCES `manager` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES (1, 1, 'myfactory', '系统自带的工厂', '正常');
INSERT INTO `factory` VALUES (2, 2, 'factory', '测试使用的工厂', '正常');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tel` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'myfactory', 'myfactory', 'cloud', '3332776039@qq.com', '工厂管理员', '15071707098');
INSERT INTO `manager` VALUES (2, 'test', 'test', 'test1', 'sample@qq.com', '工厂管理员', 'test');
INSERT INTO `manager` VALUES (3, 'test2', 'test2', 'test2', 'sample2@qq.com', '工厂管理员', 'test2');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) NOT NULL,
  `productAmount` int(11) NOT NULL,
  `accomplishDeadline` datetime(0) NOT NULL,
  `tenderDeadline` datetime(0) NOT NULL,
  `consigneeId` int(11) NOT NULL,
  `orderStatus` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `order_product_key`(`pId`) USING BTREE,
  INDEX `consignee_order_key`(`consigneeId`) USING BTREE,
  CONSTRAINT `order_consignee_key` FOREIGN KEY (`consigneeId`) REFERENCES `consignee` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_product_key` FOREIGN KEY (`pId`) REFERENCES `product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (4, 5, 100, '2020-07-23 00:00:00', '2020-07-29 00:00:00', 1, '已发布');

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `oid` int(11) NOT NULL,
  `managerId` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  INDEX `order_record_key`(`oid`) USING BTREE,
  INDEX `manager_record_key`(`managerId`) USING BTREE,
  CONSTRAINT `manager_record_key` FOREIGN KEY (`managerId`) REFERENCES `manager` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_record_key` FOREIGN KEY (`oid`) REFERENCES `order` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_record
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `ptId` int(11) NULL DEFAULT NULL,
  `productName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `productInfo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productSpecification` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`productId`) USING BTREE,
  INDEX `product_type`(`ptId`) USING BTREE,
  CONSTRAINT `product_productType_key` FOREIGN KEY (`ptId`) REFERENCES `product_type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (2, 2, '铁剑1', '武器，近战', '100kg');
INSERT INTO `product` VALUES (3, 2, '弩箭', '武器，远程', '100kg');
INSERT INTO `product` VALUES (4, 3, '蛋糕', '食物，生日，食品', '10kg');
INSERT INTO `product` VALUES (5, 4, '可乐', '食物，快乐，饮料，不健康', '5kg');
INSERT INTO `product` VALUES (6, 3, '炸鸡', '食物，快乐，不健康', '5kg');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES (1, '棉制品');
INSERT INTO `product_type` VALUES (2, '铁制品');
INSERT INTO `product_type` VALUES (3, '食品');
INSERT INTO `product_type` VALUES (4, '饮品');

SET FOREIGN_KEY_CHECKS = 1;
