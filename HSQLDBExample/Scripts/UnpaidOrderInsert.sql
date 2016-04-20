SELECT * FROM COFFEE;
SELECT * FROM CUSTOMER;

INSERT INTO UnpaidOrder
	(ProdNum, CustomerNumber, OrderDate, Quantity, Cost)
VALUES
	('16-001', '101', '2016-03-31', 2, 18.00);
	
INSERT INTO UnpaidOrder
	(ProdNum, CustomerNumber, OrderDate, Quantity, Cost)
VALUES
	('16-001', '102', '2016-03-31', 2, 19.90);
	
INSERT INTO UnpaidOrder
	(ProdNum, CustomerNumber, OrderDate, Quantity, Cost)
VALUES
	('21-002', '101', '2016-01-31', 3, 30.00);
