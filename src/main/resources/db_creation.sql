create database aop;
\c aop;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "postgis";
SET timezone TO 'UTC';
CREATE USER books_usr WITH PASSWORD 'us3rs';
GRANT ALL PRIVILEGES  ON DATABASE books TO books_usr;