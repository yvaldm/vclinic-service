
create table public.user_registration (

  id bigserial primary key,
  email text unique not null,
  password text not null,
  code integer not null,
  created_at timestamp not null default now()

);

create table public.user_basic (

  id bigserial primary key,
  email text unique not null,
  password text not null,
  created_at timestamp not null default now()
);

create table public.user_profile (

 id bigint primary key references user_basic,
 first_name text not null,
 last_name text not null,
 fathers_name text not null,
 birthday date not null,
 place_of_birth text not null,
 passport_number integer not null,
 passport_issue_date date not null,
 passport_issue_authority text not null,
 registration_address text not null,
 living_address text not null,
 updated_at timestamp not null default now()
);
