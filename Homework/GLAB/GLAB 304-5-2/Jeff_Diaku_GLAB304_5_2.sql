
-- Example: “OR” Operator Examples
SELECT    customername, country
FROM    customers
WHERE    country = 'USA' OR country = 'France';

-- Example: “AND” Operator Examples
SELECT    customername, country, creditLimit
FROM    customers
WHERE (country = 'USA' OR country = 'France') AND creditlimit > 100000;

-- Example: BETWEEN and NOT BETWEEN
SELECT     productCode,  productName,  buyPrice
FROM    products
WHERE     buyPrice BETWEEN 90 AND 100;

--  Example:  “IS NULL” Operator
SELECT customerName, country, salesrepemployeenumber
FROM customers
WHERE salesrepemployeenumber IS NULL
ORDER BY  customerName;


SELECT customerName, country, salesrepemployeenumber
FROM  customers
WHERE  salesrepemployeenumber IS NOT NULL
ORDER BY customerName;