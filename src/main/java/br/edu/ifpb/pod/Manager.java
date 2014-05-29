/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod;

import br.edu.ifpb.dao.LoginDao;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class Manager implements Serializable, FacadeService{
    LoginDao loginDao = new LoginDao();
    ArrayList<Session> sessionList = new ArrayList();
    
    @Override
    public Session login(String login, String password) {
        Session session = null;
        try {
            if(this.loginDao.login(login, password)){
                session = new Session();
                sessionList.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            session = null;
        }
        return session;
    }

    @Override
    public void logout(Session sesion) {
        sessionList.remove(sesion);
    }

    @Override
    public Message sendMessage(Session session, Message message) {
        if(sessionList.contains(session)){
            RegisterLookup registerLookup = new RegisterLookup();
            registerLookup.publishLookup(session, message);
            return message;
        }
        return null;
    }

    @Override
    public boolean publish(ArrayList<Message> messages) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
