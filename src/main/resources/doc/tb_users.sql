
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `status` char(1) DEFAULT NULL COMMENT '状态:1-启用 0-禁用',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;






BEGIN;
INSERT INTO `tb_users` VALUES (1, '张三', '123', '0', '2018-07-30 13:19:35');
INSERT INTO `tb_users` VALUES (2, '王勇', '111', '1', '2018-07-30 13:20:24');
INSERT INTO `tb_users` VALUES (3, '赵亮', '1212', '1', '2018-07-30 12:36:13');
COMMIT;

