package DAOS;

import Banco.ConnectionFactory;
import Beans.Turma;
import Beans.Sala;
import DAOS.salaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TurmaDAO {

    public Turma adiciona(Turma turma) {
        String sql = "insert into turma (nome_turma,idinstrutorturma,iddisciplina)" + " values (?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, turma.getNometurma());
            stmt.setInt(2, turma.getInstrutor().getIdInstrutor());
            stmt.setInt(3, turma.getSalaafk().getId());
            stmt.execute();
            System.out.println("Elemento inserido com sucesso.");
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "Adicionado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return turma;
    }

    public List<Turma> lista() {
        String sql = "select * from turma";
        InstrutorDAO dao = new InstrutorDAO();
        salaDAO dao2 = new salaDAO();
        List<Turma> turmas = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("idturma");
                String nome = rs.getString("nome_turma");
                int idafk = rs.getInt("idinstrutorturma");
                int iddisciplina = rs.getInt("iddisciplina");
                Turma turma = new Turma();
                turma.setIdturma(id);
                turma.setNometurma(nome);
                turma.setInstrutor(dao.buscar(idafk));
                turma.setSalaafk(dao2.buscar(iddisciplina));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return turmas;
    }

    public Turma buscar(int code) {
        InstrutorDAO dao = new InstrutorDAO();
        salaDAO dao2 = new salaDAO();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = createPreparedStatement(connection, code);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idturma");
                String nome = rs.getString("nome_turma");
                int instrutor = rs.getInt("idinstrutorturma");
                int iddisciplina = rs.getInt("iddisciplina");
                Turma turma = new Turma();
                turma.setIdturma(id);
                turma.setNometurma(nome);
                turma.setInstrutor(dao.buscar(instrutor));
                turma.setSalaafk(dao2.buscar(iddisciplina));
                return turma;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private java.sql.PreparedStatement createPreparedStatement(Connection con, int id) throws SQLException {
        String sql = "select * from turma where idturma = ?";
        java.sql.PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public Turma altera(Turma turma) {
        String sql = "update turma set nome_turma = ?, idinstrutorturma = ?, iddisciplina = ?"
                + " where idturma = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, turma.getNometurma());
            stmt.setInt(2, turma.getInstrutor().getIdInstrutor());
            stmt.setInt(3, turma.getSalaafk().getId());
            stmt.setInt(4, turma.getIdturma());
            stmt.execute();
            System.out.println("Elemento alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return turma;
    }

    public Turma exclui(Turma turma) {
        String sql = "delete from turma where idturma = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, turma.getIdturma());
            stmt.execute();
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return turma;
    }
}
