/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_package;

/**
 *
 * @author C L
 */
public class User {   //parent
    //attributes
    private String Name;
    private String Address;
    
    public User(String Name, String Address, String Age) {
        this.Name = Name;
        this.Address = Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

   
    
}
