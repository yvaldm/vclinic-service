create table user_registration (

  id bigserial primary key,
  email text not null,
  password text not null,
  code integer not null,
  created_at timestamp not null default now()
);