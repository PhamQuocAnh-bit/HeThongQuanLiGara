/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import static dao.DAO.con;
import java.awt.List ;
import java.util.ArrayList;
import model.Services;
import java.sql.Statement ;
import java.sql.PreparedStatement ;
import java.sql.*;
import java.awt.List ;
import java.sql.ResultSet ;
import java.util.HashMap;
import java.util.Map;
import model.Employer;
import model.TechService;

/**
 *
 * @author ADMIN
 */
public class ServiceDAO extends DAO{
    public ServiceDAO (){
        super () ;
    }
    
    // tim kiem linh kien 
    
    public ArrayList<Services> searchService (String name ) {
        ArrayList<Services> listSe = new ArrayList<>() ;
        
        try {
          String sql = "SELECT * FROM tblservices WHERE name LIKE ?" ;
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1 , "%" + name + "%") ;
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()) {
             Services se = new Services() ;
             
             se.setID(rs.getInt("ID"));
             se.setName(rs.getString("name"));
             se.setImportPrice(rs.getFloat("importPrice"));
             se.setUnitPrice(rs.getFloat("unitprice"));
             se.setPosition(rs.getString("position"));
             se.setAmout(rs.getInt("amout"));
             se.setNote(rs.getString("note"));
             
             listSe.add(se) ;
             
             
          }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listSe ;
    }
    
    // them linh kien / dich vu 
    
    public void addServices (Services se) {
        
        try {
            String sql = "INSERT INTO tblservices(name , amout,importprice , unitprice ,position , note) VALUES (?,?,?,?,?,?)" ;
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) ;
            
            ps.setString(1,se.getName());
            ps.setInt(2,se.getAmout()) ;
            ps.setFloat(3,se.getImportPrice()) ;
            ps.setFloat(4,se.getUnitPrice());
            ps.setString(5,se.getPosition()) ;
            ps.setString(6,se.getNote()) ;
            
            ps.executeUpdate() ;
            ResultSet genderateKey = ps.getGeneratedKeys();
            if(genderateKey.next()){
                se.setID(genderateKey.getInt(1));
            }
            
        
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void  addTechService(TechService techSe) {
        try {
            String sql = "INSERT INTO tbltechservice(ID, idInvoice , idClient , idCar , name , position , unitprice , amout) VALUES (?,?,?,?,?,?,?,?)" ;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setInt(1,techSe.getId()) ;
            ps.setInt(2,techSe.getIdInvoice());
            ps.setInt(3,techSe.getIdClient());
            ps.setInt(4,techSe.getIdCar()) ;
            ps.setString(5 , techSe.getName()) ;
            ps.setString(6,techSe.getPosition());
            ps.setFloat(7, techSe.getUnitPrice());
            ps.setInt(8, techSe.getAmout());
            
            
            ps.executeUpdate() ;
            ResultSet genderateKey = ps.getGeneratedKeys() ;
            if(genderateKey.next()){
                techSe.setIdInvoice(genderateKey.getInt(1));
            }
            
        } catch (Exception e) {
        }
    }
    
    // Tìm LK/DV đã sd trong hoa don
    
    public ArrayList<TechService> searchTechService(String idInvoice) {
        ArrayList<TechService> listService = new ArrayList<>() ;
        try {
            String sql = "SELECT * FROM tbltechservice WHERE idInvoice = ?" ;
            PreparedStatement ps = con.prepareStatement(sql) ;
            ps.setString(1, idInvoice);
            ResultSet rs = ps.executeQuery() ;
            
            while(rs.next()) {
                TechService tese = new TechService() ;
                
                
                tese.setId(rs.getInt("ID"));
                tese.setIdClient(rs.getInt("idClient"));
                tese.setIdInvoice(rs.getInt("idInvoice"));
                tese.setIdCar(rs.getInt("idCar"));
                tese.setName(rs.getString("name"));
                tese.setUnitPrice(rs.getFloat("unitprice"));
                tese.setAmout(rs.getInt("amout"));
                tese.setPosition(rs.getString("position"));
                
               
                
                
                listService.add(tese) ;
                
                
            }
            
        } catch (Exception e) {
        }
        return listService ;
    }
    // update techService 
    
    public void updateTechService(TechService techse) {
        String sql = "UPDATE tbltechservice SET amout = ?  WHERE ID = ? AND idInvoice = ? " ;
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            
            ps.setInt(1,techse.getAmout()) ;
            ps.setInt(2,techse.getId());
            ps.setInt(3,techse.getIdInvoice()) ;
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    // Xoa techService 
    
      public void deleteTechService(TechService tese) {
        String sql = "DELETE FROM tbltechservice WHERE ID = ? AND idInvoice = ?" ;
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            ps.setInt(1,tese.getId()) ;
            ps.setInt(2,tese.getIdInvoice());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      // Xóa Service
      
      public void deleteService(int idse) {
          String sql = "DELETE FROM tblservices WHERE ID = ? " ;
          try {
              PreparedStatement ps = con.prepareStatement(sql) ;
              ps.setInt(1, idse);
              
              ps.executeUpdate() ; 
          } catch (Exception e) {
          }
      }
      
      // dem so linh kien 
      
      public int amoutLK() {
          int amout = 0 ;
          try {
              String sql = "SELECT COUNT(*) FROM tblservices WHERE position = ? ";
              PreparedStatement ps = con.prepareStatement(sql) ;
              ps.setString(1,"Linh Kiện") ;
              ResultSet rs = ps.executeQuery() ;
              while(rs.next()) {
                  amout = rs.getInt(1) ;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return amout ;
      }
      public int amoutDV() {
          int amout = 0 ;
          try {
              String sql = "SELECT COUNT(*) FROM tblservices WHERE position = ? ";
              PreparedStatement ps = con.prepareStatement(sql) ;
              ps.setString(1,"Dịch Vụ") ;
              ResultSet rs = ps.executeQuery() ;
              while(rs.next()) {
                  amout = rs.getInt(1) ;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return amout ;
      }
      
      // so LK đã su dung 
      public Map<String, Double> getAmountByPosition() {
        Map<String, Double> dataMap = new HashMap<>();

        try  {
            String sql = "SELECT position, SUM(amout) AS total_amount FROM tbltechservice GROUP BY position";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String position = rs.getString("position");
                double amount = rs.getDouble("total_amount");
                dataMap.put(position, amount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataMap;
    }
      
    
    
    
    
   // public void AddedService(Services se) {
     //   try sql = ""
    }





