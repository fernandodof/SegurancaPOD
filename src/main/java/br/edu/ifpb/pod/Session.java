/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
/**
 *
 * @author Fernando
 */
public class Session implements Serializable{
    public String id;
    public Time time;
    public boolean valid;

    public Session() {
    }
    
    public Session(Time time, boolean valid) {
        this.id = this.generateId();
        this.time = time;
        this.valid = valid;
    }
    
    private synchronized String generateId(){
        return Calendar.getInstance().getTime().toString().concat(String.valueOf(Math.random()));
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
