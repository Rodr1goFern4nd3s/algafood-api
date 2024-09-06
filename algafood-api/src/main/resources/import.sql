insert into tb_cozinhas (id, nome) values (1, 'Tailandesa');
insert into tb_cozinhas (id, nome) values (2, 'Indiana');
insert into tb_cozinhas (id, nome) values (3, 'Chinesa');
insert into tb_cozinhas (id, nome) values (4, "Argentina")
insert into tb_cozinhas (id, nome) values (5, "Brasileira")

insert into tb_estados (id, nome) values (1, 'Amazonas');
insert into tb_estados (id, nome) values (2, 'Acre');
insert into tb_estados (id, nome) values (3, 'Roraima');

insert into tb_cidades (id, nome, estado_id) values (1, 'Manaus', 1);
insert into tb_cidades (id, nome, estado_id) values (2, 'Rio Branco', 2);
insert into tb_cidades (id, nome, estado_id) values (3, 'Boa Vista', 3);

insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, '38400-589', 'Rua João Pinheiro', '1000', 'Rua do CRÁS', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp, '23459-159', 'Rua João Pinheiro', '1000', 'Rua do CRÁS', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp, '65497-654', 'Rua João Pinheiro', '1000', 'Rua do CRÁS', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (4, 'Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp, '65497-654', 'Rua João Pinheiro', '1000', 'Rua do VEU', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (5, 'Lanchonete do Tio Sam', 11, 4, utc_timestamp, utc_timestamp, '65497-654', 'Rua João Pinheiro', '1000', 'Rua do VEU', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (4, 'Bar da Maria', 6, 4, utc_timestamp, utc_timestamp, '65497-654', 'Rua João Pinheiro', '1000', 'Rua do VEU', 'Centro');

insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);
insert into tb_produtos (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);