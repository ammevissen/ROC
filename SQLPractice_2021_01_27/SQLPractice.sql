--https://en.wikipedia.org/wiki/James_Cameron#Frequent_collaborators

CREATE TABLE actor(
	--id SERIAL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) PRIMARY KEY,
	YOB INTEGER CHECK (YOB>1850) Not Null
);


CREATE TABLE movie(
	--id SERIAL PRIMARY KEY,
	title VARCHAR(100) PRIMARY KEY,
	"year" INTEGER check ("year">1975) NOT NULL,
	run_time INTEGER NOT NULL
	);


CREATE TABLE movie_actors(
	last_name VARCHAR(50) NOT NULL,
	--first_name VARCHAR(50) NOT NULL-- REFERENCES actor(first_name) ON UPDATE CASCADE,
	title VARCHAR(100) NOT NULL,
	FOREIGN KEY (last_name) REFERENCES actor(last_name) ON UPDATE CASCADE,	
	--FOREIGN KEY (first_name) REFERENCES actor(first_name)  ON UPDATE CASCADE,
	FOREIGN KEY (title)REFERENCES movie(title)  ON UPDATE CASCADE,
	PRIMARY KEY (last_name, title)
);



--DROP TABLE actor
--DROP TABLE movie
DROP TABLE movie_actors

INSERT INTO actor(first_name, last_name, YOB)
VALUES
('Michael', 'Biehn', 1956),
('Jenette', 'Goldstein', 1960),
('Lance', 'Henriksen', 1940),
('Bill', 'Paxton', 1955),
('Arnold', 'Schwarzenegger', 1947),
('Sigourney', 'Weaver', 1949),
('Kate', 'Winslet', 1975),
('William', 'Wisher_II', 1958);

INSERT INTO movie(title, "year", run_time)
VALUES
('Xenogenesis', 1978, 12),
('Piranha II', 1982, 94),
('The Terminator', 1978, 107),
('Aliens', 1986, 137),
('The Abyss', 1989, 140),
('Terminator 2', 1991, 137),
('True Lies', 1994, 141),
('Titanic', 1997, 195),
('Expedition: Bismarck', 2002, 92),
('Ghosts of the Abyss', 2003, 61),
('Avatar', 2009, 162);

INSERT INTO movie_actors(last_name, title)
VALUES
('Biehn', 'The Terminator'),
('Biehn', 'Terminator 2'),
('Biehn', 'Aliens'),
('Biehn', 'The Abyss'),
('Goldstein', 'The Terminator'),
('Goldstein', 'Terminator 2'),
('Goldstein', 'Aliens'),
('Goldstein', 'Titanic'),
('Henriksen', 'Piranha II'),
('Henriksen', 'The Terminator'),
('Henriksen', 'Terminator 2'),
('Henriksen', 'Aliens'),
('Henriksen', 'Expedition: Bismarck'),
('Paxton', 'The Terminator'),
('Paxton', 'Terminator 2'),
('Paxton', 'Aliens'),
('Paxton', 'True Lies'),
('Paxton', 'Titanic'),
('Paxton', 'Ghosts of the Abyss'),
('Schwarzenegger', 'The Terminator'),
('Schwarzenegger', 'Terminator 2'),
('Schwarzenegger', 'True Lies'),
('Weaver', 'Aliens'),
('Weaver', 'Avatar'),
('Winslet', 'Titanic'),
('Winslet', 'Avatar'),
('Wisher_II', 'The Terminator'),
('Wisher_II', 'Terminator 2'),
('Wisher_II', 'Ghosts of the Abyss');

SELECT *
FROM actor

SELECT *
FROM movie

SELECT *
FROM movie_actors


SELECT first_name, actor.last_name, title
FROM actor
INNER JOIN movie_actors
on actor.last_name=movie_actors.last_name;



--https://www.postgresqltutorial.com/postgresql-inner-join/
SELECT a.first_name, ma.last_name, ma.title, m."year"
FROM movie m
INNER JOIN movie_actors ma
on ma.title=m.title
INNER JOIN actor a
on a.last_name=ma.last_name;






