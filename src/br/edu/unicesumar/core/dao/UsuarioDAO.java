package br.edu.unicesumar.core.dao;

import br.edu.unicesumar.core.dao.conexao.ConexaoJDBC;
import br.edu.unicesumar.core.entity.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Milton
 */
public class UsuarioDAO {
    
    public void inserir(Usuario usuario) {
        
        String sql = "INSERT INTO USUARIO(NOME, LOGIN, SENHA, EMAIL) VALUES (?,?,?,?)";
        
        PreparedStatement ps;
        
        try{
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            
            ps.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuario(String login, String senha) {
        String sql = "SELECT ID, NOME, LOGIN, SENHA , EMAIL FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
        
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            
            ps.setString(1, login);
            ps.setString(2, senha);
            
            rs = ps.executeQuery();
            
            
            
            if(rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setID(rs.getLong("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setEmail(rs.getString("EMAIL"));
                
                return usuario;
            }
            
            return null;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
