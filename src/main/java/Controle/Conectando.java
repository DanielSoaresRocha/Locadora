package Controle;

import Persistencia.ConexaoDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Conectando {
    
   
    public void conecta(){
        System.out.println("Entrou1");
        ConexaoDAO con = new ConexaoDAO();
        con.dbConnection();
        con.closeConnection();
            
    }
    public String conecta2(){
        return "entrouuuu";
       
            
    }
    
    
     
    
}
