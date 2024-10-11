CREATE DATABASE universities_db;
USE universities_db;

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    population INT,
    country_id INT NOT NULL,
    
    FOREIGN KEY(country_id)
    REFERENCES countries(id)
);

CREATE TABLE universities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL UNIQUE,
    address VARCHAR(80) NOT NULL UNIQUE,
    tuition_fee DECIMAL(19, 2) NOT NULL,
    number_of_staff INT,
    city_id INT,
    
    FOREIGN KEY(city_id)
    REFERENCES cities(id)
);

CREATE TABLE students(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    is_graduated BOOLEAN NOT NULL,
    city_id INT,
    
    FOREIGN KEY(city_id)
    REFERENCES cities(id)
);

CREATE TABLE courses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    duration_hours DECIMAL(19, 2),
    start_date DATE,
    teacher_name VARCHAR(60) NOT NULL UNIQUE,
    description TEXT,
    university_id INT,
    
    FOREIGN KEY(university_id)
    REFERENCES universities(id)
);

CREATE TABLE students_courses(
	grade DECIMAL(19, 2) NOT NULL,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    
    FOREIGN KEY(student_id)
    REFERENCES students(id),
    FOREIGN KEY(course_id)
    REFERENCES courses(id)
);

INSERT INTO courses(name, duration_hours, start_date, teacher_name, description, university_id)
SELECT 
	CONCAT(teacher_name, ' ', 'course') AS name,
    LENGTH(name) / 10,
    DATE_ADD(start_date, INTERVAL 5 DAY),
    REVERSE(teacher_name),
    CONCAT('Course', ' ', teacher_name, REVERSE(description)),
    DAY(start_date)
FROM courses
WHERE id <= 5;

UPDATE universities
SET tuition_fee = tuition_fee + 300
WHERE id >= 5 AND id <= 12;

DELETE FROM universities
WHERE number_of_staff IS NULL;

SELECT id, name, population, country_id
FROM cities
ORDER BY population DESC;

SELECT first_name, last_name, age, phone, email
FROM students
WHERE age >= 21 
ORDER BY first_name DESC, email, id
LIMIT 10;

select 
	CONCAT(s.first_name, ' ', s.last_name) as full_name,
	substring(s.email, 2, 10) as username,
	reverse(s.phone) as password
from students s
left join students_courses sc
on s.id = sc.student_id 
where sc.course_id is null
order by password desc; 

select COUNT(sc.student_id) as students_count, u.name 
from universities u 
join courses c ON u.id = c.university_id 
join students_courses sc on c.id = sc.course_id 
group by u.name 
having students_count >= 8
order by students_count desc, u.name desc;

select u.name as university_name, c.name as city_name, u.address, 
case 	
	when u.tuition_fee < 800 then 'cheap'
	when u.tuition_fee < 1200 then 'normal'
	when u.tuition_fee < 2500 then 'high'
	else 'expensive' 
end as price_rank, u.tuition_fee
from universities u 
join cities c on u.city_id = c.id 
order by u.tuition_fee;


DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60)) 
RETURNS DECIMAL(12, 2)
DETERMINISTIC
BEGIN
    RETURN (
        SELECT AVG(sc.grade)
        FROM students_courses sc
        JOIN students s ON sc.student_id = s.id
        JOIN courses c ON sc.course_id = c.id
        WHERE s.is_graduated = 1 
        AND c.name = course_name
    );
END$$

create procedure udp_graduate_all_students_by_year (year_started INT)
begin
	update students s
	join students_courses sc on s.id = sc.student_id
	join courses c on sc.course_id = c.id
	set s.is_graduated = 1
	where year(c.start_date) = year_started;
end

DELIMITER ;

select udf_average_alumni_grade_by_course_name('Quantum Physics');
call udp_graduate_all_students_by_year(2017);