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
	 * Đưa ra những Person tham gia sự kiện Bach Khoa Open Day diễn ra tại Location
	 * Hà Nội trong tháng 10/2018
	 * 
	 * @param name
	 */
	public void AdvancedQuery1() {
		System.out.println("AdvancedQuery1: Đưa ra những Person tham gia sự kiện Bach Khoa Open Day "
				+ "diễn ra tại Hà Nội trong tháng 10/2018");
		String queryString = "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX lc: <http://example.org/Location/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select * \n";
		queryString += "where {\n";
		queryString += "?idP ps:Name ?person.\n";
		queryString += "?idP re:attend ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "?idE ?re ?idL.\n";
		queryString += "?idL lc:Name ?location.\n";
		queryString += "?idE ev:At ?time.\n";
		queryString += "FILTER regex(?event,\"Bach Khoa Open Day\").\n";
		queryString += "FILTER regex(?location,\"Hà Nội\").\n";
		queryString += "FILTER regex(?re,\"take place\").\n";
		queryString += "FILTER regex(?time,\"10/2018\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDPerson: " + FormatValue.formatString(solution.getValue("idP").toString()));
			System.out.println("Person: " + FormatValue.formatString(solution.getValue("person").toString()));
			System.out.println("Relationship: Attend");
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println("Relationship: " + FormatValue.formatString(solution.getValue("re").toString()));
			System.out.println("IDLocation: " + FormatValue.formatString(solution.getValue("idL").toString()));
			System.out.println("Location: " + FormatValue.formatString(solution.getValue("location").toString()));
			System.out.println("Time: " + FormatValue.formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 1: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * Đưa ra những Person work in organization International SOS và come sự kiện
	 * launches iPhone XS, XS Max and XR
	 */
	public void AdvancedQuery2() {
		System.out.println("AdvancedQuery2: Đưa ra những Person làm việc tại International SOS và "
				+ "tới sự kiện launches iPhone XS, XS Max and XR");
		String queryString = "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select * \n";
		queryString += "where {\n";
		queryString += "?idP ps:Name ?person.\n";
		queryString += "?idP ?re1 ?idO.\n";
		queryString += "?idO or:Name ?organization.\n";
		queryString += "?idP ?re2 ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "FILTER regex(?re1,\"work in\").\n";
		queryString += "FILTER regex(?organization,\"International SOS\").\n";
		queryString += "FILTER (str(?re2) like \"%come\").\n";
		queryString += "FILTER regex(?event,\"launches iPhone XS, XS Max and XR\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDPerson: " + FormatValue.formatString(solution.getValue("idP").toString()));
			System.out.println("Person: " + FormatValue.formatString(solution.getValue("person").toString()));
			System.out.println("Relationship1: work in");
			System.out.println("IDOrganization: " + FormatValue.formatString(solution.getValue("idO").toString()));
			System.out
					.println("Organization: " + FormatValue.formatString(solution.getValue("organization").toString()));
			System.out.println("Relationship2: " + FormatValue.formatString(solution.getValue("re2").toString()));
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 2: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * 'Microsoft' 'organize' sự kiện 'World Trade Celebration 2018' ở ?location nào
	 */
	public void AdvancedQuery3() {
		System.out.println("AdvancedQuery3: Microsoft tổ chức sự kiện 'World Trade Celebration 2018' ở Location nào ?");
		String queryString = "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX lc: <http://example.org/Location/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select * \n";
		queryString += "where {\n";
		queryString += "?idO or:Name ?organization.\n";
		queryString += "?idO re:organize ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "?idE ?re ?idL.\n";
		queryString += "?idL lc:Name ?location.\n";
		queryString += "FILTER regex(?organization,\"Microsoft\").\n";
		queryString += "FILTER regex(?event,\"World Trade Celebration 2018\").\n";
		queryString += "FILTER regex(?re,\"take place\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDOrganization: " + FormatValue.formatString(solution.getValue("idO").toString()));
			System.out
					.println("Organization: " + FormatValue.formatString(solution.getValue("organization").toString()));
			System.out.println("Relationship1: organize");
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println("Relationship2: " + FormatValue.formatString(solution.getValue("re").toString()));
			System.out.println("IDLocation: " + FormatValue.formatString(solution.getValue("idL").toString()));
			System.out.println("Location: " + FormatValue.formatString(solution.getValue("location").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 3: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * 'Toyota' có headquarters ở 'Talitsy' organize sự kiện gì trong time '2018'
	 */
	public void AdvancedQuery4() {
		System.out.println("AdvancedQuery4: Toyota có trụ sở ở Talitsy tổ chức sự kiện gì trong năm 2018.");
		String queryString = "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX lc: <http://example.org/Location/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select * \n";
		queryString += "where {\n";
		queryString += "?idO or:Name ?organization.\n";
		queryString += "?idO or:Headquarters ?headquarters.\n";
		queryString += "?idO re:organize ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "?idE ev:At ?time.\n";
		queryString += "FILTER regex(?organization,\"Toyota\").\n";
		queryString += "FILTER regex(?headquarters,\"Talitsy\").\n";
		queryString += "FILTER regex(?time,\"2018\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDOrganization: " + FormatValue.formatString(solution.getValue("idO").toString()));
			System.out
					.println("Organization: " + FormatValue.formatString(solution.getValue("organization").toString()));
			System.out
					.println("Headquarters: " + FormatValue.formatString(solution.getValue("headquarters").toString()));
			System.out.println("Relationship1: organize");
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println("Time: " + FormatValue.formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 4: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * 'Google' có trụ sở 'headquarters' tại 'Tp. Hồ Chí Minh' hợp tác với
	 * 'cooperate with' Organization nào ?
	 */
	public void AdvancedQuery5() {
		System.out.println("AdvancedQuery5: Google có trụ sở tại Tp. Hồ Chí Minh hợp tác với Organization nào ?");
		String queryString = "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "\n";
		queryString += "Select * \n";
		queryString += "where {\n";
		queryString += "?idO1 or:Name ?organization1.\n";
		queryString += "?idO1 or:Headquarters ?headquarters.\n";
		queryString += "?idO1 ?re1 ?idO2.\n";
		queryString += "?idO2 or:Name ?organization2.\n";
		queryString += "FILTER regex(?organization1,\"Google\").\n";
		queryString += "FILTER regex(?headquarters,\"Tp. Hồ Chí Minh\").\n";
		queryString += "FILTER regex(?re1,\"cooperate with\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("IDOrganization1: " + FormatValue.formatString(solution.getValue("idO1").toString()));
			System.out.println(
					"Organization1: " + FormatValue.formatString(solution.getValue("organization1").toString()));
			System.out
					.println("Headquarters: " + FormatValue.formatString(solution.getValue("headquarters").toString()));
			System.out.println("Relationship: cooperate with");
			System.out.println("IDOrganization2: " + FormatValue.formatString(solution.getValue("idO2").toString()));
			System.out.println(
					"Organization2: " + FormatValue.formatString(solution.getValue("organization2").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 5: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * 'Việt Nam" đàm phám với 'negotiate with' ?Country tổ chức 'organize' event
	 * 'AFF cup' vào time '12/2018'
	 */
	public void AdvancedQuery6() {
		System.out.println(
				"AdvancedQuery6: Việt Nam đàm phám với Country nào tổ chức sự kiện 'AFF cup' vào tháng 12/2018");
		String queryString = "PREFIX c: <http://example.org/Country/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select * \n";
		queryString += "where {\n";
		queryString += "?idC1 ?re1 ?idC2.\n";
		queryString += "?idC1 re:organize ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "?idE ev:At ?time.\n";
		queryString += "FILTER regex(?re1,\"negotiate with\" ).\n";
		queryString += "FILTER regex(?idC1,\"Viet Nam\").\n";
		queryString += "FILTER regex(?idC2,c:).\n";
		queryString += "FILTER (!(str(?idC2) like \"%Viet Nam\")).\n";
		queryString += "FILTER regex(?event,\"AFF cup\").\n";
		queryString += "FILTER regex(?time,\"12/2018\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("Country1: " + FormatValue.formatString(solution.getValue("idC1").toString()));
			System.out.println("Relationship1: " + FormatValue.formatString(solution.getValue("re1").toString()));
			System.out.println("Country2: " + FormatValue.formatString(solution.getValue("idC2").toString()));
			System.out.println("Relationship2: organize");
			System.out.println("IDEvent: " + FormatValue.formatString(solution.getValue("idE").toString()));
			System.out.println("Event: " + FormatValue.formatString(solution.getValue("event").toString()));
			System.out.println("Time: " + FormatValue.formatString(solution.getValue("time").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 6: " + (end - start) + "ms");
		System.out.println();
	}

	/**
	 * Số lượng Person đã tham dự sự kiện có tên nameEvent
	 * 
	 * @param nameEvent
	 */
	public void AdvancedQuery7(String nameEvent) {
		System.out.println("AdvancedQuery7: Số lượng Person đã tham dự sự kiện có tên " + nameEvent);
		String queryString = " PREFIX ps: <http://example.org/Person/>\n";
		queryString += " PREFIX ev: <http://example.org/Event/>\n";
		queryString += " PREFIX re: <http://example.org/Relationship/>\n";
		queryString += " Select count(distinct ?idP) as ?countP\n";
		queryString += " where {\n";
		queryString += " ?idP re:attend ?idE.\n";
		queryString += " ?idE ev:Name ?event.\n";
		queryString += "FILTER regex(?idP,ps:).\n";
		queryString += "FILTER regex(?idE,ev:).\n";
		queryString += " FILTER regex(?event,\"" + nameEvent + "\").\n";
		queryString += " }";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("Name Event: " + nameEvent);
			System.out.println("CountPerson: " + FormatValue.formatString(solution.getValue("countP").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 7: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * Số Person làm việc tại Samsung or Google
	 */
	public void AdvancedQuery8() {
		System.out.println("AdvancedQuery8: Số Person làm việc tại Samsung or Google");
		String queryString = "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select count(distinct ?idP) as ?countP\n";
		queryString += "where {\n";
		queryString += "?idP ?re ?idO.\n";
		queryString += "?idO or:Name ?organization.\n";
		queryString += "FILTER regex(?idP,ps:).\n";
		queryString += "FILTER regex(?re,\"work in\").\n";
		queryString += "FILTER (str(?organization) like \"%Samsung\" or str(?organization) like \"%Google\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("CountPerson: " + FormatValue.formatString(solution.getValue("countP").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 8: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * Số Person work in Microsoft or Honda đã tham gia sự kiện 'President Obama
	 * visits Vietnam'
	 */
	public void AdvancedQuery9() {
		System.out.println("AdvancedQuery9: Số Person làm việc tại Microsoft hoặc Honda "
				+ "đã tham gia sự kiện 'President Obama visits Vietnam'");
		String queryString = "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "PREFIX or: <http://example.org/Organization/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select count(distinct ?idP) as ?countP\n";
		queryString += "where {\n";
		queryString += "?idP ?re ?idO.\n";
		queryString += "?idO or:Name ?organization.\n";
		queryString += "?idP re:come ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "FILTER regex(?idE,ev:).\n";
		queryString += "FILTER regex(?idP,ps:).\n";
		queryString += "FILTER regex(?re,\"work in\").\n";
		queryString += "FILTER (str(?organization) like \"%Honda\" or str(?organization) like \"%Microsoft\").\n";
		queryString += "FILTER regex(?event,\"President Obama visits Vietnam\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("CountPerson: " + FormatValue.formatString(solution.getValue("countP").toString()));
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 9: " + (end - start) + "ms");
		System.out.println();
	}

	/*
	 * Đếm số Person passed final exam at 07/2018
	 */
	public void AdvancedQuery10() {
		System.out.println("AdvancedQuery10: Đếm số Person vượt qua bài kiểm tra cuối kì vào tháng 07/2018");
		String queryString = "PREFIX ps: <http://example.org/Person/>\n";
		queryString += "PREFIX ev: <http://example.org/Event/>\n";
		queryString += "PREFIX re: <http://example.org/Relationship/>\n";
		queryString += "Select count(distinct ?idP) as ?countP\n";
		queryString += "Where {\n";
		queryString += "?idP re:passed ?idE.\n";
		queryString += "?idE ev:Name ?event.\n";
		queryString += "?idE ev:At ?time.\n";
		queryString += "FILTER regex(?idP,ps:).\n";
		queryString += "FILTER regex(?event ,\"final exam\").\n";
		queryString += "FILTER regex(?time,\"07/2018\").\n";
		queryString += "}";

		long start = System.currentTimeMillis();
		TupleQuery query = vc.conn.prepareTupleQuery(queryString);
		TupleQueryResult result = query.evaluate();
		long end = System.currentTimeMillis();

		while (result.hasNext()) {
			BindingSet solution = result.next();
			System.out.println("CountPerson: " + FormatValue.formatString(solution.getValue("countP").toString()));
			System.out.println("Relationship: passed");
			System.out.println("Event: " + "final exam");
			System.out.println("Time: " + "07/2018");
			System.out.println();
		}
		System.out.println("Time AdvancedQuery 10: " + (end - start) + "ms");
		System.out.println();
	}
}
