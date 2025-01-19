-- Inserção Cozinha
insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Arábe');
insert into cozinha (id, nome) values (3, 'Indiana');

-- Inserção Restaurante
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Viet Roll', 9.90, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Shabat Food', 5.90, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 3);

-- Inserção Forma Pagamento
insert into forma_pagamento (descricao) values ("Pix");
insert into forma_pagamento (descricao) values ("Debito");
