select ITEM_ID, ITEM_NAME, RARITY
from ITEM_TREE
join ITEM_INFO
using(ITEM_ID)
where PARENT_ITEM_ID 
in 
    (select ITEM_ID
    from ITEM_INFO
    where RARITY = 'RARE'
    )
order by 1 desc