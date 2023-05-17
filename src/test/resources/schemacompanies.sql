DROP TABLE   IF EXISTS company;
create table company(
            objectId varchar(25),
            code varchar(50),
            state varchar(50),
            licenseId varchar(50),
            limitUsers integer,
            name varchar(50),
            address varchar(50),
            phone varchar(15),
            countryIso varchar(10),
            taxId varchar(50),
            url varchar(50),
            createdAt date,
            updatedAt date);

