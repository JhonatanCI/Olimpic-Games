package model;

import java.util.ArrayList;
import java.util.Collections;

public class CountryData {
private ArrayList<Country> country;
	
	public CountryData() {
		country = new ArrayList<>();
	}
	
	public void order() {
		Collections.sort(country);
	}
	
	public void addCountry(Country p) {
		country.add(p);
	}
	
	public void print() {
		for(Country p : country)
			System.out.print(p.toString()+"\n");
	}

	public void clearData() {
		country.clear();
	}
}
