create table QUEUE_LAST_READ (
    ID varchar(50) primary key,
    POSITION bigint not null,
    LAST_UPDATE datetime not null,
    VERSION bigint not null
);

grant select on QUEUE_LAST_READ to app_user_role;
grant update on QUEUE_LAST_READ to app_user_role;

insert into QUEUE_LAST_READ (ID, POSITION, LAST_UPDATE, VERSION)values ('BAR', 0, current_timestamp , 1);
