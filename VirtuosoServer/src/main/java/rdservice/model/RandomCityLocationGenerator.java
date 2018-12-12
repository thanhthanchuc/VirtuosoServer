package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import contains.variable.Variable;
import file.contents.ListData;
import model.CityLocation;
import virtuoso.connectivity.VirtuosoConnector;

public class RandomCityLocationGenerator extends GetRandom implements EntityModel {
	private final String NAMESPACE = "http://example.org/Location/";
	private ArrayList<String> location;
	private ArrayList<String> locationDetail;
	
	public RandomCityLocationGenerator() throws FileNotFoundException {
		location = ListData.ListFirstNames();
		locationDetail = ListData.listLocationDetail();
	}

	public CityLocation generateRandomLocation() {
		RandomCityLocationGenerator lc = null;
		try {
			lc = new RandomCityLocationGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String name = GetRandom.getRandomFromList(lc.location);
		String de = GetRandom.getRandomFromList(lc.locationDetail);
		String pLink = GetRandom.getRandomFromList(EntityModel.links);
		String timeLink = GetRandom.getRandomFromList(EntityModel.times);
		CityLocation location = new CityLocation(name, de, pLink, timeLink);
		return location;
	}

	public IRI createIriAndPush(RepositoryConnection conn, ValueFactory vf) {
		CityLocation lc = generateRandomLocation();
		IRI name = Variable.getIRI(NAMESPACE, lc.getName());
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		conn.add(name, detail, vf.createLiteral(lc.getDetail()));
		conn.add(name, link, vf.createLiteral(lc.getLink()));
		return name;
	}
	
public static void main(String[] args) throws FileNotFoundException {
		VirtuosoConnector vc = new VirtuosoConnector();
		RandomCityLocationGenerator rdL = new RandomCityLocationGenerator();
		long start_time = System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			IRI name = rdL.createIriAndPush(vc.conn,vc.vf);
			if (i % 100 == 0)
				System.out.println(name);
		}
		long end_time = System.currentTimeMillis();
		System.out.println(end_time - start_time + "ms");
	}

}
