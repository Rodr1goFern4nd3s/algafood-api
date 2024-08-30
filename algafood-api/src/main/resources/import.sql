insert into tb_cozinhas (id, nome) values (1, 'Tailandesa');
insert into tb_cozinhas (id, nome) values (2, 'Indiana');
insert into tb_cozinhas (id, nome) values (3, 'Chinesa');

insert into tb_estados (id, nome) values (1, 'Amazonas');
insert into tb_estados (id, nome) values (2, 'Acre');
insert into tb_estados (id, nome) values (3, 'Roraima');

insert into tb_cidades (id, nome, estado_id) values (1, 'Manaus', 1);
insert into tb_cidades (id, nome, estado_id) values (2, 'Rio Branco', 2);
insert into tb_cidades (id, nome, estado_id) values (3, 'Boa Vista', 3);

insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, '38400-589', 'Rua João Pinheiro', '1000', 'Rua do CRÁS', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp, '23459-159', 'Rua João Pinheiro', '1000', 'Rua do CRÁS', 'Centro');
insert into tb_restaurantes (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp, '65497-654', 'Rua João Pinheiro', '1000', 'Rua do CRÁS', 'Centro');
