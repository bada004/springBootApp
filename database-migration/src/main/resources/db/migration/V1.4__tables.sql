CREATE TABLE indicators
(
    id                  INTEGER,
    value               VARCHAR(100),
    created_date        TIMESTAMP,
    created_by          VARCHAR(100)
);

CREATE TABLE indicators_aud
(
    rev                 integer, --txn id
    rev_type            integer,  -- 0 create, 1 update, 2 delete
    id                  INTEGER,
    value               VARCHAR(100),
    created_date        TIMESTAMP,
    created_by          VARCHAR(100)
);
