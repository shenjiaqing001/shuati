---Write your MySQL query statement below
WITH CTE AS (
    SELECT s.Score as Score,
           RANK()     OVER (
    ORDER BY s.Score desc) AS rn
    FROM (
             Select *
             from Scores
             Group BY Score
         ) s
)

Select s.Score, rn as 'Rank'
from Scores s
         left join
     CTE c
     on s.Score = c.Score
Order by s.Score desc