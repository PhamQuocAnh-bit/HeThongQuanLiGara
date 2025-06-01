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
public class Bill implements Serializable{
    private int idbill ;
    private int  idClient ;
    private int  idCar ;
    private Timestamp time ;
    private float total ;
    String position ;
    private int id ; 
    
    public Bill() {
        super() ;
    }
    public Bill(int idbill , int idClient , int idCar , Timestamp  time , float total , String position  ) {
        this.idbill = idbill ;
        this.idClient = idClient ;
        this.idCar = idCar;
        this.time = time ;
        this.total = total ;
        this.position = position ;
        
    }

    public int getIdbill() {
        return idbill;
    }

    public void setIdbill(int idbill) {
        this.idbill = idbill;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
      
    
}
