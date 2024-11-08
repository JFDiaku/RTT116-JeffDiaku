SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));


# Write a query to display each customer’s name (as “Customer Name”), along with the name of the employee
# who is responsible for that customer’s orders. The employee name should be in a single “Sales Rep” column, formatted as “lastName, firstName.”
# The output should be sorted alphabetically by customer name.
select c.customerName as 'Customer Name', concat(e.lastName, ', ', e.firstName) as 'Sales Rep'
from customers c JOIN employees e
                      on c.salesRepEmployeeNumber = e.employeeNumber
order by c.customerName asc;

#To determine which products are the most popular with our customers. For each product, list the total quantity ordered, along with the
# total sale generated (total quantity ordered * priceEach) for that product.
# The column headers should be “Product Name,” “Total # Ordered,” and “Total Sale.” List the products by “Total Sale” descending.
select p.productName as 'Product Name', sum(od.quantityOrdered) as 'Total # Ordered', sum(od.quantityOrdered * od.priceEach) as 'Total Sale'
from products p LEFT JOIN orderdetails od
                          on p.productCode=od.productCode
group by p.productName, p.buyPrice
order by 3 desc


#Write a query to display the Name, Product Line, Scale, and Vendor of all of the Car products
# — both classic and vintage. The output should display all vintage cars first (sorted alphabetically by name),
# and all classic cars last (also sorted alphabetically by name).
SELECT p.productName Name, p.productLine AS `Product Line`, p.productScale AS `Scale`, p.productVendor AS `Vendor` FROM productlines l NATURAL JOIN products p
WHERE l.productLine = 'Classic Cars' OR l.productLine = 'Vintage Cars'
ORDER BY p.productLine DESC, p.productName ASC;
