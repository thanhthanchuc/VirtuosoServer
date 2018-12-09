package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.variable.Variable;
import file.contents.ListData;
import model.Organization;
import virtuoso.connectivity.VirtuosoConnector;

public class RandomOrganizationGenerator extends GetRandom {
	private final String NAMESPACE = "http://example.org/Organization/";

	private ArrayList<String> organization;
	private ArrayList<String> headquarters;
	private ArrayList<String> organizationDetail;
	private ArrayList<String> link; // Link trich rut
	private ArrayList<String> time; // Thoi gian trich rut

	// Khi tao moi object RandomPersonGenerator, data se auto add vao list
	public RandomOrganizationGenerator() throws FileNotFoundException {
		organization = ListData.listOrganization();
		headquarters = ListData.ListCitys();
		organizationDetail = ListData.listOrganizationDetail();
		link = ListData.listLink();
		time = ListData.listTime();
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
		String oLink = GetRandom.getRandomFromList(org.link);
		String timeLink = GetRandom.getRandomFromList(org.time);
		return new Organization(name, hp, detail, oLink, timeLink);
	}


	public IRI createIriAndPush(Organization org, RepositoryConnection conn, ValueFactory vf) {
		org = generateRandomOrganization();
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
