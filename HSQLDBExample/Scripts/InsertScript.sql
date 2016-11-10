-- INSERT INTO TableName VALUES(Value1, Value2, ...)
INSERT INTO COFFEE VALUES('Dan Light Roast', '30-001', 11.95);

SELECT * FROM COFFEE;

-- We can specify the COLUMN ORDER during inserts
-- INSERT INTO TableName (ColumnName1, ColumnName2) VALUES (Value1, Value2)
INSERT INTO COFFEE
	(Description, 	   ProdNum,  Price)
VALUES
	('Dan Dark Roast', '30-002', 10.95);