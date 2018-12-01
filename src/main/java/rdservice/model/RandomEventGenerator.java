package rdservice.model;

import file.contents.ListData;
import model.Event;

public class RandomEventGenerator extends GetRandom {
	private String name;
	private String detail;
	private String time;
	
	public RandomEventGenerator() {
		this.name = getRandomFromList(ListData.listEvent());
		//Su dung tam detail cua person cho event
		this.detail = getRandomFromList(ListData.listDetailPerson());
		this.time = getRandomFromList(ListData.listTime());
	}
	public Event generateRandomEvent() {
		RandomEventGenerator rde = new RandomEventGenerator();
		return new Event(rde.name, rde.detail, rde.time);
	}
}
