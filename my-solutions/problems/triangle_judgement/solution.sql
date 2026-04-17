# Write your MySQL query statement below
select x, y, z, if(
z+y > x and
x+y > z and
z+x > y, "Yes",
"No") triangle
from Triangle
