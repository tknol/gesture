alter table user add email varchar(255);

create table schedule(id bigint not null auto_increment, name varchar(255), description varchar(255), user_id bigint, primary key (id)) engine=InnoDB;
create table schedule_item(id bigint not null auto_increment, schedule_id bigint not null, duration bigint, image_count bigint, primary key (id)) engine=InnoDB;
create table schedule_tag(tag_id bigint not null, schedule_id bigint not null) engine=InnoDB;

alter table schedule_tag add constraint schedule_tag_tag_id foreign key (tag_id) references tag (id);
alter table schedule_tag add constraint schedule_tag_schedule_id foreign key (schedule_id) references schedule (id);
