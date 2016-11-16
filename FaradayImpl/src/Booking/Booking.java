/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Jonas Borg Petersen
 */
public class Booking {
    public int id;
    public Date pickUpDate;
    public Time pickUpTime;
    public Date deliveryDate;
    public Time deliveryTime;
    public String licensePlateNumber;
    
    public Booking(){}
    
    public Booking(int id, Date pickUpDate, Time pickUpTime, Date deliveryDate, Time deliveryTime, String licensePlateNumber){
        this.id = id;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getId() {
        return id;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public Time getPickUpTime() {
        return pickUpTime;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Time getDeliveryTime() {
        return deliveryTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setPickUpTime(Time pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
