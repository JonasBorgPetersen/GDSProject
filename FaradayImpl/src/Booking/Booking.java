/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    
    public boolean isValid(){
        
        if(this.deliveryDate.before(this.pickUpDate))
            return false;
        if(this.pickUpDate.equals(this.deliveryDate))
            if(this.deliveryTime.before(this.pickUpTime))
                return false;
        
        long diff = deliveryDate.getTime() - pickUpDate.getTime();
        
        if((TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)) > 21)
            return false;

        return true;
    }
}
