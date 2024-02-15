INSERT INTO super_mercado (nome, cnpj, email)
VALUES ('Supermercado A', '123456789', 'jonhvector0111@gmail.com');
INSERT INTO super_mercado (nome, cnpj, email)
VALUES ('Supermercado B', '123453789', 'supermercadoB@example.com');





INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Arroz', 'Tio João', 'ARZ123', 10.99, 1, 50, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Feijão', 'Camil', 'FEI456', 5.99, 1, 40, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Macarrão', 'Piraquê', 'MAC789', 3.99, 1, 60, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Leite', 'Nestlé', 'LEI234', 2.99, 1, 35, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Biscoito', 'Oreo', 'BIS567', 4.49, 1, 45, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Iogurte', 'Danone', 'IOG890', 1.99, 1, 55, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Azeite', 'Borges', 'AZE123', 7.99, 1, 30, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Café', '3 Corações', 'CAF456', 8.49, 1, 70, 1);

INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Açúcar', 'União', 'ACU789', 3.49, 1, 50, 1);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Molho de Tomate', 'Quero', 'MOL012', 2.79, 1, 40, 1);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Cerveja', 'Skol', 'CER123', 3.99, 12, 120, 1);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Refrigerante', 'Coca-Cola', 'REF456', 4.49, 6, 60, 1);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Sabonete', 'Dove', 'SAB789', 2.99, 3, 90, 1);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Papel Higiênico', 'Neve', 'PAH012', 5.99, 4, 40, 1);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Shampoo', 'Pantene', 'SHA345', 7.99, 2, 50, 1);

INSERT INTO lote (data_compra, quantidade_recebida)
VALUES ('2023-01-01', 150);

INSERT INTO lote (data_compra, quantidade_recebida)
VALUES ('2023-02-05', 200);


INSERT INTO lote (data_compra, quantidade_recebida)
VALUES ('2023-03-10', 250);


INSERT INTO lote (data_compra, quantidade_recebida)
VALUES ('2023-04-15', 180);

INSERT INTO lote (data_compra, quantidade_recebida)
VALUES ('2023-05-20', 220);


INSERT INTO produto (nome, marca, codigo, valor, quantidade_unidade, quantidade, id_super_mercado)
VALUES ('Desodorante', 'Rexona', 'DEO678', 3.49, 5, 70, 1);
INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 1, '2023-06-01');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 2, '2023-07-15');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 3, '2023-08-30');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 4, '2023-09-22');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 5, '2023-10-10');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 6, '2023-11-05');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 7, '2023-12-18');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 8, '2024-01-12');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 9, '2024-02-28');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 10, '2024-03-20');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (NULL, 11, '2024-04-06');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (1, 12, '2024-05-15');

INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (2, 13, '2024-06-25');


INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (3, 14, '2024-07-30');


INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (4, 15, '2023-06-10');


INSERT INTO controle_produto (id_lote, id_produto, data_vencimento)
VALUES (5, 16, '2023-07-20');

INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('2', 1, 'RAPIDO', 1);


INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('3', 1, 'COMUM', 0);

INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('4', 1, 'TOTEM', 1);




