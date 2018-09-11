update image_tag set tag_id = 3 where tag_id = 14;
update image_tag set tag_id = 4 where tag_id = 15;
update image_tag set tag_id = 6 where tag_id = 16;
update image_tag set tag_id = 7 where tag_id = 17;

delete from tag where id not in (select it.tag_id from image_tag it);

delete from tag where user_id is null;
delete from image where user_id is null;
-- delete from user where id > 1;

select * from user;
select * from image;
select * from image_tag;
select * from tag;