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

public class RandomPersonGenerator implements DataLink {
	// List data for random Person
	private final String NAMESPACE = "http://example.org/Person/";
	private ArrayList<String> firstNames;
	private ArrayList<String> lastNames;
	private ArrayList<String> positions;
	private ArrayList<String> detailPerson;

	// Khi tao moi object RandomPersonGenerator, data se auto add vao list
	public RandomPersonGenerator() throws FileNotFoundException {
		firstNames = ListData.ListFirstNames();
		lastNames = ListData.ListLastNames();
		positions = ListData.ListPositions();
		detailPerson = ListData.listDetailPerson();
	}

	public Person generateRandomPerson() {
		// Tao person de them du lieu vao cac truong tren
		RandomPersonGenerator p = null;
		try {
			p = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String fn = GetRandom.getRandomFromList(p.firstNames);
		String ln = GetRandom.getRandomFromList(p.lastNames);
		String pos = GetRandom.getRandomFromList(p.positions);
		String de = GetRandom.getRandomFromList(p.detailPerson);
		String pLink = GetRandom.getRandomFromList(DataLink.links);
		String timeLink = GetRandom.getRandomFromList(DataLink.times);
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

	public static void main(String[] args) {
//		VirtuosoConnector vc = new VirtuosoConnector();
//		RandomPersonGenerator rdp = null;
//		Model model = new TreeModel();
//		try {
//			rdp = new RandomPersonGenerator();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int count = rdp.countPerson(vc.conn) + 1;
//		long start_time = System.currentTimeMillis();
//		for (int i = 1; i <= 10; i++) {
//			IRI entityPerson = rdp.createIriEntity(vc.vf, model, count++);
//			System.out.println(entityPerson);
//		}
//		vc.conn.add(model);
//		long end_time = System.currentTimeMillis();
//		System.out.println(end_time - start_time + "ms");
//
	}
}
