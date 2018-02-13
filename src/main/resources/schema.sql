create table Human
(
   id bigint auto_increment not null,
   name varchar(255) not null,
   CREATED_BY TIMESTAMP not null,
   primary key(id)
);