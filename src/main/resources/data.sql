/**
 * CREATE Script for init of DB
 */

-- Create 3 OFFLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (101, now(), false, 'OFFLINE',
'driver01pw', 'driver01');

insert into driver (id, date_created, deleted, online_status, password, username) values (102, now(), false, 'OFFLINE',
'driver02pw', 'driver02');

insert into driver (id, date_created, deleted, online_status, password, username) values (103, now(), false, 'OFFLINE',
'driver03pw', 'driver03');


-- Create 3 ONLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (104, now(), false, 'ONLINE',
'driver04pw', 'driver04');

insert into driver (id, date_created, deleted, online_status, password, username) values (105, now(), false, 'ONLINE',
'driver05pw', 'driver05');

insert into driver (id, date_created, deleted, online_status, password, username) values (106, now(), false, 'ONLINE',
'driver06pw', 'driver06');

-- Create 1 OFFLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (107,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'OFFLINE',
'driver07pw', 'driver07');

-- Create 1 ONLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (108,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'ONLINE',
'driver08pw', 'driver08');



-- Create 6 cars

 

insert into car (id, manufacturer, license_plate, seat_count, engine_type, convertible, rating, is_booked, date_created) values (201, 'BMW', 'KA01HA', 5, 'GAS',

'Y', 5,  'N', now());

 

insert into car (id, manufacturer, license_plate, seat_count, engine_type, convertible, rating,is_booked, date_created) values (202, 'VOLKSWAGEN', 'KA21HA', 7, 'GAS',

'Y', 5,  'N', now());

 

insert into car (id, manufacturer, license_plate, seat_count, engine_type, convertible, rating,is_booked,date_created) values (203, 'i10', 'AA01HA', 5, 'PETROL',

'N', 3,  'N', now());

 

insert into car (id, manufacturer, license_plate, seat_count, engine_type, convertible, rating, is_booked, date_created) values (204, 'BMW', 'BA01HA', 5, 'DIESEL',

'Y', 5, 'N', now());

 

insert into car (id, manufacturer, license_plate, seat_count, engine_type, convertible, rating,is_booked, date_created) values (205, 'VOLKSWAGEN', 'CA21HA', 7, 'GAS',

'Y', 5, 'N', now());

 

insert into car (id, manufacturer, license_plate, seat_count, engine_type, convertible, rating,is_booked,date_created) values (206, 'i10', 'DA01HA', 5, 'PETROL',

'N', 4, 'N', now());
 

---create view

CREATE VIEW V_DRIVER_DETAILS AS (SELECT  d.id as DRIVER_ID, d.COORDINATE, d.date_coordinate_updated,d.date_created, d.deleted,d.online_status, d.username,d.password, c.id as CAR_ID, 
c.engine_type,c.IS_BOOKED, c.LICENSE_PLATE, c.RATING, c.SEAT_COUNT FROM Driver d left join CAR c on d.CAR_ID = c.ID) ;
