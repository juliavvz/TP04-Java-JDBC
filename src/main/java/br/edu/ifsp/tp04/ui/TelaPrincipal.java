package br.edu.ifsp.tp04.ui;

import br.edu.ifsp.tp04.dao.FuncionarioDAO;
import br.edu.ifsp.tp04.model.Funcionario;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TelaPrincipal extends JFrame {
    private final JTextField campoBusca = new JTextField(20);
    private final JTextField campoNome = new JTextField();
    private final JTextField campoSalario = new JTextField();
    private final JTextField campoCargo = new JTextField();
    private final JButton botaoAnterior = new JButton("Anterior");
    private final JButton botaoProximo = new JButton("Próximo");
    private final FuncionarioDAO dao = new FuncionarioDAO();
    private List<Funcionario> funcionarios = Collections.emptyList();
    private int indiceAtual = -1;

    public TelaPrincipal() {
        super("TRABALHO PRÁTICO 04");
        montarTela();
    }

    private void montarTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 280);
        setLocationRelativeTo(null);

        JPanel busca = new JPanel(new FlowLayout(FlowLayout.CENTER));
        busca.add(new JLabel("Nome:"));
        busca.add(campoBusca);
        JButton pesquisar = new JButton("Pesquisar");
        pesquisar.addActionListener(evento -> pesquisar());
        busca.add(pesquisar);

        campoNome.setEditable(false);
        campoSalario.setEditable(false);
        campoCargo.setEditable(false);
        JPanel dados = new JPanel(new GridLayout(3, 2, 8, 8));
        dados.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        dados.add(new JLabel("Nome:"));
        dados.add(campoNome);
        dados.add(new JLabel("Salário:"));
        dados.add(campoSalario);
        dados.add(new JLabel("Cargo:"));
        dados.add(campoCargo);

        botaoAnterior.addActionListener(evento -> navegar(-1));
        botaoProximo.addActionListener(evento -> navegar(1));
        JPanel navegacao = new JPanel(new GridLayout(1, 2));
        navegacao.add(botaoAnterior);
        navegacao.add(botaoProximo);

        add(busca, BorderLayout.NORTH);
        add(dados, BorderLayout.CENTER);
        add(navegacao, BorderLayout.SOUTH);
        atualizarBotoes();
    }

    private void pesquisar() {
        try {
            funcionarios = dao.pesquisar(campoBusca.getText());
            indiceAtual = funcionarios.isEmpty() ? -1 : 0;
            mostrarAtual();
            if (funcionarios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum funcionário encontrado.");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível consultar o banco:\n" + erro.getMessage(),
                    "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navegar(int deslocamento) {
        int novoIndice = indiceAtual + deslocamento;
        if (novoIndice >= 0 && novoIndice < funcionarios.size()) {
            indiceAtual = novoIndice;
            mostrarAtual();
        }
    }

    private void mostrarAtual() {
        if (indiceAtual < 0 || indiceAtual >= funcionarios.size()) {
            campoNome.setText("");
            campoSalario.setText("");
            campoCargo.setText("");
        } else {
            Funcionario funcionario = funcionarios.get(indiceAtual);
            campoNome.setText(funcionario.nome());
            campoSalario.setText(formatarSalario(funcionario.salario()));
            campoCargo.setText(funcionario.cargo());
        }
        atualizarBotoes();
    }

    private String formatarSalario(BigDecimal salario) {
        return NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(salario);
    }

    private void atualizarBotoes() {
        botaoAnterior.setEnabled(indiceAtual > 0);
        botaoProximo.setEnabled(indiceAtual >= 0 && indiceAtual < funcionarios.size() - 1);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
