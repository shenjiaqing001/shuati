---
Weather
table:
+----+------------+-------------+
| Id | RecordDate | Temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
---

select a.id
from Weather a,
     Weather b
where TO_DAYS(a.RecordDate) = TO_DAYS(b.RecordDate) + 1
  and a.Temperature > b.Temperature