INSERT INTO cleanControl.address (
        street,
        number,
        complement,
        neighborhood,
        city,
        state,
        cep,
        create_date,
        update_date
    )
VALUES (
        'Rua das Flores',
        123,
        'Apt 101',
        'Centro',
        'São Paulo',
        'SP',
        '01000-000',
        NOW(),
        NOW()
    ),
    (
        'Avenida Brasil',
        456,
        'Bloco B',
        'Zona Norte',
        'Rio de Janeiro',
        'RJ',
        '02000-000',
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.client (
        name,
        lastname,
        nickname,
        email,
        password,
        cpf,
        phone,
        date_birth,
        img_url,
        active,
        create_date,
        update_date,
        address_id
    )
VALUES (
        'João',
        'Silva',
        'joaos',
        'joao@example.com',
        'senha123',
        '12345678901',
        '11999999999',
        '1990-01-01',
        'http://example.com/joao.jpg',
        TRUE,
        NOW(),
        NOW(),
        1
    ),
    (
        'Maria',
        'Oliveira',
        'mariao',
        'maria@example.com',
        'senha123',
        '98765432100',
        '21999999999',
        '1985-05-05',
        'http://example.com/maria.jpg',
        TRUE,
        NOW(),
        NOW(),
        2
    );
INSERT INTO cleanControl.enterprise (
        name,
        cnpj,
        phone,
        email,
        password,
        img_logo,
        active,
        create_date,
        update_date,
        address_id
    )
VALUES (
        'Empresa X',
        '12345678000100',
        '1133334444',
        'contato@empresax.com',
        'senha123',
        'http://example.com/empresax.jpg',
        TRUE,
        NOW(),
        NOW(),
        1
    ),
    (
        'Empresa Y',
        '98765432000100',
        '2133334444',
        'contato@empresay.com',
        'senha123',
        'http://example.com/empresay.jpg',
        TRUE,
        NOW(),
        NOW(),
        2
    );
INSERT INTO cleanControl.employee_type (
        name,
        description,
        active,
        create_date,
        update_date
    )
VALUES (
        'Admin',
        'Administrador do sistema',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Operacional',
        'Funcionário operacional',
        TRUE,
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.employee (
        name,
        lastname,
        nickname,
        email,
        password,
        cpf,
        phone,
        date_birth,
        employee_type_id,
        img_url,
        active,
        create_date,
        update_date,
        enterprise_id
    )
VALUES (
        'Carlos',
        'Pereira',
        'carlosp',
        'carlos@example.com',
        'senha123',
        '32165498701',
        '11988888888',
        '1992-02-02',
        1,
        'http://example.com/carlos.jpg',
        TRUE,
        NOW(),
        NOW(),
        1
    ),
    (
        'Ana',
        'Souza',
        'anas',
        'ana@example.com',
        'senha123',
        '65498732100',
        '21988888888',
        '1988-08-08',
        2,
        'http://example.com/ana.jpg',
        TRUE,
        NOW(),
        NOW(),
        2
    );
INSERT INTO cleanControl.category (
        name,
        description,
        img_url,
        active,
        create_date,
        update_date
    )
VALUES (
        'Limpeza',
        'Produtos de limpeza',
        'http://example.com/limpeza.jpg',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Higiene',
        'Produtos de higiene pessoal',
        'http://example.com/higiene.jpg',
        TRUE,
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.product_type (
        name,
        description,
        category_id,
        img_url,
        active,
        create_date,
        update_date
    )
VALUES (
        'Detergente',
        'Detergente líquido',
        1,
        'http://example.com/detergente.jpg',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Sabonete',
        'Sabonete em barra',
        2,
        'http://example.com/sabonete.jpg',
        TRUE,
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.product (
        name,
        description,
        price,
        img_url,
        qtd_stock,
        active,
        create_date,
        update_date,
        enterprise_id,
        product_type_id
    )
VALUES (
        'Detergente Azul',
        'Detergente para louças',
        5.50,
        'http://example.com/detergente_azul.jpg',
        100,
        TRUE,
        NOW(),
        NOW(),
        1,
        1
    ),
    (
        'Sabonete Floral',
        'Sabonete com fragrância floral',
        2.75,
        'http://example.com/sabonete_floral.jpg',
        200,
        TRUE,
        NOW(),
        NOW(),
        2,
        2
    );
INSERT INTO cleanControl.service_type (
        name,
        description,
        category_id,
        img_url,
        active,
        create_date,
        update_date
    )
VALUES (
        'Limpeza Residencial',
        'Serviço de limpeza para residências',
        1,
        'http://example.com/limpeza_residencial.jpg',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Limpeza Comercial',
        'Serviço de limpeza para empresas',
        1,
        'http://example.com/limpeza_comercial.jpg',
        TRUE,
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.service (
        name,
        description,
        price,
        img_url,
        active,
        create_date,
        update_date,
        enterprise_id,
        service_type_id
    )
VALUES (
        'Limpeza Completa',
        'Limpeza geral da residência',
        150.00,
        'http://example.com/limpeza_completa.jpg',
        TRUE,
        NOW(),
        NOW(),
        1,
        1
    ),
    (
        'Limpeza Escritório',
        'Limpeza de escritório',
        250.00,
        'http://example.com/limpeza_escritorio.jpg',
        TRUE,
        NOW(),
        NOW(),
        2,
        2
    );
INSERT INTO cleanControl.coupon_type (
        name,
        description,
        active,
        create_date,
        update_date
    )
VALUES (
        'Desconto',
        'Cupom de desconto',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Frete Grátis',
        'Cupom de frete grátis',
        TRUE,
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.coupon (
        name,
        description,
        discount,
        active,
        create_date,
        update_date,
        enterprise_id,
        coupon_type_id
    )
VALUES (
        'CUPOM10',
        '10% de desconto',
        10.00,
        TRUE,
        NOW(),
        NOW(),
        1,
        1
    ),
    (
        'FRETEGRATIS',
        'Frete grátis para compras acima de R$100',
        0.00,
        TRUE,
        NOW(),
        NOW(),
        2,
        2
    );
INSERT INTO cleanControl.transaction_type (
        name,
        description,
        active,
        create_date,
        update_date
    )
VALUES (
        'Venda',
        'Transação de venda',
        TRUE,
        NOW(),
        NOW()
    ),
    (
        'Compra',
        'Transação de compra',
        TRUE,
        NOW(),
        NOW()
    );
INSERT INTO cleanControl.transaction_client (
        total,
        payment_method,
        transaction_type_id,
        status,
        create_date,
        update_date,
        client_id
    )
VALUES (
        150.00,
        'Cartão de Crédito',
        1,
        'Concluída',
        NOW(),
        NOW(),
        1
    ),
    (250.00, 'Boleto', 1, 'Pendente', NOW(), NOW(), 2);
INSERT INTO cleanControl.transaction (
        total,
        payment_method,
        transaction_type_id,
        status,
        create_date,
        update_date,
        enterprise_id
    )
VALUES (
        500.00,
        'Cartão de Crédito',
        1,
        'Concluída',
        NOW(),
        NOW(),
        1
    ),
    (300.00, 'Boleto', 1, 'Pendente', NOW(), NOW(), 2);