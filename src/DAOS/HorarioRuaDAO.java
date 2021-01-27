/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Banco.ConnectionFactory;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Beans.HorarioRua;
import DAOS.InstrutorDAO;
import DAOS.HoraAulaDAO;
import Beans.HoraAula;
import Beans.Instrutor;
import Telas.TelaHorarioRua;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Mario Souto
 */
public class HorarioRuaDAO {
    
    HorarioRua[] horario = new HorarioRua[5];

    public HorarioRua adiciona(HorarioRua horario) {
        String sql = "INSERT INTO horariorua (nomealuno,horario,data,codinstrutor)"
                + "values (?,?,?,?)";
       
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
 
             ResultSet rs = stmt.executeQuery("SELECT * FROM gestao_autoescolas.horariorua WHERE horario = '" + horario.getHorario().getId() + "' and codinstrutor ='" + horario.getInstrutor().getIdInstrutor() +"' and data ='" + horario.getData()+"'");
             if(rs.next()){
                  JOptionPane.showMessageDialog(null, "Horário já agendado.", "Erro", JOptionPane.ERROR_MESSAGE);
             }else{
            stmt.setString(1, horario.getNome());
            stmt.setInt(2, horario.getHorario().getId());
            stmt.setString(3, horario.getData());
            stmt.setInt(4, horario.getInstrutor().getIdInstrutor());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "Adicionado", JOptionPane.INFORMATION_MESSAGE);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return horario;
    }

    public HorarioRua localizar(HorarioRua horario) {
        String sql = "select * from horariorua where idhorario = ?";
        HorarioRua obj = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, horario.getId());
            
            HoraAulaDAO horaAulaDAO = new HoraAulaDAO();
            InstrutorDAO dao = new InstrutorDAO();
            try (ResultSet rs = stmt.executeQuery()) {
               
                while (rs.next()) {
                    obj = new HorarioRua();
                    obj.setId(rs.getInt("idhorario"));
                    obj.setNome(rs.getString("nomealuno"));
                    obj.setHorario(horaAulaDAO.localizar(rs.getInt("horario")));
                    obj.setData(rs.getString("data"));
                    obj.setInstrutor(dao.buscar(rs.getInt("codinstrutor")));
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

    public List<HorarioRua> lista() {

        String sql = "select * from horariorua";
        List<HorarioRua> horarios = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
                ) {
            
            HoraAulaDAO horaAulaDAO = new HoraAulaDAO();
            InstrutorDAO dao = new InstrutorDAO();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HorarioRua user = new HorarioRua();
                int id = rs.getInt("idhorario");
                String nome = rs.getString("nomealuno");
                HoraAula horario = horaAulaDAO.localizar(rs.getInt("horario"));
                String data = rs.getString("data");               
                Instrutor instrutor = dao.buscar(rs.getInt("codinstrutor"));
                
                user.setId(id);
                user.setNome(nome);
                user.setHorario(horario);
                user.setData(data);
                user.setInstrutor(instrutor);
                horarios.add(user);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return horarios;
    }
    
    public HorarioRua altera(HorarioRua user) {
        String sql = "update horariorua set nomealuno = ?, horario = ?,"
                + " data = ?, codinstrutor = ? where idhorario = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getNome());
            stmt.setInt(2, user.getHorario().getId());
            stmt.setString(3, user.getData());
            stmt.setInt(4, user.getInstrutor().getIdInstrutor());
            stmt.setInt(5, user.getId());

            stmt.execute();

            System.out.println("HorarioRua alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public HorarioRua exclui(HorarioRua horario) {
        String sql = "delete from horariorua where idhorario = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, horario.getId());
            stmt.execute();

            System.out.println("HorarioRua excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return horario;
    }
    
    public List<HorarioRua> listaInstrutor(int cod) {

        String sql = "select DISTINCT * from horariorua hr inner join instrutor i on i.idinstrutor = hr.codinstrutor where "
                + "codinstrutor = ?";
        List<HorarioRua> horarios = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
                ) {
            
            HoraAulaDAO horaAulaDao = new HoraAulaDAO();
            InstrutorDAO dao = new InstrutorDAO();
            stmt.setInt(1, cod);
            //stmt.execute(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HorarioRua user = new HorarioRua();
                int id = rs.getInt("idhorario");
                String nome = rs.getString("nomealuno");
                HoraAula horaula = horaAulaDao.localizar(rs.getInt("horario"));
                String data = rs.getString("data");               
                Instrutor instrutor = dao.buscar(rs.getInt("codinstrutor"));
                
                user.setId(id);
                user.setNome(nome);
                user.setHorario(horaula);
                user.setData(data);
                user.setInstrutor(instrutor);
                horarios.add(user);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return horarios;
    }
    
      

}
