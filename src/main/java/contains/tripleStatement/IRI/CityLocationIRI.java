package contains.tripleStatement.IRI;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.CityLocation;
import rdservice.model.RandomCityLocationGenerator;

public class CityLocationIRI {
	private RandomCityLocationGenerator rd;
	private CityLocation city;
	public IRI NAME;
	public IRI DETAIL;
	
	private IRI IRI(String context) {
		return Variable.getIRI(context);
	}
	
	public CityLocationIRI() {
		rd = new RandomCityLocationGenerator();
		city = rd.generateRandomCityLication();
		NAME = IRI(city.Name());
		DETAIL = IRI(city.Detail());
	}
	
}
