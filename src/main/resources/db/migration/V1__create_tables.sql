DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'user_role') THEN
create type user_role as enum('ADMIN', 'PUBLISHER', 'USER');
END IF;
END
$$;

CREATE TABLE if NOT EXISTS  books
(
    id          uuid        NOT NULL    DEFAULT uuid_generate_v4(),
    title       text        NOT NULL,
    isbn         text        NOT NULL,
    description  text        NOT NULL,
    no_pages      int        NOT NULL,

    PRIMARY KEY (id)
);