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
	private ArrayList<String> link; // Link trich rut
	private ArrayList<String> time; // Thoi gian trich rut

	// Khi tao moi object RandomPersonGenerator, data se auto add vao list
	public RandomPersonGenerator() throws FileNotFoundException {
		firstNames = ListData.ListFirstNames();
		lastNames = ListData.ListLastNames();
		positions = ListData.ListPositions();
		detailPerson = ListData.listDetailPerson();
		link = ListData.listLink();
		time = ListData.listTime();
	}

	/**
	 * Generate a random person This used to create API keys and secrets.
	 *
	 * @param
	 * @return Person
	 * @throws FileNotFoundException
	 */
	public Person generateRandomPerson() {
		// Tao person de them du lieu vao cac truong tren
		RandomPersonGenerator p = null;
		try {
			p = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String fn = GetRandom.getRandomFromList(p.firstNames);
		String ln = GetRandom.getRandomFromList(p.lastNames);
		String pos = GetRandom.getRandomFromList(p.positions);
		String de = GetRandom.getRandomFromList(p.detailPerson);
		String pLink = GetRandom.getRandomFromList(p.link);
		String timeLink = GetRandom.getRandomFromList(p.time);
		Person ps = new Person(fn, ln, pos, de, pLink, timeLink);
		return ps;
	}

	/* Random successfully */
	public static void main(String[] arg) throws FileNotFoundException {
		RandomPersonGenerator rd = new RandomPersonGenerator();
		for (int i = 0; i < 1000; i++) {
			Person person = rd.generateRandomPerson();
			System.out.println(person.getLink());
		}
	}
}
