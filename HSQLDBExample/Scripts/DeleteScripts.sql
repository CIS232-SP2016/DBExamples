-- DELETE expensive coffees
DELETE FROM Coffee
WHERE Price > 12;

-- DELETE BY product number
DELETE FROM Coffee
WHERE ProdNum = '22-003';

-- DELETE Everything
DELETE FROM Coffee;