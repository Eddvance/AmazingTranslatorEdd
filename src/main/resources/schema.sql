CREATE TABLE IF NOT EXISTS TRANSLATION (
                                           id INT PRIMARY KEY,
                                           language VARCHAR(10),
                                           position INT,
                                           text VARCHAR(255)
);