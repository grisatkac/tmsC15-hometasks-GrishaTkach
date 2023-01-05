CREATE database if not exists helpdesk;
USE helpdesk;

CREATE TABLE IF NOT EXISTS role(
    id bigint primary key auto_increment,
    role varchar(30)
);

CREATE TABLE IF NOT EXISTS user (
    id bigint primary key auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    email varchar(30),
    password varchar(30),
    can_do_job BOOLEAN,
    role_id bigint,
    FOREIGN KEY role(role_id) REFERENCES role(id)
    ON DELETE SET NULL
    );

CREATE TABLE IF NOT EXISTS ticket(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30),
    description VARCHAR(1000),
    status VARCHAR(11)
    );

CREATE TABLE IF NOT EXISTS user_ticket(
    user_id bigint,
    ticket_id bigint
);

CREATE DATABASE if not exists todo;

use todo;

CREATE TABLE IF NOT EXISTS task (
    id bigint primary key auto_increment,
    title varchar(30),
    description varchar(400),
    status VARCHAR(11)
);



