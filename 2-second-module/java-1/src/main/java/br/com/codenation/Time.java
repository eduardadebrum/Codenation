package br.com.codenation;


import java.time.LocalDate;

/**
 * @author Eduarda de Brum Lucena
 */
public class Time {

    private Long id;

    private String nome;

    private LocalDate dataCriacao;

    private String corUniformePrincipal;

    private String corUniformeSecundario;

    private Long idCapitao;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) throw new IllegalArgumentException();
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException();
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        if (dataCriacao == null) throw new IllegalArgumentException();

        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        if (corUniformePrincipal == null || corUniformePrincipal.isEmpty()) throw new IllegalArgumentException();
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        if (corUniformeSecundario == null || corUniformeSecundario.isEmpty()) throw new IllegalArgumentException();

        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getIdCapitao() {
        return idCapitao;
    }

    public void setIdCapitao(Long idCapitao) {
        this.idCapitao = idCapitao;
    }
}