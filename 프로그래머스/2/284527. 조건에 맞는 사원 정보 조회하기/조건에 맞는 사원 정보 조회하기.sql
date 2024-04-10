-- 코드를 작성해주세요
with CTE as
(
    select EMP_NO, sum(SCORE) SCORE
    from HR_GRADE
    group by EMP_NO
)

select SCORE,EMP_NO,EMP_NAME,POSITION,EMAIL
from CTE
join HR_EMPLOYEES
using(EMP_NO)
order by SCORE desc
limit 1; 
