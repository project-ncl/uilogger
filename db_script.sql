CREATE TABLE uilogs (
    id bigint NOT NULL,
    client_name character varying(255),
    client_revision character varying(255),
    client_version character varying(255),
    data character varying(255),
    message character varying(255),
    name character varying(255),
    stack character varying(255),
    "timestamp" character varying(255),
    url character varying(255),
    user_browser character varying(255),
    user_id character varying(255),
    user_language character varying(255),
    seen boolean
);
ALTER TABLE ONLY uilogs
    ADD CONSTRAINT uilogs_pkey PRIMARY KEY (id);
GRANT ALL PRIVILEGES ON TABLE uilogs TO *db_user*;
