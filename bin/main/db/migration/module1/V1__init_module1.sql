-- executed before migration for module2, should create the view in module1 schema

create view v_foo as select 1;