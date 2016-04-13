-- example update
UPDATE Coffee
	SET Description = 'Dan''s Light',
		Price = 3.33
	WHERE ProdNum = '22-005';
	
-- second example with multiple rows updating
UPDATE Coffee
	SET Price = .8 * Price
	WHERE ProdNum LIKE '14-%';
	