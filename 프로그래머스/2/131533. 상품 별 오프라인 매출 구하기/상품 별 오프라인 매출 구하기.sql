-- 코드를 입력하세요
# SELECT PRODUCT_CODE, SUM(PRICE*SALES_AMOUNT) AS SALES # 상품 코드 별 매출액
# FROM PRODUCT P
# JOIN OFFLINE_SALE O
# ON P.PRODUCT_ID = O.PRODUCT_ID
# GROUP BY PRODUCT_CODE # 상품 코드 별
# ORDER BY SALES DESC, PRODUCT_CODE ASC

select PRODUCT_CODE, sum(PRICE*SALES_AMOUNT) as SALES
from PRODUCT p
join OFFLINE_SALE o
on p.PRODUCT_ID = o.PRODUCT_ID
group by PRODUCT_CODE
order by 2 desc, 1
