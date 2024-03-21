CREATE TABLE uilogs (
    id bigint NOT NULL,
    client_name character varying,
    client_revision character varying,
    client_version character varying,
    data character varying,
    label character varying,
    message character varying,
    error_name character varying,
    error_stack character varying,
    error_message character varying,
    "timestamp" character varying,
    url character varying,
    user_browser character varying,
    user_id character varying,
    user_language character varying,
    seen boolean
);
ALTER TABLE ONLY uilogs
    ADD CONSTRAINT uilogs_pkey PRIMARY KEY (id);
GRANT ALL PRIVILEGES ON TABLE uilogs TO *db_user*;

-- if empty db: CREATE SEQUENCE hibernate_sequence START 1;
