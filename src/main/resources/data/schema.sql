DROP database cleanControl;
CREATE DATABASE cleanControl;
USE cleanControl;
CREATE TABLE IF NOT EXISTS cleanControl.address (
    id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(255) NOT NULL,
    number INT,
    complement VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    cep VARCHAR(9),
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS cleanControl.client (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    date_birth DATE NOT NULL,
    img_url VARCHAR(500) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    address_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.enterprise (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    img_logo VARCHAR(500),
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    address_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.employee_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS cleanControl.employee (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    date_birth DATE NOT NULL,
    employee_type_id INT NOT NULL,
    img_url VARCHAR(500),
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_type_id) REFERENCES employee_type(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    img_url VARCHAR(2000),
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS cleanControl.product_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    img_url VARCHAR(2000),
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    img_url VARCHAR(2000) NOT NULL,
    qtd_stock INT NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    product_type_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (product_type_id) REFERENCES product_type(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.service_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    img_url VARCHAR(2000),
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.services (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    img_url VARCHAR(2000) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    service_type_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (service_type_id) REFERENCES service_type(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.coupon_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS cleanControl.coupon (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    discount DECIMAL(10, 2) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    coupon_type_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (coupon_type_id) REFERENCES coupon_type(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.transaction_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS cleanControl.transaction_client (
    id INT NOT NULL AUTO_INCREMENT,
    total DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    transaction_type_id INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    client_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cleanControl.transaction(
    id INT NOT NULL AUTO_INCREMENT,
    total DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    transaction_type_id INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS cleanControl.event_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS cleanControl.event_emterprise (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500) NOT NULL,
    active BOOLEAN NOT NULL,
    price DECIMAL(10, 2),
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    event_type_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (event_type_id) REFERENCES event_type(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS cleanControl.event_services_enterprise (
    id INT NOT NULL AUTO_INCREMENT,
    event_id INT NOT NULL,
    service_id INT,
    product_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (event_id) REFERENCES event_emterprise(id) ON DELETE CASCADE,
    FOREIGN KEY (service_id) REFERENCES services(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS cleanControl.scheduler_type (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cleanControl.scheduler (
    id INT NOT NULL AUTO_INCREMENT,
    date TIMESTAMP NOT NULL,
    active BOOLEAN NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    enterprise_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE
);

-- Depois adicionar as outras tabelas (agenda, lembretes, niveis de acesso, etc... ) ugga bugga 