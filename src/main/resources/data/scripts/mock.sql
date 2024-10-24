USE cleanControl;
-- Inserts para a tabela `address`
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
        'Rua A',
        123,
        'Apto 1',
        'Centro',
        'São Paulo',
        'SP',
        '01000-000',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Rua B',
        456,
        NULL,
        'Jardim',
        'Rio de Janeiro',
        'RJ',
        '20000-000',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Avenida C',
        789,
        'Bloco 3',
        'Zona Norte',
        'Belo Horizonte',
        'MG',
        '30000-000',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Praça D',
        101,
        NULL,
        'Centro',
        'Curitiba',
        'PR',
        '40000-000',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `user_type`
INSERT INTO cleanControl.user_type (
        name,
        description,
        create_date,
        update_date
    )
VALUES (
        'Cliente',
        'Usuário que compra produtos e serviços',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Funcionário',
        'Usuário que trabalha na empresa',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Administrador',
        'Usuário com acesso total ao sistema',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Fornecedor',
        'Usuário que fornece produtos e serviços',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `users`
INSERT INTO cleanControl.users (
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
        address_id,
        user_type_id
    )
VALUES (
        'João',
        'Silva',
        'joao.s',
        'joao@example.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        '12345678900',
        '11999999999',
        '1990-01-01',
        'http://example.com/images/joao.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        1
    ),
    (
        'Maria',
        'Souza',
        'maria.s',
        'maria@example.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        '23456789012',
        '21999999999',
        '1985-05-15',
        'http://example.com/images/maria.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2,
        2
    ),
    (
        'Pedro',
        'Lima',
        'pedro.l',
        'pedro@example.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        '34567890123',
        '31999999999',
        '1992-09-30',
        'http://example.com/images/pedro.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        3,
        3
    ),
    (
        'Ana',
        'Pereira',
        'ana.p',
        'ana@example.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        '45678901234',
        '41999999999',
        '1988-12-12',
        'http://example.com/images/ana.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        4,
        4
    );
-- Inserts para a tabela `client`
INSERT INTO cleanControl.client (users_id, create_date, update_date)
VALUES (1, '2023-01-01 10:00:00', '2023-01-01 10:00:00'),
    (2, '2023-01-01 10:00:00', '2023-01-01 10:00:00'),
    (3, '2023-01-01 10:00:00', '2023-01-01 10:00:00'),
    (4, '2023-01-01 10:00:00', '2023-01-01 10:00:00');
-- Inserts para a tabela `enterprise`
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
        'Empresa A',
        '12345678000195',
        '11988888888',
        'contato@empresaA.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        'http://example.com/images/empresaA.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1
    ),
    (
        'Empresa B',
        '98765432000196',
        '21988888888',
        'contato@empresaB.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        'http://example.com/images/empresaB.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2
    ),
    (
        'Empresa C',
        '12345678000197',
        '31988888888',
        'contato@empresaC.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        'http://example.com/images/empresaC.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        3
    ),
    (
        'Empresa D',
        '98765432000198',
        '41988888888',
        'contato@empresaD.com',
        '2a$10$29IZeSvs9TEXP2EaJefatuRTAZhCshmGyPb6PWMeJNROj94uPd9ta',
        'http://example.com/images/empresaD.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        4
    );
-- Inserts para a tabela `employee_type`
INSERT INTO cleanControl.employee_type (
        name,
        description,
        active,
        create_date,
        update_date
    )
