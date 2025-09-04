-- Drop tables in reverse order of creation to avoid foreign key conflicts
DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `events`;
DROP TABLE IF EXISTS `venues`;
DROP TABLE IF EXISTS `organizers`;

-- Create tables
CREATE TABLE `organizers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255),
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `venues` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `city` VARCHAR(255),
    `country` VARCHAR(255),
    `name` VARCHAR(255) NOT NULL,
    `street` VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE `events` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `end_date` DATE,
    `name` VARCHAR(255) NOT NULL,
    `start_date` DATE,
    `organizer_id` INT NOT NULL,
    `venue_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`organizer_id`) REFERENCES `organizers`(`id`),
    FOREIGN KEY (`venue_id`) REFERENCES `venues`(`id`)
);

CREATE TABLE `products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255),
    `event_id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `price` DECIMAL(38,2) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`event_id`) REFERENCES `events`(`id`)
);