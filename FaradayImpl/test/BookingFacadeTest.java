/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Booking.BookingFacade;
import DataAccess.DBFacade;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author s_eng
 */
public class BookingFacadeTest {

    public BookingFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Ignore
    @Test
    public void GetRentalCarsTest() throws IOException, ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date pickUpDate = format.parse("07-11-2016");
        Date deliverDate = format.parse("14-11-2016");
        Time pickUpTime = new Time(06, 0, 0);
        Time deliverTime = new Time(16, 0, 0);
        Booking.BookingFacade bf = new BookingFacade();

        List<Booking.RentalCar> rc = new ArrayList<>();
        rc = bf.checkCars("Copenhagen", "Copenhagen", pickUpDate, deliverDate, pickUpTime, deliverTime);
        System.out.println("Final list size: " + rc.size());
        assertNotNull(rc);
    }

    @Ignore
    @Test
    public void DateTest() throws ParseException {
        String stringDate = "1-11-2016 00:00:00";

        DateFormat format = new SimpleDateFormat("dd-mm-YYYY hh:mm:ss");

        Date newDate = format.parse(stringDate);

        System.out.println("newDate: " + newDate.toString());

    }

    @Ignore
    @Test
    public void TimeTest() throws ParseException {
        String stringTime = "06:00:00";
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        
        long ms = timeFormat.parse(stringTime).getTime();
        
        Time t = new Time(ms);
        System.out.println("New time: " + t);
        
//        Time.parse(stringTime);
//
//        System.out.println("newDate: " + Time.parse(stringTime));

    }
    
    @Test
    public void TestMakeBooking() throws IOException{
        BookingFacade bookingFacade = new BookingFacade();
        
        //valid 
        int id = bookingFacade.makeBooking(new Date(2016, 11, 17), new Date(2016, 11, 20), new Time(12, 50, 0), new Time(16, 30, 0), 0, 0, 0, "123543dsf", "Jonas Borg Petersen");
        
        //valid 
        //int id = bookingFacade.makeBooking(new Date(2016, 11, 17), new Date(2016, 11, 17), new Time(12, 50, 0), new Time(16, 30, 0), 0, 0, 0, "123543dsf", "Jonas Borg Petersen");
        
        //invalid *date
        //int id = bookingFacade.makeBooking(new Date(2016, 11, 17), new Date(2016, 12, 17), new Time(12, 50, 0), new Time(16, 30, 0), 0, 0, 0, "123543dsf", "Jonas Borg Petersen");
        
        //invalid *time
        //int id = bookingFacade.makeBooking(new Date(2016, 11, 17), new Date(2016, 11, 17), new Time(12, 50, 0), new Time(11, 30, 0), 0, 0, 0, "123543dsf", "Jonas Borg Petersen");
        
        assertNotEquals("Test new booking", id, -1);
    }
}
