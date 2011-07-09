	drop table if exists USERS;
    
	create table USERS (
        USR_ID bigint not null,
        USR_NAME varchar(100),
        USR_CITY varchar(100),
        primary key (USR_ID)
    );
