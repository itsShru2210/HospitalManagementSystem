package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.HospitalDB;
import model.Patient;

public class PatientDAO {
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Patient obj) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String q = "INSERT INTO PATIENTS(p_id,p_name,p_gender,p_disease, p_age,room_no,amit_status) VALUES (?, ?, ?, ?,?,?,?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getPatientID());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getGender());
            pstmt.setString(4, obj.getDisease());
            pstmt.setInt(5, obj.getage());
            pstmt.setInt(6, obj.getroomno());
            pstmt.setString(7, obj.getadmitstatus());

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

    // Update Instructor
    public static boolean update(Patient obj, int p_id) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String q = "UPDATE PATIENTS SET p_name = ?, p_gender= ?,p_disease=?, p_age = ?,room_no=?,amit_status=? WHERE p_id = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getGender());
            pstmt.setString(3, obj.getDisease());
            pstmt.setInt(4, obj.getage());
            pstmt.setInt(5, obj.getroomno());
            pstmt.setString(6, obj.getadmitstatus());
            pstmt.setLong(7, p_id);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Delete Method
    public static boolean delete(String p_id) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String qDelete = "DELETE FROM PATIENTS WHERE p_id=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setString(1, p_id);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // 
    public static Patient getByPatientID(String p_id) {
        Patient patient = null;
        try {
            conn = HospitalDB.createC();

            String q = "SELECT * FROM PATIENTS WHERE p_id=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, p_id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                patient = new Patient();
                patient.setPatientID(rs.getInt("p_id"));
                patient.setName(rs.getString("p_name"));
                patient.setGender(rs.getString("p_gender"));
                patient.setDisease(rs.getString("p_disease"));
                patient.setage(rs.getInt("p_age"));
                patient.setroomno(rs.getInt("room_no"));
                patient.setadmitstatus(rs.getString("amit_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return patient;
    }

    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            conn = HospitalDB.createC();

            String q = "SELECT * FROM PATIENTS";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientID(rs.getInt("p_id"));
                patient.setName(rs.getString("p_name"));
                patient.setGender(rs.getString("p_gender"));
                patient.setDisease(rs.getString("p_disease"));
                patient.setage(rs.getInt("p_age"));
                patient.setroomno(rs.getInt("room_no"));
                patient.setadmitstatus(rs.getString("amit_status"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return patients;
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
