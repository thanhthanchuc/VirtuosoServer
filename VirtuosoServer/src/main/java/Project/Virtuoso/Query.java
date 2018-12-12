package Project.Virtuoso;

import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;

import virtuoso.connectivity.VirtuosoConnector;

public class Query {
	VirtuosoConnector vc;

	public Query() {
		vc = new VirtuosoConnector();

	}

	/**
	 * Đưa ra id name detail link của Person có mã Person
	 * 
	 * @param maPerson
	 * @param conn
	 */
	public void basicQuery1(String maPerson) {
		String queryString = "PREFIX ex:<http://example.org/Person/> \n" + "Select ?id ?name ?detail ?link \n"
				+ "where\n" + "{\n" + "?id ex:Name ?name.\n" + "?id ex:Detail ?detail.\n" + "?id ex:Link ?link.\n"
				+ "FILTER (str(?id) like \"http://example.org/Person/Person40%\")\n" + "}";
		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("Định danh: " + formatStringIRI(solution.getValue("id").toString()) + " \nTên: "
					+ formatStringIRI(solution.getValue("name").toString()) + "\nMô tả: "
					+ formatStringIRI(solution.getValue("detail").toString()) + "\nLink: "
					+ formatStringIRI(solution.getValue("link").toString()));

		}
	}

	private static String formatStringIRI(String str) {
		if (str.substring(0, 1).equals("\""))
			return str.substring(1, str.lastIndexOf("\""));
		else
			return str.substring(str.lastIndexOf("/") + 1, str.length());
	}
}
