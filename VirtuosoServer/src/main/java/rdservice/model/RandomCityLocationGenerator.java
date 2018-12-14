package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import contains.variable.Variable;
import file.contents.ListData;
import model.CityLocation;


public class RandomCityLocationGenerator extends GetRandom implements DataLink {
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
		String detail = GetRandom.getRandomFromList(lc.locationDetail);
		String pLink = GetRandom.getRandomFromList(DataLink.links);
		String timeLink = GetRandom.getRandomFromList(DataLink.times);
		CityLocation location = new CityLocation(name, detail, pLink, timeLink);
		return location;
	}

	public IRI createIriEntity(ValueFactory vf, Model model) {
		CityLocation lc = generateRandomLocation();
		IRI name = Variable.getIRI(NAMESPACE, lc.getName());
		IRI detail = Variable.getIRI(NAMESPACE, "Detail");
		IRI link = Variable.getIRI(NAMESPACE, "Link");
		model.add(name, detail, vf.createLiteral(lc.getDetail()));
		model.add(name, link, vf.createLiteral(lc.getLink()));
		return name;
	}
}
