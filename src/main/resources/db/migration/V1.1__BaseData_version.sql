insert t_user values (1,'admin','admin');
insert t_role values (1,'admin_role');
insert t_resources values (1,'res_admin','/user/*','post');
insert t_user_role values (1,1);
insert t_role_resources values (1,1);