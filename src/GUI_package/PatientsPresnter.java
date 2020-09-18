/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_package;

import Backend_package.Patient;
import Backend_package.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C L
 */
public class PatientsPresnter {
    PatientsView view;
    
    ArrayList<Patient> patientList=new ArrayList<>();

    private String patient_ID;
    private String patientName;
    private String age;
    private String address;
    private String phone_no;
    private String Scanned_date;
    private String Appoinment;
    private String doctor_name;
    private String Blood_group;
    private String gender;
    private String imagePath;

    public PatientsPresnter(PatientsView view) {
        this.view = view;
    }
    public ArrayList<Patient> getDataFromFile() {
        File f=new File("Project Files\\Patient.txt");
            FileReader reader = null;
        try {
            reader = new FileReader(f);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
            BufferedReader bf=new BufferedReader(reader);
            String line=null;
            String[] ListOfLines = null;
        try {
            while((line= bf.readLine()) != null){
                ListOfLines=line.split("@");
                patient_ID=ListOfLines[0];
                patientName=ListOfLines[1];
                age=ListOfLines[2];
                address=ListOfLines[3];
                phone_no=ListOfLines[4];
                Scanned_date=ListOfLines[5];
                Appoinment=ListOfLines[6];
                doctor_name=ListOfLines[7];
                Blood_group=ListOfLines[8];
                gender=ListOfLines[9];
                imagePath=ListOfLines[10];
                User patient=new Patient(patient_ID, phone_no, Scanned_date, Appoinment, doctor_name, Blood_group, gender, imagePath, patientName, address, age);
                patientList.add((Patient) patient);
            }   } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            return patientList;
}
    public void getPatientList() {
        view.onGetPatientsList(getDataFromFile());
    }
}
