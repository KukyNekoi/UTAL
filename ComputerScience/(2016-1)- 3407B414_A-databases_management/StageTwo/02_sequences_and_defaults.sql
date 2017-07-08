﻿--Sequence
CREATE SEQUENCE colours_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 20
  CACHE 1;
ALTER TABLE colours_id_seq OWNER TO postgres;
ALTER TABLE colours ALTER COLUMN id SET DEFAULT nextval('colours_id_seq');
CREATE DOMAIN baloon_type AS text CONSTRAINT baloon_type_check CHECK (VALUE ~ '([A-Za-z]+( )*)+');
ALTER TABLE colours ALTER COLUMN name SET DATA TYPE baloon_type;

CREATE SEQUENCE contest_sites_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 330000
  CACHE 1;
ALTER TABLE contest_sites_id_seq OWNER TO postgres;
ALTER TABLE contest_sites ALTER COLUMN id SET DEFAULT nextval('contest_sites_id_seq');

CREATE SEQUENCE contestants_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 880000
  CACHE 1;
ALTER TABLE contestants_id_seq OWNER TO postgres;
ALTER TABLE contestants ALTER COLUMN id SET DEFAULT nextval('contestants_id_seq');

CREATE SEQUENCE contests_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 440000
  CACHE 1;
ALTER TABLE contests_id_seq OWNER TO postgres;
ALTER TABLE contests ALTER COLUMN id SET DEFAULT nextval('contests_id_seq');

CREATE SEQUENCE countries_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 33000
  CACHE 1;
ALTER TABLE countries_id_seq OWNER TO postgres;
ALTER TABLE countries ALTER COLUMN id SET DEFAULT nextval('countries_id_seq');

CREATE SEQUENCE problem_set_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 5600000
  CACHE 1;
ALTER TABLE problem_set_id_seq OWNER TO postgres;
ALTER TABLE problem_set ALTER COLUMN id SET DEFAULT nextval('problem_set_id_seq');

CREATE SEQUENCE problems_content_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 880000
  CACHE 1;
ALTER TABLE problems_content_id_seq OWNER TO postgres;
ALTER TABLE problems_content ALTER COLUMN id SET DEFAULT nextval('problems_content_id_seq');

CREATE SEQUENCE problems_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 880000
  CACHE 1;
ALTER TABLE problems_id_seq OWNER TO postgres;
ALTER TABLE problems ALTER COLUMN id SET DEFAULT nextval('problems_id_seq');

CREATE SEQUENCE roles_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 33000
  CACHE 1;
ALTER TABLE roles_id_seq OWNER TO postgres;
ALTER TABLE roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq');

CREATE SEQUENCE scoreboards_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1500000
  CACHE 1;
ALTER TABLE scoreboards_id_seq OWNER TO postgres;
ALTER TABLE scoreboards ALTER COLUMN id SET DEFAULT nextval('scoreboards_id_seq');

CREATE SEQUENCE sites_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 330000
  CACHE 1;
ALTER TABLE sites_id_seq OWNER TO postgres;
ALTER TABLE sites ALTER COLUMN id SET DEFAULT nextval('sites_id_seq');

CREATE SEQUENCE team_members_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1600000
  CACHE 1;
ALTER TABLE team_members_id_seq OWNER TO postgres;
ALTER TABLE team_members ALTER COLUMN id SET DEFAULT nextval('team_members_id_seq');

CREATE SEQUENCE teams_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 880000
  CACHE 1;
ALTER TABLE teams_id_seq OWNER TO postgres;
ALTER TABLE teams ALTER COLUMN id SET DEFAULT nextval('teams_id_seq');
