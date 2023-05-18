DROP TABLE IF EXISTS request;
create table request(
    objectId varchar(255),
    code varchar(50),
    offerId varchar(255),
    ownerId varchar(255),
    companyId varchar(255),
    isAccepted BOOLEAN,
    privateCompanyIds varchar(255),
    category varchar(50),
    scientificName varchar(50),
    name varchar(50),
    originalCountryIso varchar(50),
    description varchar(50),
    productionMethod varchar(50),
    glazing integer,
    currency varchar(50),
    createdAt date,
    updatedAt date
);