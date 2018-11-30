package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import file.contents.ListData;
import model.Person;

public class RandomPersonGenerator {
	// List data for random Person
	private ArrayList<String> firstNames;
	private ArrayList<String> lastNames;
	private ArrayList<String> positions;
	private ArrayList<String> detailPerson;

	public RandomPersonGenerator() throws FileNotFoundException {
		firstNames = ListData.ListFirstNames();
		lastNames = ListData.ListLastNames();
		positions = ListData.ListPositions();
		detailPerson = ListData.listDetailPerson();
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
		String de = GetRandom.getRandomFromList(p.detailPerson);
		return new Person(fn, ln, pos, de);
	}
	
	public static void main(String[] arg) throws FileNotFoundException {
		Person person = generateRandomPerson();
		System.out.println(person.name);
	}
}
