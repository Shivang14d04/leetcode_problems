# Write your MySQL query statement below
(
select b.name results from MovieRating a
left join Users b
on a.user_id = b.user_id
group by a.user_id
order by count(a.user_id) desc, b.name
limit 1
)
union all
(
select d.title results from MovieRating c
left join Movies d on c.movie_id = d.movie_id
where c.created_at like '2020-02%'
group by c.movie_id
order by avg(c.rating) desc, d.title
limit 1
)
