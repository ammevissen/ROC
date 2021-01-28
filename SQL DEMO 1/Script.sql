CREATE TABLE person(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	"age" INTEGER NOT NULL,
	created_at Timestamp DEFAULT current_timestamp -- the default constraint allows values to be automatically inserted as well
	);
	
CREATE TABLE car(
	id SERIAL PRIMARY KEY,
	vin VARCHAR(16) UNIQUE NOT NULL,
	make VARCHAR(50) NOT NULL,
	model VARCHAR(50) NOT NULL,
	--person_id INTEGER REFERENCES person(id)--FK
	
	person_id INTEGER, --column we want to be FK
	CONSTRAINT fk_person FOREIGN KEY(person_id) references person(id)--specifying a constraint that we then apply to the column
);

--to add more columns
ALTER TABLE person
ADD COLUMN column_name data_type constraint

--to delete that table
DROP TABLE person;
DROP TABLE car;

--DELETE all data from the table, but not the table itself
TRUNCATE TABLE person;

DELETE FROM person WHERE 


--DML, (CRUD)-->INSERT, SELECT, UPDATE, DELETE,
INSERT INTO person (first_name, last_name, "age")
VALUES
('Bob', 'Doe', 20),
('John', 'Doe', 23),
('Jane', 'Doe', 30);

INSERT INTO car (vin, make, model, person_id)
VALUES
('A1B2C3D4A1B2C3D4', 'Tesla', 'Model 3', 5),
('A1B2C3D4A1B2C3D5', 'Tesla', 'Model S', 5);

INSERT INTO car (vin, make, model, person_id)
VALUES
('A1B2C3D4A1B2C3D9', 'Chevrolet', 'Tahoe', 6),
('A1B2C3D4A1B2C3D8', 'Toyota', 'Supra', 7);
--('A1B2C3D4A1B2C3D5', 'Tesla', 'Model S', 5),
--('A1B2C3D4A1B2C3D4', 'Tesla', 'Model 3', 5);

SELECT *
from person;

SELECT *
from car;

--Joins
--Joins are used to combine +2 tables based on some condition

--Here I want to join together the person and car table based on the foreign key and the primary key of person
SELECT c.*
FROM person per   --per is an aliase, short hand for table name
INNER JOIN car c
ON per.id = c.person_id
WHERE per.id=5

UNION

SELECT c.*
FROM person per   --per is an aliase, short hand for table name
INNER JOIN car c
ON per.id = c.person_id
WHERE per.id=7;

SELECT c.*
FROM person per   --per is an aliase, short hand for table name
INNER JOIN car c
ON per.id = c.person_id
WHERE per.id in (5, 6);

SELECT c.*
FROM person per   --per is an aliase, short hand for table name
INNER JOIN car c
ON per.id = c.person_id
WHERE per.id BETWEEN 5 and 7;


