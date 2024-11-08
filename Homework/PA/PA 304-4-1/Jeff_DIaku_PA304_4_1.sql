-- Display the name, product line, and buy price of all products. The output columns should display as: “Name,”
-- “Product Line,” and “Buy Price.” The output should display the most expensive items first.

select productName as "Name",
       productLine as "Product Line",
        buyPrice as "Buy Price"
from products
order by
    "Buy Price" desc;


# Display the first name, last name, and city name of all customers from Germany. The output columns
# should display as: “First Name,” “Last Name,” and “City.” The output should be sorted by “Last Name” (ascending).

select contactFirstName as "First Name",
       contactLastName as "Last Name",
       city as "City"
from customers
order by
    "Last Name" desc;


# Display each of the unique values of the status field in the orders table. The output should be sorted alphabetically, ascending.

Select distinct status from orders;


# Display all fields from the payments table for payments made on or after January 1, 2005.
# The output should be sorted by the payment date from highest to lowest.


select * from payments where paymentDate > '2005-01-01'


# Display the last Name, first Name, email address, and job title of all employees
# working out of the San Francisco office. The output should be sorted by “Last Name.”\

select employees.lastName as "Last Name",
       employees.firstName as "First Name",
       employees.email as "email adress",
       employees.jobTitle as "Job Title"

from employees
join offices on employees.officeCode = offices.officeCode
where offices.city = 'San Francisco';


#Display the name, product line, scale, and vendor of all of the car products – both classic and vintage.
# The output should display all vintage cars first (sorted alphabetically by name), and all classic cars last (also sorted alphabetically by name).
select productName as "Name",
       productLine as "Product Line",
       productScale as "Product Scale",
       productVendor as "Product Vendor"
from products
where productLine in ('Vintage Cars', 'Classic cars')
order by
    case
        when productLine = 'Vintage Cars' THEN 1
        when productLine = 'Classic Cars' THEN 2
    end,
    "Name";





