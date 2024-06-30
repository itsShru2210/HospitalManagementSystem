package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.HospitalDB;
import model.Medical;

public class MedicalDAO {

	   static PreparedStatement pstmt = null;
	    static Connection conn = null;
	    static Statement stmt = null;
	    static ResultSet rs = null;

	    // Insert method handles auto-increment
	    public static boolean insert(Medical obj) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String q = "INSERT INTO MEDICAL_RECORDS(p_name,test_type,result1,diagnosis) VALUES ( ?, ?, ?,?)";
	            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

	            pstmt.setString(1, obj.getPatientName());
	           // pstmt.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(obj.getDate()));
	            pstmt.setString(2, obj.getTestType());
	            pstmt.setString(3, obj.getMedicalResult());
	            pstmt.setString(4, obj.getDiagnosis());
	            
	         

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

	    // Update Medical Records
	    public static boolean update(Medical obj, String p_name) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String q = "UPDATE MEDICAL_RECORDS SET    test_type = ?, result1= ?,diagnosis= ? WHERE p_name = ?";
	            pstmt = conn.prepareStatement(q);

	            //pstmt.setString(1, obj.getPatientName());
	          //  pstmt.setDate(2, new java.sql.Date(obj.getDate().getTime())); // Converting Date to SQL Date
	            pstmt.setString(1, obj.getTestType());
	            pstmt.setString(2, obj.getMedicalResult());
	            pstmt.setString(3, obj.getDiagnosis());
	            pstmt.setString(4, p_name);

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
	    public static Medical getByPatientName(String p_name) {
	        Medical medical = null;
	        try {
	            conn = HospitalDB.createC();

	            String q = "SELECT * FROM MEDICAL_RECORDS WHERE p_name=?";
	            pstmt = conn.prepareStatement(q);

	            pstmt.setString(1, p_name);

	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	medical = new Medical();
	            	medical.setPatientName(rs.getString("p_name"));
	               
	            	//medical.setDate(rs.getDate("date"));
	            	medical.setTestType(rs.getString("test_type"));
	            	medical.setMedicalResult(rs.getString("result1"));
	            	medical.setDiagnosis(rs.getString("diagnosis"));
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return medical;
	    }

	    public static List<Medical> getAllMedicals() {
	        List<Medical> medicals = new ArrayList<>();
	        try {
	            conn = HospitalDB.createC();

	            String q = "SELECT * FROM MEDICAL_RECORDS";
	            stmt = conn.createStatement();

	            rs = stmt.executeQuery(q);

	            while (rs.next()) {
	                Medical medical = new Medical();
	                medical.setPatientName(rs.getString("p_name"));
		               
	            	//medical.setDate(rs.getDate("date"));
	            	medical.setTestType(rs.getString("test_type"));
	            	medical.setMedicalResult(rs.getString("result1"));
	            	medical.setDiagnosis(rs.getString("diagnosis"));
	                medicals.add(medical);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return medicals;
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
