create table pr_products(
    pr_id serial primary key not null ,
    pr_name varchar(100) not null ,
    pr_category varchar(50),
    pr_value decimal(10,2)
)