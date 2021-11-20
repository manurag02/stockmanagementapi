DROP TABLE IF EXISTS stock;
CREATE TABLE stock(id serial PRIMARY KEY, name VARCHAR(255), currentPrice DECIMAL, currency VARCHAR, lastUpdate TIMESTAMP);