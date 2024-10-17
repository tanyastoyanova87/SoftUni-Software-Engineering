create database summer_olympics;
use summer_olympics;

create table countries(
	id INT primary key auto_increment,
	name VARCHAR(40) not null unique
);


create table sports(
	id INT primary key auto_increment,
	name VARCHAR(20) not null unique
);

create table disciplines(
	id INT primary key auto_increment,
	name VARCHAR(40) not null unique,
	sport_id INT not null,
	
	foreign key(sport_id) 
	references sports(id)
);

create table athletes(
	id INT primary key auto_increment,
	first_name VARCHAR(40) not null,
	last_name VARCHAR(40) not null,
	age INT not null,
	country_id INT not null,
	
	foreign key(country_id) 
	references countries(id)
);

create table medals(
	id INT primary key auto_increment,
	type varchar(10) not null unique
);

create table disciplines_athletes_medals(
	discipline_id INT not null,
	athlete_id INT not null,
	medal_id INT not null,
	
	key(discipline_id, athlete_id),
	foreign key(discipline_id) 
	references disciplines(id),
	foreign key(athlete_id) 
	references athletes(id),
	foreign key(medal_id) 
	references medals(id),
	
	unique key unique_discipline_medal(discipline_id, medal_id)
);

insert into athletes(first_name, last_name, age, country_id)
select 
	  UPPER(first_name) as first_name,
	  CONCAT(last_name, ' ', 'comes from', ' ', c.name) as last_name,
	  SUM(age + country_id) as age,
	  country_id
from athletes a
join countries c on a.country_id = c.id
where c.name like 'A%'
group by first_name, last_name, age, c.name;

update disciplines
set name = REPLACE(name, 'weight', '')
where name like '%weight';

delete from athletes 
where age > 35;

select id, name
from countries c 
where id not in(select a.country_id from athletes a)
order by name desc
limit 15;

select CONCAT(first_name, ' ', last_name) as full_name, age
from athletes a
where a.id in(select athlete_id from disciplines_athletes_medals) 
and age = (select MIN(age) from athletes)
order by id 
limit 2;

select id, first_name, last_name
from athletes a
where id not in(select athlete_id from disciplines_athletes_medals)
order by id;

select a.id, a.first_name, a.last_name, COUNT(dam.medal_id) medals_count, s.name as sport
from athletes a
join disciplines_athletes_medals dam on a.id = dam.athlete_id
join disciplines d on dam.discipline_id = d.id
join sports s on d.sport_id = s.id
group by a.id, a.first_name, a.last_name, s.name
order by medals_count desc, first_name
limit 10;

select CONCAT(first_name, ' ', last_name) as full_name,
case 
	when age <= 18 then 'Teenager'
	when age <= 25 then 'Young adult'
	else 'Adult'
end as age_group
from athletes
order by age desc, first_name;

delimiter $$
create function udf_total_medals_count_by_country (name VARCHAR(40))
returns int
deterministic
begin
	return(select COUNT(dam.medal_id)
	       from disciplines_athletes_medals dam 
	       join athletes a
	       on dam.athlete_id = a.id
	       join countries c on a.country_id = c.id
	       where c.name = name);
end$$

create procedure udp_first_name_to_upper_case (letter CHAR(1))
begin
	update athletes
	set first_name = UPPER(first_name)
	where RIGHT(first_name, 1) = letter;
end
delimiter ;

select udf_total_medals_count_by_country('Bahamas');
call udp_first_name_to_upper_case('s');