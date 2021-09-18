select Email
from (
         select Email, count(Email) as cnt
         from Person
         group by Email
     ) a
where a.cnt > 1
----

select Email
from Person
group by Email
having count(Email) > 1