DROP TABLE IF EXISTS bc.dock;
DROP TABLE IF EXISTS bc.slip;
DROP TABLE IF EXISTS bc.boat;
DROP TABLE IF EXISTS bc.member;


CREATE TABLE bc.`member`
(
    `id`                  int PRIMARY KEY AUTO_INCREMENT,
    `first_name`          varchar(255),
    `last_name`           varchar(255),
    `address`             varchar(255),
    `phone`               varchar(255),
    `email`               varchar(255),
    `spouse`              varchar(255),
    `is_office_member`    boolean,
    `is_committee_member` boolean,
    `committee_type`      ENUM ('' boat_committee ''),
    `office_type`         ENUM ('' boat_office ''),
    `annual_dues`         int,
    `boat_id`             int,
    `slip_id`             int
);

CREATE TABLE bc.`boat`
(
    `id`                           int PRIMARY KEY AUTO_INCREMENT,
    `member_id`                    int,
    `length`                       int,
    `beam`                         int,
    `depth`                        int,
    `registration`                 varchar(255),
    `is_boat_registration_current` boolean,
    `is_city_registration_current` boolean,
    CONSTRAINT fk_member_boat
        FOREIGN KEY (member_id)
            REFERENCES member (id)
);

CREATE TABLE bc.`dock`
(
    `id`        int PRIMARY KEY AUTO_INCREMENT,
    `dock_name` varchar(255)
);

CREATE TABLE bc.`slip`
(
    `id`          int PRIMARY KEY AUTO_INCREMENT,
    `length`      int,
    `width`       int,
    `is_wet_slip` boolean,
    `is_dry_slip` boolean,
    `member_id`   int,
    `dock_id`     int,
    CONSTRAINT fk_member_slip
        FOREIGN KEY (member_id)
            REFERENCES member (id),
    CONSTRAINT fk_dock_id
        FOREIGN KEY (dock_id)
            REFERENCES dock (id)
);

