-- Last updated: 7/17/2026, 3:15:44 PM
# Write your MySQL query statement below
WITH ctl AS (
    SELECT
        id, 
        email,
        ROW_NUMBER() OVER(PARTITION BY email ORDER BY id ASC) AS rankk
    FROM Person
)
DELETE FROM Person
WHERE id IN (
    SELECT id FROM ctl WHERE rankk > 1
);