CREATE TABLE animalorder.`Customers`;

CREATE TABLE animalorder.`Customers` (
  id int(11) NOT NULL,
  name varchar(45) NOT NULL,
  city varchar(45) NOT NULL,
  country varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;