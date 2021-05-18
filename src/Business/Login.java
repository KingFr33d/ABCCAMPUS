/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author aashiq
 */
public abstract class Login {
    
    private String username;
    private String password;
    private int stdId;
    private String firstName;
    private String lastName;
    private int batchNumber;
    private int mark1;
    private int mark2;

    public Login() {
    }

    public Login(String username, String password, int stdId, String firstName, String lastName, int batchNumber, int mark1, int mark2) {
        this.username = username;
        this.password = password;
        this.stdId = stdId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batchNumber = batchNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }
    

    
    
    
    
}
