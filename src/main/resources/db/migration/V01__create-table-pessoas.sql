CREATE TABLE Pessoas
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    nome        VARCHAR(40) NOT NULL,
    ativo       BOOLEAN      NOT NULL DEFAULT TRUE,
    logradouro  VARCHAR(100) NOT NULL,
    bairro      VARCHAR(100) NOT NULL,
    cep         VARCHAR(9)   NOT NULL,
    complemento VARCHAR(100),
    numero      VARCHAR(10),
    uf          CHAR(2)      NOT NULL,
    cidade      VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);