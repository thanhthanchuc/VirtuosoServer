package rdservice.model;

import java.util.ArrayList;
import java.util.Random;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import contains.variable.Variable;
import file.contents.ListData;
import model.Country;


public class RandomCountryGenerator implements EntityModel{

	private ArrayList<Country> Countrys;
	private final String NAMESPACE = "http://example.org/Country/";
	public RandomCountryGenerator() {
		this.Countrys = ListData.country();
	}

	private Country generateRandomCountry() {
		Random rd = new Random();
		int n = rd.nextInt(Countrys.size());
		return Countrys.get(n);
	}

	public IRI createIriAndPush(RepositoryConnection conn, ValueFactory vf) {
		Country c = generateRandomCountry();
		IRI name = Variable.getIRI(NAMESPACE, c.getName());
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		conn.add(name, detail, vf.createLiteral(c.getDetail()));
		conn.add(name, link, vf.createLiteral(c.getLink()));
		return name;
	}
}
