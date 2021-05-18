/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.*;
import java.io.*;
import Business.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aashiq
 */
public class LoginInfo implements abcFile{

    private File path;
    public LoginInfo() {
        
        path = new File ("Login.txt");
    }

    
    @Override
    public ArrayList<Object> readFile() {
        
        ArrayList <Object> rList = new ArrayList<>();
        
        try {
            
            Scanner sc = new Scanner (path);
            
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String [] std = line.split("");
                String user = std[0];
                String pass = std[1];
                
                RecordLogin s = new RecordLogin (user, pass);
                rList.add(s);
                
            }
            
            sc.close();
            return rList;
            
            
        }catch (Exception  e)
        {
            e.printStackTrace();
            return rList;
        }
        
        
    }

    @Override
    public boolean writeFile(ArrayList<Object> objList) 
    {
        
        try {
            
            FileWriter fw = new FileWriter (path, true);
            PrintWriter pw = new PrintWriter(fw);
            
            for (Object ob : objList)
            {
                RecordLogin l = (RecordLogin) ob;
                
                String write = l.getUser() + " " + l.getPass();
                
                pw.write(write);
                
            }
            
            fw.close();
            pw.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
}
