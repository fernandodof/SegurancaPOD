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
    
    public void publishLookup(Session session, Message message){

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 10888);
            FacadeService loginService = (FacadeService) registry.lookup("FacadeService");
            
            loginService.sendMessage(session, message);
        } catch (RemoteException|NotBoundException ex) {
            Logger.getLogger(RegisterLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

