DROP TABLE IF EXISTS attraction_tag;
DROP TABLE IF EXISTS attraction;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS city;

CREATE TABLE IF NOT EXISTS city (
                                    id   INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(120) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS tag (
                                   id   INT AUTO_INCREMENT PRIMARY KEY,
                                   name VARCHAR(80) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS attraction (
                                          id          INT AUTO_INCREMENT PRIMARY KEY,
                                          name        VARCHAR(160) NOT NULL,
    description TEXT NULL,
    city        VARCHAR(120) NOT NULL,
    CONSTRAINT uk_attraction_name UNIQUE (name)
    );

CREATE TABLE IF NOT EXISTS attraction_tag (
                                              attraction_id INT NOT NULL,
                                              tag_id        INT NOT NULL,
                                              PRIMARY KEY (attraction_id, tag_id),
    CONSTRAINT fk_attraction
    FOREIGN KEY (attraction_id) REFERENCES attraction(id) ON DELETE CASCADE,
    CONSTRAINT fk_tag
    FOREIGN KEY (tag_id)        REFERENCES tag(id)        ON DELETE CASCADE
    );
