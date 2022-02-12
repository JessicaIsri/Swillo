create table or_orders (
    or_id serial primary key not null ,
    or_date timestamp,
    us_id bigint not null,
    or_value decimal(10,2),
    constraint uau_usr_fk foreign key (us_id)
    references us_user (us_id)
    on delete restrict on update cascade
);

create table op_order_products (
    op_id serial primary key not NULL,
    pr_id bigint,
    or_id bigint,
    op_quantity int,
    value decimal(10,2),
    constraint pr_id_fk foreign key (pr_id)
        references pr_products (pr_id),
    constraint or_id_fk foreign key (or_id)
        references or_orders (or_id)
)