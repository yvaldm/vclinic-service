create table track (

  id bigserial primary key,
  name text not null,
  description text not null,
  length numeric not null,
  unit text not null
);

create table user_registration (

  id bigserial primary key,
  email text not null,
  password text not null,
  code integer not null

);