DROP DATABASE IF EXISTS safeclass2;
CREATE DATABASE safeclass2;
USE safeclass2;

CREATE TABLE endereco (
    idEndereco INT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(45),
    numero VARCHAR(45),
    cidade VARCHAR(45),
    bairro VARCHAR(45),
    uf CHAR(2)
);

CREATE TABLE escola (
    idEscola INT PRIMARY KEY AUTO_INCREMENT,
    idSlack VARCHAR(45),
    fkEndereco INT,
    nome VARCHAR(45),
    email VARCHAR(45),
    telefone CHAR(11),
    codigoInep VARCHAR(45),
    FOREIGN KEY (fkEndereco) REFERENCES endereco(idEndereco)
);

CREATE TABLE codigoAtivacao (
    idCodigo INT PRIMARY KEY AUTO_INCREMENT,
    fkEscola INT,
    codigo VARCHAR(45),
    validade DATE,
    qtdUsos INT,
    FOREIGN KEY (fkEscola) REFERENCES escola(idEscola)
);

CREATE TABLE sala (
    idSala INT PRIMARY KEY AUTO_INCREMENT,
    fkEscola INT,
    nome VARCHAR(45),
    localizacao VARCHAR(45),
    FOREIGN KEY (fkEscola) REFERENCES escola(idEscola)
);

CREATE TABLE cargo (
    idCargo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    permissao VARCHAR(100)
);

CREATE TABLE usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    fkCargo INT,
    fkEscola INT,
    fkGestor INT NULL,
    nome VARCHAR(45),
    email VARCHAR(45),
    senha VARCHAR(45),
    senhaTemporaria DATETIME NULL,
    dtCadastro DATE,
    status VARCHAR(45),
    imagemPerfil VARCHAR(255),
    last_login DATETIME,
    online BOOLEAN,
    FOREIGN KEY (fkCargo) REFERENCES cargo(idCargo),
    FOREIGN KEY (fkEscola) REFERENCES escola(idEscola),
    FOREIGN KEY (fkGestor) REFERENCES usuario(idUsuario)
);

CREATE TABLE logins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT,
    dataHoraLogin DATETIME,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE maquina (
    idMaquina INT PRIMARY KEY AUTO_INCREMENT,
    fkSala INT,
    ip VARCHAR(45),
    username VARCHAR(45),
    senha VARCHAR(45),
    sistemaOperacional VARCHAR(45),
    marca VARCHAR(45),
    macaddress VARCHAR(45),
    status VARCHAR(45),
    estado VARCHAR(45),
    FOREIGN KEY (fkSala) REFERENCES sala(idSala)
);

CREATE TABLE desligamentoRemoto (
    idDesligamento INT,
    fkMaquina INT,
    fkUsuario INT,
    dtDesligamento DATETIME,
    PRIMARY KEY (idDesligamento, fkMaquina),
    FOREIGN KEY (fkMaquina) REFERENCES maquina(idMaquina),
    FOREIGN KEY (fkUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE componente (
    idComponente INT AUTO_INCREMENT PRIMARY KEY,
    fkMaquina INT,
    nome VARCHAR(45),
    formatacao VARCHAR(45),
    capacidade VARCHAR(45),
    FOREIGN KEY (fkMaquina) REFERENCES maquina(idMaquina)
);

CREATE TABLE captura (
    idCaptura INT AUTO_INCREMENT PRIMARY KEY,
    fkComponente INT,
    registro FLOAT,
    dtCaptura TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (fkComponente) REFERENCES componente(idComponente)
);

CREATE TABLE parametro (
    idParametro INT AUTO_INCREMENT PRIMARY KEY,
    fkComponente INT,
    nivel VARCHAR(45),
    minimo FLOAT,
    maximo FLOAT,
    FOREIGN KEY (fkComponente) REFERENCES componente(idComponente)
);

CREATE TABLE alerta (
    idAlerta INT AUTO_INCREMENT PRIMARY KEY,
    fkParametro INT,
    fkCaptura INT,
    mensagem VARCHAR(80),
    enviado TINYINT(1),
    FOREIGN KEY (fkParametro) REFERENCES parametro(idParametro),
    FOREIGN KEY (fkCaptura) REFERENCES captura(idCaptura)
);

