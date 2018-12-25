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
	 * Đưa ra tất cả thông tin của Person có định danh là idP
	 * 
	 * @param maPerson
	 * @param conn
	 */
	public void basicQuery1(String idP) {
		System.out.println("BasicQuery1: Đưa ra tất cả thông tin của Person có định danh là " + idP);
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
			System.out.println("IDPerson: " + FormatValue.formatString(solution.getValue("idP").toString()));
			System.out.println("Name: " + FormatValue.formatString(solution.getValue("name").toString()));
			System.out.println("Position: " + FormatValue.formatString(solution.getValue("position").toString()));
			System.out.println("Detail: " + FormatValue.formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + FormatValue.formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 1: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Đưa ra tất cả thông tin của Organization có định danh là idO
	 * 
	 * @param idO
	 */
	public void basicQuery2(String idO) {
		System.out.println("BasicQuery2: Đưa ra tất cả thông tin của Organization có định danh là " + idO);
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
			System.out.println("IDOrganization: " + FormatValue.formatString(solution.getValue("idO").toString()));
			System.out.println("Name: " + FormatValue.formatString(solution.getValue("name").toString()));
			System.out
					.println("Headquarter: " + FormatValue.formatString(solution.getValue("headquarters").toString()));
			System.out.println("Detail: " + FormatValue.formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + FormatValue.formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 2: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Đưa ra tất cả thông tin của Location có định danh là idL
	 * 
	 * @param idL
	 */
	public void basicQuery3(String idL) {
		System.out.println("BasicQuery3: Đưa ra tất cả thông tin của Location có định danh là " + idL);
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
			System.out.println("IDLocation: " + FormatValue.formatString(solution.getValue("idL").toString()));
			System.out.println("Name: " + FormatValue.formatString(solution.getValue("name").toString()));
			System.out.println("Detail: " + FormatValue.formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + FormatValue.formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 3: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Đưa ra tất cả thông tin của Country có định danh là nameCountry
	 * 
	 * @param idC
	 */
	public void basicQuery4(String nameCountry) {
		System.out.println("BasicQuery4: Đưa ra tất cả thông tin của Country có định danh là " + nameCountry);
		String queryString = "PREFIX c:<http://example.org/Country/>\n";
		queryString += "select distinct ?idC ?detail ?link\n";
		queryString += "where {\n";
		queryString += "?idC c:Detail ?detail.\n";
		queryString += "?idC c:Link ?link.\n";
		queryString += "FILTER (str(?idC) like \"%" + nameCountry + "\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("Name: " + FormatValue.formatString(solution.getValue("idC").toString()));
			System.out.println("Detail: " + FormatValue.formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + FormatValue.formatString(solution.getValue("link").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 4: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Đưa ra tất cả thông tính của Event có định danh là idE
	 * 
	 * @param idE
	 */
	public void basicQuery5(String idE) {
		System.out.println("BasicQuery5: Đưa ra tất cả thông tính của Event có định danh là " + idE);
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
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Name: " + FormatValue.formatString(solution.getValue("name").toString()));
			System.out.println("Detail: " + FormatValue.formatString(solution.getValue("detail").toString()));
			System.out.println("Link: " + FormatValue.formatString(solution.getValue("link").toString()));
			System.out.println("At: " + FormatValue.formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 5: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Sự kiện có tên là nameEvent diễn ra vào lúc nào ?
	 * 
	 * @param idE
	 */
	public void basicQuery6(String nameEvent) {
		System.out.println("BasicQuery6: Sự kiện có tên " + nameEvent + " diễn ra vào lúc nào ?");
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
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Name: " + FormatValue.formatString(solution.getValue("name").toString()));
			System.out.println("At: " + FormatValue.formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 6: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * 
	 * @param nameEvent: Sự kiện có tên nameEvent diễn ra ở Location nào
	 */
	public void basicQuery7(String nameEvent) {
		System.out.println("BasicQuery7: Sự kiện có tên " + nameEvent + " diễn ra ở Location nào ?");
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
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("NAME: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println("Relatioship: " + FormatValue.formatString(solution.getValue("rl").toString()));
			System.out.println("Location: " + FormatValue.formatString(solution.getValue("location").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 7: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * 
	 * @param nameEvent: Đưa ra những Organization đã tổ chức sự kiện nameEvent
	 */
	public void basicQuery8(String nameEvent) {
		System.out.println("BasicQuery8: Đưa ra những Organization đã tổ chức sự kiện " + nameEvent);
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
			System.out.println("IDOrganization: " + FormatValue.formatString(solution.getValue("idO").toString()));
			System.out.println("NAME: " + FormatValue.formatString(solution.getValue("organization").toString()));
			System.out.println("Relatioship: " + FormatValue.formatString(solution.getValue("rl").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 8: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * 
	 * @param nameEvent: Đưa ra những Person tham gia sự kiện nameEvent
	 */
	public void basicQuery9(String nameEvent) {
		System.out.println("BasicQuery9: Đưa ra những Person tham gia sự kiện " + nameEvent);
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
			System.out.println("IDPerson: " + FormatValue.formatString(solution.getValue("idP").toString()));
			System.out.println("NAME: " + FormatValue.formatString(solution.getValue("person").toString()));
			System.out.println("Relatioship: " + FormatValue.formatString(solution.getValue("rl").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 9: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Đưa ra những người đã phát triển tổ chức có tên nameOrganization
	 * 
	 * @param nameOrganization
	 */
	public void basicQuery10(String nameOrganization) {
		System.out.println("BasicQuery10: Đưa ra những người đã phát triển tổ chức có tên " + nameOrganization);
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
			System.out.println("IDPerson: " + FormatValue.formatString(solution.getValue("idP").toString()));
			System.out.println("Person: " + FormatValue.formatString(solution.getValue("person").toString()));
			System.out.println("Relatioship: " + FormatValue.formatString(solution.getValue("rel").toString()));
			System.out.println("IDOrganization: " + FormatValue.formatString(solution.getValue("idO").toString()));
			System.out
					.println("Organization: " + FormatValue.formatString(solution.getValue("organization").toString()));
			System.out.println();
		}
		System.out.println("Time BasicQuery 10: " + (end - start) + "ms");
		System.out.println();
	}
}
