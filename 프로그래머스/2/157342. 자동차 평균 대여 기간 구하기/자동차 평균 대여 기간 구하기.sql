-- 코드를 입력하세요

select CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1),1) AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having AVERAGE_DURATION >= 7
order by 2 desc, 1 desc