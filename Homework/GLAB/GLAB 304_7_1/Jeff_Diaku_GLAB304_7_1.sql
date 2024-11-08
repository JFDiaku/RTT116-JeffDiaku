-- Suppose you have to find all employees who are located at the location with the ID 1700. You might come up with the following solution.
-- First, find all departments located at the location_id is 1700:
SELECT  * FROM  departments WHERE  location_id = 1700;
-- According to the result, the departments of 1, 3, 9, 10, and 11 are located at 1700 ID.
-- Secondly, to find employees that belong to the location 1700, we can use the department id list
-- from the previous query, as depicted in the query below.
SELECT  employee_id, first_name, last_name, department_id
FROM   employees
WHERE  department_id IN (1, 3, 9, 10, 11)
ORDER BY first_name, last_name;

-- using WHERE clause
SELECT   employee_id, first_name, last_name, department_id
FROM employees
WHERE department_id IN (SELECT department_id
                        FROM      departments
                        WHERE location_id = 1700)
ORDER BY first_name, last_name;

-- The following example uses a subquery with the NOT IN operator to find all employees' information who do not locate at location 1700.
SELECT employee_id, first_name, last_name
FROM  employees
WHERE  department_id NOT IN (SELECT department_id
                             FROM   departments
                             WHERE location_id = 1700)
ORDER BY first_name , last_name;

-- The following example finds the employees who have the highest salary:
SELECT employee_id, first_name, last_name, salary
FROM   employees
WHERE salary = (SELECT MAX(salary) FROM  employees)
ORDER BY first_name, last_name;


-- The following query finds the employee number, name, and salary for the employees whose
-- salary is higher than the average salary throughout the company:
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary)FROM employees);


--  The following example finds that all departments have at least one employee with a salary greater
--  than 10,000. We will use the Where clause and the EXISTS operator.
SELECT department_name
FROM departments d
WHERE EXISTS ( SELECT * FROM employees e
               WHERE salary > 10000 AND e.department_id = d.department_id)
ORDER BY department_name;

-- Similarly, the following query finds all departments that do not have an employee with a salary greater
-- than 10,000, We will use the Where clause, and the NOT EXISTS operator.
SELECT department_name
FROM departments d
WHERE NOT EXISTS ( SELECT * FROM employees e
                   WHERE salary > 10000 AND e.department_id = d.department_id) ORDER BY department_name;

-- The following query returns the average salary of every department:
SELECT AVG(salary) average_salary
FROM employees GROUP BY department_id;
-- You can use the above query as a subquery in the FROM clause to calculate the average salary of departments as follows:
SELECT ROUND( AVG(average_salary), 0)
FROM  ( SELECT AVG(salary) as average_salary FROM employees   GROUP BY department_id) department_salary;