# TP04-Java-JDBC

Solução do Trabalho Prático 04 de CBTLPR2 (Java), com Java Swing, JDBC e SQL Server.

## Requisitos do enunciado atendidos

- Tela semelhante ao modelo do PDF, com pesquisa por nome.
- Banco SQL Server chamado `aulajava`.
- Tabelas `cargo` e `funcionario`, com chave estrangeira.
- Registros de exemplo respeitando o relacionamento.
- Conexão usando JDBC.
- Pesquisa com `LIKE` e `PreparedStatement`.
- Navegação pelos resultados com os botões **Anterior** e **Próximo**, bloqueados nos limites.

## Como executar

1. Instale Java 17 ou superior, Maven e SQL Server.
2. Abra o SQL Server Management Studio e execute [`database/aulajava.sql`](database/aulajava.sql).
3. Configure as variáveis de ambiente da conexão:

   ```bash
   export DB_URL='jdbc:sqlserver://localhost:1433;databaseName=aulajava;encrypt=true;trustServerCertificate=true'
   export DB_USER='sa'
   export DB_PASSWORD='sua_senha'
   ```

   No Windows PowerShell, use `\$env:DB_URL = '...'`, `\$env:DB_USER = 'sa'` e `\$env:DB_PASSWORD = '...'`.

4. Na pasta do projeto, compile e execute:

   ```bash
   mvn clean compile
   mvn exec:java
   ```

Digite um nome completo ou parcial e clique em **Pesquisar**. A consulta usa `%texto%`, portanto também encontra nomes que contenham o texto informado.

## Divisão do trabalho para duas pessoas

### Pessoa 1 — Banco e camada JDBC

- Executar e revisar `database/aulajava.sql`.
- Conferir as tabelas, chaves e registros no SQL Server.
- Implementar/revisar `Conexao.java` e `FuncionarioDAO.java`.
- Testar a consulta `LIKE` com diferentes nomes.
- Criar uma branch chamada `pessoa-1-jdbc` e abrir um Pull Request.

### Pessoa 2 — Interface e integração

- Implementar/revisar `Funcionario.java` e `TelaPrincipal.java`.
- Ajustar o layout para ficar semelhante ao modelo do enunciado.
- Testar os botões **Anterior** e **Próximo** no primeiro, no meio e no último registro.
- Tratar mensagens de lista vazia e erro de conexão.
- Criar uma branch chamada `pessoa-2-interface` e abrir um Pull Request.

### Integração final

Uma das pessoas deve revisar os dois Pull Requests, resolver conflitos, executar `mvn clean compile` e fazer um teste completo com SQL Server antes do merge na branch `master`.

## Fluxo Git recomendado

```bash
git clone https://github.com/juliavvz/TP04-Java-JDBC.git
cd TP04-Java-JDBC

git checkout -b pessoa-1-jdbc       # Pessoa 1
git add database src/main/java/br/edu/ifsp/tp04/config src/main/java/br/edu/ifsp/tp04/dao
 git commit -m "feat: adiciona banco e camada JDBC"
git push -u origin pessoa-1-jdbc

# Em outro clone ou após voltar para master:
git checkout -b pessoa-2-interface  # Pessoa 2
git add pom.xml src/main/java/br/edu/ifsp/tp04/model src/main/java/br/edu/ifsp/tp04/ui README.md
 git commit -m "feat: adiciona interface Swing e documentacao"
git push -u origin pessoa-2-interface
```

Depois, no GitHub, abra um Pull Request de cada branch para `master`. Não coloquem senha do banco em nenhum arquivo versionado.
