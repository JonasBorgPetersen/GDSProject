package DataAccess;

import Booking.Booking;
import Booking.RentalCar;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class DBFacade {

    public static List<RentalCar> checkCars(String pickupCity, String deliverCity, Date pickUpDate, Date deliveryDate, Time pickUpTime, Time deliveryTime) throws IOException, ParseException {

        List<RentalCar> rentalCars = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\s_eng\\Desktop\\jsonPath\\RentalCar.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] s = line.split(",");
                RentalCar car = new RentalCar(Integer.parseInt(s[0]), s[1]);
                rentalCars.add(car);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\s_eng\\Desktop\\jsonPath\\Booking.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] s = line.split(",");

                //Convert string to sql.Time
                long newPickUpTime = timeFormat.parse(s[2]).getTime();
                long deliverPickUpTime = timeFormat.parse(s[4]).getTime();

                Booking booking = new Booking(Integer.parseInt(s[0]), dateFormat.parse(s[1]), new Time(newPickUpTime), dateFormat.parse(s[3]), new Time(deliverPickUpTime), s[5]);
                bookings.add(booking);
            }
        } catch (Exception e) {
            System.out.println("Exception e: " + e);
        }

        Iterator<RentalCar> i = rentalCars.iterator();
        while (i.hasNext()) {
            RentalCar rc = i.next();
            for (Booking booking : bookings) {
                if (rc.licenseplateNumber.trim().equals(booking.licensePlateNumber.trim())) {
                    if (pickUpDate.after(booking.pickUpDate) && pickUpDate.before(booking.deliveryDate)) {
                        i.remove();
                    }
                    else if (pickUpDate.before(booking.pickUpDate) && deliveryDate.after(booking.deliveryDate)) {
                        i.remove();
                    }
                }
            }
        }

        //query database and return result
        return rentalCars;
    }

    public static int makeBooking(Date pickupDate, Date deliveryDate, Time pickupTime, Time deliveryTime, int pickupStationId, int deliveryStationId, int rentalCarId, String driverLicenseNumber, String driverName) {

        //query database and return result
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
