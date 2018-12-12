package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import contains.variable.Variable;
import file.contents.ListData;
import model.Person;
import virtuoso.connectivity.VirtuosoConnector;


public class RandomPersonGenerator implements EntityModel {
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
		String pLink = GetRandom.getRandomFromList(EntityModel.links);
		String timeLink = GetRandom.getRandomFromList(EntityModel.times);
		Person ps = new Person(fn, ln, pos, de, pLink, timeLink);
		return ps;
	}

	// Dem so luong person trong db.
	public int countPerson(RepositoryConnection conn) {
		String count = null;
		String queryString = "PREFIX :<http://example.org/Person/>\n" 
				+ "select count(distinct ?s) as ?count\n" 
				+ "where\n" 
				+ "{\n" 
				+ "?s ?p ?o.\n" 
				+ "FILTER (str(?s) like \"http://example.org/Person/Person%\").\n" 
				+ "}";
		TupleQuery query = conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		
		while (result.hasNext()) {
			BindingSet solution = result.next();
			count = solution.getValue("count").toString();
		}
		count = count.substring(1,count.lastIndexOf("\""));
		int s = Integer.parseInt(count);
		return s;
	}

	public IRI createIriAndPush(RepositoryConnection conn, ValueFactory vf, int count) {
		Person p = generateRandomPerson();
		int id = count + 1;
		
		IRI idP = Variable.getIRI(NAMESPACE, "Person" + id);
		IRI name = Variable.getIRI(NAMESPACE, "Name");
		IRI position = Variable.getIRI(NAMESPACE, "Position");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		
		conn.add(idP, name, vf.createLiteral(p.getName()));
		conn.add(idP, position, vf.createLiteral(p.getPosition()));
		conn.add(idP, detail, vf.createLiteral(p.getDetail()));
		conn.add(idP, link, vf.createLiteral(p.getLink()));
		return idP;
	}
	/* Random successfully */
	public static void main(String[] args) {
		VirtuosoConnector vc = new VirtuosoConnector();
		RandomPersonGenerator rdp = null;
		try {
			rdp = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = rdp.countPerson(vc.conn);
		long start_time = System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			IRI id = rdp.createIriAndPush(vc.conn, vc.vf, count);
			if (i % 1 == 0)
				System.out.println(id);
			count++;
		}

		long end_time = System.currentTimeMillis();
		System.out.println(end_time - start_time + "ms");
		
	}
}
