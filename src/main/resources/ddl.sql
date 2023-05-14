CREATE TABLE IF NOT EXISTS moeda
(
    id_moeda varchar(40),
    tx_nome varchar(50) NOT NULL,
    tx_simbolo varchar(5) NOT NULL,
    tx_sigla varchar(5) NOT NULL,
    CONSTRAINT moeda_pkey PRIMARY KEY (id_moeda)
);
