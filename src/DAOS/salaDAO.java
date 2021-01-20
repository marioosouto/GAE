/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Beans.Sala;
import Banco.ConnectionFactory;
import Beans.Instrutor;
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
public class salaDAO {

    public Sala adiciona(Sala sala) {
        String sql = "INSERT INTO sala (materia,capacidade,nome)"
                + "values (?,?,?)";
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sala.getDisciplina());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setString(3, sala.getNome());
            stmt.execute();
            System.out.println("Sala inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sala;
    }
    
       public Sala buscar(int code) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = createPreparedStatement(connection, code);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idsala");
                String nome = rs.getString("nome");
                int capacidade = rs.getInt("capacidade");
                String materia = rs.getString("materia");
                Sala s = new Sala();
                s.setId(id);
                s.setNome(nome);
                s.setCapacidade(capacidade);
                s.setDisciplina(materia);
                return s;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Sala localizar(Sala sala) {
        String sql = "select * from sala where idsala = ?";
        Sala obj = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, sala.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    obj = new Sala();
                    obj.setId(rs.getInt("idsala"));
                    obj.setDisciplina(rs.getString("materia"));
                    obj.setCapacidade(rs.getInt("capacidade"));
                    obj.setNome(rs.getString("nome"));
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

    public List<Sala> lista() {

        String sql = "select * from sala";
        List<Sala> sala = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sala s = new Sala();
                int id = rs.getInt("idsala");
                String materia = rs.getString("materia");
                int capacidade = rs.getInt("capacidade");
                String nome = rs.getString("nome");
                s.setId(id);
                s.setDisciplina(materia);
                s.setCapacidade(capacidade);
                s.setNome(nome);
                sala.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sala;
    }

    public Sala altera(Sala sala) {
               String sql = "update sala set materia = ?, capacidade = ?,"
                + " nome = ? where idsala = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, sala.getDisciplina());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setString(3, sala.getNome());
            stmt.setInt(4, sala.getId());
            stmt.execute();

            System.out.println("Sala alterada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sala;
    }

    public Sala exclui(Sala sala) {
        String sql = "delete from sala where idsala = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, sala.getId());
            stmt.execute();

            System.out.println("Sala excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sala;
    }

      private PreparedStatement createPreparedStatement(Connection con, int id) throws SQLException {
        String sql = "select * from sala where idsala = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

}
