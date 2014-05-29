/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod;

import br.edu.ifpb.dao.LoginDao;
import java.util.ArrayList;
import sun.security.jgss.LoginConfigImpl;

/**
 *
 * @author Fernando
 */
public class Manager implements LoginService{

    @Override
    public Session login(String login, String password) {
        LoginDao loginDao = new LoginDao();
        loginDao.login(login, password)
    }

    @Override
    public void logout(Session sesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message sendMessage(Session session, Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
