-- executed after migration for module1, should fail since there is no view in module2 schema
-- however, with auto-commit=false this migration succeeds and drops the view in schema module1

drop view v_foo;