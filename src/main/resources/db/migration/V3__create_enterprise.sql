create table enterprise (
    id serial,
    name varchar(100) not null,
    phone varchar(11) not null,
    email varchar(100) not null CONSTRAINT enterprise_email_unique UNIQUE,
    zipcode char(8) not null,
    street varchar(150) not null,
    number int not null,
    neighborhood varchar(80) not null,
    city varchar(100) not null,
    state varchar(80) not null,
    country varchar(80) not null,
    cnpj char(14) not null CONSTRAINT enterprise_cnpj_unique UNIQUE,
    type varchar(50) not null,
    enabled boolean not null,
    primary key (id)
);