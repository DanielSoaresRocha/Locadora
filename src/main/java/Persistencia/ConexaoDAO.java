package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class ConexaoDAO {
     private Connection connection;
    private String url = "jdbc:postgresql://ec2-54-235-114-242.compute-1.amazonaws.com:5432/ddjnolj9bnrrfb";
    private String user = "ypqnkojminousa";
    private String password = "6da643198af6415f9dec3a12491878e79cde33bb6ee1f77b57a44d86536769b6";
    private String driver = "org.postgresql.Driver";

    public void dbConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Aqui deu ruim vey");
            //Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch (SQLException ex) {
            //Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Not connected");
        }

    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            //Logger.getLogger(PConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
}
