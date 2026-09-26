# Write your MySQL query statement below
SELECT w1.id 
from Weather  w1
join Weather  w2
where  SUBDATE(w1.recordDate ,1)=w2.recordDate
AND w1.temperature >w2.temperature
