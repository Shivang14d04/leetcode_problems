# Write your MySQL query statement below
select contest_id, round(count(contest_id)*100 / (select count(user_id) from Users),2)percentage from Register a
group by contest_id
order by percentage desc, contest_id asc;
