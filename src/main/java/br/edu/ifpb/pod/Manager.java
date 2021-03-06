/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod;

import br.edu.ifpb.dao.LoginDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class Manager extends UnicastRemoteObject implements FacadeService{
    LoginDao loginDao = new LoginDao();
    ArrayList<Session> sessionList = new ArrayList();

    public Manager() throws RemoteException{
        super();
    }
    
    @Override
    public Session login(String login, String password) throws RemoteException{
        System.out.println(login);
        System.out.println(password);
        try {
            if(this.loginDao.login(login, password)){
                Session session = new Session();
                sessionList.add(session);
                System.out.println(session.getId());
                System.out.println(session.isValid());
                return session;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void logout(Session sesion) {
        sesion.setValid(false);
        sessionList.remove(sesion);
    }

    @Override
    public Message sendMessage(Session session, Message message) {
        if(sessionList.contains(session)){
            RegisterLookup registerLookup = new RegisterLookup();
            return registerLookup.publishLookup(session, message);
        }
        return null;
    }

    @Override
    public ArrayList<Message> publish(ArrayList<Message> messages) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
