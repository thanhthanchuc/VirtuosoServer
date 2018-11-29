package rdservice;

import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import file.contents.ListData;
import model.Person;

public class RandomPersonGenerator {
	// List data for random Person
	private ArrayList<String> firstNames;
	private ArrayList<String> lastNames;
	private ArrayList<String> positions;

	public RandomPersonGenerator() throws FileNotFoundException {
		firstNames = ListData.ListFirstNames();
		lastNames = ListData.ListLastNames();
		positions = ListData.ListPositions();
	}

	/**
	 * Generate a random person This used to create API keys and secrets.
	 *
	 * @param
	 * @return Person
	 * @throws FileNotFoundException 
	 */
	public static Person generateRandomPerson() throws FileNotFoundException {
		//Tao person de them du lieu vao cac truong tren
		RandomPersonGenerator p = new RandomPersonGenerator();
		String fn = GetRandom.getRandomFromList(p.firstNames);
		String ln = GetRandom.getRandomFromList(p.lastNames);
		String pos = GetRandom.getRandomFromList(p.positions);
		return new Person(fn, ln, pos);
	}
	
	public static void main(String[] arg) throws FileNotFoundException {
		Person person = generateRandomPerson();
		System.out.println(person.name);
	}
}
