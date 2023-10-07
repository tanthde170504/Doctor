/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Manager;
import Controller.Validation;
import Model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Main {
    private Validation validation = new Validation();

    public int menu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("   1. Add doctor");
        System.out.println("   2. Update doctor");
        System.out.println("   3. Delete doctor");
        System.out.println("   4. Search doctor");
        System.out.println("   5. Exit");
        System.out.print("Enter your choice: ");
        int choice = validation.checkInputIntLimit(1, 5);
        return choice;
    }

    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        Manager manager = new Manager();
        Main main = new Main(); // Create an instance of Main
        while (true) {
            int choice = main.menu(); // Access menu() through the instance
            switch (choice) {
                case 1:
                    manager.addDoctor(ld);
                    break;
                case 2:
                    manager.updateDoctor(ld);
                    break;
                case 3:
                    manager.deleteDoctor(ld);
                    break;
                case 4:
                    manager.searchDoctor(ld);
                    break;
                case 5:
                    return;
            }
        }
    }
}