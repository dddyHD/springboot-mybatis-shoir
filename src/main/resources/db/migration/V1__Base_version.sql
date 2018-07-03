
DROP Table IF EXISTS user;
CREATE Table `user`(
  `id` bigint(20) Not NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL UNIQUE COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS role;
CREATE TABLE `role`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar (225) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS permission;
CREATE TABLE  `permission`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar (225) NOT NULL COMMENT '资源名',
  `res_url` varchar (225) NOT NULL COMMENT '资源url',
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS user_role;
CREATE TABLE  `user_role`(
  `user_id` bigint(20) NOT NULL COMMENT '用户表主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色表主键'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS role_permission;
CREATE TABLE  `role_permission`(
  `role_id` bigint(20) NOT NULL COMMENT '角色表主键',
  `permission_id` bigint(20) NOT NULL COMMENT '权限主键'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_user
  FOREIGN KEY(`user_id`) REFERENCES user(`id`);

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_role
  FOREIGN KEY(`role_id`) REFERENCES role(`id`);

ALTER TABLE role_permission ADD CONSTRAINT fk_role_permission_role
  FOREIGN KEY(`role_id`) REFERENCES role(`id`);

ALTER TABLE role_permission ADD CONSTRAINT fk_role_permission_permission
  FOREIGN KEY(`permission_id`) REFERENCES permission(`id`);

