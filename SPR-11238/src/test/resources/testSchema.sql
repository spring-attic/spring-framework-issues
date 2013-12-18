CREATE TABLE IF NOT EXISTS appmember(
  account varchar(10) primary key,
  name   varchar(16) ,
  passwd  varchar(20) not null,
  enabled varchar(1) default 'Y' check(enabled='Y' or enabled='N'), 
  birthday date
);        
insert into appmember(account,name,passwd,enabled,birthday)
select 'admin','admin','admin','Y',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='admin');
insert into appmember(account,name,passwd,enabled,birthday)
select 'user1','user1','user1','Y',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='user1');
insert into appmember(account,name,passwd,enabled,birthday)
select 'user2','user2','user2','Y',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='user2');
insert into appmember(account,name,passwd,enabled,birthday)
select 'user3','user3','user3','Y',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='user3');
insert into appmember(account,name,passwd,enabled,birthday)
select 'user4','user4','user4','Y',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='user4');
insert into appmember(account,name,passwd,enabled,birthday)
select 'user5','user5','user5','Y',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='user5');
insert into appmember(account,name,passwd,enabled,birthday)
select 'userx','userx','userx1','N',CURRENT_DATE()
 WHERE NOT EXISTS(SELECT 1 FROM appmember where account='userx');

CREATE TABLE IF NOT EXISTS authorities(
  aid SERIAL primary key,
  account varchar(10) references appmember on update cascade on delete cascade,
  authority varchar(50) not null
);
create unique index IF NOT EXISTS authorities_idx on authorities(account,authority);

insert into authorities(account,authority) select 'admin','ROLE_ADMIN'
 where not exists(select 1 from authorities where account='admin' and authority='ROLE_ADMIN');
insert into authorities(account,authority) select 'admin','ROLE_USER'
 where not exists(select 1 from authorities where account='admin' and authority='ROLE_USER');
insert into authorities(account,authority) select 'user1','ROLE_USER'
 where not exists(select 1 from authorities where account='user1' and authority='ROLE_USER');
insert into authorities(account,authority) select 'user2','ROLE_USER'
 where not exists(select 1 from authorities where account='user2' and authority='ROLE_USER');
insert into authorities(account,authority) select 'user3','ROLE_USER'
 where not exists(select 1 from authorities where account='user3' and authority='ROLE_USER');
insert into authorities(account,authority) select 'user4','ROLE_USER'
 where not exists(select 1 from authorities where account='user4' and authority='ROLE_USER');
insert into authorities(account,authority) select 'user5','ROLE_USER'
 where not exists(select 1 from authorities where account='user5' and authority='ROLE_USER');
insert into authorities(account,authority) select 'userx','ROLE_USER'
 where not exists(select 1 from authorities where account='userx' and authority='ROLE_USER');
