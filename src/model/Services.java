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
public class Services implements Serializable{
    private int ID ;
    private String name ;
    private float importPrice ;
    private float unitPrice ;
    private String position ;
    private int amout ;
    private String note ;
    
    public Services(){
        super() ;
    }
    
    public Services(int ID , String name , float importPrice , float unitPrice , String position , String note , int amout ) {
        this.ID = ID ;
        this.name = name ;
        this.importPrice = importPrice ;
        this.unitPrice = unitPrice ;
        this.position = position;
        this.amout = amout ;
        this.note = note ;
              
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    
    
    
    
}
