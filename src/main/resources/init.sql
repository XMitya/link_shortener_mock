drop table if exists links;

create table if not exists links (
    short_string varchar(125) primary key,
    long_link varchar(2048) not null
);