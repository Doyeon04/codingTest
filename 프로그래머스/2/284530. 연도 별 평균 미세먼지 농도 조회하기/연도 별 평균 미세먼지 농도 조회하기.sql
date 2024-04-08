-- 코드를 작성해주세요

select YEAR(YM) as YEAR, ROUND(avg(PM_VAL1),2) "PM10", ROUND(avg(PM_VAL2),2) "PM2.5"
from AIR_POLLUTION
where LOCATION2 = '수원'
group by YEAR
order by 1 asc

