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

	/*
	 * Khi tạo mới class dữ liệu tự động thêm vào ArrayList tương ứng
	 */
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

	/**
	 * Tạo ngẫu nhiên giá trị cho các thuộc tính của thực thể
	 * @return: thực thể
	 */
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

	/**
	 * 
	 * @param conn
	 * @return: Số lượng thực thể có trong database tính đến thời điểm hiện tại
	 */
	public int countPerson(RepositoryConnection conn) {
		String count = null;
		String queryString = "select count(distinct ?s) as ?count\n";
		queryString += "where\n";
		queryString += "{\n";
		queryString += "?s ?p ?o.\n";
		queryString += "FILTER regex(str(?s),\"http://example.org/Person/Person\").\n";
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

	/**
	 * Tạo các triple lưu dữ liệu và add vào model
	 * 
	 * @param vf
	 * @param       model: chứa các triple
	 * @param count
	 * @return: IRI định danh thực thể
	 */
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
