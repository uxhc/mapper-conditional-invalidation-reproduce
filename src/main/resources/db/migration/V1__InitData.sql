create table USER
(
    id   bigint primary key auto_increment,
    name varchar(100)
);

insert into USER(id, name)
values (1, 'zhangsan');
insert into USER(id, name)
values (2, 'lisi');
insert into USER(id, name)
values (3, 'wangwu');
