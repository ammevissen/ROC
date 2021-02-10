DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer(
	accountNumber Integer PRIMARY KEY,
	firstName varchar(50) NOT NULL,
	lastName varchar(50) NOT NULL,
	customerPassword varchar(100) NOT NULL,
	checkingID Integer NOT NULL UNIQUE,
	savnigsID integer NOT NULL UNIQUE,
	checkingBalance double precision NOT NULL DEFAULT 0,
	savingBalance double precision NOT NULL DEFAULT 0,
	dob date NOT NULL
);

DROP TABLE IF EXISTS checkingBalance CASCADE;
CREATE TABLE checkingBalance(
	id serial PRIMARY KEY,
	checkingID integer,
	CONSTRAINT fk_checkingID FOREIGN KEY(checkingID) references customer(checkingID),
	balance double precision NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS  savingsBalance CASCADE;
CREATE TABLE savingsBalance(
	id serial PRIMARY KEY,
	savingsID integer,
	CONSTRAINT fk_savingsID FOREIGN KEY(savingsID) references customer(savnigsID),
	balance double precision NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS employee CASCADE;
CREATE TABLE employee(
	employeeNumber serial PRIMARY KEY,
	employeePassword varchar(100) NOT NULL,
	emplyeeFirstName varchar(50) NOT NULL,
	emplyeeLastName varchar(50) NOT NULL
);


DROP TABLE IF EXISTS trasactions CASCADE;
CREATE TABLE trasactions(
	id serial PRIMARY KEY,
	accountID integer NOT null,
	trasancitonAmount double precision NOT NULL CHECK (trasancitonAmount>=0),
	trasancitonType varchar(20) NOT NULL,
	trasanciontPartner integer DEFAULT 0,
	timeCreated time (0) DEFAULT current_timestamp,
	dateCreated date DEFAULT current_date

);

INSERT INTO CUSTOMER (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID, checkingBalance, savingBalance)
VALUES
(1, 'andy', 'mev', 'p@55w0rd', 11, 12, 0, 0),
(2, 'john', 'sen', 'p@55w0rd', 21, 22, 0, 0),
(3, 'amy', 'vis', 'p@55w0rd', 31, 32, 0, 0);

INSERT INTO CUSTOMER (accountNumber, firstName, lastName, customerPassword, checkingID, savnigsID)
VALUES
(4, 'andy', 'mev', 'p@55w0rd', 41, 42),
(5, 'john', 'sen', 'p@55w0rd', 51, 52),
(6, 'amy', 'vis', 'p@55w0rd', 61, 62);

INSERT INTO employee (employeePassword, emplyeeFirstName, emplyeeLastName)
VALUES
('p@55w0rd', 'andy1', 'mev1');


SELECT max(accountNumber) 
FROM customer;

SELECT *
FROM customer;

SELECT *
FROM trasactions;

SELECT *
FROM employee;

SELECT * 
FROM ROC_Banking.customer 
WHERE firstName = 'andy';

SELECT checkingbalance
FROM CUSTOMER
WHERE checkingid=11;

UPDATE CUSTOMER 
SET checkingBalance =50
WHERE checkingid=11;


INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)
VALUES
(11, 1000, 'Deposit', 0);

INSERT INTO roc_banking.trasactions (accountID, trasancitonAmount, trasancitonType, trasanciontPartner)
VALUES
(12, 50, 'Deposit', 0);