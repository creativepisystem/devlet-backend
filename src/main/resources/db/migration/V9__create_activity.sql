create table activity(
    id serial,
    title varchar(25) not null,
    description varchar(350),
    creation_date timestamp with time zone default current_timestamp,
    conclusion_date timestamp with time zone default null,
    content varchar(150),
    person_id serial,
    stage_id serial,
    enterprise_id serial,
    primary key(id),
    foreign key(person_id) references person,
    foreign key(stage_id) references stage,
    foreign key(enterprise_id) references enterprise
);