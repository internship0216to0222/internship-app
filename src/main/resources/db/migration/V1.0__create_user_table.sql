CREATE TABLE user (
    id                   INT UNSIGNED AUTO_INCREMENT,
    email_address        VARCHAR(254) NOT NULL,
    phone_number         VARCHAR(256) NOT NULL,
    bank                 VARCHAR(50)  NOT NULL,
    branch               VARCHAR(50)  NOT NULL,
    account_type         TINYINT      NOT NULL,
    account_number       VARCHAR(7)   NOT NULL,
    created_at           DATETIME     NOT NULL,
    updated_at           DATETIME     NOT NULL,
    PRIMARY KEY (`id`),
    INDEX (`email_address`)
);

CREATE TABLE user_login_history (
    id                 INT UNSIGNED AUTO_INCREMENT,
    user_id            INT UNSIGNED NOT NULL,
    user_agent         VARCHAR(512) NOT NULL,
    source_ip_address  VARCHAR(39)  NOT NULL,
    logged_in_at       DATETIME     NOT NULL,
    created_at         DATETIME     NOT NULL,
    updated_at         DATETIME     NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES user (`id`)
);
