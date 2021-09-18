select IFNULL((
    select Salary
    from Employee
    GROUP BY Salary
    Order by Salary desc LIMIT 1 offset 1 ), NULL)as SecondHighestSalary

--- ---

    WITH CTE AS
(
   SELECT
      Salary,
      RANK() OVER (
   ORDER BY
      Salary desc) AS rn
   FROM
      Employee
)
SELECT MAX(salary) AS SecondHighestSalary
FROM CTE
WHERE rn = 2