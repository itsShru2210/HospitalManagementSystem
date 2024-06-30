package menu;

import java.util.Scanner;

import operation.PatientsOperation;
import operation.MedicalReportsOperation;


public class DoctorMenu {


    // Doctor menu
    public static void doctorMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\nWelcome to Doctor Adminstration Page\n");
            System.out.println("1.Manage Patients");
            System.out.println("2.Manage Medical Records");
            
            System.out.println("Press 0 to Logout from Instructor menu");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
            	case 1:
	            	managePatients(sc);
	                break;    
            	case 2:
            		manageMedicalReports(sc);
                    break;
                
                case 0:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    public static void managePatients(Scanner sc) {
	       int choice;
	       do {
	           System.out.println("\nWelcome to Patients operation\n");
	           System.out.println(" 1.  Add Patients");
	           System.out.println(" 2.  Update an Patients");
	           System.out.println(" 3.  View all Patients");
	           System.out.println("4.  View Patients by Id");
	           System.out.println("5. Delete Patients by Id");
	           System.out.println("Press 0 for returning to Doctor menu");

	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	                   PatientsOperation.addPatient(sc);
	                   break;
	               case 2:
	            	   PatientsOperation.updatePatient(sc);
	                   break;
	               case 3:
	            	   PatientsOperation.showPatients(sc);
	                   break;
	               case 4:
	            	   PatientsOperation.showPatientById(sc);
	                   break;
	               case 5:
	            	   PatientsOperation.deletePatientById(sc);
	                   break;
	               case 0:
	                   System.out.println("Returning back to Doctors menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }
    
    
    
    
    
    
    public static void manageMedicalReports(Scanner sc) {
        int choice;
        do {
            System.out.println("\nWelcome to Medical Records\n");
            System.out.println(" 1. Add Medical Records");
            System.out.println("2. Update Records By Patients Name");
            System.out.println("3.  View all Records");
            System.out.println("4.  View  Records By Patients Name");
            System.out.println("Press 0 for returning to Doctor menu");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MedicalReportsOperation.addMedicalRepost(sc);
                    break;
                case 2:
                	MedicalReportsOperation.updateMedical(sc);
                    break;
                case 3:
                	MedicalReportsOperation.showMedical(sc);
                    break;
                case 4:
                	MedicalReportsOperation.showMedicalByName(sc);
                    break;
                case 0:
                    System.out.println("Returning back to Doctors menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

}
