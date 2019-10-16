create table team(
    id serial,
    name varchar(50) not null,
    "date" timestamp with time zone default current_timestamp,
    enterprise_id serial references enterprise,
    primary key (id)
);