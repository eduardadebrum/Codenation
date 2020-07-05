package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Eduarda de Brum Lucena
 */
public class Jogador {

    private Long id;

    private Long idTime;

    private String nome;

    private LocalDate dataNascimento;

    private Integer nivelHabilidade; //* Nível de habilidade do jogador (0 a 100)

    private BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNasciment, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNasciment;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) throw new IllegalArgumentException();
        this.id = id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        if (idTime == null) throw new IllegalArgumentException();
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException();
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) throw new IllegalArgumentException();

        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        if (nivelHabilidade == null || (nivelHabilidade < 0 || nivelHabilidade > 100)) throw new IllegalArgumentException();
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        if (salario == null) throw new IllegalArgumentException();
        this.salario = salario;
    }

}