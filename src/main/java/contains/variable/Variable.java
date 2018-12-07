package contains.variable;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

import file.contents.ListData;
import rdservice.model.GetRandom;

public class Variable extends GetRandom {
	private static Random rd;
	// The full namespace: "http://example.org/".
	public static final String NAMESPACE = "http://example.org/Relationship/";

	// The prefix usually used for this vocabulary: 'ex'.
	public static final String PREFIX = "ex";
	
	//Toi
	public static final IRI COME = getIRI("Come");
	
	//Tham du
	public static final IRI ATTEND = getIRI("Attend");
	
	//To chuc boi
	public static final IRI HOSTED = getIRI("Hosted by");
	
	//To chuc vao luc
	public static final IRI TIME = getIRI("Time");
	
	//Dia diem
	public static final IRI WHERE = getIRI("Where");
	
	//detail
	public static final IRI DETAIL = getIRI("Detail");
	
	//Position: Chuc vu
	public static final IRI POSITION = getIRI("Position");
	
	public static final IRI LOCATION = getIRI("Location");
	
	//Random IRI
	public static IRI VerIRI() {
		return getIRI(getRandomFromList(ListData.ListVerbForIRIs()));
	}
	
	public static IRI VerIRI(int m) {
		ArrayList<String> listVerb = ListData.ListVerbForIRIs();
    	ArrayList<String> arr = new ArrayList<>();
    	
    	int size = listVerb.size();
    	for(int i = 0; i< m; i++) {
    		rd = new Random();
    		int rand = rd.nextInt(size);
    		
    		arr.add(listVerb.get(rand));
    	}
    	int m_rand = rd.nextInt(arr.size());
    	return getIRI(arr.get(m_rand));
	}
	/**
	 * Creates a new {@link IRI} with this vocabulary's namespace for the given
	 * local name.
	 *
	 * @param localName a local name of an IRI, e.g. 'creatorOf', 'name', 'Artist',
	 *                  etc.
	 * @return an IRI using the http://example.org/ namespace and the given local
	 *         name.
	 */
	private static IRI getIRI(String localName) {
		return SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName);
	}
	
	public static IRI getIRI(String namespace, String localName) {
		return SimpleValueFactory.getInstance().createIRI(namespace, localName);
	}
	
	public static Literal getLiteral(String namespace, String localName) {
		return SimpleValueFactory.getInstance().createLiteral(namespace, localName);
	}
}
