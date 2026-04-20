# Write your MySQL query statement below

select id,num from (

select id, sum(num)num from (
select requester_id id, count(accepter_id) num from RequestAccepted
group by requester_id
union all 
select accepter_id id, count(requester_id) num from RequestAccepted
group by accepter_id 
) as t

group by id 
) as b
order by num desc
limit 1
