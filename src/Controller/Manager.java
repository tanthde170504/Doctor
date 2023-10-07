/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Manager {

    Validation validation = new Validation();
    
    //allow user add doctor
    public void addDoctor(ArrayList<Doctor> ld) {
        System.out.println("--------- Add Doctor ----------");
        System.out.print("  Enter code: ");
        String code = validation.checkInputString();
        //check code exist or not
        if (!validation.checkCodeExist(ld, code)) {
            System.out.println("Code exist!!!");
            return;
        }
        System.out.print("  Enter name: ");
        String name = validation.checkInputString();
        System.out.print("  Enter specialization: ");
        String specialization = validation.checkInputString();
        System.out.print("  Enter availability: ");
        int availability = validation.checkInputInt();
        //check worker duplicate
        if (!validation.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful!!!");
    }

    //allow user update doctor
    public void updateDoctor(ArrayList<Doctor> ld) {
        System.out.println("--------- Update Doctor -------");
        System.out.print("  Enter code: ");
        String code = validation.checkInputString();
        //check code exist or not
        if (validation.checkCodeExist(ld, code)) {
            System.err.println("  Not found doctor!!!");
            return;
        }
        System.out.print("  Enter code: ");
        String codeUpdate = validation.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("  Enter name: ");
        String name = validation.checkInputString();
        System.out.print("  Enter specialization: ");
        String specialization = validation.checkInputString();
        System.out.print("  Enter availability: ");
        int availability = validation.checkInputInt();
        //check user change infomation or not
        if (!validation.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.out.println("No change!!!");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful!!!");
    }

    //allow user delete doctor
    public void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.println("--------- Delete Doctor -------");
        System.out.print("  Enter code: ");
        String code = validation.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor!!!");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful!!!");
    }

    //allow user search doctor
    public void searchDoctor(ArrayList<Doctor> ld) {
        System.out.println("---------- Search Doctor --------");
        System.out.print("  Enter text: ");
        String nameSearch = validation.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty!!!");
        } else {
            System.out.printf("%-15s%-20s%-30s%-30s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-20s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
