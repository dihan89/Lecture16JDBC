set schema public;



drop table IF EXISTS PERSON;

create table PERSON (
                        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        age INT NOT NULL
);

CREATE UNIQUE INDEX IF NOt EXISTS UNIQUE_PERSON ON PERSON(name);