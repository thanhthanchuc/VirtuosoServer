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
import model.Location;

public class RandomLocationGenerator extends GetRandom implements DataLinkAndTime {

	private final String NAMESPACE = "http://example.org/Location/";
	private static ArrayList<String> location;
	private static ArrayList<String> locationDetail;

	public RandomLocationGenerator() {
		try {
			location = ListData.ListFirstNames();
			locationDetail = ListData.listLocationDetail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Location generateRandomLocation() {
		String name = GetRandom.getRandomFromList(location);
		String detail = GetRandom.getRandomFromList(locationDetail);
		String pLink = GetRandom.getRandomFromList(DataLinkAndTime.links);
		String timeLink = GetRandom.getRandomFromList(DataLinkAndTime.times);
		Location location = new Location(name, detail, pLink, timeLink);
		return location;
	}

	public int countLocation(RepositoryConnection conn) {
		String count = null;
		String queryString = "select count(distinct ?s) as ?count\n" + "where\n" + "{\n" + "?s ?p ?o.\n"
				+ "FILTER regex(str(?s),\"http://example.org/Location/Location\").\n" + "}";
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
		Location lc = generateRandomLocation();

		IRI idL = Variable.getIRI(NAMESPACE, "Location" + count);
		IRI name = Variable.getIRI(NAMESPACE, "Name");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");

		model.add(idL, name, vf.createLiteral(lc.getName()));
		model.add(idL, detail, vf.createLiteral(lc.getDetail()));
		model.add(idL, link, vf.createLiteral(lc.getLink()));
		return idL;
	}
}
