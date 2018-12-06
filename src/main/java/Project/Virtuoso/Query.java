package Project.Virtuoso;

import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class Query {
	public static void main(String[] args) {
		Repository myRepository = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME,
				VirtuosoVariable.PASSWORD);

		String query2 = "PREFIX ps: <http://example.org/Person/>\r\n" + "PREFIX ev: <http://example.org/Event/>\r\n"
				+ "select ?person ?p ?event \r\n" + "where {\r\n" + "?person ?p ?event .\r\n"
				+ "FILTER regex(?person , ps:).\r\n" + "FILTER regex(?event , ev:).\r\n" + "}";

		RepositoryConnection conn = myRepository.getConnection();
		long start = System.currentTimeMillis();
		TupleQuery query = conn.prepareTupleQuery(query2);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " mns");
		int i = 0;
		while (result.hasNext()) {
			i++;
			BindingSet solution = result.next();

			System.out.println("Mr. " + getString(solution.getValue("person").toString()) + " attend "
					+ getString(solution.getValue("event").toString()));
			
		}
		System.out.println(i);
		// ?s a ex:Artist; foar:firstName ?n.
	}

	private static String getString(String str) {
		return str.substring(str.lastIndexOf("/") + 1, str.length());
	}
}
