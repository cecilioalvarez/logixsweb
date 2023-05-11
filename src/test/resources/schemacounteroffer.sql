DROP TABLE   IF EXISTS counteroffer;
create table counteroffer (
    objectId varchar(25) not null,
    name varchar(50) not null,
    vom varchar(50),
    originalPrice double not null,
    counterOfferPrice double not null,
    quantity double not null,
    primary key (objectId)
);