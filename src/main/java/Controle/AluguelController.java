package Controle;

import Modelo.Filme;
import Persistencia.FilmesDAO;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;

@ManagedBean(name = "aluguel")
@SessionScoped

public class AluguelController {

    private HtmlCommandButton botao;
    private ArrayList<Filme> cesta = new ArrayList<>();
    private int id;

    private FilmesDAO con = new FilmesDAO();

    public boolean inserirCesta(int id) {

        Filme f = con.encontrar(id);
        //impedindo que o cliente coloque na cesta um produto que não está no estoque
        if (f.getQuantidade() >= 1) {
            for (int i = 0; i < cesta.size(); i++) {
                if (cesta.get(i).getId() == f.getId()) {
                    cesta.get(i).setQuantidade(cesta.get(i).getQuantidade() + 1);//incrementa +1 ao existente
                    con.diminuiEstoque(f.getId());
                    
                    return true; //sai da função
                }
            }
            //adiciona um novo a cesta
            f.setQuantidade(1); //Adicionando a primeira vez
            cesta.add(f);
            con.diminuiEstoque(f.getId());

        } else {
            System.out.println("estoque não disponível");
            //botao.setDisabled(true);
        }
        return true;
    }

    public void removeCesta(int id) {
        
        Filme f = con.encontrar(id);
        for (int i = 0; i < cesta.size(); i++) {
            if (cesta.get(i).getId() == f.getId()) {
                if(cesta.get(i).getQuantidade() > 1){ //se a quantidade for maior que 1
                    System.out.println("PRIMEIRO IF");
                    cesta.get(i).setQuantidade(cesta.get(i).getQuantidade() - 1); //diminui quantidade na cesta
                }else{
                    System.out.println("SEGUNDO IF");
                    cesta.remove(i); //remove da cesta
                    
                }
                    
            }
        }
        con.aumentaEstoque(id); //devolve 1 ao estoque
    }
    
    public String telaCadastrar(){
        return "index";
    }
     
    //vai para a tela da cesta
    public String verCesta() {
        return "cesta";
    }

    //volta para a tela de aluguel
    public String verFilmes() {
        return "aluguel";
    }

    public HtmlCommandButton getBotao() {
        return botao;
    }

    public void setBotao(HtmlCommandButton botao) {
        this.botao = botao;
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
