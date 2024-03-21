# -- 코드를 입력하세요

# SELECT COUNT(DISTINCT NAME)
# FROM ANIMAL_INS

SELECT COUNT(DISTINCT NAME) COUNT
FROM ANIMAL_INS

# SELECT COUNT(*)
# FROM
# (
#     SELECT NAME
#     FROM ANIMAL_INS
#     GROUP BY NAME
#     HAVING NAME IS NOT NULL 
# ) T

# COUNT는 *가 아니면 null을 세지 않음

# SELECT COUNT(NAME)
# FROM
# (
#     SELECT NAME
#     FROM ANIMAL_INS
#     GROUP BY NAME
# ) T