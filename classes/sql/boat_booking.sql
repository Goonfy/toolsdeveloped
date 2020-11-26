CREATE TABLE sailors(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE boats(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE booking(
    sailor_id INTEGER NOT NULL,
    boat_id INTEGER NOT NULL,
    day DATE NOT NULL,
    PRIMARY KEY(boat_id, day),
    FOREIGN KEY (sailor_id) REFERENCES sailors(id),
    FOREIGN KEY (boat_id) REFERENCES boats(id)
);

INSERT INTO sailors(id, name, age) VALUES (1, "Edu", 22);

