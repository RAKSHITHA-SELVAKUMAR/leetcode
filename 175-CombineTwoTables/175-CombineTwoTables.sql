-- Last updated: 7/17/2026, 3:16:00 PM
# Write your MySQL query statement below
SELECT 
    Person.firstName,
    Person.lastName,
    Address.city,
    Address.state
FROM Person
LEFT JOIN Address
    ON Person.personId = Address.personId;