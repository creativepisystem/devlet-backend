create table stage(
    id serial,
    name varchar(50) not null,
    description varchar(350),
    "date" timestamp with time zone default current_timestamp,
    project_id serial,
    enterprise_id serial,
    primary key(id),
    foreign key(project_id) references project,
    foreign key(enterprise_id) references enterprise
);