-- Select All users

SELECT * FROM cleanControl.users;

-- select by id

SELECT * FROM cleanControl.users WHERE id = 1;


-- Select by email

SELECT * FROM cleanControl.users WHERE email ='';

-- Select by email and password

SELECT * FROM cleanControl.users WHERE email ='' AND password = '';

-- select by user_type_id

SELECT * FROM cleanControl.users WHERE user_type_id = 1;

-- select by user_type_id and active

SELECT * FROM cleanControl.users WHERE user_type_id = 1 AND active = TRUE;

-- select by active

SELECT * FROM cleanControl.users WHERE active = TRUE;