CREATE TABLE Planta (
    idPlanta SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nomeCientifico VARCHAR(255),
    descricao TEXT,
    origem VARCHAR(255),
    cuidados TEXT,
    imagem BYTEA,
    dataRegistro DATE NOT NULL,
    categoria VARCHAR(50) NOT NULL
);