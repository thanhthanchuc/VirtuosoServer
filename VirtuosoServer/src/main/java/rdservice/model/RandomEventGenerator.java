package rdservice.model;

import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import contains.variable.Variable;
import file.contents.ListData;
import model.Event;


public class RandomEventGenerator extends GetRandom implements DataLink {
	private ArrayList<String> names;
	private ArrayList<String> details;
	private final String NAMESPACE = "http://example.org/Event/";

	public RandomEventGenerator() {
		this.names = ListData.listEvent();
		this.details = ListData.listEventDetail();
	}

	private Event generateRandomEvent() {
		RandomEventGenerator rde = new RandomEventGenerator();
		String name = getRandomFromList(rde.names);
		String detail = getRandomFromList(rde.details);
		String link = getRandomFromList(DataLink.links);
		String timeLink = getRandomFromList(DataLink.times);
		String time = getRandomFromList(DataLink.times);
		return new Event(name, detail, link, timeLink, time);
	}

	public IRI createIriEntity(ValueFactory vf,Model model) {
		Event e = generateRandomEvent();
		IRI name = Variable.getIRI(NAMESPACE, e.getName());
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		IRI time = Variable.getIRI(NAMESPACE, "At");
		model.add(name, detail, vf.createLiteral(e.getDetail()));
		model.add(name, link, vf.createLiteral(e.getLink()));
		model.add(name, time, vf.createLiteral(e.getTime()));
		return name;
	}
}
