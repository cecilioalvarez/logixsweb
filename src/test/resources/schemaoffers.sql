drop table if exists offer;
create table offer(
    objectId varchar(25) not null,
    code varchar(50) not null,
    name varchar(25),description varchar(50),
    category varchar(25),primary key (objectId)
);