VALUES (
        'Gerente',
        'Responsável pela equipe',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Atendente',
        'Atendimento ao cliente',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Estilista',
        'Corte e estilo de cabelo',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Vendedor',
        'Venda de produtos e serviços',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `employee`
INSERT INTO cleanControl.employee (
        users_id,
        employee_type_id,
        create_date,
        update_date,
        enterprise_id
    )
VALUES (
        1,
        1,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1
    ),
    (
        2,
        2,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1
    ),
    (
        3,
        3,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2
    ),
    (
        4,
        4,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        3
    );
-- Inserts para a tabela `category`
INSERT INTO cleanControl.category (
        name,
        description,
        img_url,
        active,
        create_date,
        update_date
    )
VALUES (
        'Cabelo',
        'Produtos e serviços para cabelo',
        'http://example.com/images/cabelo.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Beleza',
        'Produtos e serviços de beleza',
        'http://example.com/images/beleza.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Saúde',
        'Produtos para saúde e bem-estar',
        'http://example.com/images/saude.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Fitness',
        'Produtos e serviços de fitness',
        'http://example.com/images/fitness.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `product_type`
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
        'Shampoo',
        'Produto para lavar o cabelo',
        1,
        'http://example.com/images/shampoo.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Condicionador',
        'Produto para condicionar o cabelo',
        1,
        'http://example.com/images/condicionador.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Maquiagem',
        'Produtos de maquiagem',
        2,
        'http://example.com/images/maquiagem.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Suplementos',
        'Suplementos alimentares',
        3,
        'http://example.com/images/suplementos.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `product`
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
        'Shampoo Anti-resíduos',
        'Remove impurezas do cabelo',
        50.00,
        'http://example.com/images/shampoo.jpg',
        100,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        1
    ),
    (
        'Condicionador Hidratante',
        'Hidrata e suaviza os fios',
        45.00,
        'http://example.com/images/condicionador.jpg',
        100,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        2
    ),
    (
        'Base Líquida',
        'Base para maquiagem',
        80.00,
        'http://example.com/images/base.jpg',
        50,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2,
        3
    ),
    (
        'Whey Protein',
        'Suplemento proteico',
        150.00,
        'http://example.com/images/whey.jpg',
        30,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        3,
        4
    );
-- Inserts para a tabela `service_type`
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
        'Corte de Cabelo',
        'Corte e estilo de cabelo',
        1,
        'http://example.com/images/corte.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Maquiagem',
        'Serviço de maquiagem',
        2,
        'http://example.com/images/maquiagem.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Consulta de Saúde',
        'Consulta com especialista',
        3,
        'http://example.com/images/consulta.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Treinamento Funcional',
        'Treino personalizado',
        4,
        'http://example.com/images/treinamento.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `services`
INSERT INTO cleanControl.services (
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
        'Corte Simples',
        'Corte de cabelo simples',
        30.00,
        'http://example.com/images/corte_simples.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        1
    ),
    (
        'Corte e Penteado',
        'Corte com penteado',
        70.00,
        'http://example.com/images/corte_penteado.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        1
    ),
    (
        'Maquiagem Completa',
        'Maquiagem para festas',
        100.00,
        'http://example.com/images/maquiagem_completa.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2,
        2
    ),
    (
        'Consulta de Saúde Geral',
        'Consulta com clínico geral',
        150.00,
        'http://example.com/images/consulta_geral.jpg',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        3,
        3
    );
-- Inserts para a tabela `coupon_type`
INSERT INTO cleanControl.coupon_type (
        name,
        description,
        active,
        create_date,
        update_date
    )
VALUES (
        'Desconto em Produto',
        'Desconto em produtos da loja',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Desconto em Serviço',
        'Desconto em serviços oferecidos',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Promoção de Aniversário',
        'Desconto especial para aniversariantes',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Desconto em Combo',
        'Desconto ao comprar produtos e serviços juntos',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `coupon`
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
        '10% OFF Produtos',
        'Desconto de 10% em produtos',
        10.00,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        1
    ),
    (
        '15% OFF Serviços',
        'Desconto de 15% em serviços',
        15.00,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        2
    ),
    (
        'Aniversariante do Mês',
        'Desconto especial para aniversariantes',
        20.00,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2,
        3
    ),
    (
        'Combo Desconto',
        'Desconto ao comprar combo de produtos e serviços',
        25.00,
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2,
        4
    );
-- Inserts para a tabela `transaction_type`
INSERT INTO cleanControl.transaction_type (
        name,
        description,
        active,
        create_date,
        update_date
    )
VALUES (
        'Venda',
        'Transação de venda de produto ou serviço',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Devolução',
        'Transação de devolução de produto',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Ajuste',
        'Ajuste de valor em transação',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    ),
    (
        'Pagamento',
        'Transação de pagamento de conta',
        TRUE,
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00'
    );
-- Inserts para a tabela `transaction`
INSERT INTO cleanControl.transaction (
        total,
        payment_method,
        transaction_type_id,
        status,
        create_date,
        update_date,
        enterprise_id,
        client_id
    )
VALUES (
        100.00,
        'Cartão de Crédito',
        1,
        'Completo',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        1
    ),
    (
        200.00,
        'Dinheiro',
        1,
        'Completo',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        1,
        2
    ),
    (
        50.00,
        'Cartão de Débito',
        1,
        'Completo',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        2,
        3
    ),
    (
        150.00,
        'Transferência',
        1,
        'Completo',
        '2023-01-01 10:00:00',
        '2023-01-01 10:00:00',
        4,
        4
    );