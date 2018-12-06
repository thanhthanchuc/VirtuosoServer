package contains.tripleStatement.IRI;

import java.util.Random;

import org.eclipse.rdf4j.model.IRI;

public class RandomIRI {
	private EventIRI eventIRI;
	private CountryIRI countryIRI;
	private PersonIRI personIRI;
	private OrganizationIRI organizationIRI;
	private CityLocationIRI cityIRI;
	private Random rd;
	
	public RandomIRI() {
		eventIRI = new EventIRI();
		countryIRI = new CountryIRI();
		personIRI = new PersonIRI();
		organizationIRI = new OrganizationIRI();
		cityIRI = new CityLocationIRI();
	}
	
	//Lay ra random 1 thuc the
	public IRI randomIRI() {
		rd = new Random();
		int num = rd.nextInt(11) + 1;
		if(num == 1)
			return eventIRI.NAME;
		if(num == 2)
			return countryIRI.NAME;
		if(num == 3)
			return personIRI.NAME;
		if(num == 4)
			return organizationIRI.NAME;
		if(num == 5)
			return cityIRI.NAME;
		if(num == 6) 
			return eventIRI.TIME;
		if(num == 7) 
			return eventIRI.DETAIL;
		if(num == 8)
			return personIRI.DETAIL;
		return num == 9 ? cityIRI.DETAIL : num == 10 ? countryIRI.DETAIL : personIRI.POSITION;
	}
}
