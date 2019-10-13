create table users (
    id serial,
    username varchar(20) not null CONSTRAINT user_username_unique UNIQUE,
    password varchar(130) not null,
    name varchar(40) not null,
    email varchar(100) not null CONSTRAINT user_email_unique UNIQUE,
    enabled boolean not null,
    last_password_reset_date timestamp,
    role varchar(30),
    primary key (id)
);
INSERT INTO USERS (id, username, password, name, email, enabled, last_password_reset_date,role) VALUES
(1, 'admin', '$2a$10$zuI3P8hoZNkFGR2dDPW9juA1C1xIHBUNrKMGqjjaEKsLTwjJkKoNa',
'Admin', 'admin@gmail.com', true, CURRENT_TIMESTAMP,'ADMIN');