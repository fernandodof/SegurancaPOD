package br.edu.ifpb.pod;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author FILIPE
 */
public class RegisterServiceManager {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(10888);
        registry.bind("FacadeService", new Manager());
    }
}
