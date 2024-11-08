-- For each product, show the product name "Product" and the product type name "Type.
SELECT p.`NAME` AS "Product", pt.`NAME` AS "Type"
FROM product p INNER JOIN product_type pt
                          ON p.product_type_cd = pt.product_type_cd;


--For each branch, list the branch name and city, plus the last name and title of each
-- employee who works in that branch.
SELECT b.`name`, b.city, e.LAST_NAME, e.TITLE
FROM employee e INNER JOIN branch b
                           ON b.BRANCH_ID = e.ASSIGNED_BRANCH_ID;



-- Show a list of each unique employee title.
SELECT distinct TITLE FROM employee;

-- Show the last name and title of each employee, along with the last name and title of that employee's boss.
SELECT e.LAST_NAME AS "Name", e.TITLE AS "Title", m.LAST_NAME AS "Boss Name", m.TITLE AS "Boss Title"
FROM employee e LEFT JOIN employee m
                          ON e.SUPERIOR_EMP_ID = m.EMP_ID;

-- List all account transaction details for individual customers whose last name starts with 'T'.
SELECT ac.*, i.LAST_NAME FROM acc_transaction ac
                                  INNER JOIN account a ON ac.ACCOUNT_ID = a.ACCOUNT_ID
                                  INNER JOIN customer c ON a.CUST_ID = c.CUST_ID
                                  INNER JOIN individual i ON c.CUST_ID = i.CUST_ID
WHERE i.LAST_NAME RLIKE "T.*"; -- same as LIKE "T%"


