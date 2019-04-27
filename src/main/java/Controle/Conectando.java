package Controle;

import Persistencia.ConexaoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Conectando {

    public Conectando() {
    
    }
   
    public void conecta(){
        ConexaoDAO con = new ConexaoDAO();
        con.dbConnection();
            
    }
    
    
    
     
    
}
