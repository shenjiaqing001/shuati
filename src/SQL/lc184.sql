select c.Name as Department, a.Name as Employee, a.Salary
from Employee a
         inner join (
    select DepartmentId, max(Salary) as Salary
    from Employee
    group by DepartmentId
) b on a.Salary = b.Salary and a.DepartmentId = b.DepartmentId
         inner join Department c on a.DepartmentId = c.Id