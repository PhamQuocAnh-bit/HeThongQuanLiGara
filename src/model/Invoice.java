/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp ;

/**
 *
 * @author ADMIN
 */
public class Invoice implements Serializable {
    private int id ;
    private int  idclient ;
    private int  idcar ;
    private Timestamp time ;
    private Float total ;
    
    public Invoice() {
        super() ;
    }
    public Invoice(int id , int idclient , int idcar , Timestamp time , float  total) {
        this.id = id ;
        this.idclient = idclient ;
        this.idcar = idcar ;
        this.time = time ;
        this.total = total ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    

   
    
    
    
}
