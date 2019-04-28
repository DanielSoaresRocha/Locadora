
package Controle;

import Modelo.Filme;
import Persistencia.FilmesDAO;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "aluguel")
@SessionScoped

public class AluguelController {
    private ArrayList<Filme> cesta = new ArrayList<>();
    private int id;
    
    private final FilmesDAO con = new FilmesDAO();
    
    public void inserirCesta(int id){
        Filme f = con.encontrar(id);
        if(f.getQuantidade() > 1){
            System.out.println("Filme adicionado na cesta");
            cesta.add(f);
        }else{
            System.out.println("Quantidade no estoque indisponível");
        }
        
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public ArrayList<Filme> getCesta() {
        return cesta;
    }

    public void setCesta(ArrayList<Filme> cesta) {
        this.cesta = cesta;
    }
    
    
    
}
