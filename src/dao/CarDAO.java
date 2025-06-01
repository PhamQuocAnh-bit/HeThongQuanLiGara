/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.awt.List ;
import java.util.ArrayList ;
import model.Client ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import model.Car;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class CarDAO extends DAO{
    
   public ArrayList<Car> searchCarOfClient(String idclient) {
       ArrayList<Car> listCar = new ArrayList<>() ;
       
       try {
           String sql = "SELECT * FROM tblcar WHERE idClient = ?" ;
           PreparedStatement ps = con.prepareStatement(sql) ;
           ps.setString(1, idclient  ) ;
           ResultSet rs = ps.executeQuery() ;
           
           while(rs.next()) {
               Car ca = new Car() ;
               
               ca.setName(rs.getString("name"));
               ca.setId(rs.getInt("ID")) ;
               ca.setIdclient(rs.getInt("idClient"));
               ca.setBrand(rs.getString("brand"));
               ca.setPlate(rs.getString("plate"));
               ca.setNote(rs.getString("note"));
               
               listCar.add(ca) ;
               
                    
           }
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       return listCar ;
   }
   
   // them xe cho khach hang 
   
   public void addCar(Car ca){
       
       try {
           String sql = "INSERT INTO tblcar(idClient , name , brand , plate , note) VALUES (?,?,?,?,?)" ;
           
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1,ca.getIdclient()) ;
           ps.setString(2,ca.getName()) ;
           ps.setString(3,ca.getBrand());
           ps.setString(4,ca.getPlate());
           ps.setString(5,ca.getNote());
           ps.executeUpdate();
           
           ResultSet genderateKeys = ps.getGeneratedKeys();
           if(genderateKeys.next()){
               ca.setId(genderateKeys.getInt(1));
           }
           
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   // tim xe theo ID 
   
   public ArrayList<Car> searchCarById(String idcar) {
       ArrayList<Car> listCar = new ArrayList<>() ;
       try {
           String sql = "SELECT * FROM tblcar WHERE ID = ?" ;
           PreparedStatement ps = con.prepareStatement(sql) ;
           ps.setString(1, idcar);
           ResultSet rs = ps.executeQuery() ;
           
           while(rs.next()) {
               Car ca = new Car() ;
               ca.setId(rs.getInt("ID"));
               ca.setName(rs.getString("name"));
               ca.setIdclient(rs.getInt("idClient"));
               ca.setBrand(rs.getString("brand"));
               ca.setPlate(rs.getString("plate"));
               ca.setNote(rs.getString("note"));
               
               listCar.add(ca) ;
           }
       } catch (Exception e) {
       }
       
       return listCar ;
   }
   
   // dem so xe 
   public int amoutCar() {
       int count = 0 ;
       try {
           String sql = "SELECT COUNT(*) FROM tblcar" ;
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
       
    
    

}
