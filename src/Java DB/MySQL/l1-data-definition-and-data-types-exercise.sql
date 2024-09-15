CREATE TABLE minions(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT
);

CREATE TABLE towns(
	town_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);

ALTER TABLE minions
ADD COLUMN town_id INT;

ALTER TABLE minions
ADD CONSTRAINT fk_town_id
FOREIGN KEY (town_id) REFERENCES towns(id);

INSERT INTO towns VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO minions VALUES
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

TRUNCATE TABLE minions;

DROP TABLE minions;
DROP TABLE towns;

CREATE TABLE people(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE,
    weight DOUBLE,
    gender CHAR NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people VALUES
(1, 'Peter', NULL, 125, 325, 'm', '1990-05-20', NULL),
(2, 'Ivana', NULL, 125.25, 325.55, 'f', '1990-05-20', NULL),
(3, 'Ulyan', NULL, 125.25, 325.55, 'm', '1990-05-20', NULL),
(4, 'Ivan', NULL, 125.25, 325.55, 'm', '1990-05-20', NULL),
(5, 'Tosho', NULL, 125.25, 325.55, 'm', '1990-05-20', NULL);

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30),
    password VARCHAR(26),
    profile_picture BLOB,
    last_login_time TIME,
    is_deleted BOOLEAN
);

INSERT INTO users VALUES
(1, 'peter123', '57575755', NULL, '19:30:10', false),
(2, 'peter1234', '57575755', NULL, '19:30:10', false),
(3, 'peter125', '57575755', NULL, '19:30:10', false),
(4, 'peter126', '57575755', NULL, '19:30:10', false),
(5, 'peter127', '57575755', NULL, '19:30:10', false);

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (id, username);

ALTER TABLE users 
MODIFY COLUMN last_login_time DATETIME DEFAULT NOW();

ALTER TABLE users 
DROP PRIMARY KEY,
ADD PRIMARY KEY(id);

ALTER TABLE users
MODIFY username VARCHAR(30) NOT NULL UNIQUE;

CREATE TABLE directors(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE genres(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE categories(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE movies(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    director_id INT,
    copyright_year DATE,
    length DOUBLE,
    genre_id INT,
    category_id INT,
    rating DOUBLE,
    notes TEXT
);

INSERT INTO directors (director_name, notes) VALUES
('Ivan Ivanov', 'fuggjuhlyufyu55'),
('Ivan', 'fuggjuhlyufyu55'),
('Ivanov', 'fuggjuhlyufyu55'),
('Ivam', 'fuggjuhlyufyu55'),
('Ivar', 'fuggjuhlyufyu55');

INSERT INTO genres (genre_name, notes) VALUES
('comedy', 'fuggjuhlyufyu55'),
('horror', 'fuggjuhlyufyu55'),
('action', 'fuggjuhlyufyu55'),
('drama', 'fuggjuhlyufyu55'),
('sci-fi', 'fuggjuhlyufyu55');

INSERT INTO categories (category_name, notes) VALUES
('gy', 'fuggjuhlyufyu55'),
('h', 'fuggjuhlyufyu55'),
('u', 'fuggjuhlyufyu55'),
('oko', 'fuggjuhlyufyu55'),
('sfi', 'fuggjuhlyufyu55');

INSERT INTO movies VALUES
(1, 'Harry Potter', 456, '2003-01-02', 5, 4, 4, 4.7, 'uiguigi'),
(2, 'hjoo', 456, '2003-01-02', 5, 4, 4, 4.7, 'uiguigi'),
(3, 'ojjj', 456, '2003-01-02', 5, 4, 4, 4.7, 'uiguigi'),
(4, 'Potter', 456, '2003-01-02', 5, 4, 4, 4.7, 'uiguigi'),
(5, 'Harry', 456, '2003-01-02', 5, 4, 4, 4.7, 'uiguigi');

CREATE TABLE categories (
	id INT PRIMARY KEY AUTO_INCREMENT,
	category VARCHAR(100), 
	daily_rate DOUBLE, 
	weekly_rate DOUBLE,
	monthly_rate DOUBLE,
	weekend_rate DOUBLE
);

CREATE TABLE cars (
	id INT PRIMARY KEY AUTO_INCREMENT,
	plate_number VARCHAR(100),
	make VARCHAR(100),
    model VARCHAR(100),
    car_year INT,
    category_id INT, 
    doors INT,
    picture BLOB,
    car_condition VARCHAR(100),
    available BOOLEAN
);

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    title VARCHAR(200),
    notes TEXT
);

CREATE TABLE customers (
	id INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT,
    full_name VARCHAR(200),
    address VARCHAR(100),
    city VARCHAR(100),
    zip_code INT,
    notes TEXT
);

CREATE TABLE rental_orders (
	id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition VARCHAR(100),
    tank_level DOUBLE,
    kilometrage_start DOUBLE,
    kilometrage_end DOUBLE,
    total_kilometrage DOUBLE,
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(100),
    notes TEXT
);

INSERT INTO categories VALUES
(1, 'KK', 5.4, 5.5, 6.5, 4.5),
(2, 'OK', 5.4, 5.5, 6.5, 4.5),
(3, 'KP', 5.4, 5.5, 6.5, 4.5);

INSERT INTO cars VALUES
(1, 'CB4545', 'P', 'AMG', 2016, 5, 4, NULL, 'good', true),
(2, 'CB4545', 'P', 'AMG', 2016, 5, 4, NULL, 'good', true),
(3, 'CB4545', 'P', 'AMG', 2016, 5, 4, NULL, 'good', true);

INSERT INTO employees VALUES
(1, 'Bob', 'Duncan', 'Tiiiiiiiiii', 'giberish'),
(2, 'Bob', 'Duncan', 'Tiiiiiiiiii', 'giberish'),
(3, 'Bob', 'Duncan', 'Tiiiiiiiiii', 'giberish');

INSERT INTO customers VALUES
(1, 4545, 'Duncan Dunkanov', 'jk edi kude si', 'Spanchovo', 1000, 'blabla'),
(2, 4545, 'Duncan Dunkanov', 'jk edi kude si', 'Spanchovo', 1000, 'blabla'),
(3, 4545, 'Duncan Dunkanov', 'jk edi kude si', 'Spanchovo', 1000, 'blabla');

INSERT INTO rental_orders VALUES
(1, 2, 2, 3, 'gore-dolu', 5.2, 4, 10, 14, '2024-02-02', '2024-02-03', 1, 6.2, 5.4, 'shipped', 'wherever'), 
(2, 2, 2, 3, 'gore-dolu', 5.2, 4, 10, 14, '2024-02-02', '2024-02-03', 1, 6.2, 5.4, 'shipped', 'wherever'), 
(3, 2, 2, 3, 'gore-dolu', 5.2, 4, 10, 14, '2024-02-02', '2024-02-03', 1, 6.2, 5.4, 'shipped', 'wherever');

INSERT INTO towns (name) VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments (name) VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary) VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

SELECT *
FROM towns
ORDER BY name;

SELECT * 
FROM departments
ORDER BY name;

SELECT *
FROM employees
ORDER BY salary DESC;

SELECT name
FROM towns
ORDER BY name;

SELECT name 
FROM departments
ORDER BY name;

SELECT first_name, last_name, job_title, salary 
FROM employees
ORDER BY salary DESC;

UPDATE employees
SET salary = salary * 1.10;

SELECT salary
FROM employees;