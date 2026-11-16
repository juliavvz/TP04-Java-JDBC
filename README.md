# TP04 - Java JDBC

## Sobre o projeto

Este projeto foi desenvolvido como parte da atividade prática TP04, com o objetivo de trabalhar a integração entre Java e SQL Server utilizando JDBC.

A aplicação permite pesquisar funcionários cadastrados no banco de dados por meio de seus nomes, além de navegar entre os registros utilizando os botões **Anterior** e **Próximo**.

A pesquisa permite informar um nome completo ou apenas parte dele, retornando os funcionários que contêm o texto digitado.

## Tecnologias utilizadas

- Java
- JDBC (Java Database Connectivity)
- SQL Server
- Maven
- Java Swing

## Funcionalidades

- Consulta de funcionários cadastrados no banco de dados.
- Pesquisa por nome completo ou parcial.
- Utilização do comando SQL `LIKE` para localizar nomes.
- Navegação entre os registros por meio dos botões **Anterior** e **Próximo**.
- Exibição dos dados dos funcionários na interface gráfica.

## Estrutura do projeto

```text
TP04-Java-JDBC/
│
├── database/
│   └── aulajava.sql
│
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── edu/
│                   └── ifsp/
│                       └── tp04/
│                           ├── config/
│                           │   └── Conexao.java
│                           │
│                           ├── dao/
│                           │   └── FuncionarioDAO.java
│                           │
│                           ├── model/
│                           │   └── Funcionario.java
│                           │
│                           └── ui/
│                               └── TelaPrincipal.java
│
├── pom.xml
└── README.md
```

## Como executar o projeto

### 1. Pré-requisitos

Antes de executar a aplicação, é necessário ter instalado:

- JDK (Java Development Kit).
- Apache Maven.
- Microsoft SQL Server.

### 2. Configuração do banco de dados

1. Abra o SQL Server Management Studio.
2. Execute o script `database/aulajava.sql`.
3. Confira se o banco de dados e as tabelas foram criados corretamente.
4. Configure os dados de conexão com o SQL Server no arquivo `Conexao.java`.

### 3. Executando a aplicação

Na pasta raiz do projeto, abra o terminal e execute:

```bash
mvn clean compile
```

Após a compilação, execute a classe principal da aplicação pela sua IDE.

## Demonstração do projeto

Assistir ao vídeo de demonstração: https://youtu.be/JAitQqGBmsY?is=g-7rxdqXj-oScdfT

Desenvolvido em dupla por:

- **Júlia Vitória**
- **Lucas Antonio**
