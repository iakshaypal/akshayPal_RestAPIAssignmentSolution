INSERT INTO users (user_id,password,username) VALUES ( 1,'$2a$12$BoCzI5nDb7TIt07VVIqUp.IHbaF6kaK3q29LJlV4I2gjcjg2prHty','admin');
INSERT INTO roles (role_id,role_name) VALUES ( 1, 'ADMIN' );

INSERT INTO users_roles (user_id,role_id) VALUES ( 1, 1);