SELECT first_name, last_name FROM employees
WHERE first_name LIKE 'Sa%'
ORDER BY employee_id;

SELECT first_name, last_name FROM employees
WHERE last_name LIKE '%ei%'
ORDER BY employee_id;

SELECT 
	first_name FROM employees
	WHERE department_id IN(3, 10) AND 
    YEAR(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id;

SELECT first_name, last_name FROM employees
WHERE job_title NOT LIKE '%engineer%'
ORDER BY employee_id;

SELECT name FROM towns
WHERE LENGTH(name) IN(5, 6)
ORDER BY name;

SELECT town_id, name FROM towns
WHERE LEFT(name, 1) IN('M', 'K', 'B', 'E')
ORDER BY name;

SELECT town_id, name FROM towns
WHERE LEFT(name, 1) NOT IN('R', 'B', 'D')
ORDER BY name;

CREATE VIEW v_employees_hired_after_2000 AS
	SELECT first_name, last_name 
    FROM employees
    WHERE YEAR(hire_date) > 2000;
    
SELECT * FROM v_employees_hired_after_2000;

SELECT first_name, last_name 
FROM employees
WHERE LENGTH(last_name) = 5;

SELECT country_name, iso_code 
FROM countries
WHERE country_name LIKE '%A%A%A%'
ORDER BY iso_code;

SELECT 
	peak_name, river_name, 
	LOWER(CONCAT(peak_name, (SUBSTRING(river_name, 2))))
    AS mix FROM peaks, rivers
	WHERE RIGHT(peak_name, 1) = LEFT(river_name, 1)
ORDER BY mix;

SELECT name, DATE_FORMAT(start, '%Y-%m-%d') AS start FROM games
WHERE YEAR(start) IN(2011, 2012)
ORDER BY start, name
LIMIT 50;

SELECT 
	user_name, SUBSTRING(email, LOCATE('@', email) + 1) 
    AS `email provider`
    FROM users
ORDER BY `email provider`, user_name;

SELECT user_name, ip_address 
FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

SELECT name AS game, 
CASE
	WHEN HOUR(start) < 12
    THEN 'Morning'
    WHEN HOUR(start) < 18
    THEN 'Afternoon'
    WHEN HOUR(start) < 24
    THEN 'Evening'
END AS `Part of the Day`,
CASE 
	WHEN duration <= 3
    THEN 'Extra Short'
    WHEN duration <= 6
    THEN 'Short'
    WHEN duration <= 10
    THEN 'Long'
    ELSE 'Extra Long'
END AS Duration
FROM games;