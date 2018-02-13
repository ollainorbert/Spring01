create table Human
(
   id bigint auto_increment not null,
   name varchar(255) not null,
   CREATED_BY TIMESTAMP default CURRENT_TIMESTAMP(),
   primary key(id)
);