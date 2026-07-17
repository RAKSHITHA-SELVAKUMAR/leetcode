-- Last updated: 7/17/2026, 3:15:58 PM
# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;