
-- select All 
SELECT * FROM cleanControl.address;

-- select by id

SELECT * FROM cleanControl.address WHERE id = 1;

-- select by cep

SELECT * FROM cleanControl.address WHERE cep = '';

-- select by street

SELECT * FROM cleanControl.address WHERE street = '';

-- select by street and number

SELECT * FROM cleanControl.address WHERE street = '' AND number = 1;

-- select by street and number and complement

SELECT * FROM cleanControl.address WHERE street = '' AND number = 1 AND complement = '';

-- select by street and number and neighborhood

SELECT * FROM cleanControl.address WHERE street = '' AND number = 1 AND neighborhood = '';

-- select by city

SELECT * FROM cleanControl.address WHERE city = '';

-- select by state

SELECT * FROM cleanControl.address WHERE state = '';

-- select by city and state

SELECT * FROM cleanControl.address WHERE city = '' AND state = '';