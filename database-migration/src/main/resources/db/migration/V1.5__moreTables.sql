CREATE TABLE ind_types
(
    id                  INTEGER,
    name                varchar(255)
);

CREATE TABLE link_reports_indicators
(
    id                  INTEGER,
    report              INTEGER NOT NULL,
    indicator           INTEGER NOT NULL
);

ALTER TABLE indicators add column
    ind_type            INTEGER NULL
