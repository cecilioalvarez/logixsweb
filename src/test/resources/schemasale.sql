DROP TABLE   IF EXISTS sale;
create table sale (
    objectId varchar(25),
    ownerId varchar(50),
    clientId varchar(50),
    code varchar(50),
    offerId varchar(50),
    counterOfferId varchar(50),
    isCounterOffer boolean
);