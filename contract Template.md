# GDSProject Contract Template


##Introduction

Several flight carriers have come together to create an online booking system. The project name is Sebastian. Access to this GDS (Global Distribution System) will be done through a web service (used by third party solutions) and a desktop application (meant for employees in travel agencies). Sebastian provides a service to view schedules* and handle bookings*.   

##Vision

###General describtion of system

Sebastian is a Global Distribution System, that is used to handle bookings, i.e. cancel, view and create, and show schedules of flights between specified airports on given dates, where it is possible to view arrival- and departure times and destination (including the names of the airports), information about the carrier and the number of free seats. 

###General describtion of porpuse of the system

The purpose of the system is to make it easier for several flight carriers and travel agencies to make reservations through an online solution. The solution will be in form of a web-service, that is meant for third-party solutions, and then a desktop solution for the employees. The system can handle many flight reservations, and can be extended with more features like seat numbers.

##Use Case Model

###Use case diagram

###Use case description

####Use case 1

<b>Name:</b> The system should show a time schedule with arrival and departure time, with information about the carrier and number of free seats, between two airports on a given date.
<b>Primary actor:</b> Employee from travel agency.
<b>Precondition:</b> Desktop application.
<b>Success scenario:</b> 
<b>Special requirements:</b> No special requirements.

####Use case 2

Name: The system should be able to make a booking for up to 9 persons, between to airports on a given day. The booking can even be a one-way or a round-trip. 
Primary actor: Employee from travel agency.
Precondition: Desktop application.
Success scenario: The booking is successful when all persons has been booked. 
Special requirements: The booking is atomic, and can only be successful, if all persons can be booked, and all legs are included. An error message should be returned, if the seats are not available anymore.

####Use case 3

Name: See a booking, providing a PNR from the booking.
Primary actor: Employee from travel agency.
Precondition: Desktop application.
Success scenario: Returns the booking.
Special requirements: 

####Use case 4

Name: Cancel a booking, providing a PNR from the booking.
Primary actor: Employee from travel agency.
Precondition: Desktop application.
Success scenario: Cancels the booking.
Special requirements: 


###Actor descriptions

##Domain Model

###Class diagram

###Description of domain model

##Non-functional requirements

##Fully dressed use case
