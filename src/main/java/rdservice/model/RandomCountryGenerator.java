package rdservice.model;

import java.util.Random;

import file.contents.ListData;
import model.Country;

public class RandomCountryGenerator {
	
	//random
	private static Random rand = new Random();
	
	public Country generateRandomCountry() {
		int rd = rand.nextInt(ListData.country().size());
		return ListData.country().get(rd);
	}
	
	//test
//	public static void main(String[] args) {
//		RandomCountryGenerator rd = null;
//		for(int i = 0; i<100; i++) {
//			rd = new RandomCountryGenerator();
//			System.out.println(rd.generateRandomCountry().Name());
//		}
//		
//	}
}
