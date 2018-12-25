package rdservice.model;

import java.io.FileNotFoundException;
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

public class RandomEventGenerator extends GetRandom implements DataLinkAndTime {

	private final String NAMESPACE = "http://example.org/Event/";
	private static ArrayList<String> names;
	private static ArrayList<String> details;

	public RandomEventGenerator() {
		try {
			names = ListData.listEvent();
			details = ListData.listEventDetail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Event generateRandomEvent() {
		String name = getRandomFromList(names);
		String detail = getRandomFromList(details);
		String link = getRandomFromList(DataLinkAndTime.links);
		String timeLink = getRandomFromList(DataLinkAndTime.times);
		String time = getRandomFromList(DataLinkAndTime.times);
		return new Event(name, detail, link, timeLink, time);
	}

	/**
	 * 
	 * @param conn
	 * @return: Số lượng thực thể có trong database tính đến thời điểm hiện tại
	 */
	public int countEvent(RepositoryConnection conn) {
		String count = null;
		String queryString = "select count(distinct ?s) as ?count\n";
		queryString += "where\n";
		queryString += "{\n";
		queryString += "?s ?p ?o.\n";
		queryString += "FILTER regex(str(?s),\"http://example.org/Event/Event\").\n";
		queryString += "}";
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

		model.add(idE, name, vf.createLiteral(e.getName()));
		model.add(idE, detail, vf.createLiteral(e.getDetail()));
		model.add(idE, link, vf.createLiteral(e.getLink()));
		model.add(idE, time, vf.createLiteral(e.getTime()));
		return idE;
	}
}
