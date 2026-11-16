IF DB_ID('aulajava') IS NULL
    CREATE DATABASE aulajava;
GO

USE aulajava;
GO

IF OBJECT_ID('dbo.funcionario', 'U') IS NOT NULL DROP TABLE dbo.funcionario;
IF OBJECT_ID('dbo.cargo', 'U') IS NOT NULL DROP TABLE dbo.cargo;
GO

CREATE TABLE dbo.cargo (
    cd_cargo INT NOT NULL CONSTRAINT pk_cargo PRIMARY KEY,
    ds_cargo VARCHAR(20) NOT NULL
);
GO

CREATE TABLE dbo.funcionario (
    cd_funcionario INT NOT NULL CONSTRAINT pk_funcionario PRIMARY KEY,
    nome_funcionario VARCHAR(90) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    cd_cargo INT NOT NULL,
    CONSTRAINT fk_funcionario_cargo FOREIGN KEY (cd_cargo)
        REFERENCES dbo.cargo (cd_cargo)
);
GO

INSERT INTO dbo.cargo (cd_cargo, ds_cargo) VALUES
    (1, 'Administrativo'),
    (2, 'Desenvolvedor'),
    (3, 'Analista'),
    (4, 'Gerente');
GO

INSERT INTO dbo.funcionario (cd_funcionario, nome_funcionario, salario, cd_cargo) VALUES
    (1, 'Marcelo Silva', 2000.00, 1),
    (2, 'Julia Souza', 3500.00, 2),
    (3, 'Ana Santos', 4200.00, 3),
    (4, 'Carlos Oliveira', 6500.00, 4),
    (5, 'Mariana Lima', 3800.00, 2);
GO
