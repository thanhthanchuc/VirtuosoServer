package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import contains.variable.Variable;
import file.contents.ListData;

public class RandomRelationshipGenerator {

	private static final String NAMESPACE = "http://example.org/Relationship/";
	private static ArrayList<String> listRelationship;

	public RandomRelationshipGenerator() {
		try {
			listRelationship = ListData.listRelatioship();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public IRI generateRelationship() {
		String relationship = GetRandom.getRandomFromList(listRelationship);
		IRI rel = Variable.getIRI(NAMESPACE, relationship);
		return rel;
	}
}
