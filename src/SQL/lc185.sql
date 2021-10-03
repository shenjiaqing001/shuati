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

-------------

    WITH CTE AS(
    SELECT s.Salary as Salary, s.DepartmentId as DepartmentId,
            RANK() OVER (
                PARTITION BY s.DepartmentId ORDER BY s.Salary desc ) as rn
            from (
                SELECT  * from Employee GROUP  BY Salary, DepartmentId
            )s
)

select d.Name as Department, e.Name as Employee, e.Salary
from Employee e
         left join Department d on e.DepartmentId = d.id
         left join CTE c on e.Salary = c.Salary and e.DepartmentId = c.DepartmentId
where c.rn <= 3