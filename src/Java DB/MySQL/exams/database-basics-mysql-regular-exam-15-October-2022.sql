create database restaurant_db;
use restaurant_db;

create table products(
	id	int primary key auto_increment,
	name VARCHAR(30) not null unique,
    type VARCHAR(30) not null,
	price DECIMAL (10, 2) not null
);

create table clients(
	id	int primary key auto_increment,
	first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
	birthdate date not null,
	card VARCHAR(50),
	review TEXT
);

create table tables(
	id	int primary key auto_increment,
	floor int not null,
    reserved boolean,
	capacity int not null
);

create table waiters(
	id	int primary key auto_increment,
	first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
	email VARCHAR(50) not null,
	phone VARCHAR(50),
	salary DECIMAL(10, 2)
);

create table orders(
	id	int primary key auto_increment,
	table_id int not null,
    waiter_id int not null,
	order_time time not null,
	payed_status boolean,
	
	FOREIGN KEY (table_id) 
    REFERENCES tables(id),
    FOREIGN KEY (waiter_id) 
    REFERENCES waiters(id)
);

CREATE TABLE orders_clients (
    order_id INT,
    client_id INT
);

CREATE TABLE orders_products (
    order_id INT,
    product_id INT,
    
    KEY (order_id, product_id),
    FOREIGN KEY (order_id)
    REFERENCES orders(id),
    FOREIGN KEY (product_id)
    REFERENCES products(id)
);

insert into products(name, type, price)
select CONCAT(w.last_name, ' ', 'specialty') as name,
	   'Cocktail' as type,
	   CEIL(w.salary / 100) as price
from waiters w
where id > 6;

update orders 
set table_id = table_id - 1
where id >= 12 and id <= 23;

delete from waiters 
where id not in (select waiter_id from orders);

select id, first_name, last_name, birthdate, card, review
from clients c 
order by birthdate desc, id desc;

select first_name, last_name, birthdate, review
from clients c 
where card is null and year(birthdate) >= 1978 and year(birthdate) <= 1993
order by last_name desc, id
limit 5;

select 
	  concat(last_name, first_name, length(first_name), "Restaurant") as username,
	  reverse(substring(email, 2, 12)) as password
from waiters w 
where salary is not null
order by password desc; 

select id, name, count(op.product_id) as count
from products p 
join orders_products op on p.id = op.product_id 
group by name
having count >= 5
order by count desc, name;

select t.id as table_id, capacity, count(oc.client_id) as count_clients,
case 
	when t.capacity > count(oc.client_id) then 'Free seats'
	when t.capacity = count(oc.client_id) then 'Full'
	when t.capacity < count(oc.client_id) then 'Extra seats'
end as availability
from tables t 
join orders o on t.id  = o.table_id 
join orders_clients oc on o.id = oc.order_id 
where t.floor  = 1
group by t.id 
order by table_id desc;

delimiter $$
create function udf_client_bill(full_name VARCHAR(50))
returns decimal(12, 2)
DETERMINISTIC
begin
     RETURN(select sum(p.price) as bill
	       from clients c
	       join orders_clients oc on c.id = oc.client_id
	       join orders_products op on oc.order_id = op.order_id
	       join products p on op.product_id = p.id
	       where CONCAT(c.first_name, ' ', c.last_name) = full_name
	       group by c.id);
end$$

create procedure udp_happy_hour(type VARCHAR(50))
begin
	update products p
	set price = price * 0.80
	where price >= 10 and p.type = type;
end$$
delimiter ;

sellect udf_client_bill('Silvio Blyth');
call udp_happy_hour('Cognac');