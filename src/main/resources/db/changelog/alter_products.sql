alter table pr_products
    add column description varchar(100),
    add column ibu decimal(10,2),
    add column alcool decimal(10,2);

alter table pr_products
    add column image varchar(50);