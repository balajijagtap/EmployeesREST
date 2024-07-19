use employeeDB;

insert into employees
values
('imandi','{noop}fun123','ROLE_MANAGER', NULL, 1);

UPDATE `employees`
SET `username` = 'harsha', `password` = '{noop}fun123'
WHERE `username` = 'harsha';

select * from employees;

delete from `employees` where `username` = 'srinivas';