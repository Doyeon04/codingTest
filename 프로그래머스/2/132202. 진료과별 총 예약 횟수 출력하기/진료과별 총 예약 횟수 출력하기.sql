-- 코드를 입력하세요

# SELECT MCDP_CD '진료과 코드', COUNT(*) '5월예약건수'
# FROM APPOINTMENT
# WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
# GROUP BY MCDP_CD
# ORDER BY 2, 1

SELECT MCDP_CD as '진료과코드', count (APNT_NO) as '5월예약건수'
from APPOINTMENT 
where APNT_YMD like "2022-05%"
group by MCDP_CD
having (
    count (distinct APNT_NO)
)
order by count (distinct APNT_NO), MCDP_CD;