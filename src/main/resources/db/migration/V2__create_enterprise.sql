create table enterprise (
    id serial,
    name varchar(100) not null,
    phone varchar(11) ,
    email varchar(100),
    zipcode char(8),
    street varchar(150),
    number int,
    neighborhood varchar(80),
    city varchar(100),
    state varchar(80),
    country varchar(80),
    cnpj char(14) not null CONSTRAINT enterprise_cnpj_unique UNIQUE,
    type varchar(50) not null,
    enabled boolean not null,
    user_id serial,
    primary key (id),
    CONSTRAINT enterprise_user_foreign_key foreign key(user_id) references users
);