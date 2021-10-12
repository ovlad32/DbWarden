### Run project
```
node-dev ./src/index.js
```

select row_to_json(t) from (
select t.*,
  (select jsonb_agg(c) as  columns
from column_info c where c.table_info_id = t.id) 	
  from table_info t 
where t.id = 9
) as t

select row_to_json(r) from (
select c.*,(select row_to_json(t) as table_info from table_info t where t.id = c.table_info_id) 
from column_info c where c.id = 50
) as r
