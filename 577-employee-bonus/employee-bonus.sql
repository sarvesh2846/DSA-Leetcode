# Write your MySQL query statement below

SELECT E1.name, B1.bonus
FROM Employee E1 LEFT JOIN Bonus  B1
ON B1.empId = E1.empId
WHERE B1.bonus < 1000 OR B1.bonus IS NULL;