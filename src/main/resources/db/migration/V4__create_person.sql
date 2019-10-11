create table person(
    id serial,
    name varchar(50) not null,
    phone varchar(11) not null,
    zipcode char(8) not null,
    street varchar(150) not null,
    number int not null,
    neighborhood varchar(80) not null,
    city varchar(100) not null,
    state varchar(80) not null,
    country varchar(80) not null,
    cpf char(11) not null CONSTRAINT person_cpf_unique UNIQUE,
    enterprise_id int not null,
    primary key(id),
    CONSTRAINT person_user_foreign_key foreign key(id) references users(id),
    CONSTRAINT person_enterprise_foreign_key foreign key(enterprise_id) references enterprise(id)
);