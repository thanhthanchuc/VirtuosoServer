package contains.tripleStatement.IRI;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.Country;
import model.Event;
import rdservice.model.RandomCountryGenerator;
import rdservice.model.RandomEventGenerator;

public class CountryIRI {
	private final String NAMESPACE = "http://example.org/Country/";
	private RandomCountryGenerator rd;
	private Country country;
	public IRI NAME;
	public IRI DETAIL;
	
	private IRI IRI(String context) {
		return Variable.getIRI(NAMESPACE, context);
	}
	
	public CountryIRI() {
		rd = new RandomCountryGenerator();
		country = rd.generateRandomCountry();
		NAME = IRI(country.Name());
		DETAIL = IRI(country.Detail());
	}
}
