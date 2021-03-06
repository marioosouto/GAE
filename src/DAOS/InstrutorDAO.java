/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Beans.Instrutor;
import Banco.ConnectionFactory;
import Beans.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario Souto
 */
public class InstrutorDAO {

    Instrutor[] instrutor = new Instrutor[5];

    public Instrutor adiciona(Instrutor instrutor) {

        String sql = "INSERT INTO instrutor (nome,cpf,rua,numero,bairro,sexo)"
                + "values (?,?,?,?,?,?)";
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery("select * from instrutor where cpf = '" + instrutor.getCpf() + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {
                stmt.setString(1, instrutor.getNome());
                stmt.setString(2, instrutor.getCpf());
                stmt.setString(3, instrutor.getRua());
                stmt.setString(4, instrutor.getNumero());
                stmt.setString(5, instrutor.getBairro());
                stmt.setString(6, instrutor.getSexo());
                stmt.execute();
                System.out.println("Instrutor inserido com sucesso.");
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "Adicionado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instrutor;

    }

    public Instrutor buscar(int code) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = createPreparedStatement(connection, code);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idinstrutor");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String numero = rs.getString("numero");
                String sexo = rs.getString("sexo");
                Instrutor i = new Instrutor();
                i.setIdInstrutor(id);
                i.setNome(nome);
                i.setCpf(cpf);
                i.setRua(rua);
                i.setBairro(bairro);
                i.setNumero(numero);
                i.setSexo(sexo);
                return i;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Instrutor> lista() {

        String sql = "select * from instrutor";
        List<Instrutor> instrutores = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                int id = rs.getInt("idinstrutor");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String numero = rs.getString("numero");
                String sexo = rs.getString("sexo");

                instrutor.setIdInstrutor(id);
                instrutor.setNome(nome);
                instrutor.setCpf(cpf);
                instrutor.setRua(rua);
                instrutor.setBairro(bairro);
                instrutor.setNumero(numero);
                instrutor.setSexo(sexo);
                
                instrutores.add(instrutor);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instrutores;
    }
    
   
    public Instrutor altera(Instrutor instrutor) {
        String sql = "update instrutor set nome = ?, cpf = ?,"
                + " rua = ?, numero = ?, bairro = ?, sexo = ? where idinstrutor = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery("select * from instrutor where cpf = '" + instrutor.getCpf() + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {
                stmt.setString(1, instrutor.getNome());
                stmt.setString(2, instrutor.getCpf());
                stmt.setString(3, instrutor.getRua());
                stmt.setString(4, instrutor.getNumero());
                stmt.setString(5, instrutor.getBairro());
                stmt.setString(6, instrutor.getSexo());
                stmt.setInt(7, instrutor.getIdInstrutor());
                stmt.execute();
                System.out.println("Instrutor alterado com sucesso.");
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Alterado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instrutor;
    }

    public Instrutor exclui(Instrutor instrutor) {
        String sql = "delete from instrutor where idinstrutor = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, instrutor.getIdInstrutor());
            stmt.execute();

            System.out.println("Instrutor excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instrutor;
    }

   private java.sql.PreparedStatement createPreparedStatement(Connection con, int id) throws SQLException {
       String sql = "select * from instrutor where idinstrutor = ?";
        java.sql.PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    } 

}
