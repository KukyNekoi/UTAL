-- primary keys
ALTER TABLE colours ADD CONSTRAINT colours_pk PRIMARY KEY (id);
ALTER TABLE contest_sites ADD CONSTRAINT contest_sites_pk PRIMARY KEY (id);
ALTER TABLE contestants ADD CONSTRAINT contestants_pk PRIMARY KEY (id);
ALTER TABLE contests ADD CONSTRAINT contests_pk PRIMARY KEY (id);
ALTER TABLE countries ADD CONSTRAINT countries_pk PRIMARY KEY (id);
ALTER TABLE problem_set ADD CONSTRAINT problem_set_pk PRIMARY KEY (id);
ALTER TABLE problems ADD CONSTRAINT problems_pk PRIMARY KEY (id);
ALTER TABLE problems_content ADD CONSTRAINT problems_content_pk PRIMARY KEY (id);
ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY (id);
ALTER TABLE scoreboards ADD CONSTRAINT scoreboards_pk PRIMARY KEY (id);
ALTER TABLE sites ADD CONSTRAINT sites_pk PRIMARY KEY (id);
ALTER TABLE team_members ADD CONSTRAINT team_members_pk PRIMARY KEY (id);
ALTER TABLE teams ADD CONSTRAINT teams_pk PRIMARY KEY (id);

-- foreign keys
ALTER TABLE contest_sites ADD FOREIGN KEY (id_site) REFERENCES sites ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE contest_sites ADD FOREIGN KEY (id_contest) REFERENCES contests ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE contestants ADD FOREIGN KEY (home_country) REFERENCES countries ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE problem_set ADD FOREIGN KEY (contest_id) REFERENCES contests ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE problem_set ADD FOREIGN KEY (problem_id) REFERENCES problem ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE problems ADD FOREIGN KEY (colour_id) REFERENCES colour ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE scoreboards ADD FOREIGN KEY (problem_id) REFERENCES problems ON DELETE RESTRICT ON UPDATE RESTRICT; --transaction
ALTER TABLE scoreboards ADD FOREIGN KEY (contest_id) REFERENCES contests ON DELETE RESTRICT ON UPDATE CASCADE; --transaction
ALTER TABLE scoreboards ADD FOREIGN KEY (team_id) REFERENCES teams ON DELETE RESTRICT ON UPDATE CASCADE; --transaction
ALTER TABLE sites ADD FOREIGN KEY (country_id) REFERENCES countries ON DELETE SET NULL ON UPDATE CASCADE; --transaction
ALTER TABLE team_members ADD FOREIGN KEY (contestant_id) REFERENCES contestants ON DELETE RESTRICT ON UPDATE RESTRICT; --transaction
ALTER TABLE team_members ADD FOREIGN KEY (role_id) REFERENCES roles ON DELETE SET NULL ON UPDATE CASCADE; --transaction
ALTER TABLE team_members ADD FOREIGN KEY (team_id) REFERENCES teams ON DELETE RESTRICT ON UPDATE CASCADE; --transaction
ALTER TABLE teams ADD FOREIGN KEY (coach_id) REFERENCES contestants ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE teams ADD FOREIGN KEY (site_id) REFERENCES sites ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE teams ADD FOREIGN KEY (country_id) REFERENCES countries ON DELETE SET NULL ON UPDATE CASCADE; --transaction