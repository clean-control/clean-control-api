SELECT c.name,
    c.lastname,
    c.email,
    a.street,
    a.number,
    a.city,
    a.state,
    a.cep,
    a.update_date,
    a.create_date
FROM cleanControl.client c
    JOIN cleanControl.address a ON c.address_id = a.id;

    
SELECT p.name,
    p.description,
    p.price,
    pt.name AS product_type,
    c.name AS category
FROM cleanControl.product p
    JOIN cleanControl.product_type pt ON p.product_type_id = pt.id
    JOIN cleanControl.category c ON pt.category_id = c.id;


SELECT e.name,
    e.lastname,
    et.name AS employee_type,
    en.name AS enterprise
FROM cleanControl.employee e
    JOIN cleanControl.employee_type et ON e.employee_type_id = et.id
    JOIN cleanControl.enterprise en ON e.enterprise_id = en.id;


SELECT s.name,
    s.description,
    s.price,
    st.name AS service_type,
    c.name AS category
FROM cleanControl.services s
    JOIN cleanControl.service_type st ON s.service_type_id = st.id
    JOIN cleanControl.category c ON st.category_id = c.id;
