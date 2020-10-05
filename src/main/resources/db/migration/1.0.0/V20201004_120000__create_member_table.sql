-- postgres db schema
CREATE SCHEMA IF NOT EXISTS iam_store;

-- member table represent user in the system

CREATE TABLE iam_store.member
(
    id         UUID NOT NULL PRIMARY KEY,
    first_name TEXT,
    last_name  TEXT,
    email      TEXT,
    created_by UUID,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE iam_store.credential
(
    id         UUID NOT NULL PRIMARY KEY,
    password   TEXT NOT NULL,
    user_id    UUID NOT NULL,
    enabled    boolean,
    created_by UUID,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES iam_store.member(id)
);


CREATE TABLE iam_store.role
(
    id          UUID NOT NULL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    created_by  UUID,
    created_on  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on  TIMESTAMP WITHOUT TIME ZONE
);


CREATE TABLE iam_store.permission
(
    id          UUID NOT NULL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    created_by  UUID,
    created_on  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on  TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE iam_store.credential_role
(
    id         UUID NOT NULL PRIMARY KEY,
    user_id    UUID NOT NULL,
    role_id    UUID NOT NULL,
    created_by UUID,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES iam_store.member(id)
);

CREATE TABLE iam_store.role_permission
(
    id            UUID NOT NULL PRIMARY KEY,
    role_id       UUID NOT NULL,
    permission_id UUID NOT NULL,
    created_by    UUID,
    created_on    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on    TIMESTAMP WITHOUT TIME ZONE
);
