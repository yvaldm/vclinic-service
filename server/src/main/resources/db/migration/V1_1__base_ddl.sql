create table track (

  id bigserial primary key,
  name text not null,
  description text not null,
  length numeric not null,
  unit text not null
);
