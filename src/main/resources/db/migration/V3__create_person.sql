create table person(
    id int,
    name varchar(50) not null,
    phone varchar(11),
    zipcode char(8),
    street varchar(150) ,
    number int ,
    neighborhood varchar(80),
    city varchar(100),
    state varchar(80),
    country varchar(80),
    cpf char(11) not null CONSTRAINT person_cpf_unique UNIQUE,
    enterprise_id int,
    primary key(id),
    CONSTRAINT person_user_foreign_key foreign key(id) references users(id),
    CONSTRAINT person_enterprise_foreign_key foreign key(enterprise_id) references enterprise(id)
);