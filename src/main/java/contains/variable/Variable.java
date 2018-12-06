package contains.variable;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

import file.contents.ListData;
import rdservice.model.GetRandom;

public class Variable extends GetRandom {
	// The full namespace: "http://example.org/".
	public static final String NAMESPACE = "http://example.org/";

	// The prefix usually used for this vocabulary: 'ex'.
	public static final String PREFIX = "ex";

//	/**
//	 * The <code>ex:creatorOf</code> property.
//	 */
//	public static final IRI CREATOR_OF = getIRI("creatorOf");
//
//	/**
//	 * The <code>ex:Artist</code> class.
//	 */
//	public static final IRI ARTIST = getIRI("Artist");
//
//	public static final IRI WATCH = getIRI("Watch");
//
	//Toi
	public static final IRI COME = getIRI("Come");
	
	//Tham du
	public static final IRI ATTEND = getIRI("Attend");
	
	//To chuc boi
	public static final IRI HOSTED = getIRI("Hosted by");
	
	//To chuc vao luc
	public static final IRI TIME = getIRI("At");
	
	//Dia diem
	public static final IRI WHERE = getIRI("Where");
	
	//detail
	public static final IRI DETAIL = getIRI("Detail");
	
	//Position: Chuc vu
	public static final IRI POSITION = getIRI("Position");
	
	//Random IRI
	public static IRI VerIRI() {
		return getIRI(getRandomFromList(ListData.ListVerbForIRIs()));
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
