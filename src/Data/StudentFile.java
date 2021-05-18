/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;



/**
 *
 * @author aashiq
 */
public class StudentFile{
    
    private File read;

    public StudentFile() {
        
        read = new File ("/Users/aashiq/Documents/Fisrt Java/ABCCAMPUS/Result.txt");
    }
    
    // To read PrizeWinners from the textfile (Prizewinners.txt)

    public  ArrayList<LoginImpl> readFile()
    {
        
        File path = new File ("Prizewinners.txt");
        
        ArrayList <LoginImpl> rList = new ArrayList<>();
        
        
        try {
            
            Scanner sc = new Scanner (read);
            
            
            while (sc.hasNextLine ())
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
            
        } catch (Exception e)
        {
            e.printStackTrace();
            return rList;
        }
        
        
        
    }
    
    //-------------------------------------
    // To write PrizeWinners in to the textfile (Prizewinners.txt)
    public boolean writeFile(ArrayList<Object> objList) {
        
        File path = new File ("Prizewinners.txt");
        
        try{
            
            
            FileWriter writer = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter (writer);
            
            for (Object ob : objList)
            {
               BestPerformers s = (BestPerformers) ob;
               
               String writeTop3 = "PRIZE WINNERS\n " + s.getHigh1() + " " + s.getHigh2() + " " + s.getHigh3()+ System.lineSeparator();
               
               
               pw.write(writeTop3);
               
            }
            
            pw.close();
            writer.close();
           
            
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return false;
    }
}


