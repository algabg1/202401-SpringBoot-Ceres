-- Criando tabela Comentario
CREATE TABLE Comentario (
    idComentario SERIAL PRIMARY KEY,
    conteudo TEXT NOT NULL,
    idUsuario INT NOT NULL,
    idNoticia INT NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idNoticia) REFERENCES Noticia(idNoticia) ON DELETE CASCADE
);