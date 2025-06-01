 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.source.tree.TryTree;
import model.Invoice ;
import java.sql.PreparedStatement ;
import java.sql.Timestamp;
import java.time.LocalDate ;
import java.time.LocalDateTime ;
import java.time.* ;
import java.sql.Statement ;
import java.sql.ResultSet ;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class InvoiceDAO extends DAO{
    
    public void addInvoice(Invoice invoice) {
        
        try {
            String sql = "INSERT INTO tblinvoice(idclient , idcar , time , total) VALUES (?,?,?,?)" ;
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) ;
            ps.setInt(1,invoice.getIdclient()); 
            ps.setInt(2, invoice.getIdcar());
            ps.setTimestamp(3,invoice.getTime());
            ps.setFloat(4,invoice.getTotal());
            
            ps.executeUpdate();
            ResultSet genarateKey = ps.getGeneratedKeys() ;
            
            if(genarateKey.next()) {
                invoice.setId(genarateKey.getInt(1));
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
    public ArrayList<Invoice> searchInvoice(String idInvoice) {
        ArrayList<Invoice> Invoices = new ArrayList<>() ;
        
        try {
            String sql = "SELECT * FROM tblinvoice WHERE ID = ?" ;
            PreparedStatement ps = con.prepareStatement(sql) ;
            ps.setString(1,idInvoice) ;
            ResultSet rs = ps.executeQuery() ;
            
            while(rs.next()) {
                Invoice invoice = new Invoice() ;
                invoice.setId(rs.getInt("ID"));
                invoice.setIdclient(rs.getInt("idClient"));
                invoice.setIdcar(rs.getInt("idCar"));
                invoice.setTime(rs.getTimestamp("time"));
                invoice.setTotal(rs.getFloat("total"));
                
                Invoices.add(invoice) ;
            }
        } catch (Exception e) {
        }
        
        return Invoices ;
    }
    
     
    
}
