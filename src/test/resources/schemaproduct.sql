DROP TABLE IF EXISTS product;
CREATE TABLE product (
    objectId varchar(255),
    userId varchar(25),
    code varchar(25),
    companyId varchar(25),
    scientificName varchar(50),
    name varchar(25),
    category varchar(25),
    originCountryIso varchar(25),
    quality varchar(25),
    descAndSpecs varchar(25),
    glazing decimal(5, 2),
    productionMethod varchar(25),
    packing varchar(25),
    description varchar(255),
    createdAt timestamp,
    updatedAt timestamp
);
