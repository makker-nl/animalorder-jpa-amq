CREATE TABLE animalorder.`Orders`;

CREATE TABLE animalorder.`Orders` (
  id int(11) NOT NULL,
  customer_id int(11) NOT NULL,
  date date NOT NULL,
  value decimal(6,2) NOT NULL,
  tax decimal(6,2) NOT NULL,
  delivered tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  KEY `Order_customer_fk_1_idx` (customer_id),
  CONSTRAINT `Order_customer_fk_1` FOREIGN KEY (customer_id) REFERENCES Customers (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;