package rdservice;

import java.util.ArrayList;
import java.util.Random;

class GetRandom {
	protected static String getRandomFromList(ArrayList<String> list) {
		Random rand = new Random();
		int rd = rand.nextInt(list.size() - 1);
		return list.get(rd);
	}	
}
