/* Write your T-SQL query statement below */



Select MAX(salary) AS SecondHighestSalary  from Employee
where salary NOT IN (Select MAX(salary) from Employee)
