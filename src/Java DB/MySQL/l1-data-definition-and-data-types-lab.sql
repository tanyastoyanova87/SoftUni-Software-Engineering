CREATE TABLE `employees` (
  `id` int NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `categories` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)  NOT NULL
);

CREATE TABLE `products` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `category_id` INT NOT NULL
);

INSERT INTO `employees` VALUES 
	(5, 'SQL', 'Inserted'),
    (6, "Double", "Quotes"),
    (7, 'Ruin', 'AI');
    
ALTER TABLE `employees` 
ADD COLUMN `middle_name` VARCHAR(50);

ALTER TABLE `products`
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE `employees` 
MODIFY COLUMN `middle_name` VARCHAR(100);