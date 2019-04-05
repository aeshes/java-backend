create table if not exists passport
(
    id         bigint primary key,
    series     varchar(255),
    no         varchar(255),
    issue_date date,
    validity   date,
    person_id  bigint
);

create table if not exists person
(
    id          bigint primary key,
    first_name  varchar(255),
    last_name   varchar(255),
    birthday    date,
    passport_id bigint references passport(id)
);
