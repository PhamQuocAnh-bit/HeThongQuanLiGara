/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.awt.List;
import model.Client;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.Statement;


import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ClientDAO extends DAO{
    public ClientDAO(){
        super() ;
    }
// Ham show client vao table cua lop Client --> đã được thay thế bằng kí tự null trong hàm tìm client rồi 
/* public static ArrayList<Client> showClient(){
    ArrayList<Client> listClient = new ArrayList<>();
    String sql = "SELECT * FROM tblClient" ;
    try {
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            Client client = new Client(rs.getString("fullname"), rs.getString("email"), rs.getString("tel") , rs.getString("address") , rs.getString("note")) ;
            listClient.add(client) ;
            
        }
    } catch (Exception e) {
        
        e.printStackTrace();
    }
    return listClient ;
} */
// Ham tim kiem theo ten 

public ArrayList<Client> searchClientByName(String name) {
    ArrayList<Client> listClient = new ArrayList<>();
    
    try {
        String sql = "SELECT * FROM tblClient WHERE fullname LIKE ? ";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1,"%" + name + "%");
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            Client cl = new Client() ;
            cl.setId(rs.getInt("id"));
            cl.setFullname(rs.getString("fullname"));
            cl.setEmail(rs.getString("email"));
            cl.setTel(rs.getString("tel"));
            cl.setAddress(rs.getString("address"));
            cl.setNote(rs.getString("note"));
            cl.setIdcard(rs.getString("idcard"));
            cl.setGender(rs.getString("gender"));
            listClient.add(cl);
            
        }
        
    } catch (Exception e) {
    }
    return listClient; 
}
// Ham Them Ten Khach Hang

public void addClient(Client client) {
    String sql = "INSERT INTO tblclient(fullname , address,email, tel , note,gender , idcard) VALUES (?,?,?,?,?,?,?)" ;
    try {
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) ;
        
        ps.setString(1,client.getFullname());
        ps.setString(2,client.getAddress());
        ps.setString(3,client.getEmail()) ;
        ps.setString(4,client.getTel()) ;
        ps.setString(5,client.getNote());
        ps.setString(6,client.getGender());
        ps.setString(7,client.getIdcard());
        
        ps.executeUpdate() ;
        
        ResultSet genderatekey = ps.getGeneratedKeys();
        if(genderatekey.next()){
            client.setId(genderatekey.getInt(1));
        }
                
        
       
    } catch (Exception e) {
        e.printStackTrace();
    }
}
// Update thong tin khach hang 

public void updateClient(Client cl ) {
    String sql = "UPDATE tblclient SET fullname = ? , email = ? , Gender = ? , address = ? , tel = ? , note = ? WHERE idcard = ?" ;
    try {
        PreparedStatement ps = con.prepareStatement(sql) ;
        
        ps.setString(1 , cl.getFullname());
        ps.setString(2 , cl.getEmail());
        ps.setString(3 , cl.getGender());
        ps.setString(4 , cl.getAddress());
        ps.setString(5 , cl.getTel());
        ps.setString(6 , cl.getNote());
        ps.setString(7, cl.getIdcard());
        
        ps.executeUpdate() ;
    } catch (Exception e) {
        e.printStackTrace(); 
    }
}

// Xóa Thông Tin Khách Hàng 

public void deleteClien(String idcard){
    String sql = "DELETE FROM tblclient WHERE idcard = ?" ;
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idcard) ;
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// tim thong tin khach hang theo ma KH 

public  ArrayList<Client> searchClientById(String idclient) {
    
    ArrayList<Client> listClient = new ArrayList<>() ;
    try {
        String sql = "SELECT * FROM tblclient WHERE ID = ?" ;
        PreparedStatement ps = con.prepareStatement(sql) ;
        ps.setString(1,idclient);
        ResultSet rs = ps.executeQuery() ;
        
        while(rs.next()) {
            Client cl = new Client() ;
            
            cl.setId(rs.getInt("ID"));
            cl.setFullname(rs.getString("fullname"));
            cl.setIdcard(rs.getString("idcard"));
            cl.setGender(rs.getString("gender"));
            cl.setAddress(rs.getString("address"));
            cl.setEmail(rs.getString("Email"));
            cl.setTel(rs.getString("tel"));
            cl.setNote(rs.getString("note"));
            
            listClient.add(cl) ;
            
        }
        
        
    } catch (Exception e) {
    }
    
    
    return listClient ;
}

    
    
    
}
