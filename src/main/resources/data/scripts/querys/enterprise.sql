-- Select All enterprise

SELECT * FROM cleanControl.enterprise;

-- select by id

SELECT * FROM cleanControl.enterprise WHERE id = 1;

-- select by name

SELECT * FROM cleanControl.enterprise WHERE name = '';

-- select by active

SELECT * FROM cleanControl.enterprise WHERE active = TRUE;

-- select by adress_id

SELECT * FROM cleanControl.enterprise WHERE address_id = 1;

-- select by city

SELECT * FROM cleanControl.enterprise JOIN address ON enterprise.address_id = address.id WHERE address.city = '';

-- select by state

SELECT * FROM cleanControl.enterprise JOIN address ON enterprise.address_id = address.id WHERE address.state = '';

-- select by city and state

SELECT * FROM cleanControl.enterprise JOIN address ON enterprise.address_id = address.id WHERE address.city = '' AND address.state = '';

