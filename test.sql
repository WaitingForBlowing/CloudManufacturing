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

 Date: 16/07/2020 17:42:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `aid` int(11) NOT NULL,
  `account` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `etId` int(11) NULL DEFAULT NULL,
  `oid` int(11) NULL DEFAULT NULL,
  `fid` int(11) NULL DEFAULT NULL,
  `equipmentId` int(11) NOT NULL,
  `equipmentSpecification` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `equipmentStatus` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rentalStatus` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`equipmentId`) USING BTREE,
  INDEX `equiment_type`(`etId`) USING BTREE,
  INDEX `equipment_order_key`(`oid`) USING BTREE,
  INDEX `equipment_factory_key`(`fid`) USING BTREE,
  CONSTRAINT `equipment_equipmentType_key` FOREIGN KEY (`etId`) REFERENCES `equipment_type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `equipment_factory_key` FOREIGN KEY (`fid`) REFERENCES `factory` (`factoryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `equipment_order_key` FOREIGN KEY (`oid`) REFERENCES `order` (`orderId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type`  (
  `typeId` int(11) NOT NULL,
  `typeName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
  INDEX `factory_maneger_key`(`uid`) USING BTREE,
  CONSTRAINT `factory_maneger_key` FOREIGN KEY (`uid`) REFERENCES `manager` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderId` int(11) NOT NULL,
  `pId` int(11) NOT NULL,
  `productAmount` int(11) NOT NULL,
  `acomplishDeadline` datetime(0) NOT NULL,
  `tenderDeadline` datetime(0) NOT NULL,
  `consigneeId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `order_product_key`(`pId`) USING BTREE,
  INDEX `consignee_order_key`(`consigneeId`) USING BTREE,
  CONSTRAINT `order_consignee_key` FOREIGN KEY (`consigneeId`) REFERENCES `consignee` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_product_key` FOREIGN KEY (`pId`) REFERENCES `product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productId` int(11) NOT NULL,
  `ptId` int(11) NULL DEFAULT NULL,
  `productName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `productInfo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productSpecification` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`productId`) USING BTREE,
  INDEX `product_type`(`ptId`) USING BTREE,
  CONSTRAINT `product_productType_key` FOREIGN KEY (`ptId`) REFERENCES `product_type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
  `typeId` int(11) NOT NULL,
  `typeName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
