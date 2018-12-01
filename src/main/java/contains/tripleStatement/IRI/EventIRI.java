package contains.tripleStatement.IRI;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.Event;
import rdservice.model.RandomEventGenerator;

public class EventIRI {
	private RandomEventGenerator rd;
	private Event event;
	public IRI NAME;
	public IRI DETAIL;
	public IRI TIME;
	
	private IRI IRI(String context) {
		return Variable.getIRI(context);
	}
	
	public EventIRI() {
		rd = new RandomEventGenerator();
		event = rd.generateRandomEvent();
		NAME = IRI(event.Name());
		DETAIL = IRI(event.Detail());
		TIME = IRI(event.Time());
	}
}
