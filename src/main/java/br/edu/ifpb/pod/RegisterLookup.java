/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Fernando
 */
public class RegisterLookup{
    
    public Message publishLookup(Session session, Message message){

        try {
            Registry registry = LocateRegistry.getRegistry("192.168.10.11", 10888);
//            Registry registry = LocateRegistry.getRegistry("25.15.29.154", 10888);
            FacadeService facadeService = (FacadeService) registry.lookup("FacadeService");
            System.out.println(message.getMessageContent());
            return facadeService.sendMessage(session, message);
        } catch (RemoteException|NotBoundException ex) {
            Logger.getLogger(RegisterLookup.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        Registry registry = LocateRegistry.getRegistry("10.1.1.104", 10888);
//        FacadeService facadeService = (FacadeService) registry.lookup("FacadeService");
//        Session session = new Session();
//        Message message = new Message();
//        message.setId("10");
//        message.setMessageContent("jose da silva");
//        message.setTo("eu");
//        message.setFrom("tu");
//        
//        Message message1 = facadeService.sendMessage(session, message);
//        
//        System.out.println(message1.getMessageContent());
//        
//    }
    
}

