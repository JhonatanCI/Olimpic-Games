package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import model.Medal;
import model.Country;
import model.CountryData;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
	
	public static void start() {
		String[] split =null;
		String string = "";
		try {
			FileInputStream file = new FileInputStream(new File("src/data/in.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			 string = "";
			String line;
			while((line = reader.readLine()) !=null) {
				string += line;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		split= string.split(" ");
		int countries = Integer.parseInt(split[0].replace(" ", ""));
		CountryData data = new CountryData();
		String []info = new String[countries];
		for(int i= 0;i<countries;i++) {
			info [i]= split[i+1];
			data = order(data,"1",info[i].split(";"),countries);
		}
		
		System.out.print("\nMasculino\n");
		data.print();
		System.out.print("\n----------\n");
		data.clearData();	
		for(int i= 0;i<countries;i++) {
			data = order(data,"2",info[i].split(";"),countries);
		}
		data.order();
		System.out.print("\nFemenino\n");
		data.print();
		System.out.print("\n----------\n");
		data.clearData();	
		for(int i= 0;i<countries;i++) {
			data = order(data,"3",info[i].split(";"),countries);
		}
		data.order();
		System.out.print("\nCombinado");
		data.print();
	}
	
	public static CountryData order(CountryData data,String type, String[] split, int countries) {
		data.addCountry(new Country(split[0],new Medal(Integer.parseInt(split[1])),new Medal(Integer.parseInt(split[2])),
					new Medal(Integer.parseInt(split[3])),new Medal(Integer.parseInt(split[4])),new Medal(Integer.parseInt(split[5])),
					new Medal(Integer.parseInt(split[6])),type));
		data.order();
		return data;
	}

}
