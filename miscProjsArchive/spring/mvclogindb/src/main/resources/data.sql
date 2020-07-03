create table if not exists booking(
    id int primary key,
    booking_name varchar(45) NOT NULL
    );

insert into booking(id, booking_name) values
(1, 'Kris'),(2, 'Martin'),(3, 'Andy'),(4, 'Josh');