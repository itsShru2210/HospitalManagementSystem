package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.HospitalDB;
import model.Bill;

public class BillDAO {
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Bill obj) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String q = "INSERT INTO BILL(bill_id, p_name,payment_mode, ammount, med_cost,total_ammount,payment_status) VALUES (?, ?, ?, ?, ?,?,?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getBillID());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getPMode());
            pstmt.setInt(4, obj.getAmmount());
            pstmt.setInt(5, obj.getMedCost());
            pstmt.setInt(6, obj.getTotalAmmount());
            pstmt.setString(7, obj.getPayStatus());
            
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

    // Update Bill
    public static boolean update(Bill obj, int bill_id) {
        boolean f = false;
        try {
            conn = HospitalDB.createC();

            String q = "UPDATE BILL SET p_name = ?, payment_mode = ?, ammount = ?, med_cost = ?,total_ammount=?,payment_status=? WHERE bill_id = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getPMode());
            pstmt.setInt(3, obj.getAmmount());
            pstmt.setInt(4, obj.getMedCost());
            pstmt.setInt(5, obj.getTotalAmmount());
            pstmt.setString(6, obj.getPayStatus()); 
            pstmt.setInt(7, bill_id);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

   
    // Bill by Id
    public static Bill getByBillID(String bill_id) {
        Bill bill = null;
        try {
            conn = HospitalDB.createC();

            String q = "SELECT * FROM BILL WHERE bill_id=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, bill_id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                bill = new Bill();
                bill.setBillID(rs.getInt("bill_id"));
                bill.setName(rs.getString("p_name"));
                bill.setPMode(rs.getString("payment_mode"));
                bill.setAmmount(rs.getInt("ammount"));
                bill.setMedCost(rs.getInt("med_cost"));
                bill.setTotalAmmount(rs.getInt("total_ammount"));
                bill.setPayStatus(rs.getString("payment_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return bill;
    }

    public static List<Bill> getAllbills() {
        List<Bill> bills = new ArrayList<>();
        try {
            conn = HospitalDB.createC();

            String q = "SELECT * FROM BILL";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillID(rs.getInt("bill_id"));
                bill.setName(rs.getString("p_name"));
                bill.setPMode(rs.getString("payment_mode"));
                bill.setAmmount(rs.getInt("ammount"));
                bill.setMedCost(rs.getInt("med_cost"));
                bill.setTotalAmmount(rs.getInt("total_ammount"));
                bill.setPayStatus(rs.getString("payment_status"));
                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return bills;
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
