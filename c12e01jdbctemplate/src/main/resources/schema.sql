-- H2
/*CREATE TABLE IF NOT EXISTS purchase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product varchar(50) NOT NULL,
    price double NOT NULL
);*/

-- PostgreSQL
CREATE TABLE IF NOT EXISTS purchase (
    id serial PRIMARY KEY,
    product varchar(50) NOT NULL,
    price decimal(8,2) NOT NULL
);
