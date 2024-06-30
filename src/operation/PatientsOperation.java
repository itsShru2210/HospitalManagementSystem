package operation;

import java.util.List;
import java.util.Scanner;

import dao.PatientDAO;
import model.Patient;

public class PatientsOperation {
	 public static void addPatient(Scanner sc) {
	        System.out.println("Enter Patient ID:");
	        int p_id = sc.nextInt();

	        System.out.println("Enter Name:");
	        String p_name = sc.next();
	        sc.nextLine();
	        System.out.println("Enter Gender:");
	        String p_gender = sc.next();
	        sc.nextLine();
	        System.out.println("Enter Disease:");
	        String p_disease = sc.next();
	        sc.nextLine();
	        System.out.println("Enter Patient AGE:");
	        int p_age = sc.nextInt();
	        
	        System.out.println("Enter Patient room No:");
	        int room_no = sc.nextInt();
	        

	        System.out.println("Enter Admit Status:");
	        String amit_status = sc.next();
	        

	        // Creating object of class
	        Patient obj = new Patient(p_id,p_name,p_gender,p_disease, p_age,room_no,amit_status);

	        // Calling method to insert into table and passing the object of Instructor class
	        boolean result = PatientDAO.insert(obj);
	        if (result) {
	            System.out.println("The Patient is successfully added.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void updatePatient(Scanner sc) {
	        System.out.println("Enter Patients ID to update:");
	        int p_id = sc.nextInt();

	        System.out.println("Enter Name:");
	        String p_name = sc.next();
	        sc.nextLine();
	        System.out.println("Enter Gender:");
	        String p_gender = sc.nextLine();
	        sc.nextLine();
	        System.out.println("Enter Disease:");
	        String p_disease = sc.nextLine();
	        sc.nextLine();
	        System.out.println("Enter age:");
	        int p_age = sc.nextInt();
	        
	        System.out.println("Enter room no:");
	        int room_no = sc.nextInt();
	        
	        System.out.println("Enter admit Status:");
	        String amit_status = sc.next();

	        // Creating object of patient class
	        Patient obj = new Patient(p_id,p_name,p_gender,p_disease,p_age,room_no,amit_status);

	        // Calling method to update the record in the table
	        boolean result = PatientDAO.update(obj, p_id);
	        if (result) {
	            System.out.println("The Patient is successfully updated.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void showPatients(Scanner sc) {
	        // Get all Instructors
	        List<Patient> patients = PatientDAO.getAllPatients();
	        for (Patient patient : patients) {
	            System.out.println(patient);
	        }
	    }

	    public static void showPatientById(Scanner sc) {
	        System.out.println("Enter Patient ID to get data:");
	        String p_id = sc.next();
	        Patient obj = PatientDAO.getByPatientID(p_id);
	        if (obj != null) {
	            System.out.println(obj);
	        } else {
	            System.out.println("Patient with ID " + p_id + " not found.");
	        }
	    }

	    public static void deletePatientById(Scanner sc) {
	        System.out.println("Enter Patient ID to delete:");
	        String p_id= sc.next();

	        // Calling method to delete a particular record
	        boolean result = PatientDAO.delete(p_id);
	        if (result) {
	            System.out.println("The Patient is successfully deleted.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }
	    
	   

}
