package virtuoso.main;

import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;

import virtuoso.connection.VirtuosoConnector;

public class BasicQuery {
	VirtuosoConnector vc;

	public BasicQuery() {
		vc = new VirtuosoConnector();

	}

	/**
	 * Format String IRI or Literal
	 * @param str
	 * @return
	 */
	private static String formatString(String str) {
		if (str.substring(0, 1).equals("\""))
			return str.substring(1, str.lastIndexOf("\""));
		else
			return str.substring(str.lastIndexOf("/") + 1, str.length());
	}

	/**
	 * Đưa ra tất cả thông tin của Person có định danh là idP
	 * 
	 * @param maPerson
	 * @param conn
	 */
	public void basicQuery1(String idP) {
		String queryString = "PREFIX ps:<http://example.org/Person/>\n";
		queryString += "select *\n";
		queryString += "where {\n";
		queryString += "?idP ps:Name ?name.\n";
		queryString += "?idP ps:Position ?position.\n";
		queryString += "?idP ps:Detail ?detail.\n";
		queryString += "?idP ps:Link ?link.\n";
		queryString += "FILTER (str(?idP) like \"%" + idP + "\").\n";
		queryString += "}";

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

	/**
	 * Đưa ra tất cả thông tin của Organization có định danh là idO
	 * 
	 * @param idO
	 */
	public void basicQuery2(String idO) {
		String queryString = "PREFIX org:<http://example.org/Organization/>\n";
		queryString += "select *\n";
		queryString += "where {\n";
		queryString += "?idO org:Name ?name.\n";
		queryString += "?idO org:Headquarters ?headquarters.\n";
		queryString += "?idO org:Detail ?detail.\n";
		queryString += "?idO org:Link ?link.\n";
		queryString += "FILTER (str(?idO) like \"%" + idO + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDOrganization: " + formatString(solution.getValue("idO").toString()));
			System.out.println("Name: " + formatString(solution.getValue("name").toString()));
			System.out.println("Headquarter: " + formatString(solution.getValue("headquarters").toString()));
			System.out.println("Detail: " + formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	public void basicQuery3(String idL) {
		String queryString = "PREFIX lc:<http://example.org/Location/>\n";
		queryString += "select *\n";
		queryString += "where {\n";
		queryString += "?idL lc:Name ?name.\n";
		queryString += "?idL lc:Detail ?detail.\n";
		queryString += "?idL lc:Link ?link.\n";
		queryString += "FILTER (str(?idL) like \"%" + idL + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDLocation: " + formatString(solution.getValue("idL").toString()));
			System.out.println("Name: " + formatString(solution.getValue("name").toString()));
			System.out.println("Detail: " + formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * Đưa ra tất cả thông tin của Country có định danh là nameCountry
	 * 
	 * @param idC
	 */
	public void basicQuery4(String nameCountry) {
		String queryString = "PREFIX c:<http://example.org/Country/>\n";
		queryString += "select distinct ?idC ?detail ?link\n";
		queryString += "where {\n";
		queryString += "?idC c:Detail ?detail.\n";
		queryString += "?idC c:Link ?link.\n";
		queryString += "FILTER (str(?idC) like \"%" + nameCountry + "\").\n";
		queryString += "}\n";
		queryString += "";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("Name: " + formatString(solution.getValue("name").toString()));
			System.out.println("Detail: " + formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * Đưa ra tất cả thông tinh của Event có định danh là idE
	 * 
	 * @param idE
	 */
	public void basicQuery5(String idE) {
		String queryString = "PREFIX ev:<http://example.org/Event/>\n";
		queryString += "select *\n";
		queryString += "where {\n";
		queryString += "?idE ev:Name ?name.\n";
		queryString += "?idE ev:Detail ?detail.\n";
		queryString += "?idE ev:Link ?link.\n";
		queryString += "?idE ev:At ?time.\n";
		queryString += "FILTER (str(?idE) like \"%" + idE + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDEvent: " + formatString(solution.getValue("idE").toString()));
			System.out.println("Name: " + formatString(solution.getValue("name").toString()));
			System.out.println("Detail: " + formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + formatString(solution.getValue("link").toString()));
			System.out.println("At: " + formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * Sự kiện có tên là nameEvent diễn ra vào lúc nào ?
	 * 
	 * @param idE
	 */
	public void basicQuery6(String nameEvent) {
		String queryString = "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "Select ?idE ?name ?time\n";
		queryString += "where {\n";
		queryString += "?idE ev:Name ?name.\n";
		queryString += "?idE ev:At ?time.\n";
		queryString += "FILTER regex(?name , \"" + nameEvent + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDEvent: " + formatString(solution.getValue("idE").toString()));
			System.out.println("Name: " + formatString(solution.getValue("name").toString()));
			System.out.println("At: " + formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * 
	 * @param nameEvent: Sự kiện có tên nameEvent diễn ra ở Location nào
	 */
	public void basicQuery7(String nameEvent) {
		String queryString = "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX rl: <http://example.org/Relationship/>\n";
		queryString += "PREFIX lc: <http://example.org/Location/>\n";
		queryString += "Select ?idE ?event ?rl ?location\n";
		queryString += "where {\n";
		queryString += "?idE ?rl ?idL.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "?idL lc:Name ?location.\n";
		queryString += "FILTER regex(?rl,\"takes place\").\n";
		queryString += "FILTER regex(?idE,ev:).\n";
		queryString += "FILTER regex(?idL,lc:).\n";
		queryString += "FILTER regex(?event,\"" + nameEvent + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDEvent: " + formatString(solution.getValue("idE").toString()));
			System.out.println("NAME: " + formatString(solution.getValue("event").toString()));
			System.out.println("Relatioship: " + formatString(solution.getValue("rl").toString()));
			System.out.println("Location: " + formatString(solution.getValue("location").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * 
	 * @param nameEvent: Đưa ra những Organization đã tổ chức sự kiện nameEvent
	 */
	public void basicQuery8(String nameEvent) {
		String queryString = "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX rl: <http://example.org/Relationship/>\n";
		queryString += "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "Select ?idO ?organization ?rl ?event\n";
		queryString += "where {\n";
		queryString += "?idO ?rl ?idE.\n";
		queryString += "?idO or:Name ?organization.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "FILTER regex(?rl,\"organize\").\n";
		queryString += "FILTER regex(?idO,or:).\n";
		queryString += "FILTER regex(?idE,ev:).\n";
		queryString += "FILTER regex(?event,\"" + nameEvent + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();
		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDOrganization: " + formatString(solution.getValue("idO").toString()));
			System.out.println("NAME: " + formatString(solution.getValue("organization").toString()));
			System.out.println("Relatioship: " + formatString(solution.getValue("rl").toString()));
			System.out.println("Event: " + formatString(solution.getValue("event").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * 
	 * @param nameEvent: Đưa ra những Person tham gia sự kiện nameEvent
	 */
	public void basicQuery9(String nameEvent) {
		String queryString = "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX rl: <http://example.org/Relationship/>\n";
		queryString += "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "Select ?idP ?person ?rl ?event\n";
		queryString += "where {\n";
		queryString += "?idP ?rl ?idE.\n";
		queryString += "?idP ps:Name ?person.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "FILTER regex(?rl,\"attend\").\n";
		queryString += "FILTER regex(?idP,ps:).\n";
		queryString += "FILTER regex(?idE,ev:).\n";
		queryString += "FILTER regex(?event,\"Bach Khoa Open Day\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();
		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDPerson: " + formatString(solution.getValue("idP").toString()));
			System.out.println("NAME: " + formatString(solution.getValue("person").toString()));
			System.out.println("Relatioship: " + formatString(solution.getValue("rl").toString()));
			System.out.println("Event: " + formatString(solution.getValue("event").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}

	/**
	 * Đưa ra những người đã phát triển tổ chức có tên nameOrganization
	 * 
	 * @param nameOrganization
	 */
	public void basicQuery10(String nameOrganization) {
		String queryString = "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "PREFIX org: <http://example.org/Organization/>\n";
		queryString += "\n";
		queryString += "Select ?idP ?person ?rel ?idO ?organization\n";
		queryString += "where {\n";
		queryString += "?idP ?rel ?idO.\n";
		queryString += "?idP ps:Name ?person.\n";
		queryString += "?idO org:Name ?organization.\n";
		queryString += "FILTER regex(?rel , \"develop\").\n";
		queryString += "FILTER regex(?organization,\"" + nameOrganization + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();
		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDPerson: " + formatString(solution.getValue("idP").toString()));
			System.out.println("Person: " + formatString(solution.getValue("person").toString()));
			System.out.println("Relatioship: " + formatString(solution.getValue("rel").toString()));
			System.out.println("IDOrganization: " + formatString(solution.getValue("idO").toString()));
			System.out.println("Organization: " + formatString(solution.getValue("organization").toString()));
			System.out.println();
		}
		System.out.println((end - start) + "ms");
	}
}
