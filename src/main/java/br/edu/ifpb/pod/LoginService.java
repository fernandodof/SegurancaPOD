/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod;

/**
 *
 * @author Fernando
 */
public interface LoginService {
    Session login (String login, String password);
    void logout (Session sesion);
    Message sendMessage (Session session, String messageContent);
}
