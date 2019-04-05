create table if not exists address
(
    id bigint primary key,
    city varchar(255),
    street varchar(255),
    home varchar(255)
);

alter table person
    add column address bigint references address(id);