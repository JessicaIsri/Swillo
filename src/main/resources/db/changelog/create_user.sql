create table us_user
(
    us_id SERIAL  not null
        constraint us_user_pkey
        primary key,
    us_name     varchar(100) not null,
    us_email    varchar(100) not null
        constraint us_user_us_email_key
            unique,
    us_password varchar(100) not null
);

create table aut_autorization
(
    aut_id   bigint      not null primary key,
    aut_name varchar(20) not null unique

);

create table uau_usuario_autorizacao
(
    usr_id bigint not null primary key,
    aut_id bigint not null,
    constraint uau_usr_fk foreign key (usr_id)
        references us_user (us_id)
        on delete restrict on update cascade,
    constraint uau_aut_fk foreign key (aut_id)
        references aut_autorization (aut_id)
        on delete restrict on update cascade
);