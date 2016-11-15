/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Booking.RentalCar;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jonas Borg Petersen
 */
public class DBFacade {

    public static List<RentalCar> checkCars(String pickupCity, String deliverCity, Date pickUpDate, Date deliveryDate, Time pickUpTime, Time deliveryTime) {
        
        //query database and return result
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int makeBooking(Date pickupDate, Date deliveryDate, Time pickupTime, Time deliveryTime, int pickupStationId, int deliveryStationId, int rentalCarId, String driverLicenseNumber, String driverName) {
        
        //query database and return result
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
