drop database if exists demo;
create database demo;

begin transaction;


-- groups --
create role demo_ddl;
create role demo_dml;
create role demo_ro;

grant all on database demo to demo_ddl;
grant connect on database demo to demo_dml, demo_ro;

revoke all on schema public from public;
grant all on schema public to demo_ddl;
grant usage on schema public to demo_dml, demo_ro;


-- users --
create role demo_dba login;
create role demo_app login;
create role demo_readonly login;

grant demo_ddl to demo_dba;
grant demo_dml to demo_app;
grant demo_ro to demo_readonly;

alter role demo_dba password 'demo_dba';
alter role demo_app password 'demo_app';
alter role demo_readonly password 'demo_readonly';
commit;