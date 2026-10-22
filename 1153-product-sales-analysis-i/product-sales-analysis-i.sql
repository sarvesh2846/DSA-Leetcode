# Write your MySQL query statement below

SELECT P1.product_name, S1.year, S1.price 
FROM Sales S1 INNER JOIN Product P1
ON S1.product_id = P1.product_id 
