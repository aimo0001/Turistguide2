INSERT INTO city(name) VALUES ('København'), ('Aarhus'), ('Odense')
    ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO tag(name) VALUES ('Family'), ('Museum'), ('Park'), ('Architecture')
    ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO attraction(name, description, city) VALUES
                                                    ('Tivoli Gardens', 'Historisk forlystelsespark', 'København'),
                                                    ('ARoS Aarhus Art Museum', 'Kunstmuseum med regnbuepanorama', 'Aarhus')
    ON DUPLICATE KEY UPDATE description=VALUES(description), city=VALUES(city);

INSERT INTO attraction_tag (attraction_id, tag_id)
SELECT a.id, t.id FROM attraction a JOIN tag t ON t.name IN ('Family','Park') WHERE a.name='Tivoli Gardens'
UNION ALL
SELECT a.id, t.id FROM attraction a JOIN tag t ON t.name IN ('Museum','Architecture') WHERE a.name='ARoS Aarhus Art Museum';
