drop table if exists task_item;
create table if not exists task_item
(
    id         serial  not null primary key,
    title      text    not null            default '',
    descr      text    not null            default '',
    completed  boolean not null            default false,
    important  boolean not null            default false,
    created_at timestamp without time zone default now()
);