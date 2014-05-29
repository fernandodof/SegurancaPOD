package teste;

import br.edu.ifpb.dao.LoginDao;
import br.edu.ifpb.pod.FacadeService;
import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.Session;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;

/**
 *
 * @author FILIPE
 */

public class Test {
    
    FacadeService facadeService = new FacadeService() {

        @Override
        public Session login(String login, String password) throws RemoteException {
            LoginDao loginDao = new LoginDao();
            
            try {
                loginDao.login(login, password);
                return new Session();
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        @Override
        public void logout(Session sesion) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Message sendMessage(Session session, Message message) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ArrayList<Message> publish(ArrayList<Message> messages) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    public Test() {
    }
    
    @org.junit.Test
    public void testLogin() throws RemoteException {
        assertNotNull(facadeService.login("filipe", "jhv654")); 
    }
}
