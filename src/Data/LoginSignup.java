/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

import java.io.*;
import java.util.*;

import Business.*;


/**
 *
 * @author aashiq
 */
public class LoginSignup implements abcFile{

    private File loc;
    
    public LoginSignup() {
        
        loc = new File ("Result.txt");
        
    }
    
    //-------------------------------------
    // To read Results from the textfile (Results.txt
    
    @Override
    public ArrayList<Object> readFile() {
        
        
        
        ArrayList<Object> rList = new ArrayList<>();
        
        try {
            
            Scanner sc = new Scanner (loc);
            
            while (sc.hasNextLine())  
            {
                String line = sc.nextLine();
                String[] std = line.split(" ");
                String user = std[0];
                String pass = std[1];
                int stdId = Integer.valueOf(std[2]);
                String fName = std[3];
                String lName = std[4];
                int bNo = Integer.valueOf(std[5]);
                int mod1 = Integer.valueOf(std[6]);
                int mod2 = Integer.valueOf(std[7]);
                
                LoginImpl s = new LoginImpl (user, pass, stdId, fName, lName, bNo, mod1, mod2);
                rList.add(s);
                
            }
            
            sc.close();
            return rList;
            
        }catch (Exception e)
        {
            e.printStackTrace();
            return rList;
        }
        
        
    }

    //-------------------------------------
    // To write Results to the textfile (Results.txt)
    @Override
    public boolean writeFile(ArrayList<Object> objList) {
        
        try {
            
                FileWriter fw = new FileWriter (loc, true);
                PrintWriter pw = new PrintWriter (fw);
                
                for (Object ob : objList)
                {
                    Login s = (Login) ob;
                    String writeLine = s.getUsername() + " " + s.getPassword() + " " + s.getStdId() + " " +
                            s.getFirstName() + " " + s.getLastName() + " " + 
                            s.getBatchNumber() + " " + s.getMark1() + " " + s.getMark2() + " " + System.lineSeparator();
                    
                    
                    pw.write(writeLine);
                    
                }
                
                fw.close();
                pw.close();
                
            
            
        } catch (Exception e)         
        {
            e.printStackTrace();
            
        }
        return false;
        
        
        
    }
    
}
