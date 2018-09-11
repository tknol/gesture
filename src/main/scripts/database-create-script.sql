-- CREATE DATABASE `tnk_gesture` /*!40100 DEFAULT CHARACTER SET latin1 */;

create table user (id bigint not null auto_increment, user_name varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), email varchar(255), primary key (id)) engine=InnoDB;
create table image(id bigint not null auto_increment, name varchar(255), image_data longblob, user_id bigint, primary key (id)) engine=InnoDB;
create table tag(id bigint not null auto_increment, name varchar(255), user_id bigint, primary key (id)) engine=InnoDB;
create table image_tag(tag_id bigint not null, image_id bigint not null) engine=InnoDB;
create table schedule(id bigint not null auto_increment, name varchar(255), description varchar(255), user_id bigint, primary key (id)) engine=InnoDB;
create table schedule_item(id bigint not null auto_increment, schedule_id bigint not null, duration bigint, image_count bigint, primary key (id)) engine=InnoDB;
create table schedule_tag(tag_id bigint not null, schedule_id bigint not null) engine=InnoDB;
alter table image add constraint image_user_id foreign key (user_id) references user (id);
alter table tag add constraint tag_user_id foreign key (user_id) references user (id);
alter table image_tag add constraint image_tag_image_id foreign key (image_id) references image (id);
alter table image_tag add constraint iamge_tag_tag_id foreign key (tag_id) references tag (id);
alter table schedule_tag add constraint schedule_tag_tag_id foreign key (tag_id) references tag (id);
alter table schedule_tag add constraint schedule_tag_schedule_id foreign key (schedule_id) references schedule (id);
