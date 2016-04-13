-- INSERT a NEW coffee
INSERT INTO Coffee VALUES ('Dan''s discount coffee', '22-003', 3.95);

INSERT INTO Coffee VALUES ('Dan''s masterpiece coffee', '22-002', 20.50);

-- INSERT coffee WITH ORDER specified
INSERT INTO Coffee 
	(ProdNum, Description, Price)
VALUES 
	('22-004', 'Dan''s Dark', 7.95);
	
-- Only insert some values
INSERT INTO Coffee
	(ProdNum, Price)
VALUES
	('22-005', 9.99);
	