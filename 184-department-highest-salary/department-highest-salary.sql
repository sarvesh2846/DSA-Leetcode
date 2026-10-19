# Write your MySQL query statement below

SELECT
    (SELECT name
     FROM Department D1
     WHERE D1.id = E1.departmentId) AS Department,
    E1.name AS Employee,
    E1.salary AS Salary
FROM Employee E1
WHERE E1.salary = (
    SELECT MAX(E2.salary)
    FROM Employee E2
    WHERE E2.departmentId = E1.departmentId
);