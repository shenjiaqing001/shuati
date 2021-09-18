CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
RETURN ( --- Write your MySQL query statement below.

    WITH CTE AS
             (
                 SELECT s.Salary as Salary,
                        RANK()      OVER (
      ORDER BY
         s.Salary desc) AS rn
                 FROM (
                          Select *
                          from Employee
                          Group BY Salary
                      ) s
             )
    SELECT MAX(salary) AS SecondHighestSalary
    FROM CTE
    WHERE rn = N);
END

--- ---
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE
M INT;
SET
M = N - 1;
RETURN (
    # Write your MySQL query statement below.

select IFNULL((
                  select Salary
                  from Employee
                  GROUP BY Salary
                  Order by Salary desc LIMIT M, 1 ), NULL)as SecondHighestSalary);
END