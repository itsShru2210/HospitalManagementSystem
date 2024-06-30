package operation;

import java.util.List;
import java.util.Scanner;

import dao.BillDAO;
import model.Bill;

public class BillOperation {
	 public static void addBill(Scanner sc) {
	        System.out.println("Enter Bill ID:");
	        int bill_id = sc.nextInt();

	        System.out.println("Enter Patient Name:");
	        String p_name = sc.next();

	        System.out.println("Enter payment mode:");
	        String payment_mode = sc.next();

	        System.out.println("Enter Ammount:");
	        int ammount = sc.nextInt();

	        System.out.println("Enter Medicine cost:");
	        int med_cost = sc.nextInt();
	        System.out.println("Enter total ammount:");
	        int total_ammount = sc.nextInt();
	        System.out.println("Enter Payment Status:");
	        String payment_status= sc.next();
	        

	        // Creating object of Score class
	        Bill obj = new Bill(bill_id, p_name,payment_mode, ammount, med_cost,total_ammount,payment_status);

	        // Calling method to insert into table and passing the object of Score class
	        boolean result = BillDAO.insert(obj);
	        if (result) {
	            System.out.println("The Bill is successfully added.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void updateBill(Scanner sc) {
	        System.out.println("Enter Bill ID to update:");
	        int bill_id = sc.nextInt();

	        System.out.println("Enter patient name:");
	        String p_name = sc.next();

	        System.out.println("Enter payment mode:");
	        String payment_mode = sc.next();

	        System.out.println("Enter Ammount:");
	       int ammount = sc.nextInt();

	        System.out.println("Enter Medicine cost:");
	        int med_cost = sc.nextInt();
	        System.out.println("Enter total ammount:");
	        int total_ammount = sc.nextInt();
	        System.out.println("Enter Payment Status:");
	        String payment_status= sc.next();

	        // Creating object of bill class
	        Bill obj = new Bill(bill_id, p_name,payment_mode, ammount, med_cost,total_ammount,payment_status);

	        // Calling method to update the record in the table
	        boolean result = BillDAO.update(obj, bill_id);
	        if (result) {
	            System.out.println("The Bill is successfully updated.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void showBill(Scanner sc) {
	        // Get all bills
	        List<Bill> bills = BillDAO.getAllbills();
	        for (Bill bill : bills) {
	            System.out.println(bill);
	        }
	    }

	    public static void showBillById(Scanner sc) {
	        System.out.println("Enter Bill ID to get data:");
	        String bill_id = sc.next();
	        Bill obj = BillDAO.getByBillID(bill_id);
	        if (obj != null) {
	            System.out.println(obj);
	        } else {
	            System.out.println("Score with ID " + bill_id + " not found.");
	        }
	    }

	 
	    
}
