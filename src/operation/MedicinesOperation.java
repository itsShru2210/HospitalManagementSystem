package operation;

import java.util.List;
import java.util.Scanner;

import dao.MedicineDAO;
import model.Medicine;

public class MedicinesOperation {
	public static void addMedicine(Scanner sc) {
        System.out.println("Enter Medicine Name:");
        String med_name = sc.next();
        
        /*System.out.println("Enter Medicine Expire Date:");
        String exp_date = sc.nextLine();
        sc.nextLine();*/

        System.out.println("Enter Company name:");
        String company = sc.next();
        sc.nextLine();

        System.out.println("Enter Medicine Cost:");
       int med_cost = sc.nextInt();

        
        // Creating object of Student class
        Medicine obj = new Medicine(med_name,company, med_cost);

        // Calling method to insert into table and passing the object of Student class
        boolean result = MedicineDAO.insert(obj);
        if (result) {
            System.out.println("The Medicine is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

   /* public static void updateMedicine(Scanner sc) {
        System.out.println("Enter medicine name to update:");
        String med_name = sc.next();

        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter date of birth (YYYY-MM-DD):");
        String dateOfBirthStr = sc.next();

        System.out.println("Enter gender:");
        String gender = sc.next();

        System.out.println("Enter email:");
        String email = sc.next();

        System.out.println("Enter phone:");
        String phone = sc.next();

        // Creating object of Student class
        Student obj = new Student(med_name, java.sql.Date.valueOf(exp_date),company, med_cost);

        // Calling method to update the record in the table
        boolean result = StudentDAO.update(obj, studentID);
        if (result) {
            System.out.println("The student is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }
    }*/

    public static void showMedicines(Scanner sc) {
        // Get all Students
        List<Medicine> medicines = MedicineDAO.getAllMedicines();
        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }

    public static void showMedicineByName(Scanner sc) {
        System.out.println("Enter Medicine Name to get data:");
        String med_name = sc.next();
        Medicine obj = MedicineDAO.getByMedicineName(med_name);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Medicine with Name " + med_name + " not found.");
        }
    }

    public static void deleteMedicineByName(Scanner sc) {
        System.out.println("Enter Medicine Name to delete:");
        String med_name = sc.next();

        // Calling method to delete a particular record
        boolean result = MedicineDAO.delete(med_name);
        if (result) {
            System.out.println("The Medicine is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
