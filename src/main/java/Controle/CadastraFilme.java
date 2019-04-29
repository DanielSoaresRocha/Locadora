package Controle;

import Modelo.Filme;
import Persistencia.FilmesDAO;

import java.util.ArrayList;
import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cadastrar")
@ViewScoped

public class CadastraFilme {
    private String titulo;
    private Date data;
    private int nota;
    private String descricao;
    private int quantidade;
    
    private ArrayList<Filme> lista = new ArrayList<>();
    FilmesDAO con = new FilmesDAO();
    
   
    
    public String telaAluguel(){
        return "aluguel";
    }
    
    public void exibeFilmes(){
        lista.clear();
        lista.addAll(con.listFilmes());
    }
    
    public void cadastrarFilme(){
        System.out.println("ENTROU EM CADASTRARFILME");
        con.insertIntoFilmes(titulo, data, nota, descricao, quantidade);
        exibeFilmes();
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
    
    public ArrayList<Filme> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Filme> lista) {
        this.lista = lista;
    }

}
