/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.dao;

import br.edu.ifpb.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
public class LoginDao {
    
    public boolean login(String login, String password) throws SQLException{
        String sql = "SELECT count(*) userCount FROM users WHERE login = ? AND password = ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        boolean valid = false;
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("userCount");
            if(count>0){
                valid = true;
            }
            stmt.close();
        }finally{
            connection.close();
        }
        return valid;
    }
}
