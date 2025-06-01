/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable ;

/**
 *
 * @author ADMIN
 */
public class Client implements Serializable{
   
    private int id ; 
    private String fullname ;
    private String address ;
    private String email ;
    private String tel ;
    private String note ;
    private String gender ;
    private String idcard;
    
    public Client(){
        super();
    }
    public Client ( String fullname , String address, String email , String tel , String note , String idcard , String gender) {
        super() ;
        this.fullname = fullname ;
        this.address = address ;
        this.email = email ;
        this.tel = tel ;
        this.note = note  ;
        this.idcard = idcard ;
        this.gender = gender ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    
    
    
    
}
