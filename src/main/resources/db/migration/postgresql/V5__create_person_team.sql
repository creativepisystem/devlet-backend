create table person_team(
    person_id serial,
    time_id serial,
    "date" timestamp not null,
    primary key (person_id,time_id)
);