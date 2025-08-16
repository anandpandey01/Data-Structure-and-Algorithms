WITH CTE AS (
    SELECT managerId FROM Employee
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5
)
SELECT E.name AS 'name' 
FROM CTE C
INNER JOIN Employee E ON E.id = C.managerId;