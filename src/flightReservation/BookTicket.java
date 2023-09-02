package flightReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTicket {
	public static void book(Flight currentflight,int tickets,int passengerID) {
		String passengerDetails=" ";
		passengerDetails ="PassengerID"+passengerID+"__"+"Number of ticketsBooked"+tickets+"__"+"total cost"+currentflight.price+tickets;
		currentflight.addPassengerDetails(passengerDetails, tickets, passengerID);
		currentflight.flightSummary();
		currentflight.printDetails();
	}
	public static void cancel(Flight currentflight,int passengerID) {
		currentflight.cancelTicket(passengerID);
		currentflight.flightSummary();
		currentflight.printDetails();
	}
	public static void print(Flight f) {
		f.printDetails();
	}

	public static void main(String[] args) {
		ArrayList<Flight>flights=new ArrayList<Flight>();
		for (int i = 0; i < 2; i++) {
			flights.add(new Flight());
			int passengerID =1;
			while(true) {
				System.out.println("1.Book 2.Cancel 3.Print");
				Scanner sc = new Scanner(System.in);
				int choice =sc.nextInt();
				switch(choice) {
				case 1:{
					System.out.println("Enter Flight ID");
					int fid = sc.nextInt();
					if(fid>flights.size()) {
						System.out.println("Invaild flight ID");
						break;
					}
					Flight currentflight = null;
					for(Flight f : flights) {
						if(f.flightID==fid) {
							currentflight = f;
							f.flightSummary();
							break;
						}
					}
					System.out.println("Enter number of tickets");
					int t= sc.nextInt();
					if(t>currentflight.tickets) {
						System.out.println("Not enought Tickets");
						break;
					}
					book(currentflight,t,passengerID);
					passengerID = passengerID+1;
					break;
				}
				case 2:
				{
					System.out.println("Enter the flightid and passengerId to cancek booking");
					int fid = sc.nextInt();
					if(fid>flights.size()) {
						System.out.println("invaild flight id");
						break;
					}
					Flight currentflight = null;
					for(Flight f:flights) {
						if(f.flightID == fid) {
							currentflight = f;
							break;
						}
					}
					int id =sc.nextInt();
					cancel(currentflight,id);
					break;
				}
				case 3:{
					for(Flight f : flights) {
						if(f.passengerDetails.size()==0) {
							System.out.println("NO passenger details for flight"+f.flightID);
						}
						else {
							print(f);
						}
						break;
					}}
				default:
				{
					break;
				}	
				}}}}}


