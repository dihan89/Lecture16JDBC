set schema public;


drop table IF EXISTS SEQUENCE;

create table SEQUENCE (
    ind INT PRIMARY KEY NOT NULL,
    val INT NOT NULL
)

--CREATE UNIQUE INDEX IF NOt EXISTS UNIQUE_INDEX ON SEQUENCE(indexElem);

