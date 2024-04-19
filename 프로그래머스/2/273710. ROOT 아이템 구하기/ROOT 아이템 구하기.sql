-- 코드를 작성해주세요
select ITEM_ID, ITEM_NAME
from ITEM_TREE
join ITEM_INFO
using(ITEM_ID)
where PARENT_ITEM_ID is null; 