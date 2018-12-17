package rdservice.model;

import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

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
	
	public int countEvent(RepositoryConnection conn) {
		String count = null;
		String queryString = "select count(distinct ?s) as ?count\n" + "where\n" + "{\n" + "?s ?p ?o.\n"
				+ "FILTER regex(str(?s),\"http://example.org/Event/Event\").\n" + "}";
		TupleQuery query = conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		while (result.hasNext()) {
			BindingSet solution = result.next();
			count = solution.getValue("count").toString();
		}
		count = count.substring(1, count.lastIndexOf("\""));
		int s = Integer.parseInt(count);
		return s;
	}
	public IRI createIriEntity(ValueFactory vf, Model model, int count) {
		Event e = generateRandomEvent();

		IRI idE = Variable.getIRI(NAMESPACE, "Event" + count);
		IRI name = Variable.getIRI(NAMESPACE, "Name");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		IRI time = Variable.getIRI(NAMESPACE, "At");

		model.add(idE,name,vf.createLiteral(e.getName()));
		model.add(idE, detail, vf.createLiteral(e.getDetail()));
		model.add(idE, link, vf.createLiteral(e.getLink()));
		model.add(idE, time, vf.createLiteral(e.getTime()));
		return idE;
	}
}
