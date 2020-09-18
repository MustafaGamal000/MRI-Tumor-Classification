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
public class Patient extends User{
    private String patient_ID;
    private String phone_no;
    private String Scanned_date;
    private String Appoinment;
    private String doctor_name;
    private String Blood_group;
    private String gender;
    private final String imagePath;

    public Patient(String imagePath, String Name, String Address, String Age) {
        super(Name, Address, Age);
        this.imagePath = imagePath;
    }
    
    

    public Patient(String patient_ID, String phone_no, String Scanned_date, String Appoinment, String doctor_name, String Blood_group, String gender, String imagePath, String Name, String Address, String Age) {
        super(Name, Address, Age);
        this.patient_ID = patient_ID;
        this.phone_no = phone_no;
        this.Scanned_date = Scanned_date;
        this.Appoinment = Appoinment;
        this.doctor_name = doctor_name;
        this.Blood_group = Blood_group;
        this.gender = gender;
        this.imagePath = imagePath;
    }

    public String getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getScanned_date() {
        return Scanned_date;
    }

    public void setScanned_date(String Scanned_date) {
        this.Scanned_date = Scanned_date;
    }

    public String getAppoinment() {
        return Appoinment;
    }

    public void setAppoinment(String Appoinment) {
        this.Appoinment = Appoinment;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getBlood_group() {
        return Blood_group;
    }

    public void setBlood_group(String Blood_group) {
        this.Blood_group = Blood_group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImagePath() {
        return imagePath;
    }

   
    
}
