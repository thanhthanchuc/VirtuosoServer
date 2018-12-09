package rdservice.model;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.variable.Variable;
import file.contents.ListData;
import model.Event;
import model.Person;

public class RandomEventGenerator extends GetRandom implements EntityModel {
	private ArrayList<String> names;
	private ArrayList<String> details;
	private final String NAMESPACE = "http://example.org/Event/";
	public RandomEventGenerator() {
		this.names = ListData.listEvent();
		this.details = ListData.listDetailPerson();
	}
	private Event generateRandomEvent() {
		RandomEventGenerator rde = new RandomEventGenerator();
		String name = getRandomFromList(rde.names);
		String detail = getRandomFromList(rde.times);
		String link = getRandomFromList(rde.links);
		String timeLink = getRandomFromList(rde.times);
		String time = getRandomFromList(rde.times);
		return new Event(name, detail, link, timeLink, time);
	}

	public IRI createIriAndPush(Event e, RepositoryConnection conn, ValueFactory vf) {
		e = generateRandomEvent();
		IRI name = Variable.getIRI(NAMESPACE, e.getName());
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		IRI time = Variable.getIRI(NAMESPACE, "TIME");
		conn.add(name, detail, vf.createLiteral(e.getDetail()));
		conn.add(name, link, vf.createLiteral(e.getLink()));
		conn.add(name,time,vf.createLiteral(e.getTime()));
		return name;
	}
}
