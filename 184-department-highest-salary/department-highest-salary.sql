
/* Write your T-SQL query statement below */
WITH CTE AS (
    Select D.name as Department, E.name  as Employee, salary,
        RANK() OVER(PARTITION BY D.id order by salary desc) as rn
    FROM Employee E 
    INNER JOIN Department D ON E.departmentId  = D.id
)
Select Department, Employee, salary from CTE where rn  = 1

