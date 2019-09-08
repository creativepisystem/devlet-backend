create table users (
    id serial,
    username varchar(255) not null CONSTRAINT user_username_unique UNIQUE,
    password varchar(255) not null,
    name varchar(255) not null,
    email varchar(255) not null CONSTRAINT user_email_unique UNIQUE,
    enabled boolean not null,
    last_password_reset_date timestamp,
    primary key (id)
);

create table roles (
    id serial,
    name varchar(255) not null CONSTRAINT role_name_unique UNIQUE,
    primary key (id)
);

create table user_role (
    user_id serial REFERENCES users(id),
    role_id serial REFERENCES roles(id),
    primary key (user_id,role_id)
);