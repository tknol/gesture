## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE tnk_gesture_dev;
CREATE DATABASE tnk_gesture_prod;

#Create database service accounts
CREATE USER 'gesture_dev_user'@'192.168.1.100' IDENTIFIED BY 'password123';
CREATE USER 'gesture_dev_user'@'localhost' IDENTIFIED BY 'password123';
CREATE USER 'gesture_dev_user'@'%' IDENTIFIED BY 'password123';
CREATE USER 'tnk_gesture_prod_user'@'127.0.0.1' IDENTIFIED BY 'password123';
CREATE USER 'tnk_gesture_prod_user'@'%' IDENTIFIED BY 'password123';

#Database grants
GRANT SELECT ON tnk_gesture_dev.* to 'gesture_dev_user'@'localhost';
GRANT INSERT ON tnk_gesture_dev.* to 'gesture_dev_user'@'localhost';
GRANT DELETE ON tnk_gesture_dev.* to 'gesture_dev_user'@'localhost';
GRANT UPDATE ON tnk_gesture_dev.* to 'gesture_dev_user'@'localhost';
GRANT SELECT ON tnk_gesture_dev.* to 'gesture_dev_user'@'%';
GRANT INSERT ON tnk_gesture_dev.* to 'gesture_dev_user'@'%';
GRANT DELETE ON tnk_gesture_dev.* to 'gesture_dev_user'@'%';
GRANT UPDATE ON tnk_gesture_dev.* to 'gesture_dev_user'@'%';
GRANT SELECT ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'localhost';
GRANT INSERT ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'localhost';
GRANT DELETE ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'localhost';
GRANT UPDATE ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'localhost';
GRANT SELECT ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'%';
GRANT INSERT ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'%';
GRANT DELETE ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'%';
GRANT UPDATE ON tnk_gesture_prod.* to 'tnk_gesture_prod_user'@'%';
