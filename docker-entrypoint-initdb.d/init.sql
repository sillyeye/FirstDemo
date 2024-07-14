-- docker-entrypoint-initdb.d/init.sql

CREATE DATABASE IF NOT EXISTS first_demo;

USE first_demo;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);