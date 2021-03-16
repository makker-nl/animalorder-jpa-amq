drop table animalorder.`Shipments`;

create table animalorder.`Shipments`(
id int(11) not null,
order_id int(11) not null,
shipped boolean not null default false,
ship_date date,
description varchar(255),
  PRIMARY KEY (id),
  KEY `Shipment_Order_fk_1_idx` (order_id),
  CONSTRAINT `Shipment_Order_fk_1` FOREIGN KEY (order_id) REFERENCES `Orders` (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;