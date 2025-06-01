/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.List ;
import model.Employer;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class EmployerDAO extends DAO{
    public EmployerDAO(){
        super();
    }
    // show employer + tim employer 
    public ArrayList<Employer> searchEmployerByName(String name ){
        ArrayList<Employer> listEmployer = new ArrayList<>() ;
        try {
            String sql = "SELECT * FROM tblEmployer WHERE fullname LIKE ?" ;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1 , "%" + name + "%") ;
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Employer emp = new Employer();
                emp.setID(rs.getInt("ID"));
                emp.setFullname(rs.getString("fullname"));
                emp.setEmail(rs.getString("email"));
                emp.setAddress(rs.getString("address"));
                emp.setGender(rs.getString("gender"));
                emp.setRole(rs.getString("role"));
                emp.setTel(rs.getString("Tel"));
                emp.setNote(rs.getString("note"));
                
                listEmployer.add(emp);
            }
        } catch (Exception e) {
        }
        
        return listEmployer;
    }
    // add new employer
    
    public void addNewEmployer(Employer emp) {
        String sql = "INSERT INTO tblemployer(fullname , email,address,tel , gender , role , note) VALUES (?,?,?,?,?,?,?)" ;
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,emp.getFullname()) ;
            ps.setString(2,emp.getEmail()) ;
            ps.setString(3,emp.getAddress());
            ps.setString(4,emp.getTel());
            ps.setString(5,emp.getGender()) ;
            ps.setString(6,emp.getRole()) ;
            ps.setString(7,emp.getNote()) ;
            
            ps.executeUpdate();
            
            ResultSet genderateKey = ps.getGeneratedKeys();
            if(genderateKey.next()){
                emp.setID(genderateKey.getInt(1));
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Xóa Nhân Viên 
    public void deleteEmployer(int id) {
        String sql = "DELETE FROM tblemployer WHERE id = ?" ;
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Update nhan vien 
    
    public void updateEmployer(Employer emp) {
        String sql = "UPDATE tblemployer SET fullname = ? , email = ? , tel = ? , gender = ? , address = ? , role = ? , note = ? WHERE ID = ? " ;
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            
            ps.setInt(8,emp.getID()) ;
            ps.setString(1,emp.getFullname());
            ps.setString(2,emp.getEmail());
            ps.setString(3,emp.getTel());
            ps.setString(4,emp.getGender());
            ps.setString(5,emp.getAddress());
            ps.setString(6,emp.getRole());
            ps.setString(7,emp.getNote());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}

