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
import Beans.HoraAula;

/**
 *
 * @author Mario Souto
 */
public class HoraAulaDAO {
    
    HoraAula[] horaAula = new HoraAula[5];


    public List<HoraAula> lista() {

        String sql = "select * from hora_aula";
        List<HoraAula> horaAulas = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
                ) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HoraAula h = new HoraAula();
                int id = rs.getInt("idhora_aula");
                String hora = rs.getString("hora_aula");
                
                
                
                h.setId(id);
                h.setHoraAula(hora);
                horaAulas.add(h);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return horaAulas;
    }
    
    public HoraAula localizar(int cod) {
        String sql = "select * from hora_aula where idhora_aula = ?";
        HoraAula obj = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cod);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    obj = new HoraAula();
                    obj.setId(rs.getInt("idhora_aula"));
                    obj.setHoraAula(rs.getString("hora_aula"));
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
    
    

    
       

}
