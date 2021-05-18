/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Aashiq Umar (KD/HDCSE/50/22)
 */

//Neccesary tools
import java.util.*;
import java.io.*;
        

//Packages
import Business.*;
import Data.*;
import java.util.stream.Collectors;


public class Main {
    
    public static void main (String [] args)
    {
        //MAIN METHOD
        
          startup();  
        
    }
    
    //-------------------------------------
    //StartUp Screen
    private static void startup()
    {
        LoginInfo lr = new LoginInfo();
        StudentFile stdF = new StudentFile();
        StudentFile fr = new StudentFile();
        LoginSignup ls = new LoginSignup();
        StudentFile sf = new StudentFile();
        
        
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("________---------ABC CAMPUS---------________");
        System.out.println(" ");
        System.out.println("\t       - LOGIN [1] - ");
        System.out.println("\t      - REGISTER [2] - ");
        System.out.println("\t       - HELP [3] - ");
        System.out.println("");
        System.out.print("\t      - ENTER CODE : "); int code = sc.nextInt(); 
        System.out.println("");
        
       
        
        switch (code)
        {
            case 1:
                login(ls, lr);
                break;
            case 2:
                registerStd(ls);
            case 3:
                
            default:
                System.out.println("Invalid Code");
                
        }
    }
    
    
    //-------------------------------------
    //Login Method
    private static void login (LoginSignup ls, LoginInfo lg)
    {
        LoginInfo sg = new LoginInfo();
        StudentFile sf = new StudentFile();
        LoginSignup lk = new LoginSignup();
        
        ArrayList <Object> rList = ls.readFile();
        ArrayList <Object> readFile = lg.readFile();
        ArrayList <LoginImpl> read = sf.readFile();
        
        Scanner sc = new Scanner (System.in);
        
        
        for (Object ob : rList)
        {
            if (ob instanceof LoginImpl)
            {
                LoginImpl s = (LoginImpl) ob;
                
                boolean yes = false;
                
                String user = s.getUsername();
                String pass = s.getPassword();
                String sum = user + pass;
                
                
                System.out.println("--------------------------------------------");
                System.out.println("\t\t LOGIN PAGE");
                System.out.println(" ");
                System.out.print("\t - USERNAME : "); String username = sc.next();
                System.out.print("\t - PASSWORD : "); String password = sc.next();
                
               
                    
                if (username.equals(user) && password.equals(pass))
                {   
                        yes = true;
                        homescreenStudent();
                    
                }
                
                else if (!username.equals(ob) && !password.equals(user))
                {
                    System.out.println("");
                    System.out.println("Try Again! Incorrect Login Info");
                    login(lk, lg);
                }
                
                else if (!username.equals(user))
                {
                    System.out.println("");
                    System.out.println("Try Again! Incorrect Login Info");
                    login(lk, lg);
                   
                }
                
                
                else if (user.equals("abc@admin") && pass.equals("abc123"))
                {
                    homescreenStudent();
                }
                
            }   
               
        }
        
        
        
    }
    
    
    private static void readLogin(RecordLogin rl)
    {
        
    }
    
    
    
