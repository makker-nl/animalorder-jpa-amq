select * from animalorder.Shipments  ;

select * from animalorder.Shipments  where shipped = false;

update animalorder.Shipments set shipped = false , ship_date = '2021-3-18';