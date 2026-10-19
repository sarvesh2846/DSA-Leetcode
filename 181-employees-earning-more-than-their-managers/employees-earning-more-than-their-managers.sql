# Write your MySQL query statement below

# Co-Related Subquery 
-- SELECT name AS Employee
-- FROM Employee E1
-- WHERE salary > (SELECT salary 
--                 FROM Employee E2
--                 WHERE E2.id = E1.managerId);

SELECT E1.name AS Employee
FROM Employee E1 JOIN Employee E2
ON E1.managerId = E2.id
WHERE E1.salary > E2.salary;