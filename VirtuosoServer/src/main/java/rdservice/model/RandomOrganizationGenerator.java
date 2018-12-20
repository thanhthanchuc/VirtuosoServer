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
import model.Organization;

public class RandomOrganizationGenerator extends GetRandom implements DataLinkAndTime {
	private final String NAMESPACE = "http://example.org/Organization/";

	private ArrayList<String> organization;
	private ArrayList<String> headquarters;
	private ArrayList<String> organizationDetail;

	// Khi tao moi object RandomPersonGenerator, data se auto add vao list
	public RandomOrganizationGenerator() {
		try {
			organization = ListData.listOrganization();
			headquarters = ListData.ListCitys();
			organizationDetail = ListData.listOrganizationDetail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Organization generateRandomOrganization() {
		String name = GetRandom.getRandomFromList(organization);
		String hp = GetRandom.getRandomFromList(headquarters);
		String detail = GetRandom.getRandomFromList(organizationDetail);
		String oLink = GetRandom.getRandomFromList(links);
		String timeLink = GetRandom.getRandomFromList(times);
		return new Organization(name, hp, detail, oLink, timeLink);
	}

	public int countOrganization(RepositoryConnection conn) {
		String count = null;
		String queryString = "select count(distinct ?s) as ?count\n" + "where\n" + "{\n" + "?s ?p ?o.\n"
				+ "FILTER regex(str(?s),\"http://example.org/Organization/Organization\").\n" + "}";
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
		Organization org = generateRandomOrganization();

		IRI idO = Variable.getIRI(NAMESPACE, "Organization" + count);
		IRI name = Variable.getIRI(NAMESPACE, "Name");
		IRI hq = Variable.getIRI(NAMESPACE, "Headquarters");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");

		model.add(idO, name, vf.createLiteral(org.getName()));
		model.add(idO, hq, vf.createLiteral(org.getHeadquarters()));
		model.add(idO, detail, vf.createLiteral(org.getDetail()));
		model.add(idO, link, vf.createLiteral(org.getLink()));
		return idO;
	}

}
