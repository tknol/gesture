create table user (id bigint not null auto_increment, user_name varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table image(id bigint not null auto_increment, name varchar(255), path varchar(255), image_data longblob, user_id bigint, primary key (id)) engine=InnoDB;
create table tag(id bigint not null auto_increment, name varchar(255), description varchar(255), user_id bigint, primary key (id)) engine=InnoDB;
create table image_tag(tag_id bigint not null, image_id bigint not null) engine=InnoDB;
alter table image add constraint image_user_id foreign key (user_id) references user (id);
alter table tag add constraint tag_user_id foreign key (user_id) references user (id);
alter table image_tag add constraint image_tag_image_id foreign key (image_id) references image (id);
alter table image_tag add constraint iamge_tag_tag_id foreign key (tag_id) references tag (id);
