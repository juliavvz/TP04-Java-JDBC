package br.edu.ifsp.tp04.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Cria conexões com o SQL Server sem deixar senha gravada no código. */
public final class Conexao {
    private Conexao() {
    }

    public static Connection abrir() throws SQLException {
        String url = valor("DB_URL", "jdbc:sqlserver://localhost:1433;databaseName=aulajava;encrypt=true;trustServerCertificate=true");
        String usuario = valor("DB_USER", "sa");
        String senha = valor("DB_PASSWORD", "SuaSenhaAqui");
        return DriverManager.getConnection(url, usuario, senha);
    }

    private static String valor(String nome, String padrao) {
        String valor = System.getenv(nome);
        return valor == null || valor.isBlank() ? padrao : valor;
    }
}
