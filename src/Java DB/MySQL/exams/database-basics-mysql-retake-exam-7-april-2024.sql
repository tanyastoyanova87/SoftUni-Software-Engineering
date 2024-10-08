CREATE DATABASE go_roadie;
USE go_roadie;

CREATE TABLE cities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);
    
CREATE TABLE cars(
	id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL UNIQUE
);
    
CREATE TABLE instructors(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    has_a_license_from DATE NOT NULL
);

CREATE TABLE driving_schools(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    night_time_driving BOOLEAN NOT NULL,
    average_lesson_price DECIMAL(10,2),
    car_id INT NOT NULL,
    city_id INT NOT NULL,
    
    FOREIGN KEY(car_id) 
    REFERENCES cars(id),
    FOREIGN KEY(city_id)
    REFERENCES cities(id)
);

CREATE TABLE students(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    age INT,
    phone_number VARCHAR(20) UNIQUE
);

CREATE TABLE instructors_driving_schools(
	instructor_id INT,
    driving_school_id INT,
    
    KEY(instructor_id, driving_school_id),
    FOREIGN KEY(instructor_id)
    REFERENCES instructors(id),
    FOREIGN KEY (driving_school_id)
    REFERENCES driving_schools(id)
);

CREATE TABLE instructors_students(
	instructor_id INT,
    student_id INT,
    
    KEY(instructor_id, student_id),
    FOREIGN KEY(instructor_id)
    REFERENCES instructors(id),
    FOREIGN KEY (student_id)
    REFERENCES students(id)
);

INSERT INTO students(first_name, last_name, age, phone_number)
SELECT 
	LOWER(REVERSE(first_name)),
    LOWER(REVERSE(last_name)),
    age + LEFT(phone_number, 1),
    CONCAT('1+', phone_number)
FROM students
WHERE age < 20;

UPDATE driving_schools ds
JOIN cities c ON ds.city_id = c.id
SET average_lesson_price = average_lesson_price + 30
WHERE night_time_driving = TRUE AND c.name = 'London';

DELETE FROM instructors_driving_schools
WHERE driving_school_id IN(4, 6, 10, 13, 14, 21, 53, 57, 63, 66, 68);

DELETE FROM driving_schools
WHERE night_time_driving = FALSE;

SELECT CONCAT_WS(' ', first_name, last_name) AS full_name, age
FROM students
WHERE first_name LIKE '%a%'
ORDER BY age, id
LIMIT 3;

SELECT ds.id, ds.name, c.brand
FROM driving_schools ds
LEFT JOIN instructors_driving_schools ids
ON ds.id = ids.driving_school_id
JOIN cars c
ON ds.car_id = c.id
WHERE driving_school_id IS NULL
AND c.brand IN ('Audi', 'BMW', 'Buick')
ORDER BY c.brand, ds.id;

SELECT i.first_name, i.last_name, COUNT(i_s.student_id) AS students_count, c.name AS city_name
FROM instructors i
JOIN instructors_students i_s ON i.id = i_s.instructor_id
JOIN instructors_driving_schools i_d_s ON i.id = i_d_s.instructor_id
JOIN driving_schools d_s ON d_s.id = i_d_s.driving_school_id
JOIN cities c ON d_s.city_id = c.id
GROUP BY i.id, i.first_name, i.last_name, c.name
HAVING COUNT(i_s.student_id) > 1
ORDER BY students_count DESC, i.first_name ASC;

SELECT c.name, COUNT(ids.driving_school_id) AS instructors_count
FROM cities c
         JOIN driving_schools ds on c.id = ds.city_id
         LEFT JOIN instructors_driving_schools ids on ds.id = ids.driving_school_id
         LEFT JOIN instructors i on ids.instructor_id = i.id
GROUP BY c.name
HAVING instructors_count > 0
ORDER BY  instructors_count DESC;

SELECT CONCAT(first_name, ' ', last_name) AS full_name,
CASE 
	WHEN YEAR(has_a_license_from) < 1990 
		THEN 'Specialist'
	WHEN YEAR(has_a_license_from) < 2000 
		THEN 'Advanced'
	WHEN YEAR(has_a_license_from) < 2008
		THEN 'Experienced'
	WHEN YEAR(has_a_license_from) < 2015
		THEN 'Qualified'
	WHEN YEAR(has_a_license_from) < 2020 
		THEN 'Provisional'
	WHEN YEAR(has_a_license_from) >= 2020
		THEN 'Trainee'
END AS level
FROM instructors
ORDER BY YEAR(has_a_license_from), first_name;

DELIMITER $$
CREATE FUNCTION udf_average_lesson_price_by_city (name VARCHAR(40))
RETURNS DECIMAL(12,2)
DETERMINISTIC
BEGIN
	RETURN (SELECT AVG(average_lesson_price) 
    FROM driving_schools ds
    JOIN cities c ON ds.city_id = c.id
    WHERE c.name = name);
END$$
DELIMITER ;

SELECT udf_average_lesson_price_by_city('London');

DELIMITER $$
CREATE PROCEDURE udp_find_school_by_car(brand VARCHAR(20))
BEGIN
	SELECT ds.name AS brand, ds.average_lesson_price 
    FROM driving_schools ds
    JOIN cars c ON ds.car_id = c.id
    WHERE c.brand = brand
    ORDER BY average_lesson_price DESC;
END$$
DELIMITER ;

CALL udp_find_school_by_car('Mercedes-Benz');