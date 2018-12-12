package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.variable.Variable;
import file.contents.ListData;
import model.Organization;


public class RandomOrganizationGenerator extends GetRandom implements EntityModel{
	private final String NAMESPACE = "http://example.org/Organization/";

	private ArrayList<String> organization;
	private ArrayList<String> headquarters;
	private ArrayList<String> organizationDetail;

	// Khi tao moi object RandomPersonGenerator, data se auto add vao list
	public RandomOrganizationGenerator() throws FileNotFoundException {
		organization = ListData.listOrganization();
		headquarters = ListData.ListCitys();
		organizationDetail = ListData.listOrganizationDetail();
	}

	public Organization generateRandomOrganization() {
		// Tao person de them du lieu vao cac truong tren
		RandomOrganizationGenerator org = null;
		try {
			org = new RandomOrganizationGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String name = GetRandom.getRandomFromList(org.organization);
		String hp = GetRandom.getRandomFromList(org.headquarters);
		String detail = GetRandom.getRandomFromList(org.organizationDetail);
		String oLink = GetRandom.getRandomFromList(links);
		String timeLink = GetRandom.getRandomFromList(times);
		return new Organization(name, hp, detail, oLink, timeLink);
	}


	public IRI createIriAndPush(RepositoryConnection conn, ValueFactory vf) {
		Organization org = generateRandomOrganization();
		IRI name = Variable.getIRI(NAMESPACE, org.getName());
		IRI hq = Variable.getIRI(NAMESPACE, "Headquarters");
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		conn.add(name, hq, vf.createLiteral(org.getHeadquarters()));
		conn.add(name, detail, vf.createLiteral(org.getDetail()));
		conn.add(name, link, vf.createLiteral(org.getLink()));
		return name;
	}

}
