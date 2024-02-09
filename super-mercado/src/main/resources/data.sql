INSERT INTO super_mercado (nome, cnpj, email)
VALUES ('Supermercado A', '123456789', 'supermercadoa@example.com');
INSERT INTO super_mercado (nome, cnpj, email)
VALUES ('Supermercado B', '123453789', 'supermercadoB@example.com');

INSERT INTO endereco (logradouro, cep, uf, id_super_mercado)
VALUES ('Rua Exemplo', '123','SP', 1);


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

INSERT INTO cliente (nome, data_nascimento, cpf) VALUES
('João da Silva', '1990-05-15', '12345678910'),
('Maria Oliveira', '1985-09-20', '98765432100'),
('Pedro Santos', '1978-03-10', '11122233344'),
('Ana Souza', '2000-12-25', '55566677788'),
('Lucas Pereira', '1992-07-07', '99988877766'),
('Carla Silva', '1983-11-30', '44433322211'),
('Paulo Oliveira', '1975-02-18', '77788899900'),
('Fernanda Santos', '1998-08-05', '22211100099'),
('Rafaela Lima', '1980-06-12', '66655544433'),
('Gustavo Almeida', '1993-04-03', '88899900011');



INSERT INTO funcionario (nome, cpf, numero_carteira, id_super_mercado)
VALUES ('João Silva', '12345678901', 'CT123', 1);

INSERT INTO funcionario (nome, cpf, numero_carteira, id_super_mercado)
VALUES ('Maria Santos', '98765432109', 'CT456', 1);

INSERT INTO funcionario (nome, cpf, numero_carteira, id_super_mercado)
VALUES ('Pedro Oliveira', '45678912345', 'CT789', 1);

INSERT INTO funcionario (nome, cpf, numero_carteira, id_super_mercado)
VALUES ('Ana Costa', '78912345678', 'CT012', 1);

INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('1', 1, 'PREFERENCIAL', 1);

INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('2', 1, 'RAPIDO', 1);


INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('3', 1, 'COMUM', 0);

INSERT INTO caixa (numero, id_super_mercado, tipo_caixa, status)
VALUES ('4', 1, 'TOTEM', 1);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (1, 1, '2023-06-01 09:00:00', '2023-06-01 18:00:00', 100.00, 150.00);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (2, 2, '2023-06-02 08:30:00', '2023-06-02 17:30:00', 150.00, null);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (null, 4, '2023-06-03 10:00:00', '2023-06-03 19:00:00', 200.00, 300.00);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (3, 3, '2023-06-04 09:30:00', '2023-06-04 18:30:00', 180.00, null);


INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (1, 3, '2024-06-05 08:00:00', '2024-06-05 17:00:00', 120.00, 180.00);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (2, 2, '2023-12-06 09:30:00', '2023-12-06 18:30:00', 200.00, null);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (3, 1, '2022-06-07 10:00:00', '2022-06-07 19:00:00', 150.00, 250.00);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (null, 4, '2023-06-08 08:30:00', '2023-06-08 17:30:00', 180.00, null);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (4, 1, '2025-06-09 09:00:00', '2025-06-09 18:00:00', 160.00, 220.00);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (1, 2, '2023-06-10 07:30:00', '2023-06-10 16:30:00', 140.00, null);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (2,2, '2023-06-11 08:00:00', '2023-06-11 17:00:00', 200.00, 280.00);

INSERT INTO jornada (id_funcionario, id_caixa, horario_abertura, horario_fechamento, valor_inicial, valor_final)
VALUES (3, 1, '2023-06-12 09:30:00', '2023-06-12 18:30:00', 170.00, null);



