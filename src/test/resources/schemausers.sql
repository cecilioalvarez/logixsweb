DROP TABLE IF EXISTS user;
CREATE TABLE user (
  objectId varchar(255) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  lastName varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  avatar varchar(50) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  prevPasswords varchar(50) DEFAULT NULL,
  companyId varchar(50) DEFAULT NULL,
  invitedBy varchar(50) DEFAULT NULL,
  role varchar(50) DEFAULT NULL,
  limitAmount DOUBLE DEFAULT NULL,
  address varchar(50) DEFAULT NULL,
  phone varchar(15) DEFAULT NULL,
  city varchar(50) DEFAULT NULL,
  zipCode varchar(10) DEFAULT NULL,
  countryIso varchar(10) DEFAULT NULL,
  createdAt DATE DEFAULT NULL,
  updatedAt DATE DEFAULT NULL
);