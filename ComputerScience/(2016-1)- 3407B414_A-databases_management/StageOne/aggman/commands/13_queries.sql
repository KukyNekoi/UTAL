SELECT * FROM problems WHERE id = 435862;
SELECT * FROM problems WHERE id = 79161;
SELECT * FROM problems WHERE id = 250502;
SELECT * FROM problems WHERE id = 690126;
SELECT * FROM problems WHERE id = 833283;
SELECT * FROM contestants WHERE first_name = 'waifu';
SELECT * FROM contestants WHERE first_name = 'jose';
SELECT * FROM contestants WHERE first_name = 'neko';
SELECT * FROM contestants WHERE first_name = 'java';
SELECT * FROM contestants WHERE first_name = 'luxo';
SELECT * FROM contestants WHERE birthdate > '1993-10-14' AND birthdate < '1995-10-14';
SELECT * FROM contestants WHERE birthdate > '1995-08-07' AND birthdate < '1996-08-07';
SELECT * FROM contestants WHERE birthdate > '1998-04-19' AND birthdate < '1999-04-19';
SELECT * FROM contestants WHERE birthdate > '2001-12-30' AND birthdate < '2002-12-30';
SELECT * FROM contestants WHERE birthdate > '1999-05-12' AND birthdate < '2000-05-12'; 
SELECT contestants.id,contestants.first_name,contestants.last_name,teams.id,teams.name,teams.institution FROM contestants,teams,team_members WHERE teams.institution = 'ligru dre oji cho ' AND team_members.contestant_id = contestants.id AND teams.id = team_members.team_id;
SELECT contestants.id,contestants.first_name,contestants.last_name,teams.id,teams.name,teams.institution FROM contestants,teams,team_members WHERE teams.institution = 'vo opeglo cha yeglo ' AND team_members.contestant_id = contestants.id AND teams.id = team_members.team_id;
SELECT contestants.id,contestants.first_name,contestants.last_name,teams.id,teams.name,teams.institution FROM contestants,teams,team_members WHERE teams.institution = 'aplu bli cloipu dretaka blu gla' AND team_members.contestant_id = contestants.id AND teams.id = team_members.team_id;
SELECT contestants.id,contestants.first_name,contestants.last_name,teams.id,teams.name,teams.institution FROM contestants,teams,team_members WHERE teams.institution = 'ka elleclo wuchoodrixowini ba za ' AND team_members.contestant_id = contestants.id AND teams.id = team_members.team_id;
SELECT contestants.id,contestants.first_name,contestants.last_name,teams.id,teams.name,teams.institution FROM contestants,teams,team_members WHERE teams.institution = 'ovi:  tuogirrerri bruipu vebrayoti ' AND team_members.contestant_id = contestants.id AND teams.id = team_members.team_id;