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
	
	public IRI randomIRI() {
		rd = new Random();
		int num = rd.nextInt(5) + 1;
		if(num == 1)
			return eventIRI.NAME;
		if(num == 2)
			return countryIRI.NAME;
		if(num == 3)
			return personIRI.NAME;
		if(num == 4)
			return organizationIRI.NAME;
		return cityIRI.NAME;
	}
}
