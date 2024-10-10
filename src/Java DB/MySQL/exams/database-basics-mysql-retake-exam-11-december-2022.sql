CREATE DATABASE airlines_db;
USE airlines_db;

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    description TEXT,
    currency VARCHAR(5) NOT NULL
);

CREATE TABLE airplanes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(50) NOT NULL UNIQUE,
    passengers_capacity INT NOT NULL,
    tank_capacity DECIMAL(19, 2) NOT NULL,
    cost DECIMAL(19, 2) NOT NULL
);

CREATE TABLE passengers(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    country_id INT NOT NULL,
    
	FOREIGN KEY(country_id) 
    REFERENCES countries(id)
);

CREATE TABLE flights(
	id INT PRIMARY KEY AUTO_INCREMENT,
    flight_code VARCHAR(30) NOT NULL UNIQUE,
    departure_country INT NOT NULL,
    destination_country INT NOT NULL,
    airplane_id INT NOT NULL,
    has_delay BOOLEAN,
    departure DATETIME,

	FOREIGN KEY(departure_country)
    REFERENCES countries(id),
    FOREIGN KEY(destination_country)
    REFERENCES countries(id),
    FOREIGN KEY(airplane_id)
    REFERENCES airplanes(id)
);

CREATE TABLE flights_passengers(
	flight_id INT,
    passenger_id INT,
    
    KEY(flight_id, passenger_id),
    FOREIGN KEY(flight_id)
    REFERENCES flights(id),
    FOREIGN KEY (passenger_id)
    REFERENCES passengers(id)
);

INSERT INTO airplanes(model, passengers_capacity, tank_capacity, cost)
SELECT 
	 CONCAT(REVERSE(first_name), 797) AS model,
     LENGTH(last_name) * 17 AS passengers_capacity,
     id * 790 AS tank_capacity,
     LENGTH(first_name) * 50.6 AS cost
FROM passengers 
WHERE id <= 5;

UPDATE flights a
JOIN countries c ON a.departure_country = c.id
SET airplane_id = airplane_id + 1
WHERE c.name = 'Armenia';

DELETE FROM flights
WHERE id NOT IN (
    SELECT flight_id 
    FROM flights_passengers
);

SELECT id, model, passengers_capacity, tank_capacity, cost
FROM airplanes
ORDER BY cost DESC, id DESC;

SELECT flight_code, departure_country, airplane_id, departure
FROM flights
WHERE YEAR(departure) = 2022
ORDER BY airplane_id, flight_code
LIMIT 20;

SELECT 
	CONCAT(UPPER(LEFT(last_name, 2)), country_id) AS flight_code, 
    CONCAT(first_name, ' ', last_name) AS full_name,
    country_id
FROM passengers p
JOIN flights_passengers fp ON p.id = fp.flight_id
ORDER BY country_id;

SELECT 
	CONCAT(UPPER(LEFT(last_name, 2)), country_id) AS flight_code, 
    CONCAT(first_name, ' ', last_name) AS full_name,
    country_id
FROM passengers
WHERE id NOT IN (
    SELECT passenger_id 
    FROM flights_passengers)
ORDER BY country_id;

SELECT c.name, c.currency, COUNT(fp.passenger_id) AS booked_tickets
FROM countries c
JOIN flights f ON c.id = f.destination_country
JOIN flights_passengers fp ON f.id = fp.flight_id
GROUP BY c.name
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;

SELECT flight_code, departure,
CASE 	
	WHEN HOUR(departure) < 5 THEN 'Night'
	WHEN HOUR(departure) < 12 THEN 'Morning'
    WHEN HOUR(departure) < 17 THEN 'Afternoon'
    WHEN HOUR(departure) < 21 THEN 'Evening '
    ELSE 'Night'
END AS day_part
FROM flights
ORDER BY flight_code DESC;

DELIMITER $$
CREATE FUNCTION udf_count_flights_from_country(country VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN(
			SELECT COUNT(f.id)
            FROM countries c
            JOIN flights f ON c.id = f.departure_country
			WHERE c.name = country);
END$$
DELIMITER ;

SELECT udf_count_flights_from_country('Brazil');

DELIMITER $$
CREATE PROCEDURE udp_delay_flight (code VARCHAR(50))
BEGIN
	UPDATE flights
    SET has_delay = 1;
    
    UPDATE flights
    SET departure = DATE_ADD(departure, INTERVAL 30 MINUTE) 
	WHERE flight_code = code;
    
END$$
DELIMITER ;

CALL udp_delay_flight('ZP-782');