SELECT
	Customer.Name,
	UnpaidOrder.Cost,
	Coffee.Description
FROM UnpaidOrder, Customer, Coffee
WHERE UnpaidOrder.CustomerNumber = Customer.CustomerNumber
	AND UnpaidOrder.ProdNum = Coffee.ProdNum;
	
SELECT 
	SUM(Cost) AS TotalCost
FROM UnpaidOrder, Customer
WHERE UnpaidOrder.CustomerNumber = Customer.CustomerNumber
	AND Customer.Name = 'Downtown Cafe';