-- Last updated: 7/17/2026, 3:15:06 PM
# Write your MySQL query statement below
select player_id,min(event_date) as first_login
from Activity
group by player_id