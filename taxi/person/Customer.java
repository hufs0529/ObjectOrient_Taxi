package taxi.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;
import taxi.place.Location;
import taxi.TaxiManager;
import taxi.TaxiManagerSystem;
import taxi.place.Departure;

@Getter
public class Customer extends Person{
	
	//private List<Driver> drivers = TaxiManager.getInstance().getDrivers();
	//private List<Customer> customers = TaxiManager.getInstance().getCustomers();
	private String destination;
	private int budget;
	private Float change;
	
	//Driver unknown = TaxiManager.getInstance().getDrivers().get(0);

	
	public Customer(String location, String destination, String name, Float rate, int budget) {
		super(location, name, rate);
		this.destination = destination;
		this.budget = budget;
	}
	
	
	public void callTaxi() throws InterruptedException {
		System.out.println("택시를 호출합니다...");
		for(int i = 0; i < 4; i++) {
			System.out.println("*-*-*-*-**-*-*");
			Thread.sleep(500);
		}
		System.out.println();
		Thread.sleep(2);
		
		
		//Customer customer = TaxiManager.getInstance().getCustomers().get(0);
		TaxiManagerSystem.finishingMatch(this);
		//TaxiManagerSystem.setRateToCustomer(this);
		
	}

	@Override
	public String toString() {
		return super.toString()+" 목적지는 "+destination+" 입니다.";
	}


	public void setBudget(int charge) {
		this.budget -= charge;
	}

}

