package rdservice.model;

import java.io.FileNotFoundException;

import file.contents.ListData;
import model.CityLocation;

public class RandomCityLocationGenerator extends GetRandom {
	private String name;
	private String detail;
	
	private RandomCityLocationGenerator() {
		try {
			this.name = getRandomFromList(ListData.ListCitys());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.detail = getRandomFromList(ListData.listDetailPerson());
	}
	
	public CityLocation generateRandomCityLication() {
		RandomCityLocationGenerator rd = new RandomCityLocationGenerator();
		return new CityLocation(rd.name, rd.detail);
	}
}
