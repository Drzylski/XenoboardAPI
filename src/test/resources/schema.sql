/*! SET storage_engine=INNODB */;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT ,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    username VARCHAR(30) NOT NULL ,
    email VARCHAR(50) NOT NULL ,
    banner VARCHAR(200),
    dob DATE,
    last_login TIMESTAMP ,
    profile_image_url VARCHAR(255),
    approved BIT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, username, email)
);

INSERT INTO users(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, username, email, banner, dob, approved)
VALUES ('d79ed735-fc17-4424-b807-c143d4e8b128', 0, NOW(), NOW(), 1, 1,
        'Xenoboard Admin', 'test@hotmail.com', 'Dost thou seeketh the power?', '1989-01-29', 1);

CREATE TABLE IF NOT EXISTS forum_category (
    id TINYINT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    title VARCHAR(25) NOT NULL ,
    description VARCHAR(200) NOT NULL ,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES users(id)
);

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
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    title VARCHAR(200) NOT NULL ,
    body VARCHAR(11000) NOT NULL ,
    approved BIT NOT NULL,
    views MEDIUMINT NOT NULL DEFAULT 0,
    likes MEDIUMINT NOT NULL DEFAULT 0,
    sticky BIT NOT NULL,
    closed BIT NOT NULL,
    reported BIT NOT NULL,
    reported_by_date TIMESTAMP NULL DEFAULT NULL,
    reported_by_reason VARCHAR(255) NULL DEFAULT NULL,
    reported_by_id INT NULL DEFAULT NULL,
    category_id TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES users(id),
    FOREIGN KEY (reported_by_id) REFERENCES users(id),
    FOREIGN KEY (category_id) REFERENCES forum_category(id)
);

CREATE TABLE IF NOT EXISTS reply (
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    body VARCHAR(11000) NOT NULL ,
    likes MEDIUMINT NOT NULL DEFAULT 0,
    reported BIT NOT NULL,
    reported_by_date TIMESTAMP NULL DEFAULT NULL,
    reported_by_reason VARCHAR(255) NULL DEFAULT NULL,
    reported_by_id INT NULL DEFAULT NULL,
    topic_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES users(id),
    FOREIGN KEY (reported_by_id) REFERENCES users(id),
    FOREIGN KEY (topic_id) REFERENCES topic(id)
);

CREATE TABLE IF NOT EXISTS tag (
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    title VARCHAR(20) NOT NULL ,
    approved BIT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS topic_tag (
    topic_id INT NOT NULL,
    tag_id INT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (topic_id, tag_id),
    CONSTRAINT fk_at_topic
        FOREIGN KEY (topic_id) REFERENCES topic (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_at_tag
        FOREIGN KEY (tag_id) REFERENCES tag (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS newscard (
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    title VARCHAR(35) NOT NULL,
    content VARCHAR(150) NOT NULL,
    link_url VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    external BIT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS site_content (
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    title VARCHAR(40) NOT NULL,
    content VARCHAR(3000) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid, title),
    FOREIGN KEY (created_by_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS topic_file (
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    filename VARCHAR(50) NULL,
    filepath VARCHAR(255) NULL,
    filesize INT NULL,
    filetype VARCHAR(25) NULL,
    comment VARCHAR(100) NULL,
    extension VARCHAR(5) NULL,
    topic_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES users(id),
    FOREIGN KEY (topic_id) REFERENCES topic(id)
);

CREATE TABLE IF NOT EXISTS reply_file (
    id INT NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL ,
    deleted BIT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by_id INT NOT NULL DEFAULT 1,
    updated_by_id INT NOT NULL DEFAULT 1,
    filename VARCHAR(50) NULL,
    filepath VARCHAR(255) NULL,
    filesize INT NULL,
    filetype VARCHAR(25) NULL,
    comment VARCHAR(100) NULL,
    extension VARCHAR(5) NULL,
    reply_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (uuid),
    FOREIGN KEY (created_by_id) REFERENCES users(id),
    FOREIGN KEY (reply_id) REFERENCES reply(id)
);

INSERT INTO site_content(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, content)
VALUES('5048e2f7-a2a0-406f-be6f-3ce6b997e7fe', false, now(), now(), 1, 1,
       'Homepage Lower Register Text','<h2 class="header-text-h2 mb-5" >Please check out our About section to learn more about <span class="xeno-text">Xenoboard</span> and feel free to signup today!</h2>');

INSERT INTO site_content(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, content)
VALUES('18952955-dd46-4773-9a92-c90323dd067b', false, now(), now(), 1, 1,
       'Privacy Policy Text','<h2 class="p-lg-5 p-md-4 p-sm-1">We do not do anything with your data except for the purposes of handling your account and services on our site that your account interacts with. We do not sell, profit from, or do anything else with data. None of that BS. For better privacy, consider using the DuckDuckgo browser, install uBlock Origin, Privacy Possum, Privacy Badger, disable permissions such as location, data sharing, etc, and disable third party cookies. A vpn can help as well. Turn off targeted advertisements. Screw ads. Do not use any apps owned by Google, Meta, or Microsoft. Do not be logged into said services unless needed</h2>');

INSERT INTO site_content(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, content)
VALUES('f646932f-43cc-4117-a012-3a65dcb67dad', false, now(), now(), 1, 1,
       'Legal Text Header','Below is a bunch of legal mumbo jumbo explaining legal stuff with the site.');


INSERT INTO topic(uuid, deleted, created_on, updated_on, created_by_id, updated_by_id, title, body, approved,
                  views, likes, sticky, closed, reported, reported_by_date, reported_by_reason, reported_by_id, category_id)
VALUES('b9467df4-546a-4941-be7d-3a0d88b9ad8b', false, NOW(), NOW(), 1, 1, 'My First Post',
       '<p>Hello! This is my first post. I''m glad to be here. Welcome to every body. <span style="color: #e03e2d; font-family: ''courier new'', courier, monospace; font-size: 14pt;"><strong>Xenoboard </strong></span>is so cool.&nbsp;</p>',
       true, 3, 1, false, false, false, null, null, null, 1);