/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Beans.Veiculo;
import DAOS.VeiculoDAO;

/**
 *
 * @author Mario Souto
 */
public class VeiculoDAO {
    
   

    public Veiculo adiciona(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa,chasse,modelo)"
                + "values (?,?,?)";
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getChassi());
            stmt.setString(3, veiculo.getModelo());
            stmt.execute();
            System.out.println("Veiculo inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }

    public List<Veiculo> lista() {

        String sql = "select * from veiculo";
        List<Veiculo> veiculos = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                int id = rs.getInt("idveiculo");
                String placa = rs.getString("placa");
                String chassi = rs.getString("chasse");
                String modelo = rs.getString("modelo");
                veiculo.setIdveiculo(id);
                veiculo.setPlaca(placa);
                veiculo.setChassi(chassi);
                veiculo.setModelo(modelo);
                veiculos.add(veiculo);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculos;
    }
    
    public Veiculo altera(Veiculo veiculo) {
        String sql = "update veiculo set placa = ?, chasse = ?,"
                + " modelo = ? where idveiculo = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getChassi());
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getIdveiculo());
            stmt.execute();

            System.out.println("Veiculo alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }

    public Veiculo exclui(Veiculo veiculo) {
        String sql = "delete from veiculo where idveiculo = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, veiculo.getIdveiculo());
            stmt.execute();

            System.out.println("Veiculo excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }
    
    
}
