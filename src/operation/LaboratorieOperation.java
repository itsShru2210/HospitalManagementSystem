package operation;

import java.util.List;
import java.util.Scanner;

import dao.LaboratoriesDAO;
import model.Labortories;

public class LaboratorieOperation {
	public static void addlab(Scanner sc) {
        System.out.println("Enter Laboratories Name:");
        String facilities = sc.next();
sc.nextLine();
System.out.println("Enter cost:");
        int cost = sc.nextInt();

        // Creating object of  class
        Labortories obj = new Labortories(facilities ,cost);

        // Calling method to insert into table and passing the object of Student class
        boolean result = LaboratoriesDAO.insert(obj);
        if (result) {
            System.out.println("The Laboratory is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }
/*
    public static void updateLab(Scanner sc) {
        System.out.println("Enter student ID to update:");
        String studentID = sc.next();

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
        Student obj = new Student(studentID, firstName, lastName, java.sql.Date.valueOf(dateOfBirthStr), gender, email, phone);

        // Calling method to update the record in the table
        boolean result = StudentDAO.update(obj, studentID);
        if (result) {
            System.out.println("The student is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }
    }*/

    public static void showlabs(Scanner sc) {
        // Get all 
        List<Labortories> labortoriess = LaboratoriesDAO.getAlllabs();
        for (Labortories labortories : labortoriess) {
            System.out.println(labortories);
        }
    }

    

    public static void deletelabByName(Scanner sc) {
        System.out.println("Enter facilities Name to delete:");
        String facilities = sc.next();

        // Calling method to delete a particular record
        boolean result = LaboratoriesDAO.delete(facilities);
        if (result) {
            System.out.println("The Laboratories is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
