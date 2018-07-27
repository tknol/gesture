create table image (id bigint not null, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_id_sequence (next_val bigint) engine=InnoDB
insert into image_id_sequence values ( 1 )
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table tag_id_sequence (next_val bigint) engine=InnoDB
insert into tag_id_sequence values ( 1 )
create table user (id bigint not null, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
create table user_id_sequence (next_val bigint) engine=InnoDB
insert into user_id_sequence values ( 1 )
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table image (id bigint not null, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_id_sequence (next_val bigint) engine=InnoDB
insert into image_id_sequence values ( 1 )
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table tag_id_sequence (next_val bigint) engine=InnoDB
insert into tag_id_sequence values ( 1 )
create table user (id bigint not null, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
create table user_id_sequence (next_val bigint) engine=InnoDB
insert into user_id_sequence values ( 1 )
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table image (id bigint not null, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table image (id bigint not null auto_increment, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null auto_increment, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table image (id bigint not null auto_increment, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null auto_increment, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table image (id bigint not null auto_increment, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null auto_increment, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table image (id bigint not null auto_increment, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null auto_increment, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
create table image (id bigint not null auto_increment, image_data longblob, name varchar(255), path varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table image_tag (tag_id bigint not null, image_id bigint not null, primary key (tag_id, image_id)) engine=InnoDB
create table tag (id bigint not null auto_increment, description varchar(255), name varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), password varchar(255), user_name varchar(255), primary key (id)) engine=InnoDB
alter table image add constraint FKlxnnh0ir05khn8iu9tgwh1yyk foreign key (user_id) references user (id)
alter table image_tag add constraint FKgb0metxaw60hmykntems06t5n foreign key (image_id) references image (id)
alter table image_tag add constraint FK28yowgjl7oksr7dc0wj7f5il foreign key (tag_id) references tag (id)
alter table tag add constraint FKld85w5kr7ky5w4wda3nrdo0p8 foreign key (user_id) references user (id)
