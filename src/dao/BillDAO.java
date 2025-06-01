/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.awt.List;
import model.Bill ;
import java.sql.PreparedStatement ;
import java.sql.Statement ;
import java.sql.ResultSet ;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Bill ;

/**
 *
 * @author ADMIN
 */
public class BillDAO extends DAO{ 
    
    // them bill vao csdl 
    
    public void addBill(Bill bill ) {
        try {
            String sql = "INSERT INTO tblbill(idbill , idClient , idCar , time , total , position) VALUES (?,?,?,?,?,?)" ;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setInt(1,bill.getIdbill()) ;
            ps.setInt(2,bill.getIdClient());
            ps.setInt(3,bill.getIdCar()); 
            ps.setTimestamp(4, bill.getTime());
            ps.setFloat(5, bill.getTotal());
            ps.setString(6,bill.getPosition());
            
            ps.executeUpdate() ;
            ResultSet generateKey = ps.getGeneratedKeys() ;
            if(generateKey.next()) {
                bill.setId(generateKey.getInt(1));
            }
        } catch (Exception e) {
        }
    }
    // dem so Bill 
    
    public int amoutBill() {
        int count = 0 ;
        try {
            String sql = "SELECT COUNT(*) FROM tblbill" ;
            PreparedStatement ps = con.prepareStatement(sql) ;
            ResultSet rs = ps.executeQuery() ;
            
            while(rs.next()) {
                count = rs.getInt(1) ;
            }
            rs.close();
            ps.close(); 
        } catch (Exception e) {
        }
        
        return count ;
        
    }
    
    // thong ke doanh thu
    
    public static Map<String, Float> getTotalPerDay() {
    Map<String, Float> data = new LinkedHashMap<>();
    String sql = "SELECT DATE(time) as Ngay, SUM(total) as TongTien FROM tblbill GROUP BY DATE(time)";
    try {
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery() ;
        while (rs.next()) {
            String ngay = rs.getString("Ngay");
            float tongTien = rs.getFloat("TongTien");
            data.put(ngay, tongTien);
        }}
     catch (Exception e) {
        e.printStackTrace();
    }
    return data;
}
    // thống kê bill
    
    public ArrayList<Bill> getBillsByMonth(int month) {
    ArrayList<Bill> list = new ArrayList<>();
    String sql = "SELECT * FROM tblbill WHERE MONTH(time) = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, month);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Bill b = new Bill();
            b.setId(rs.getInt("id"));
            b.setIdbill(rs.getInt("idbill"));
            b.setIdClient(rs.getInt("idClient"));
            b.setIdCar(rs.getInt("idCar"));
            b.setTime(rs.getTimestamp("time"));
            b.setTotal((float) rs.getDouble("total"));
            b.setPosition(rs.getString("position"));
            list.add(b);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
    
}
