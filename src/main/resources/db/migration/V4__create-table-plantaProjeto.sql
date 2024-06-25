-- Criando tabela PlantaProjeto
CREATE TABLE PlantaProjeto (
    idPlanta INT NOT NULL,
    idProjeto INT NOT NULL,
    PRIMARY KEY (idPlanta, idProjeto),
    FOREIGN KEY (idPlanta) REFERENCES Planta(idPlanta),
    FOREIGN KEY (idProjeto) REFERENCES Projeto(idProjeto)
);