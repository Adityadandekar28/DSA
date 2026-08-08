# Write your MySQL query statement below
SELECT a.player_id, MIN(event_date) as first_login
FROM Activity as a
GROUP BY a.player_id