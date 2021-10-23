/**
 * For this assignment you will design a set of classes that work together to simulate a police officer issuing a parking ticket. 
 * You should design the following classes:
	- The ParkedCar Class: This class should simulate a parked car. The class's responsibilities are as follows:
	- To know the car's make, model, color, license number, and the number of minutes that the car has been parked.
	- The ParkingMeter Class: This class should simulate a parking meter. The class's only responsibility is as follows:
    - To know the number of minutes of parking time that has been purchased.
	- The ParkingTicket Class: This class should simulate a parking ticket. The class's responsibilities 
	  are as follows:
	- To report the make, model, color, and license number of the illegally parked car
	- To report the amount of the fine, which is $25 for the first hour or part of an hour that the car is illegally parked, 
	  plus $10 for every additional hour or part of an hour that the car is illegally parked
	- To report the name and badge number of the police officer issuing the ticket
	- The PoliceOfficer Class: This class should simulate a police officer inspecting parked cars. The class's 
	  responsibilities are as follows:
	- To know the police officer's name and badge number
	- To examine a ParkedCar object and a ParkingMeter object, and determine whether
		the car's time has expired
	- To issue a parking ticket (generate a ParkingTicket object) if the car's time has	expired
	Write a program that demonstrates how these classes collaborate. Make the aforementioned classes 
	nested classes within the class containing your main method; only this outermost class can be declared public.
 */
import java.util.Scanner;
public class ParkingTicketSimulator {
	
  static class ParkedCar {
  private String
       make,
        model,
         licenseNum,
         color;
     private int
         minsParked;
		      public void setMake(String make) {
	         this.make = make;
	         return;      }
      public void setModel(String model) {
		         this.model = model;
         return;
      }
      public void setColor(String color) {
         this.color = color;
	         return;
	      }
	      public void setLicenseNum(String licenseNum) {
		         this.licenseNum = licenseNum;
		         return;
	      }
		      public void setMinsParked(int minsParked) {
	         this.minsParked = minsParked;
	         return;
		      }
	   }
  static class ParkingMeter {
      private int minsPurchased;
	      public void setMinsPurchased(int minsPurchased) {
	         this.minsPurchased = minsPurchased;
	         return;
	      }
	   }
   static class ParkingTicket {
	      private int fineAmount;
	      private String poName;
	      private int poBadgeNum;
	      private ParkedCar car;
      public ParkingTicket(ParkedCar car,
		            int mins, String poName, int poBadgeNum) {
	         this.car = car;
	         this.poName = poName;
	         this.poBadgeNum = poBadgeNum;
	         if (mins <= 60)
	            fineAmount = 25;
		         else
	            fineAmount = (25 + (10 * ((mins - 60) / 60)));
	      }
	      public String getCarMake() {
	         return car.make;
	      }
	      public String getCarModel() {
	         return car.model;
      }
	      public String getCarColor() {
	         return car.color;
	      }
		      public String getCarLicenseNum() {
	         return car.licenseNum;
	      }
	      public int getFineAmount() {
	         return fineAmount;
	      }
	      public String getPOName() {
	         return poName;
		      }
	      public int getPOBadgeNum() {
	         return poBadgeNum;
		      }
		   }
	
	   static class PoliceOfficer {
	      private String name;
	      private int badgeNum;
	      public void setPOName(String name) {
		         this.name = name;
	         return;
	      }
	      public void setPOBadgeNum(int badgeNum) {
	         this.badgeNum = badgeNum;
	         return;
		      }
	      public ParkingTicket checkCarAndMeter(
		            ParkedCar car, ParkingMeter meter) {
		         ParkingTicket ticket = null;
		         int mins;
	         if ((mins = (car.minsParked - meter.minsPurchased)) > 0)
	            ticket = new ParkingTicket(car, mins, name, badgeNum);
	         return ticket;
		      }
   }
	
	   public static void main(String[] args) {
		      Scanner input = new Scanner(System.in);
		      ParkedCar car = new ParkedCar();
		      ParkingMeter meter = new ParkingMeter();
		      PoliceOfficer po = new PoliceOfficer();
		      System.out.printf("=== Parking Ticket Simulator ===%n%n"
		            + "---------%nCar Data%n---------%n%n"
		            + "Enter car make: ");
		      car.setMake(input.nextLine());
		      System.out.printf("Enter car model: ");
		      car.setModel(input.nextLine());
		      System.out.printf("Enter car color: ");
		      car.setColor(input.nextLine());
		      System.out.printf("Enter car license number: ");
		      car.setLicenseNum(input.nextLine());
		      System.out.printf("Enter minutes car has been parked: ");
		      car.setMinsParked(input.nextInt());
		      System.out.printf("%n----------%nMeter Data%n----------"
		            + "%n%nEnter minutes purchased by driver: ");
		      meter.setMinsPurchased(input.nextInt());
		      input.nextLine();
		      System.out.printf("%n-------%nPO Data%n-------%n%n"
		            + "Enter police officer's name: ");
		      po.setPOName(input.nextLine());
		      System.out.printf("Enter police officer's badge number: ");
		      po.setPOBadgeNum(input.nextInt());
		      System.out.printf("%n---------------------%n"
		            + "Parking Ticket Issued%n---------------------"
		            + "%n%n");
		      ParkingTicket ticket;
		      if ((ticket = po.checkCarAndMeter(car, meter)) != null) {
		         System.out.printf("| Parking ticket #: . . .%n"
		               + "| Fined amount: $%d.00%n"
		               + "| Car issued to: %s %s %s, license #: %s%n"
		               + "| Issued by officer: %s, badge #: %d%n",
		               ticket.getFineAmount(), ticket.getCarColor(),
		               ticket.getCarMake(), ticket.getCarModel(),
		               ticket.getCarLicenseNum(), ticket.getPOName(),
		               ticket.getPOBadgeNum());
		      } else {
		         System.out.printf("No parking ticket has been issued!%n");
		      }
		      return;
		   }
		}