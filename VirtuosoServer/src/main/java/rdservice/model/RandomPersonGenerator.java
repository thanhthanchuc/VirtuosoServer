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
import model.Person;

public class RandomPersonGenerator implements DataLinkAndTime {
	// List data for random Person
	private final String NAMESPACE = "http://example.org/Person/";
	private static ArrayList<String> firstNames;
	private static ArrayList<String> lastNames;
	private static ArrayList<String> positions;
	private static ArrayList<String> detailPerson;

	// Khi tao moi object RandomPersonGenerator, data se auto add vao list
	public RandomPersonGenerator() {
		try {
			firstNames = ListData.ListFirstNames();
			lastNames = ListData.ListLastNames();
			positions = ListData.ListPositions();
			detailPerson = ListData.listDetailPerson();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Person generateRandomPerson() {
		String fn = GetRandom.getRandomFromList(firstNames);
		String ln = GetRandom.getRandomFromList(lastNames);
		String pos = GetRandom.getRandomFromList(positions);
		String de = GetRandom.getRandomFromList(detailPerson);
		String pLink = GetRandom.getRandomFromList(DataLinkAndTime.links);
		String timeLink = GetRandom.getRandomFromList(DataLinkAndTime.times);
		Person ps = new Person(fn, ln, pos, de, pLink, timeLink);
		return ps;
	}

	// Dem so luong person trong db.
	public int countPerson(RepositoryConnection conn) {
		String count = null;
		String queryString = "select count(distinct ?s) as ?count\n" + "where\n" + "{\n" + "?s ?p ?o.\n"
				+ "FILTER regex(str(?s),\"http://example.org/Person/Person\").\n" + "}";
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
		Person p = generateRandomPerson();

		IRI idP = Variable.getIRI(NAMESPACE, "Person" + count);
		IRI name = Variable.getIRI(NAMESPACE, "Name");
		IRI position = Variable.getIRI(NAMESPACE, "Position");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");

		model.add(idP, name, vf.createLiteral(p.getName()));
		model.add(idP, position, vf.createLiteral(p.getPosition()));
		model.add(idP, detail, vf.createLiteral(p.getDetail()));
		model.add(idP, link, vf.createLiteral(p.getLink()));
		return idP;
	}
}
