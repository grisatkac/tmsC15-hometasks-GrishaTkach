CREATE DATABASE IF NOT EXISTS spring;
use spring;

CREATE TABLE IF NOT EXISTS task (
    id bigint primary key auto_increment,
    title varchar(30),
    description varchar(400),
    status VARCHAR(11)
    );

CREATE TABLE IF NOT EXISTS students (
    id bigint primary key auto_increment,
    first_name varchar(30),
    last_name varchar(400),
    number VARCHAR(11)
);

CREATE TABLE IF NOT EXISTS users (
    id bigint primary key auto_increment,
    first_name varchar(30),
    last_name varchar(400)
);