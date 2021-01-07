/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Mario Souto
 */
public class ConnectionFactory {
    
    
    
    public Connection getConnection() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "root");
            properties.setProperty("useSSL", "false");
            properties.setProperty("useTimezone", "true");
            properties.setProperty("serverTimezone", "UTC");
            properties.setProperty("allowPublicKeyRetrieval", "true");
            String con = "jdbc:mysql://localhost/gestao_autoescolas";
            return DriverManager.getConnection(con, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
