package contains.tripleStatement.IRI;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.Event;
import rdservice.model.RandomEventGenerator;

public class EventIRI {
	private final String NAMESPACE = "http://example.org/Event/";
	private RandomEventGenerator rd;
	private Event event;
	public IRI NAME;
	public IRI DETAIL;
	public IRI TIME;
	public IRI LINK;
	
	private IRI IRI(String context) {
		return Variable.getIRI(NAMESPACE, context);
	}
	
	public EventIRI() {
		rd = new RandomEventGenerator();
		event = rd.generateRandomEvent();
		NAME = IRI(event.Name());
		DETAIL = IRI(event.getDetail());
		TIME = IRI(event.Time());
	}
}
