DROP TABLE users;
CREATE TABLE users (
    id SERIAL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

DROP TABLE incomings;
CREATE TABLE incomings (
    id SERIAL,
    agentId  INTEGER NOT NULL,
    value  INTEGER NOT NULL
);

DROP TABLE agents;
CREATE TABLE agents (
    id SERIAL,
    name VARCHAR(255) NOT NULL UNIQUE,
    divisionId INTEGER NOT NULL
);

DROP TABLE divisions;
CREATE TABLE divisions (
    id SERIAL,
    name VARCHAR(255) NOT NULL UNIQUE
);
