CREATE TABLE ativos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT
  , ticket VARCHAR(10) NOT NULL UNIQUE
  , id_instituicao BIGINT NOT NULL
  , created_at DATETIME
  , updated_at DATETIME
  , FOREIGN KEY (id_instituicao) REFERENCES instituicoes (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;