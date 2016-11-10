SELECT * FROM Coffee;

-- When Updating make sure you have a WHERE criteria, or else you will update every row!
-- UPDATE TableName SET ColumnName1 = Value1, ColumnName2 = Value2 WHERE Criteria;

UPDATE COFFEE
SET PRICE = 11.95,
	Description = 'More expensive coffee'
WHERE PRODNUM = '14-001';

-- Deleting rows (also make sure you have a where criteria)
-- DELETE FROM TableName WHERE Criteria

DELETE FROM COFFEE
WHERE Description = 'Bolivian Medium';

