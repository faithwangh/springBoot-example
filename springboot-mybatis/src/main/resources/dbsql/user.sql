
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `unique_name` char(16) NOT NULL,
  `gender` enum('male','femal') DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `is_active` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `remember_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name` (`unique_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '2019-08-23 15:13:38', '2019-08-23 15:33:45', '18856899711', 'male', '123456', 1, NULL);
INSERT INTO `user` VALUES (2, '2019-08-23 15:14:04', '2019-08-23 15:33:47', '18823455898', 'male', '8888888', 1, NULL);
INSERT INTO `user` VALUES (3, '2019-08-23 15:14:27', '2019-08-23 15:33:49', '13867793435', 'femal', '666666', 0, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
