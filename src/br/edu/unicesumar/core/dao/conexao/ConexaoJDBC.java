
package br.edu.unicesumar.core.dao.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton
 */
public class ConexaoJDBC {
    
    private static final String URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection conn;
    
    public static Connection getConexao(){
        
        try{
            if(conn == null) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            } else {
                return conn;
            }
        } 
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar conectar no banco de dados");
            return null;
        }
    }
}
