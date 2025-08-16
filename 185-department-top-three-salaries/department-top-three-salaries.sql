/* Write your T-SQL query statement below */

WITH CTE AS(
    SELECT D.name as Department , E.name as Employee , salary,
        DENSE_RANK() OVER (PARTITION BY D.name ORDER BY salary DESC) as rnk
    FROM Employee E
    INNER JOIN Department D
    ON E.departmentId = D.id
)
select Department, Employee, salary from CTE where rnk < 4
