/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import br.edu.ifpb.dao.LoginDao;
import br.edu.ifpb.pod.Session;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

/**
 *
 * @author Fernando
 */
public class Security {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginDao loginDao = new LoginDao();
        try {
            System.out.println(loginDao.login("fernan", "123456"));
            Date d = new Date();
            Session s = new Session();
            
            System.out.println(s.getId());
            
//            System.out.println(d.getTime());
        } catch (SQLException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
