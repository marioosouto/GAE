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

/**
 *
 * @author Mario Souto
 */
public class AlunoDAO {

    Aluno[] aluno = new Aluno[5];

    public Aluno adiciona(Aluno aluno) {

        String sql = "INSERT INTO aluno (nome,cpf,rua,numero,bairro,categoria,sexo)"
                + "values (?,?,?,?,?,?,?)";
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery("select * from aluno where cpf = '" + aluno.getCpf() + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getCpf());
                stmt.setString(3, aluno.getRua());
                stmt.setString(4, aluno.getNumero());
                stmt.setString(5, aluno.getBairro());
                stmt.setString(6, aluno.getCategoria());
                stmt.setString(7, aluno.getSexo());
                stmt.execute();
                System.out.println("Aluno inserido com sucesso.");
                 JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "Adicionado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;

    }

    public List<Aluno> lista() {

        String sql = "select * from aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (Connection connection = new Banco.ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                int id = rs.getInt("idaluno");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                String categoria = rs.getString("categoria");
                String sexo = rs.getString("sexo");

                aluno.setIdaluno(id);
                aluno.setNome(nome);
                aluno.setCpf(cpf);
                aluno.setRua(rua);
                aluno.setNumero(numero);
                aluno.setBairro(bairro);
                aluno.setCategoria(categoria);
                aluno.setSexo(sexo);
                alunos.add(aluno);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

    public Aluno altera(Aluno aluno) {
        String sql = "update aluno set nome = ?, cpf = ?,"
                + " rua = ?, numero = ?, bairro = ?, categoria = ?, sexo = ? where idaluno = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery("select * from aluno where cpf = '" + aluno.getCpf() + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getCpf());
                stmt.setString(3, aluno.getRua());
                stmt.setString(4, aluno.getNumero());
                stmt.setString(5, aluno.getBairro());
                stmt.setString(6, aluno.getCategoria());
                stmt.setString(7, aluno.getSexo());
                stmt.setInt(8, aluno.getIdaluno());
                stmt.execute();
                System.out.println("Aluno alterado com sucesso.");
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Alterado", JOptionPane.INFORMATION_MESSAGE);
            }

           
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }

    public Aluno exclui(Aluno aluno) {
        String sql = "delete from aluno where idaluno = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, aluno.getIdaluno());
            stmt.execute();

            System.out.println("Aluno excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }

}
