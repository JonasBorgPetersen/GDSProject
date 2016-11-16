/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jonas Borg Petersen
 */
public class BookingFacade {
    
    public List<RentalCar> checkCars(String pickupCity, String deliverCity, Date pickUpDate, Date deliveryDate, Time pickUpTime, Time deliveryTime) throws IOException, ParseException{      
        return Controller.checkCars(pickupCity,deliverCity,pickUpDate,deliveryDate,pickUpTime,deliveryTime);
    }
    
    public int makeBooking(Date pickupDate, Date deliveryDate, Time pickupTime, 
            Time deliveryTime, int pickupStationId, int deliveryStationId, int rentalCarId, 
            String driverLicenseNumber, String driverName){
        
        return Controller.makeBooking(pickupDate,deliveryDate,pickupTime,deliveryTime,pickupStationId,deliveryStationId,rentalCarId,driverLicenseNumber,driverName);
    }
}
