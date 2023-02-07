CREATE TABLE user (
    id     INT UNSIGNED AUTO_INCREMENT,
    email  VARCHAR(254) NOT NULL,
    phone  VARCHAR(256) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX (`email`)
);