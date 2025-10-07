DROP TABLE IF EXISTS attraction_tag;
DROP TABLE IF EXISTS attraction;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS city;

CREATE TABLE city (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(120) NOT NULL UNIQUE
);

CREATE TABLE tag (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE attraction (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(160) NOT NULL,
                            description TEXT,
                            city VARCHAR(120) NOT NULL,
                            CONSTRAINT uk_attraction_name UNIQUE (name)
);

CREATE TABLE attraction_tag (
                                attraction_id INT NOT NULL,
                                tag_id INT NOT NULL,
                                PRIMARY KEY (attraction_id, tag_id)
);
