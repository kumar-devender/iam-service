CREATE TABLE iam_store.changelog
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    action      TEXT,
    comment_id  INTEGER,
    created_by  UUID,
    created_on  TIMESTAMP WITHOUT TIME ZONE,
    field       TEXT,
    new_value   TEXT,
    object_id   UUID,
    object_type TEXT,
    old_value   TEXT,
    parent_id   UUID,
    parent_type TEXT
);
