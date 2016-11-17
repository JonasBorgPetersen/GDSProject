package DataAccess;

import Booking.Booking;
import Booking.RentalCar;
import com.google.gson.Gson;
import java.sql.Time;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DBFacade {

    private static Gson gson = new Gson();

    public static List<RentalCar> checkCars(String pickupCity, String deliverCity, Date pickUpDate, Date deliveryDate, Time pickUpTime, Time deliveryTime) throws IOException, ParseException {

        List<RentalCar> rentalCars = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        //Getting rentalcars from "DB"
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\s_eng\\Desktop\\jsonPath\\RentalCar.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] s = line.split(",");
                RentalCar car = new RentalCar(Integer.parseInt(s[0]), s[1]);
                rentalCars.add(car);
            }
        }

        //Getting bookings from "DB"
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
                    if (pickUpDate.before(booking.deliveryDate) && booking.pickUpDate.before(deliveryDate)) {
                        i.remove();
                        break;
                    }
                }
            }
        }
        return rentalCars;
    }

    public static int makeBooking(Date pickupDate, Date deliveryDate, Time pickupTime, Time deliveryTime, int pickupStationId, int deliveryStationId, int rentalCarId, String driverLicenseNumber, String driverName) throws IOException {

        ArrayList<Booking> bookings;
        int id = -1;

        try {
            bookings = new ArrayList<Booking>(Arrays.asList(gson.fromJson(new FileReader("C:\\Users\\Jonas Borg Petersen\\Documents\\bookings.json"), Booking[].class)));

        } catch (Exception e) {
            bookings = new ArrayList<Booking>();
        }

        id = (int) (Math.random() * 100);

        Booking b
                = new Booking(
                        id,
                        pickupDate,
                        pickupTime,
                        deliveryDate,
                        deliveryTime,
                        driverLicenseNumber
                );

        if (!b.isValid()) {
            return -1;
        }

        bookings.add(b);

        String json = gson.toJson(bookings);
        System.out.println("JSON\n" + json);
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("C:\\Users\\Jonas Borg Petersen\\Documents\\bookings.json"), false);
            writer.write(json);
        } catch (Exception e) {
            return -1;
        } finally {
            writer.close();
        }

        return id;
    }

}
