package DAOS;

import Banco.ConnectionFactory;
import Beans.AlunoTurma;
import Beans.Aluno;
import Beans.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoTurmaDAO {

    public void adiciona(Turma turma, Aluno aluno) {
        String sql = "insert into alunos_turma (id_turma,id_aluno)" + " values (?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, turma.getIdturma());
            stmt.setInt(2, aluno.getIdaluno());
  
            stmt.execute();
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AlunoTurma> lista() {
        String sql = "select * from alunos_turma";
        List<AlunoTurma> alunoTurmas = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("idalunos_turma");
                int idTurma = rs.getInt("id_turma");
                int id_aluno = rs.getInt("id_aluno");
               
                AlunoTurma alunoTurma = new AlunoTurma();
                TurmaDAO turmaDAO = new TurmaDAO();
                AlunoDAO alunoDAO = new AlunoDAO();
                alunoTurma.setId(id);
                alunoTurma.setIdTurma(turmaDAO.buscar(idTurma));
                alunoTurma.setIdAluno(alunoDAO.buscar(id_aluno));
           
                alunoTurmas.add(alunoTurma);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunoTurmas;
    }

    public AlunoTurma buscar(int code) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = createPreparedStatement(connection, code);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idalunos_turma");
                int idTurma = rs.getInt("id_turma");
                int id_aluno = rs.getInt("id_aluno");
            
                AlunoTurma alunoTurma = new AlunoTurma();
                TurmaDAO turmaDAO = new TurmaDAO();
                AlunoDAO alunoDAO = new AlunoDAO();
                alunoTurma.setId(id);
                alunoTurma.setIdTurma(turmaDAO.buscar(idTurma));
                alunoTurma.setIdAluno(alunoDAO.buscar(id_aluno));
 
                return alunoTurma;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean AlunoJaCadastrado(Turma turma, Aluno aluno) {
        String sql = "select * from alunos_turma";
        List<AlunoTurma> alunoTurmas = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("idalunos_turma");
                int idTurma = rs.getInt("id_turma");
                int id_aluno = rs.getInt("id_aluno");
             
                AlunoTurma alunoTurma = new AlunoTurma();
                TurmaDAO turmaDAO = new TurmaDAO();
                AlunoDAO alunoDAO = new AlunoDAO();
                alunoTurma.setId(id);
                alunoTurma.setIdTurma(turmaDAO.buscar(idTurma));
                alunoTurma.setIdAluno(alunoDAO.buscar(id_aluno));
              
                if (alunoTurma.getIdAluno().getIdaluno() == aluno.getIdaluno()
                        && alunoTurma.getIdTurma().getIdturma() == turma.getIdturma()) {
                    return true;
                }
                alunoTurmas.add(alunoTurma);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<AlunoTurma> buscaralunosTurmas(int code) {
        List<AlunoTurma> alunoTurmas = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = createPreparedStatement(connection, code);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idalunos_turma");
                int id_turma = rs.getInt("id_turma");
                int id_aluno = rs.getInt("id_aluno");
       
                AlunoTurma alunoTurma = new AlunoTurma();
                TurmaDAO turmaDAO = new TurmaDAO();
                AlunoDAO alunoDAO = new AlunoDAO();

                alunoTurma.setId(id);
                alunoTurma.setIdTurma(turmaDAO.buscar(id_turma));
                alunoTurma.setIdAluno(alunoDAO.buscar(id_aluno));
           
                alunoTurmas.add(alunoTurma);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunoTurmas;
    }

    private PreparedStatement createPreparedStatement(Connection con, int id) throws SQLException {
        String sql = "select * from alunos_turma where idalunos_turma = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public AlunoTurma exclui(AlunoTurma alunoTurma) {
        String sql = "delete from alunos_turma where idalunos_turma = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, alunoTurma.getId());
            stmt.execute();
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunoTurma;
    }
}
