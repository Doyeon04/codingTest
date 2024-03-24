-- 코드를 입력하세요
# SELECT ANIMAL_TYPE, COUNT(*) COUNT
# FROM ANIMAL_INS
# GROUP BY ANIMAL_TYPE
# HAVING ANIMAL_TYPE IN ("Cat", "Dog")
# ORDER BY ANIMAL_TYPE


select animal_type, count(*) count
from animal_ins
group by animal_type
order by animal_type