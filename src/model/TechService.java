/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class TechService implements Serializable{
    private int id ;
    private int idInvoice ;
    private int idClient ;
    private int idCar ;
    private String name ;
    private String position ;
    private float unitPrice ;
    private int amout ;
    private  int idTechService;
    
    public TechService() {
        super() ;
        
        
    }
    public TechService(int id , int idInvoice , int idClient , int idCar , String name , String position , float unitPrice , int amout) {
        this.id = id ;
        this.idInvoice = idInvoice ;
        this.idClient = idClient ;
        this.idCar = idCar ;
        this.name= name ;
        this.position = position ;
        this.unitPrice = unitPrice ;
        this.amout = amout ;
    }

    public int getIdTechService() {
        return idTechService;
    }

    public void setIdTechService(int idTechService) {
        this.idTechService = idTechService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
    
    
    
    
}
