package rdservice.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import contains.variable.Variable;
import file.contents.ListData;


public class RandomRelationshipGenerator {
	private ArrayList<String> relationship;
	private static final String NAMESPACE = "http://example.org/Relationship/";

	public RandomRelationshipGenerator() throws FileNotFoundException {
		relationship = ListData.ListVerbForIRIs();
	}
	
	public IRI generateRelationship() {
		RandomRelationshipGenerator rdr = null;
		try {
			rdr = new RandomRelationshipGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String relationship = GetRandom.getRandomFromList(rdr.relationship);
		IRI rel = Variable.getIRI(NAMESPACE,relationship);
		return rel;
	}
}
