package contains.tripleStatement.IRI;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.CityLocation;
import rdservice.model.RandomCityLocationGenerator;

public class CityLocationIRI {
	private final String NAMESPACE = "http://example.org/City/";
	private RandomCityLocationGenerator rd;
	private CityLocation city;
	public IRI NAME;
	public IRI DETAIL;
	public IRI LINK;
	
	private IRI IRI(String context) {
		return Variable.getIRI(NAMESPACE, context);
	}
	
	public CityLocationIRI() {
		rd = new RandomCityLocationGenerator();
		city = rd.generateRandomCityLication();
		NAME = IRI(city.Name());
		DETAIL = IRI(city.getDetail());
	}
	
}
