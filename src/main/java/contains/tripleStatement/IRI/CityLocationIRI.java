package contains.tripleStatement.IRI;

import javax.xml.soap.Detail;

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
		city = rd.generateRandomCityLication();
		NAME = IRI(city.Name());
		DETAIL = IRI(city.Detail());
	}
	
}
