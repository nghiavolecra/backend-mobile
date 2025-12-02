-- Flyway migration: create departments table
CREATE SEQUENCE IF NOT EXISTS seq_department START WITH 1;

CREATE TABLE IF NOT EXISTS departments (
  id bigint PRIMARY KEY DEFAULT nextval('seq_department'),
  name varchar(100) not null,
  description text
);
