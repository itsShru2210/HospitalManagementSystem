package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.HospitalDB;
import model.Medicine;

public class MedicineDAO {

	   static PreparedStatement pstmt = null;
	    static Connection conn = null;
	    static Statement stmt = null;
	    static ResultSet rs = null;

	    // Insert method handles auto-increment
	    public static boolean insert(Medicine obj) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String q = "INSERT INTO MEDICINES(med_name,company, med_cost) VALUES (?, ?, ?)";
	            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

	            pstmt.setString(1, obj.getMedicineName());
	            //pstmt.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(obj.getexpireDate()));
	            pstmt.setString(2, obj.getCompany());
	            pstmt.setLong(3, obj.getMedicineCost());
	            
	         

	            pstmt.executeUpdate();

	            // Retrieve the auto-generated key (ID)
	            ResultSet rs = pstmt.getGeneratedKeys();
	            if (rs.next()) {
	                // You might want to handle the auto-generated key if required
	            }

	            f = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            closeResources();
	        }
	        return f;
	    }

	    // Update Student
	    /*public static boolean update(Medicine obj, String med_name) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String q = "UPDATE MEDICINES SET  exp_date = ?,  company = ?, med_cost = ? WHERE med_name = ?";
	            pstmt = conn.prepareStatement(q);

	            pstmt.setString(1, obj.getMedicineName());
	            pstmt.setDate(2, new java.sql.Date(obj.getexpireDate().getTime())); // Converting Date to SQL Date
	            pstmt.setString(3, obj.getCompany());
	            pstmt.setLong(4, obj.getMedicineCost());
	            pstmt.setString(7, med_name);

	            pstmt.executeUpdate();
	            f = true;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return f;
	    }
*/
	    // Delete Method
	    public static boolean delete(String med_name) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String qDelete = "DELETE FROM MEDICINES WHERE med_name=?";
	            pstmt = conn.prepareStatement(qDelete);
	            pstmt.setString(1, med_name);
	            
	            pstmt.executeUpdate();
	            f = true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return f;
	    }


	    // medicine by med_name
	    public static Medicine getByMedicineName(String med_name) {
	        Medicine medicine = null;
	        try {
	            conn = HospitalDB.createC();

	            String q = "SELECT * FROM MEDICINES WHERE med_name=?";
	            pstmt = conn.prepareStatement(q);

	            pstmt.setString(1, med_name);

	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	medicine = new Medicine();
	            	medicine.setMedicineName(rs.getString("med_name"));
	               
	                //medicine.setexpireDate(rs.getDate("exp_date"));
	                medicine.setCompany(rs.getString("company"));
	                medicine.setMedicineCost(rs.getInt("med_cost"));
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return medicine;
	    }

	    public static List<Medicine> getAllMedicines() {
	        List<Medicine> medicines = new ArrayList<>();
	        try {
	            conn = HospitalDB.createC();

	            String q = "SELECT * FROM MEDICINES";
	            stmt = conn.createStatement();

	            rs = stmt.executeQuery(q);

	            while (rs.next()) {
	                Medicine medicine = new Medicine();
	                medicine.setMedicineName(rs.getString("med_name"));
		               
	                //medicine.setexpireDate(rs.getDate("exp_date"));
	                medicine.setCompany(rs.getString("company"));
	                medicine.setMedicineCost(rs.getInt("med_cost"));
	                medicines.add(medicine);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return medicines;
	    }

	    // Close resources method
	    private static void closeResources() {
	        try {
	            if (pstmt != null)
	                pstmt.close();
	            if (rs != null)
	                rs.close();
	            if (conn != null)
	                conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
