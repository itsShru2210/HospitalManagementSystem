package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.HospitalDB;
import model.Doctor;

public class DoctorDAO {


    static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Doctor obj) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String q = "INSERT INTO DOCTOR(dr_id,dr_name,dr_specialist,Timing,quaification) VALUES (?, ?, ?,?,?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getDoctor_id());
            pstmt.setString(2, obj.getDoctor_name());
            pstmt.setString(3, obj.getSpecilist());
            //pstmt.setInt(4, obj.getPassword());
            pstmt.setString(4, obj.getTiming());
            pstmt.setString(5, obj.getQualification());

            pstmt.executeUpdate();

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
    public static boolean delete(String dr_id) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String qDelete = "DELETE FROM DOCTOR WHERE dr_id=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setString(1, dr_id);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

   

    public static List<Doctor> getAllDoctor() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            conn = HospitalDB.createC();

            String q = "SELECT * FROM DOCTOR";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor .setDoctor_id(rs.getInt("dr_id"));
                doctor .setDoctor_name(rs.getString("dr_name"));
                doctor .setSpecilist(rs.getString("dr_specialist"));
                
                //doctor .setPassword(rs.getInt("dr_password"));
                doctor .setTiming(rs.getString("Timing"));
                doctor .setQualification(rs.getString("quaification"));
                
                doctors .add(doctor );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return doctors;
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
