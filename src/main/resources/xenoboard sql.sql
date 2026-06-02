CREATE DATABASE xenoboard CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS user (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NULL DEFAULT NULL,
    updated_by_id INT(20) UNSIGNED NULL DEFAULT NULL,
    username VARCHAR(30) NOT NULL ,
    email VARCHAR(50) NOT NULL ,
    banner VARCHAR(200) NULL DEFAULT NULL,
    dob DATE NULL DEFAULT NULL,
    last_login TIMESTAMP NULL,
    profile_image_url VARCHAR(255) NULL DEFAULT NULL,
    approved BIT(1) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, username, email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO user(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, username, email, banner, dob, approved)
VALUES ('d79ed735-fc17-4424-b807-c143d4e8b128', 0, NOW(), NOW(), 1, 1,
        'Xenoboard Admin', 'test@hotmail.com', 'Dost thou seeketh the power?', '1989-01-29', 1);

CREATE TABLE IF NOT EXISTS forum_category (
    id TINYINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    title VARCHAR(25) NOT NULL ,
    description VARCHAR(200) NOT NULL ,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO forum_category(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, description)
VALUES ('1105f62e-3d72-4473-9451-31869a6f1bd8', 0, NOW(), NOW(), 1, 1,
        'Discussions', 'A forum for general discussions about video game related topics.');

INSERT INTO forum_category(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, description)
VALUES ('fc836275-1ccb-4010-9266-aac825037a2b', 0, NOW(), NOW(), 1, 1,
        'Bazaar', 'A place to sell all of your unwanted treasure for maximum profits');

INSERT INTO forum_category(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, description)
VALUES ('354e6b26-cdd8-45ff-8a5c-ff84c78d4bf5', 0, NOW(), NOW(), 1, 1,
        'Events', 'A place to post about community events and other such topics. Such as contests, etc');

INSERT INTO forum_category(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, description)
VALUES ('512b5bfd-9805-43e9-9659-664c971d8ef2', 0, NOW(), NOW(), 1, 1,
        'News', 'News that you can use about our site and about important events in the gaming world');

INSERT INTO forum_category(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, description)
VALUES ('cfc6f856-1109-4eb2-b097-53656d5414f8', 0, NOW(), NOW(), 1, 1,
        'Top Secret', 'A forum for discussion of Top Secret topics. Aliens, UFOs, Classified information, Government Secrets, Etc. The Truth is out there. Far out');

CREATE TABLE IF NOT EXISTS topic (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    title VARCHAR(200) NOT NULL ,
    body VARCHAR(11000) NOT NULL ,
    approved BIT(1) NOT NULL,
    views MEDIUMINT(15) UNSIGNED NOT NULL DEFAULT 0,
    likes MEDIUMINT(15) UNSIGNED NOT NULL DEFAULT 0,
    sticky BIT(1) NOT NULL,
    closed BIT(1) NOT NULL,
    reported BIT(1) NOT NULL,
    reported_by_date TIMESTAMP NULL DEFAULT NULL,
    reported_by_reason VARCHAR(255) NULL DEFAULT NULL,
    reported_by_id INT(20) UNSIGNED NULL DEFAULT NULL,
    category_id TINYINT(5) UNSIGNED NOT NULL DEFAULT 1,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES user(id),
    FOREIGN KEY (reported_by_id) REFERENCES user(id),
    FOREIGN KEY (category_id) REFERENCES forum_category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS reply (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    body VARCHAR(11000) NOT NULL ,
    likes MEDIUMINT(15) UNSIGNED NOT NULL DEFAULT 0,
    reported BIT(1) NOT NULL,
    reported_by_date TIMESTAMP NULL DEFAULT NULL,
    reported_by_reason VARCHAR(255) NULL DEFAULT NULL,
    reported_by_id INT(20) UNSIGNED NULL DEFAULT NULL,
    topic_id INT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES user(id),
    FOREIGN KEY (reported_by_id) REFERENCES user(id),
    FOREIGN KEY (topic_id) REFERENCES topic(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS tag (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    title VARCHAR(20) NOT NULL ,
    approved BIT(1) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS topic_tag (
    topic_id INT(20) UNSIGNED NOT NULL,
    tag_id INT(20) UNSIGNED NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (topic_id, tag_id),
    KEY idx_tag_topic (tag_id, topic_id),
    CONSTRAINT fk_at_topic
        FOREIGN KEY (topic_id) REFERENCES topic (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_at_tag
        FOREIGN KEY (tag_id) REFERENCES tag (id)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS newscard (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    title VARCHAR(35) NOT NULL,
    content VARCHAR(150) NOT NULL,
    link_url VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    external BIT(1) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS site_content (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    title VARCHAR(40) NOT NULL,
    content VARCHAR(3000) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS topic_file (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    filename VARCHAR(50) NULL,
    filepath VARCHAR(255) NULL,
    filesize INT(20) UNSIGNED NULL,
    filetype VARCHAR(25) NULL,
    comment VARCHAR(100) NULL,
    extension VARCHAR(5) NULL,
    topic_id INT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES user(id),
    FOREIGN KEY (topic_id) REFERENCES topic(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS reply_file (
    id INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT(1) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    updated_by_id INT(20) UNSIGNED NOT NULL DEFAULT 1,
    filename VARCHAR(50) NULL,
    filepath VARCHAR(255) NULL,
    filesize INT(20) UNSIGNED NULL,
    filetype VARCHAR(25) NULL,
    comment VARCHAR(100) NULL,
    extension VARCHAR(5) NULL,
    reply_id INT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES user(id),
    FOREIGN KEY (reply_id) REFERENCES reply(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



