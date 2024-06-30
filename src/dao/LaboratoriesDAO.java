package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import connection.HospitalDB;
import model.Labortories;

public class LaboratoriesDAO {

	   static PreparedStatement pstmt = null;
	    static Connection conn = null;
	    static Statement stmt = null;
	    static ResultSet rs = null;

	    // Insert method handles auto-increment
	    public static boolean insert(Labortories obj) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String q = "INSERT INTO LABORATORIES (facilities,cost) VALUES (?, ?)";
	            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

	            pstmt.setString(1, obj.getLabName());
	            pstmt.setInt(2, obj.getCost());
	           

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

	  
	    // Delete Method
	    public static boolean delete(String facilities) {
	        boolean f = false;
	        try {
	            conn = HospitalDB.createC();

	            String qDelete = "DELETE FROM LABORATORIES WHERE facilities=?";
	            pstmt = conn.prepareStatement(qDelete);
	            pstmt.setString(1, facilities);
	            
	            pstmt.executeUpdate();
	            f = true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return f;
	    }


	    
	    public static List<Labortories> getAlllabs() {
	        List<Labortories> labortoriess = new ArrayList<>();
	        try {
	            conn = HospitalDB.createC();

	            String q = "SELECT * FROM LABORATORIES";
	            stmt = conn.createStatement();

	            rs = stmt.executeQuery(q);

	            while (rs.next()) {
	            	Labortories labortories = new Labortories();
	            	labortories.setlabName(rs.getString("facilities"));
	            	labortories.setCost(rs.getInt("cost"));
	            	labortoriess.add(labortories);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return labortoriess;
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
