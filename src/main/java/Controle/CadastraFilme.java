package Controle;

import Modelo.Filme;
import Persistencia.FilmesDAO;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;


@ManagedBean(name = "cadastrar")
@ViewScoped

public class CadastraFilme {
    private String titulo;
    private Date data;
    private int nota;
    private String descricao;
    private int quantidade;
    
    private HtmlInputText text;
    
    private ArrayList<Filme> lista = new ArrayList<>();
    FilmesDAO con = new FilmesDAO();
    
   
    
    public String telaAluguel(){
        return "aluguel";
    }
    
    public void exibeFilmes(){
        lista.clear();
        lista.addAll(con.listFilmes());
    }
    
    public void cancelar(){
        System.out.println("Entrou em cancelar");
        titulo = "";
        data = null;
        nota = 0;
        descricao = "";
        quantidade = 0;
        
        text.setLabel("");
        text.setTitle("entrou");
       
    }
            
    
    public void cadastrarFilme(){
        System.out.println("ENTROU EM CADASTRARFILME");
        //covertendo java.util.date para java.sql.date
        data = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        
        con.insertIntoFilmes(titulo, dataSql, nota, descricao, quantidade);
        
        //exibeFilmes();
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

    public HtmlInputText getText() {
        return text;
    }

    public void setText(HtmlInputText text) {
        this.text = text;
    }

    
}
