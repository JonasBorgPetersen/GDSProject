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

![USe Case Diagram](https://github.com/Englund0110/GDSProject/blob/master/Use%20Case%20Model.jpg)

###Use case description

####Use case 1

> <b>Name:</b> The system should show a time schedule with arrival and departure time, with information about the carrier and number of free seats, between two airports on a given date.

> <b>Primary actor:</b> Employee from travel agency.

> <b>Precondition:</b> Desktop application.

> <b>Special requirements:</b> No special requirements.

####Use case 2

> <b>Name:</b> The system should be able to make a booking for up to 9 persons, between to airports on a given day. The booking can even be a one-way or a round-trip. 

> <b>Primary actor:</b> Employee from travel agency.

> <b>Precondition:</b> Desktop application.

> <b>Success scenario:</b> The booking is successful when all persons has been booked. 

> <b>Special requirements:</b> The booking is atomic, and can only be successful, if all persons can be booked, and all legs are included. An error message should be returned, if the seats are not available anymore.

####Use case 3

> <b>Name:</b> See a booking, providing a PNR from the booking.

> <b>Primary actor:</b> Employee from travel agency.

> <b>Precondition:</b> Desktop application.

> <b>Success scenario:</b> Returns the booking.

####Use case 4

> <b>Name:</b> Cancel a booking, providing a PNR from the booking.

> <b>Primary actor:</b> Employee from travel agency.

> <b>Precondition:</b> Desktop application.

> <b>Success scenario:</b> The booking has been canceled.



###Actor descriptions

> <b>Employee:</b> The employee is the employees from the travel agencies.

##Domain Model

###Class diagram

![Class Diagram](https://github.com/Englund0110/GDSProject/blob/master/Class%20Diagram.PNG)

###Description of domain model

> <b>Schedule:</b> Contains all flights from and to a specified date

> <b>Flight:</b> Contains information about a flight

> <b>Booking:</b> Is attached to a specific flight, and includes a single or multiple passengers

> <b>Passenger:</b> Contains basic passenger identifiers (name and id)

> <b>TicketType:</b> Enum, to define the possible ticket types (of a booking)

###Constraints

####Flight:
> <b>CarrierCode:</b> Two letter value (min & max)

> <b>AirportDeparture:</b> Three letter value (min & max)

> <b>AirportArrival:</b> Three letter value (min & max)

####Booking:
> <b>FrequentFlyterNumber:</b> Nullable, passengers may not have this attribute

> <b>Passengers:</b> Minimum 1 passenger, maximum 9

####Passenger:
> <b>PNR:</b> A combination of numbers and letters
* Always contains six alphanumeric characters
* First character can NOT be a number

> <b>FullName:</b> Full name (from passport) in capital letters

##Non-functional requirements

##Fully dressed use case
