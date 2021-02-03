DROP TABLE IF EXISTS team CASCADE;
CREATE TABLE team(
	id serial PRIMARY KEY,
	team_name varchar(50) NOT null
);


DROP TABLE IF EXISTS player CASCADE;
CREATE TABLE player(
	id serial PRIMARY KEY,
	player_name varchar(50) NOT NULL,
	player_position varchar(50) NOT NULL,
	gender varchar(10) NOT NULL,
	"age" integer NOT NULL,
	phone_number varchar(20) NOT NULL unique,
	team_id integer,
	CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES team(id)
);

INSERT INTO team (team_name)
VALUES
('Tigers');

INSERT INTO player(player_name, player_position, gender, age, phone_number, team_id)
VALUES
('Joe', 'PG', 'Male', 24, '111-111-1111', 1),
('Bob', 'FG', 'Male', 22, '777-777-7777', 1),
('Mary', 'SG', 'Female', 24, '222-222-2222', 1),
('Jimmy', 'PF', 'Male', 27, '333-333-3333', 1),
('Tommy', 'C', 'Male', 25, '444-444-4444', 1),
('Joe', 'PG', 'Male', 24, '555-555-5555', 1),
('Sarah', 'PG', 'Female', 21, '666-666-6666', 1);


SELECT *
FROM JDBC_DEMO_1.player;

UPDATE jdbc_demo_1.player 
SET phone_number= '111-111-1111'--"+phoneNumber+" 
WHERE id=1;