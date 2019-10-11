create table person_team(
    person_id serial references person(id),
    team_id serial references team(id),
    primary key(person_id,team_id)
);