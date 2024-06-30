package operation;

import java.util.List;
import java.util.Scanner;

import dao.MedicalDAO;
import model.Medical;

public class MedicalReportsOperation {
	public static void addMedicalRepost(Scanner sc) {
        System.out.println("Enter Patient Name:");
        String p_name = sc.next();
        sc.nextLine();
/*
        System.out.println("Enter  Date:");
        String date = sc.next();
        sc.next();*/

        System.out.println("Enter Test Type:");
        String test_type = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Result of test:");
      String result1 = sc.nextLine();
      sc.nextLine();
      System.out.println("Enter Diagnosis:");
      String diagnosis = sc.nextLine();
      sc.nextLine();

        
        // Creating object of Student class
        Medical obj = new Medical(p_name, test_type,result1,diagnosis);

        // Calling method to insert into table and passing the object of Student class
        boolean result = MedicalDAO.insert(obj);
        if (result) {
            System.out.println("The Medical Report  is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void updateMedical(Scanner sc) {
        System.out.println("Enter Patients name to update:");
        String p_name = sc.next();
        sc.nextLine();
        /*System.out.println("Enter date (YYYY-MM-DD):");
        String date = sc.next();*/
        System.out.println("Enter Test Type:");
        String test_type = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Test Result:");
        String result1 = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Diagnosis:");
        String diagnosis = sc.nextLine();
        sc.nextLine();

        // Creating object of Student class
        Medical obj = new Medical(p_name,test_type,result1,diagnosis);

        // Calling method to update the record in the table
        boolean result = MedicalDAO.update(obj, p_name);
        if (result) {
            System.out.println("The Medical Report is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void showMedical(Scanner sc) {
        // Get all Students
        List<Medical> medicals = MedicalDAO.getAllMedicals();
        for (Medical medical : medicals) {
            System.out.println(medical);
        }
    }

    public static void showMedicalByName(Scanner sc) {
        System.out.println("Enter Patient Name to get data:");
        String p_name = sc.next();
        Medical obj = MedicalDAO.getByPatientName(p_name);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Patient with Name " + p_name + " not found.");
        }
    }

  

}
