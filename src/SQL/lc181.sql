--- Write your MySQL query statement below

select a.Name as 'Employee'
from Employee a
         left join Employee b
                   on a.ManagerId = b.Id
where a.Salary > b.Salary

----

select a.Name as Employee
from Employee a,
     Employee b
where a.ManagerId = b.Id
  and a.Salary > b.Salary