-- Adicionar nova coluna idPlantaProjeto
ALTER TABLE PlantaProjeto
ADD COLUMN idPlantaProjeto serial;

-- Remover chave primária composta existente
ALTER TABLE PlantaProjeto
DROP CONSTRAINT PlantaProjeto_pkey;

-- Adicionar nova chave primária na coluna idPlantaProjeto
ALTER TABLE PlantaProjeto
ADD CONSTRAINT PlantaProjeto_pkey PRIMARY KEY (idPlantaProjeto);

-- Garantir que idPlanta e idProjeto ainda são chaves estrangeiras
ALTER TABLE PlantaProjeto
ADD CONSTRAINT fk_idPlanta FOREIGN KEY (idPlanta) REFERENCES Planta(idPlanta);

ALTER TABLE PlantaProjeto
ADD CONSTRAINT fk_idProjeto FOREIGN KEY (idProjeto) REFERENCES Projeto(idProjeto);
