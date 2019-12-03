create table activity(
    id serial,
    title varchar(25) not null,
    description varchar(350),
    status varchar(50) default 'CLOSED' not null,
    opening_date timestamp with time zone,
    conclusion_date timestamp with time zone,
    content jsonb,
    person_id serial,
    stage_id serial,
    enterprise_id serial,
    primary key(id),
    foreign key(person_id) references person,
    foreign key(stage_id) references stage,
    foreign key(enterprise_id) references enterprise
);