package br.edu.ifsp.tp04.model;

import java.math.BigDecimal;

public record Funcionario(int codigo, String nome, BigDecimal salario, String cargo) {
}
