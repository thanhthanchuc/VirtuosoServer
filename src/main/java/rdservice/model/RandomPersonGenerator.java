package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.VCARD4;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import file.contents.ListData;
import model.Person;
import virtuoso.connectivity.VirtuosoConnector;
import virtuoso.rdf4j.driver.VirtuosoRepository;

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
<<<<<<< HEAD
		String pLink = GetRandom.getRandomFromList(p.link);
		String timeLink = GetRandom.getRandomFromList(p.time);
		Person ps = new Person(fn, ln, pos, de, pLink, timeLink);
		return ps;
=======
		String pLink = GetRandom.getRandomFromList(p.links    );
		String timeLink = GetRandom.getRandomFromList(p.times);
		Person ps = new Person(fn, ln, pos, de, pLink, timeLink);
		return ps;
	}

	// Dem so luong person trong db.
	private static int countPerson() {
		VirtuosoConnector vc = new VirtuosoConnector();
		Repository myRepository = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME,
				VirtuosoVariable.PASSWORD);
		String count = null;
		String query2 = "PREFIX :<http://example.org/Person/>\n" 
				+ "select count(?s) as ?count\n" 
				+ "where\n" 
				+ "{\n" 
				+ "?s ?p ?o.\n" 
				+ "FILTER (str(?s) like \"http://example.org/Person/Person%\").\n" 
				+ "}";
		TupleQuery query = vc.conn.prepareTupleQuery(query2);
		TupleQueryResult result = query.evaluate();
		
		while (result.hasNext()) {
			BindingSet solution = result.next();
			count = solution.getValue("count").toString();
		}
		count = count.substring(1,count.lastIndexOf("\""));
		int s = Integer.parseInt(count);
		return s;
>>>>>>> Phuc
	}

	public IRI createIriAndPush(Person p, RepositoryConnection conn, ValueFactory vf, int count) {
		p = generateRandomPerson();
		IRI name = Variable.getIRI(NAMESPACE, "Name");
		IRI position = Variable.getIRI(NAMESPACE, "Position");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		int id = count + 1;
		IRI idP = Variable.getIRI(NAMESPACE, "Person" + id);
		conn.add(idP, name, vf.createLiteral(p.getName()));
		conn.add(idP, position, vf.createLiteral(p.getPosition()));
		conn.add(idP, detail, vf.createLiteral(p.getDetail()));
		conn.add(idP, link, vf.createLiteral(p.getLink()));
		return idP;
	}
	/* Random successfully */
<<<<<<< HEAD
	public static void main(String[] arg) throws FileNotFoundException {
		RandomPersonGenerator rd = new RandomPersonGenerator();
		for (int i = 0; i < 1000; i++) {
			Person person = rd.generateRandomPerson();
			System.out.println(person.getLink());
=======
	public static void execute() {
		VirtuosoConnector vc = new VirtuosoConnector();
		RandomPersonGenerator rdp = null;
		try {
			rdp = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = countPerson();
		long start_time = System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			Person p = rdp.generateRandomPerson();
			//Bởi vì cái hàm này nó gọi connect 1000 lần @@ ok lúc nãy nó tràn nên fail anh hay quá anh à :)) lại xàm rồi :3
			//Khôn ý, mình chỉ chery 1 ần thôi., Nãy e viết nt là 1000 lần query. em hiểu rồi. giờ làm sao chuyển cái này thành class
			// ko dùng main để class App gọi tới anh.
			IRI id = rdp.createIriAndPush(p, vc.conn, vc.vf, count);
			if (i % 100 == 0)
				System.out.println(id);
			count++;
>>>>>>> Phuc
		}

		long end_time = System.currentTimeMillis();
		System.out.println(end_time - start_time + "ms");
		
	}
}
