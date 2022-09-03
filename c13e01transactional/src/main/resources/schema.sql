CREATE TABLE IF NOT EXISTS account (
    id serial PRIMARY KEY,
    name varchar(50) NOT NULL,
    amount real NOT NULL
);
