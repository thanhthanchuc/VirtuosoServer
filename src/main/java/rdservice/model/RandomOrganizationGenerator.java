package rdservice.model;

import java.io.FileNotFoundException;

import file.contents.ListData;
import model.CityLocation;
import model.Organization;

public class RandomOrganizationGenerator extends GetRandom {
	private String name;
	private String detail;
	private String headquater;
	
	public RandomOrganizationGenerator() {
		try {
			this.name = getRandomFromList(ListData.ListCitys());
			this.headquater = getRandomFromList(ListData.ListCitys());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.detail = getRandomFromList(ListData.listDetailPerson());
	}
	
	public Organization generateOrganization() {
		RandomOrganizationGenerator rd = new RandomOrganizationGenerator();
		return new Organization(rd.name, rd.detail, rd.headquater);
	}
}
