package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Filme;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmesDAO {

    private final ConexaoDAO con = new ConexaoDAO();

    public FilmesDAO() {

    }

    public ArrayList<Filme> listFilmes() {

        ArrayList<Filme> lista = new ArrayList<>();
        con.dbConnection();
        String query = "select *\n"
                + "from filmes order by titulo;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) { //enquanto houver registro
                Filme f = new Filme();
                f.setId(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setData(rs.getDate(3));
                f.setNota(rs.getInt(4));
                f.setDescricao(rs.getString(5));
                f.setQuantidade(rs.getInt(6));
                lista.add(f);

            }
            // DESCONECTA
            con.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Collections.sort(lista);
        return lista;

    }

    //Inserindo venda no banco
    public void insertIntoFilmes(String titulo, Date data, int nota, String descricao, int quantidade) {
        System.out.println(">>>>ENTROU EM insetIntoFilmes<<<<");
        con.dbConnection();
        String query = "insert into filmes(titulo, dataa, nota, descricao, quantidade) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, titulo);
            pst.setDate(2, data);
            pst.setInt(3, nota);
            pst.setString(4, descricao);
            pst.setInt(5, quantidade);
            pst.executeUpdate();

            System.out.println("Filme adicionado");
        } catch (SQLException ex) {
            //Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("N deu certo");
        }
        con.closeConnection();
    }

    //Tenta encontrar um filme
    public Filme encontrar(int id) {
        con.dbConnection();
        String query = " SELECT * FROM filmes;";
        try {

            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int x = rs.getInt(1);
                if (x == id) {
                    System.out.println("FILME ENCONTRADO");
                    Filme f = new Filme();
                    f.setId(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setData(rs.getDate(3));
                    f.setNota(rs.getInt(4));
                    f.setDescricao(rs.getString(5));
                    f.setQuantidade(rs.getInt(6));

                    return f;
                }
            }
        } catch (SQLException ex) {
            System.out.println("LoginFromVendedor não deu certo");
            //Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Vendedor não foi encontrado");
        con.closeConnection();
        return null;
    }

    //diminui 1 no estoque
    public boolean diminuiEstoque(int id) {
        con.dbConnection();
        String query = "update filmes \n"
                + "set quantidade = quantidade -1\n"
                + "where idfilmes = ?\n"
                + "and quantidade > 0;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setInt(1, id);
            
            pst.executeUpdate();
            System.out.println("Filme editado");
            return true;
        } catch (SQLException ex) {
            System.out.println("n deu certo");
            //Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.closeConnection();
        return false;
    }
    
    //diminui 1 no estoque
    public boolean aumentaEstoque(int id) {
        con.dbConnection();
        String query = "update filmes \n"
                + "set quantidade = quantidade +1\n"
                + "where idfilmes = ?\n"
                + "and quantidade > 0;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setInt(1, id);
            
            pst.executeUpdate();
            System.out.println("Filme editado");
            return true;
        } catch (SQLException ex) {
            System.out.println("n deu certo");
            //Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.closeConnection();
        return false;
    }

}
