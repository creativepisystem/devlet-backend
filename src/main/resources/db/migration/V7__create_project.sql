create table project(
    id serial,
    name varchar(50) not null,
    description varchar(350),
    budget numeric(8, 4),
    estimated_hours int,
    client_id serial,
    enterprise_id serial,
    team_id serial,
    primary key(id),
    foreign key(client_id) references enterprise,
    foreign key(enterprise_id) references enterprise,
    foreign key(team_id) references team
);