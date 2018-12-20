package rdservice.model;

import java.util.ArrayList;
import java.util.Random;

public abstract class GetRandom {
	protected static Random rand = new Random(); 
	protected static String getRandomFromList(ArrayList<String> list) {
		int rd = rand.nextInt(list.size());
		return list.get(rd);
	}	
}
