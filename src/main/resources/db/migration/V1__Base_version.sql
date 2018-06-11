
DROP Table IF EXISTS t_user;
CREATE Table `t_user`(
  `id` bigint(20) Not NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL UNIQUE COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS t_role;
CREATE TABLE `t_role`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar (225) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS t_resources;
CREATE TABLE  `t_resources`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar (225) NOT NULL COMMENT '资源名',
  `res_url` varchar (225) NOT NULL COMMENT '资源url',
  `method` varchar (20) NOT NULL DEFAULT '*' COMMENT '请求方法',
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS t_user_role;
CREATE TABLE  `t_user_role`(
  `user_id` bigint(20) NOT NULL COMMENT '用户表主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色表主键'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS t_role_resources;
CREATE TABLE  `t_role_resources`(
  `role_id` bigint(20) NOT NULL COMMENT '角色表主键',
  `resources_id` bigint(20) NOT NULL COMMENT '资源表主键'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE t_user_role ADD CONSTRAINT fk_user_role_user
  FOREIGN KEY(`user_id`) REFERENCES t_user(`id`);

ALTER TABLE t_user_role ADD CONSTRAINT fk_user_role_role
  FOREIGN KEY(`role_id`) REFERENCES t_role(`id`);

ALTER TABLE t_role_resources ADD CONSTRAINT fk_role_resources_role
  FOREIGN KEY(`role_id`) REFERENCES t_role(`id`);

ALTER TABLE t_role_resources ADD CONSTRAINT fk_role_resources_resources
  FOREIGN KEY(`resources_id`) REFERENCES t_resources(`id`);

