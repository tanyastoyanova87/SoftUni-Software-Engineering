CREATE TABLE continents(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE countries (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    country_code VARCHAR(10) NOT NULL UNIQUE,
    continent_id INT NOT NULL,
    
    FOREIGN KEY (continent_id) 
    REFERENCES continents(id)
);


CREATE TABLE preserves(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6),
    area INT,
    type VARCHAR(20),
    established_on DATE
);

CREATE TABLE positions(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    description TEXT,
    is_dangerous BOOLEAN NOT NULL
);

CREATE TABLE workers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    personal_number VARCHAR(20) NOT NULL UNIQUE,
    salary DECIMAL(19, 2),
    is_armed BOOLEAN NOT NULL,
    start_date DATE,
    preserve_id INT,
    position_id INT NOT NULL,
    
    FOREIGN KEY (preserve_id) 
    REFERENCES preserves(id),
    FOREIGN KEY (position_id)
    REFERENCES positions(id)
);

CREATE TABLE countries_preserves(
	country_id INT NOT NULL,
    preserve_id INT NOT NULL,
    
    KEY(country_id, preserve_id),
    FOREIGN KEY(country_id)
    REFERENCES countries(id),
    FOREIGN KEY(preserve_id)
    REFERENCES preserves(id)
);

INSERT INTO preserves (name, latitude, longitude , area, type, established_on)
SELECT
	CONCAT(name, ' ', 'is in South Hemisphere') AS name,
	latitude,
    longitude,
    area * id AS area,
    LOWER(type) AS type,
    established_on
FROM preserves
WHERE latitude < 0;

UPDATE workers 
SET salary = salary + 500
WHERE position_id IN(5, 8, 11, 13);

DELETE FROM preserves 
WHERE established_on IS NULL;

SELECT CONCAT(first_name, ' ', last_name) AS full_name, DATEDIFF('2024-01-01', start_date) AS days_of_experience
FROM workers
WHERE YEAR('2024-01-01') - YEAR(start_date) > 5
ORDER BY days_of_experience DESC
LIMIT 10;

SELECT w.id, w.first_name, w.last_name, p.name AS preserve_name, c.country_code
FROM workers w
JOIN preserves p ON w.preserve_id = p.id
JOIN countries_preserves cp ON cp.preserve_id = p.id
JOIN countries c ON cp.country_id = c.id
WHERE w.salary > 5000 AND age < 50
ORDER BY c.country_code;

SELECT name, COUNT(w.preserve_id) AS armed_workers
FROM preserves p
JOIN workers w ON p.id = w.preserve_id
WHERE w.is_armed = 1
GROUP BY name
ORDER BY armed_workers DESC, name;

SELECT p.name, c.country_code, YEAR(established_on) AS founded_in
FROM preserves p
JOIN countries_preserves cp ON p.id = cp.preserve_id
JOIN countries c ON cp.country_id = c.id
WHERE MONTH(established_on) = 5
ORDER BY established_on;

SELECT id, name,
CASE
	WHEN area <= 100 THEN 'very small'
    WHEN area <= 1000 THEN 'small'
    WHEN area <= 10000 THEN 'medium'
    WHEN area <= 50000 THEN 'large'
    ELSE 'very large'
END AS category 
FROM preserves 
ORDER BY area DESC;

DELIMITER $$
CREATE FUNCTION udf_average_salary_by_position_name (name VARCHAR(40))
RETURNS DECIMAL(12,2)
DETERMINISTIC
BEGIN
	RETURN (SELECT AVG(w.salary)
    FROM workers w
    JOIN positions p ON w.position_id = p.id
    WHERE p.name = name
    GROUP BY p.name);
END$$
DELIMITER ;

SELECT udf_average_salary_by_position_name('Forester'); 

DELIMITER $$
CREATE PROCEDURE udp_increase_salaries_by_country (country_name VARCHAR(40))
BEGIN
	UPDATE workers w
    JOIN preserves p ON w.preserve_id = p.id
    JOIN countries_preserves cp ON cp.preserve_id = p.id
    JOIN countries c ON cp.country_id = c.id
    SET salary = salary * 1.05
    WHERE c.name = country_name;
END$$
DELIMITER ;

CALL udp_increase_salaries_by_country('Germany');