    //-------------------------------------
    //To register students to ABC Campus
    private static void registerStd (LoginSignup ls)
    {
        LoginInfo tr = new LoginInfo();
        LoginInfo lj = new LoginInfo();
        LoginSignup lk = new LoginSignup();
        
        LoginSignup kl = new LoginSignup();
        
        ArrayList<Object> regList = new ArrayList<>();
        ArrayList<Object> logList = new ArrayList<>();
        
        
        Scanner sc = new Scanner (System.in);
        String ans = "yes";
        
        while (ans.equals("yes"))
        {
            System.out.println("--------------------------------------------");
            System.out.println("");
            System.out.println("\tABC CAMPUS REGISTRATION FORM");
            System.out.println(" ");
            System.out.print("1. Enter Username : "); String user = sc.next();
            System.out.print("2. Enter Password : "); String pass = sc.next();
            System.out.print("3. Enter Student ID : "); int stdId = sc.nextInt();
            System.out.print("4. Enter First Name : "); String fName = sc.next();
            System.out.print("5. Enter Last Name : "); String lName = sc.next();
            System.out.print("6. Enter Batch No. : "); int batchNo = sc.nextInt();
            System.out.print("7. Enter Module 1 Mark : "); int mod1 = sc.nextInt();
            System.out.print("8. Enter Module 2 Mark : "); int mod2 = sc.nextInt();
            System.out.println("");
            System.out.println("Successfully Registered...");
            
            LoginImpl s = new LoginImpl (user, pass, stdId, fName, lName, batchNo, mod1, mod2);
            RecordLogin w = new RecordLogin (user, pass);
            
            logList.add(s);
            regList.add(w);
            
            ls.writeFile(logList);
            lj.writeFile(regList);
            
            System.out.println("");
            System.out.println("[1] - LOGIN");
            System.out.println("[2] - EXIT");
            System.out.print("\nEnter Code [1] : ");
            int code = sc.nextInt();
            
            if (code == 1)
            {
                login(lk, tr);
            }
            
            else if (code == 2)
            {
                return;
            }
            
        }
        
        
    }
    
    
    
    
    //-------------------------------------
    //Homescreen of registered students 
    private static void homescreenStudent ()
    {
       Scanner sc = new Scanner (System.in);
       LoginSignup si = new LoginSignup();
       LoginSignup sk = new LoginSignup();
       LoginSignup sf = new LoginSignup();
       
       
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("\t\t_-HOME PAGE-_");
        System.out.println(" ");
        System.out.println("- Show Student Details : [1]");
        System.out.println("- Check Results : [2]");
        System.out.println("- Prize Winners : [3]");
        System.out.println("- EXIT : [4]");
        System.out.println("");
        System.out.print("Enter Code : "); int code = sc.nextInt();
        
        if (code == 1)
        {       
            checkDetails(si);
        }
        
        else if (code == 2)
        {
            calculateMarks(si);
        }
        
        else if (code == 3)
        {
            prizewinners();
        }
        
        else if (code == 4)
        {
            startup();
        }
        
        
        }
    
    
    //-------------------------------------
    //Prizewinners menu, to check the top scorers in the course
    private static void prizewinners ()
    {
        LoginSignup sf = new LoginSignup ();
        StudentFile sj = new StudentFile ();
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("\t\t_-PRIZE WINNERS-_");
        System.out.println("");
        System.out.println("- Top 3 Winners : [1]");
        System.out.println("- Best Performers : [2]");
        System.out.println("- Return [3]");
        System.out.print("Enter CODE : "); int code = sc.nextInt();
        
        switch (code){
            case 1:
                jav(sj);
                break;
            case 2:
                bestPerformer();
                break;
            case 3:
                homescreenStudent();
            default:
            
                System.out.println("Enter Correct Code!");
                prizewinners();
                break;
        }
        
        
                
        
    }
    
    
    //-------------------------------------
    //To check the details of the current user of the system
    private static void checkDetails (LoginSignup sf)
    {
        ArrayList <Object> rList = sf.readFile();
        Scanner sc = new Scanner (System.in);
        
        for (Object ob : rList)
                {
                    if (ob instanceof Login)
                    {
                        Login s = (Login) ob;
                        
                            System.out.println("--------------------------------------------");
                            System.out.println("");
                            System.out.println("\t\tSTUDENT DETAILS");
                            System.out.println("");
                            System.out.println("- Student ID : " + "[" + s.getStdId() + "]");
                            System.out.println("- First Name : " + "[" + s.getFirstName() + "]");
                            System.out.println("- Last Name : " + "[" + s.getLastName() + "]");
                            System.out.println("- Batch Number : " + "[" + s.getBatchNumber() + "]");
                            System.out.println("- Marks Module 1 : " + "[" + s.getMark1() + "]");
                            System.out.println("- Marks Module 2 : " + "[" + s.getMark2() + "]");
                            
                            System.out.println("");
                            System.out.print("To Return, type 'yes' and Enter! : "); String ans = sc.next();
                            
                            
                            
                            if (ans.equals("yes"))
                            {
                                homescreenStudent();

                            }

                        }
                    }
                
        
    }
    
    
    //-------------------------------------
    //To get the result of the Current user
    private static void calculateMarks (LoginSignup si)
    {
        ArrayList <Integer> rList = new ArrayList<>();
        ArrayList <Object> wList = si.readFile();
        Scanner sc = new Scanner (System.in);
        
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("\t\tYOUR RESULT");
        System.out.println("");
        for (Object ob : wList)
        {
            if (ob instanceof Login)
            {
                Login s = (Login) ob;
                
                int mod1 = s.getMark1();
                int mod2 = s.getMark2();
                int sum = mod1 + mod2;
                int avg = sum/2;
                
                
                
                
                System.out.println("- Student ID : " + "[" + s.getStdId() + "]");
                System.out.println("- First Name : " + "[" + s.getFirstName() + "]");
                System.out.println("- Last Name : " + "[" + s.getLastName() + "]");
                System.out.println("- Batch Number : " + "[" + s.getBatchNumber() + "]");
                System.out.println("- Marks Module 1 : " + "[" + s.getMark1() + "]");
                System.out.println("- Marks Module 2 : " + "[" + s.getMark2() + "]");
                System.out.println("");
                System.out.println("Total Marks = " + sum);
                System.out.println("Average = " + avg);
                System.out.println("");
                
                
                System.out.println("");
                System.out.print("To Return, type 'yes' and Enter! : "); String ans = sc.next();
                
                if (ans.equals("yes"))
                {
                    homescreenStudent();
                } 
                
                
            }
        }
        
        
        
    }
    
    
    //-------------------------------------
    //Best performer in each modules Menu
    private static void bestPerformer ()    
    {
        StudentFile sj = new StudentFile();
        StudentFile hj = new StudentFile();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("\t\tBEST PERFORMERS");
        System.out.println("");
        System.out.println("- Module 1 : [1]");
        System.out.println("- Module 2 : [2]");
        System.out.println("- Return : [3]");
        System.out.println("");
        System.out.print("Enter Code : "); int code = sc.nextInt();
        
        if (code == 1)
        {
            PerformerModule1(sj); //Module1 
        }
        
        else if (code == 2)
        {
            PerformerModule2(sj); //Module2
        }
        else if (code == 3)
        {
            prizewinners(); //PrizeWinners Menu
        }
        
        
    }
    
    
    //-------------------------------------
    //help menu
    private static void help()
    {
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("\t\tHELP GUIDELINES");
        System.out.println("");
        
        
    }
    
    
    //-------------------------------------
    //To find the top 3 Students among registered students
    private static void jav (StudentFile fr) 
    {
        ArrayList<LoginImpl> lList = fr.readFile();
        ArrayList<Object> wList = new ArrayList<>();
        
        Scanner sc = new Scanner (System.in);
        
        int first = Integer.MIN_VALUE;
        String fStud = "";
        
        int second = Integer.MIN_VALUE;
        String sStud = "";
        
        int third = Integer.MIN_VALUE;
        String tStud = "";
        
        for (LoginImpl l : lList )
        {
            int current = l.getMark1() + l.getMark2();
            
            if (first < current)
            {
                third = second;
                tStud = sStud;
                second = first;
                sStud = fStud;
                first = current;
                fStud = "PLACE - " + l.getStdId() + " " + l.getFirstName() + " " + l.getLastName() + " Total = " + first + System.lineSeparator();
              
            }
            
            else if (second < current)
            {
                third = second;
                tStud = sStud;
                second = current;
                sStud = "PLACE - " + l.getStdId() + " " + l.getFirstName() + " " + l.getLastName() + " Total = " + second + System.lineSeparator();
            }
            
            else if (third < current)
            {
                third = current;
                tStud = "PLACE - " + l.getStdId() + " " + l.getFirstName() + " "+ l.getLastName() + " Total = " + third + System.lineSeparator();
            }
            
            
        }
        
        System.out.println("");
        System.out.println("-------------TOP3 STUDENTS--------------");
        System.out.println("");   
        String score = "1ST " + fStud;
        String sec = "2ND " + sStud;
        String name = "3RD " + tStud;
        
        BestPerformers s = new BestPerformers (score, sec, name);
        wList.add(s);
        fr.writeFile(wList);
        
        System.out.println(score);
        System.out.println(sec);
        System.out.println(name);
        
         System.out.println("");
         System.out.print("To Return, type 'yes' and Enter! : "); String ans = sc.next();
                
                if (ans.equals("yes"))
                {
                    prizewinners();
                } 
                
                else if (!ans.equals("yes"))
                {
                    return;
                }
        
        
        
        
    }
    
    
    //-------------------------------------
    //To Fint the Highest Marks in Module 1
    private static void PerformerModule1(StudentFile ls)
    {
        ArrayList <LoginImpl> rList = ls.readFile();
        ArrayList <Object> wList = new ArrayList<>();
        
            int first = Integer.MIN_VALUE;
            String fStud = "";
        
            int second = Integer.MIN_VALUE;
            String sStud = "";
        
            int third = Integer.MIN_VALUE;
            String tStud = "";
            
            String det2 = "";
            String det3 = "";
        
        Scanner sc = new Scanner (System.in);
        
        for (LoginImpl s : rList)
        {
            int score = s.getMark1();
            
            if (score > first)
            {
                third = second;
                second = first;
                sStud = fStud;
                first = score;
                fStud = "MODULE 1 - Student ID : " + s.getStdId();
                det2 = " " + s.getFirstName() + " ";
                det3 = s.getLastName() + " " + "[MARKS = " + first + "]"  +System.lineSeparator();
            
            }
            
            else if (score > second)
            {
                third = second;
                tStud = sStud;
                second = score;
                sStud = "MODULE 1 : Highest - " + s.getStdId();
                
            }
            
            else if (score > third)
            {
                third = score;
                tStud = "MODULE 1 : Highest - " + s.getStdId();
                
            }
        }
        
        BestPerformers d = new BestPerformers (fStud, det2, det3);
        wList.add(d);
        ls.writeFile(wList);
        
        String dis = "1st - " + fStud + det2 + det3;
        System.out.println("");
        System.out.println("---------BEST PERFORMER MODULE 1--------");
        System.out.println("");
        System.out.println(dis);
        
         System.out.println("");
         System.out.print("To Return, type 'yes' and Enter! : "); String ans = sc.next();
                
                if (ans.equals("yes"))
                {
                    bestPerformer();
                } 
                
                else if (!ans.equals("yes"))
                {
                    return;
                }
        
        
        
    }
    
    
    
