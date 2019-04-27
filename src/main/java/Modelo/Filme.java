package Modelo;

import java.util.Date;


public class Filme {
    private int id;
    private String titulo;
    private Date data;
    private int nota;
    private String descricao;
    private int quantidade;

    public Filme() {
    
    }
    
    
    public Filme(int id, String titulo, Date data, int nota, String descricao, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
