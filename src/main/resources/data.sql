INSERT INTO city(name) VALUES ('København'), ('Aarhus'), ('Odense');

INSERT INTO tag(name) VALUES ('Family'), ('Museum'), ('Park'), ('Architecture');

INSERT INTO attraction(name, description, city) VALUES
                                                    ('Tivoli Gardens', 'Historisk forlystelsespark', 'København'),
                                                    ('ARoS Aarhus Art Museum', 'Kunstmuseum med regnbuepanorama', 'Aarhus');

INSERT INTO attraction_tag (attraction_id, tag_id) VALUES
                                                       ((SELECT id FROM attraction WHERE name='Tivoli Gardens'), (SELECT id FROM tag WHERE name='Family')),
                                                       ((SELECT id FROM attraction WHERE name='Tivoli Gardens'), (SELECT id FROM tag WHERE name='Park')),
                                                       ((SELECT id FROM attraction WHERE name='ARoS Aarhus Art Museum'), (SELECT id FROM tag WHERE name='Museum')),
                                                       ((SELECT id FROM attraction WHERE name='ARoS Aarhus Art Museum'), (SELECT id FROM tag WHERE name='Architecture'));
