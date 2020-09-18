/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_package;

import Backend_package.Patient;
import java.util.ArrayList;

/**
 *
 * @author C L
 */
public interface PatientsView {
    void onGetPatientsList(ArrayList<Patient> patient);
}
