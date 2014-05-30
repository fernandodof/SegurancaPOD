/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
public class ConnectionFactory {
    private static ConnectionFactory instance;
    private final String url;
    private final String usuario;
    private final String senha;

    private ConnectionFactory() {
        this.url = "jdbc:postgresql://localhost:5432/projeto2pod";
        this.usuario = "postgres";
//        this.senha = "123";
        this.senha = "123456";
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException("Problems Initializing database");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}
