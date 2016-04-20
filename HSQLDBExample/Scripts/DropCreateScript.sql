DROP TABLE IF EXISTS Meat;

CREATE TABLE Meat 
(
	ProdNum CHAR(10) NOT NULL PRIMARY KEY,
	Name VARCHAR(50),
	FatGrams DOUBLE,
	Price DOUBLE
);

INSERT INTO Meat
	(ProdNum, Name, FatGrams, Price)
VALUES
	(
		'01-001',
		'Bacon',
		40,
		8.00
	);
	
SELECT * FROM MEAT;