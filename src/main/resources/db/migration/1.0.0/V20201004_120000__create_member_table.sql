-- postgres db schema
-- SET statement_timeout = 0;
-- SET lock_timeout = 0;
-- SET client_encoding = 'UTF8';
-- SET standard_conforming_strings = ON;
-- SET check_function_bodies = FALSE;
-- SET client_min_messages = WARNING;

CREATE SCHEMA IF NOT EXISTS iam_store;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
-- SET default_tablespace = '';
-- SET default_with_oids = FALSE;

CREATE EXTENSION "uuid-ossp" SCHEMA public;

SET search_path = iam_store, pg_catalog, public;
SET default_tablespace = '';
SET default_with_oids = FALSE;

-- member table represent user in the system

CREATE TYPE iam_store.UserType AS ENUM (
    'MERCHANT',
    'ADMINISTRATOR',
    'CUSTOMER'
);

CREATE TABLE iam_store.member
(
    id         UUID NOT NULL PRIMARY KEY,
    first_name TEXT,
    last_name  TEXT,
    email      TEXT,
    user_type  UserType NOT NULL,
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

-- Insert role and permission

-- INSERT INTO iam_store.permission(id, name, description, created_by, created_on, updated_on) VALUES
-- (uuid_generate_v4(), 'admin_access', 'full admin access to everything in the system(God mode)', null , now(), now());
--
-- INSERT INTO iam_store.role(id, name, description, created_by, created_on, updated_on) VALUES
-- (uuid_generate_v4(), 'admin', 'admin role', null , now(), now());
--
-- INSERT INTO iam_store.role_permission(id, role_id, permission_id, created_by, created_on, updated_on) VALUES
-- (uuid_generate_v4(),
--  (SELECT id FROM iam_store.role where name = 'admin'), -- admin role id
--  (SELECT id FROM iam_store.permission where name = 'admin_access'), -- admin permission id
--  null , now(), now());


-- insert admin user

-- INSERT INTO iam_store.member(id, first_name, last_name, email, user_type, created_by, created_on, updated_on) VALUES
-- (uuid_generate_v4(), 'devender', 'kumar', 'devender.kumar@gmail.com', 'ADMINISTRATOR', null , now(), now());
--
-- INSERT INTO iam_store.credential(id, password, user_id, enabled, created_by, created_on, updated_on) VALUES
-- (uuid_generate_v4(), '$2y$10$eLmz/6cohzveHv90kZiLyupGd2oKtLc4vgVGn4m10vUvejfZqXNke',
--  (SELECT id FROM iam_store.member where email = 'devender.kumar@gmail.com'), -- admin user id
--  true, null , now(), now());

