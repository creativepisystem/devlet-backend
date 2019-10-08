create table team(
    id serial,
    name varchar(50) not null,
    "date" timestamp not null,
    primary key (id, name)
);