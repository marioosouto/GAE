/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Beans.Usuario;
import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario Souto
 */
public class UsuarioDAO {
    
    Usuario[] usuario = new Usuario[5];

    public Usuario adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome,login,senha)"
                + "values (?,?,?)";
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
            System.out.println("Usuario inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public Usuario localizar(Usuario usuario) {
        String sql = "select * from usuario where login = ? AND senha = ?";
        Usuario obj = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    obj = new Usuario();
                    obj.setId(rs.getInt("idusuario"));
                    obj.setNome(rs.getString("nome"));
                    obj.setLogin(rs.getString("login"));
                    obj.setSenha(rs.getString("senha"));
                    return obj;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return obj;
    }

    public List<Usuario> lista() {

        String sql = "select * from usuario";
        List<Usuario> usuario = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                int id = rs.getInt("idusuario");
                String nome = rs.getString("nome");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                user.setId(id);
                user.setNome(nome);
                user.setLogin(login);
                user.setSenha(senha);
                usuario.add(user);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public Usuario altera(Usuario user) {
        String sql = "update usuario set nome = ?, login = ?,"
                + " senha = ? where idusuario = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.setInt(4, user.getId());

            stmt.execute();

            System.out.println("Usuario alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public Usuario exclui(Usuario usuario) {
        String sql = "delete from usuario where idusuario = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getId());
            stmt.execute();

            System.out.println("Usuario excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
       Usuario ValidarLogin(String login, String senha, UsuarioDAO usuarioDAO) {

        for (Usuario usuario1 : usuario) {
            if (usuario1 != null && usuario1.getLogin().equals(login) && usuario1.getSenha().equals(senha)) {
                return usuario1;
            }
        }

        return null;
    }

}
