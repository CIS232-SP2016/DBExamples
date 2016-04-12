-- This is a comment.
-- getting coffees with price over 10
SELECT * FROM Coffee WHERE Price > 10;

-- getting coffee with price equal to 7.95
SELECT * FROM Coffee WHERE Price = 7.95;

-- getting coffee WITH price NOT equal TO 7.95
SELECT * FROM Coffee WHERE Price <> 7.95;

-- find bolivian dark
SELECT * FROM Coffee WHERE Description = 'Bolivian Dark';

-- case insensitive by using upper
SELECT * FROM Coffee WHERE upper(Description) = upper('Bolivian dark');

-- wildcard searches
SELECT * FROM Coffee WHERE Description LIKE 'Bolivian%';

SELECT * FROM Coffee WHERE Description LIKE '%Dark%';

SELECT * FROM Coffee WHERE ProdNum LIKE '2_-00_%';

-- AND and OR
-- find all coffees between 5 and 10 dollars
SELECT * FROM Coffee WHERE Price > 5.00 AND Price < 10.00;

-- find all coffees less than 5 and greater than 10 dollars
SELECT * FROM Coffee WHERE Price <= 5.00 OR Price >= 10.00;

-- Order results
SELECT 
	Description,
	ProdNum,
	Price
FROM Coffee 
WHERE Price > 10.00
ORDER BY Price DESC;

-- Mathematical functions
SELECT 
	AVG(Price) AS AveragePrice, -- Average Price
	SUM(Price) AS PriceTotal, -- Total price of all
	MIN(Price) AS MinimumPrice, -- minimum price
	MAX(Price) AS MaximumPrice,
	Count(*) AS CoffeeCount
FROM Coffee
WHERE ProdNum LIKE '2_-00_%';