    //-------------------------------------
    //To Fint the Highest Marks in Module 2
    private static void PerformerModule2(StudentFile fr)
    {
        ArrayList <LoginImpl> rList = fr.readFile();
        ArrayList <Object> wList = new ArrayList<>();
        
            int first = Integer.MIN_VALUE;
            String fStud = "";
        
            int second = Integer.MIN_VALUE;
            String sStud = "";
        
            int third = Integer.MIN_VALUE;
            String tStud = "";
        
            String det2 = "";
            String det3 = "";
            
        Scanner sc = new Scanner (System.in);
        
        for (LoginImpl s : rList)
        {
            int score = s.getMark2();
            
            if (score > first)
            {
                third = second;
                second = first;
                sStud = fStud;
                first = score;
                fStud = "MODULE 2 : Student ID - " + s.getStdId() + " ";
                det2 = s.getFirstName() + "";
                det3 = s.getLastName() + " " + "[MARKS = " + first + "]" + System.lineSeparator();
            
            }
            
            else if (score > second)
            {
                third = second;
                tStud = sStud;
                second = score;
                sStud = "MODULE 2 : Highest - " + s.getStdId();
                
            }
            
            else if (score > third)
            {
                third = score;
                tStud = "MODULE 2 : Student ID - " + s.getStdId();
                det2 = " " + s.getFirstName() + " ";
                
            }
            
        }
        
        String dis = "1st - " + " " + det2 + " " + det3;
        System.out.println("");
        System.out.println("---------BEST PERFORMER MODULE 2--------");
        System.out.println("");
        System.out.println(dis);
        
        BestPerformers s = new BestPerformers (fStud, det2, det3);
        wList.add(s);
        fr.writeFile(wList);
        
        
         System.out.println("");
         System.out.print("To Return, type 'yes' and Enter! : "); String ans = sc.next();
                
                if (ans.equals("yes"))
                {
                    bestPerformer();
                } 
                
                else if (!ans.equals("yes"))
                {
                    return;
                }

    
            }
    
    }
    
    

        
    
    
    