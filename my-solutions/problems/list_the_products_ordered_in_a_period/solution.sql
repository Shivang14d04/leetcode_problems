# Write your MySQL query statement below
select a.product_name product_name, sum(b.unit) unit from Products a 
join Orders b 
on a.product_id = b.product_id
where b.order_date like '2020-02-%' 
group by a.product_id 
having sum(b.unit) >= 100