package virtuoso.main;

import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;

import virtuoso.connection.VirtuosoConnector;

public class AdvancedQuery {
	VirtuosoConnector vc;
	public AdvancedQuery() {
		vc = new VirtuosoConnector();

	}

	/**
	 * Format String IRI or Literal
	 * 
	 * @param str
	 * @return
	 */
	private static String formatString(String str) {
		if (str.substring(0, 1).equals("\""))
			return str.substring(1, str.lastIndexOf("\""));
		else
			return str.substring(str.lastIndexOf("/") + 1, str.length());
	}
	public void AdvancedQuery1(String name) {
		String queryString = "PREFIX ps:<http://example.org/Person/>\n";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDPerson: " + formatString(solution.getValue("idP").toString()));
			System.out.println("Name: " + formatString(solution.getValue("name").toString()));
			System.out.println("Position: " + formatString(solution.getValue("position").toString()));
			System.out.println("Detail: " + formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}
	
	
}
