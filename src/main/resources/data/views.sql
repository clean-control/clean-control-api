-- ? teste de view de serviços com categoria
CREATE VIEW cleanControl.services_category_view AS
SELECT s.id AS service_id,
    s.name AS service_name,
    s.description AS service_description,
    s.price AS service_price,
    s.img_url AS service_img_url,
    s.active AS service_active,
    s.create_date AS service_create_date,
    s.update_date AS service_update_date,
    c.id AS category_id,
    c.name AS category_name,
    c.description AS category_description,
    c.img_url AS category_img_url,
    c.active AS category_active,
    c.create_date AS category_create_date,
    c.update_date AS category_update_date
FROM cleanControl.services s
    JOIN cleanControl.service_type st ON s.service_type_id = st.id
    JOIN cleanControl.category c ON st.category_id = c.id;



-- ? teste de view de dashboard pra empresa
CREATE VIEW enterprise_dashboard_view AS
SELECT e.id AS enterprise_id,
    e.name AS enterprise_name,
    e.active AS enterprise_active,
    e.create_date AS enterprise_create_date,
    e.update_date AS enterprise_update_date,
    p.name AS product_name,
    p.description AS product_description,
    p.price AS product_price,
    p.img_url AS product_img_url,
    p.qtd_stock AS product_qtd_stock,
    p.active AS product_active,
    p.create_date AS product_create_date,
    p.update_date AS product_update_date,
    s.name AS service_name,
    s.description AS service_description,
    s.price AS service_price,
    s.img_url AS service_img_url,
    s.active AS service_active,
    s.create_date AS service_create_date,
    s.update_date AS service_update_date,
    SUM(t.total) AS total_transaction
FROM cleanControl.enterprise e
    JOIN cleanControl.product p ON e.id = p.enterprise_id
    JOIN cleanControl.services s ON e.id = s.enterprise_id
    JOIN cleanControl.transaction t ON e.id = t.enterprise_id
GROUP BY e.id,
    e.name,
    e.active,
    e.create_date,
    e.update_date,
    p.name,
    p.description,
    p.price,
    p.img_url,
    p.qtd_stock,
    p.active,
    p.create_date,
    p.update_date,
    s.name,
    s.description,
    s.price,
    s.img_url,
    s.active,
    s.create_date,
    s.update_date;