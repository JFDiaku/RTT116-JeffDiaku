-- The following statement finds whether the quantity of products, which customers ordered, is odd or even.
SELECT orderNumber, SUM(quantityOrdered) as Qty,
       IF(MOD(SUM(quantityOrdered),2),'odd', 'even') as oddOrEven
FROM    orderdetails
GROUP BY    orderNumber
ORDER BY    orderNumber;


# TRUNCATE() Function
#     Let’s review some examples of using the TRUNCATE() function, using SQL TRUNCATE() with a positive number of decimal places.

SELECT TRUNCATE(1.555,1);

# ROUND() function
# We will use the orderDetails table from the sample database for the demonstration.

SELECT productCode, AVG(quantityOrdered * priceEach) as avg_order_value
FROM orderDetails
GROUP BY productCode;

#For the average values, the number after the decimal point may not be important.
# Therefore, you can use the ROUND() function to round them to zero decimal places, as shown in the following query:


SELECT     productCode,
           ROUND(AVG(quantityOrdered * priceEach)) as avg_order_item_value
FROM     orderDetails
GROUP BY    productCode;


# The syntax of using the REPLACE() function in an UPDATE statement is as follows:


UPDATE products
SET productDescription = REPLACE(productDescription,'abuot','about');

#later date for second argumnet returns negative result
SELECT DATEDIFF('2011-08-17','2023-08-17');

#To select the order’s data and format the date value, you can use the query statement:
SELECT
    orderNumber,
    DATE_FORMAT(orderdate, '%Y-%m-%d') orderDate,
    DATE_FORMAT(requireddate, '%a %D %b %Y') requireddate,
    DATE_FORMAT(shippedDate, '%W %D %M %Y') shippedDate
FROM    orders;






