create table user_registration (

  id bigserial primary key,
  email text unique not null,
  password text not null,
  code integer not null,
  created_at timestamp not null default now()

);

create table user_basic (

  id bigserial primary key,
  email text unique not null,
  password text not null,
  created_at timestamp not null default now()
);

create table user_profile (

 id bigint primary key references user_basic,
 first_name text,
 last_name text,
 fathers_name text,
 birthday date,
 place_of_birth text,
 passport_number integer,
 passport_issue_date date,
 passport_issue_authority text,
 registration_address text,
 living_address text,
 updated_at timestamp not null default now()
);