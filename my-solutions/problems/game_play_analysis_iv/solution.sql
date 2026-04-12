# Write your MySQL query statement below
select round(count(player_id)/ (SELECT count(distinct player_id) from Activity),2) fraction 
from Activity
where (player_id, DATE_SUB(event_date, INTERVAL 1 DAY)) 
IN(
    select player_id, MIN(event_date) from Activity
    group by player_id
);
