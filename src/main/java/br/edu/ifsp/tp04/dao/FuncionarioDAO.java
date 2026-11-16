package br.edu.ifsp.tp04.dao;

import br.edu.ifsp.tp04.config.Conexao;
import br.edu.ifsp.tp04.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static final String BUSCAR_POR_NOME = """
            SELECT f.cd_funcionario, f.nome_funcionario, f.salario, c.ds_cargo
              FROM funcionario f
              JOIN cargo c ON c.cd_cargo = f.cd_cargo
             WHERE f.nome_funcionario LIKE ?
             ORDER BY f.cd_funcionario
            """;

    /** Materializa o ResultSet em uma lista para permitir Próximo/Anterior na tela. */
    public List<Funcionario> pesquisar(String nome) throws SQLException {
        List<Funcionario> resultado = new ArrayList<>();
        try (Connection conexao = Conexao.abrir();
             PreparedStatement comando = conexao.prepareStatement(BUSCAR_POR_NOME);
        ) {
            comando.setString(1, "%" + nome.trim() + "%");
            try (ResultSet resultadoSql = comando.executeQuery()) {
                while (resultadoSql.next()) {
                    resultado.add(new Funcionario(
                            resultadoSql.getInt("cd_funcionario"),
                            resultadoSql.getString("nome_funcionario"),
                            resultadoSql.getBigDecimal("salario"),
                            resultadoSql.getString("ds_cargo")));
                }
            }
        }
        return resultado;
    }
}
