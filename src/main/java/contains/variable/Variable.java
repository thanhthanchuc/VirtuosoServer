package contains.variable;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class Variable {
	// The full namespace: "http://facebook.com/".
	public static final String NAMESPACE = "http://facebook.com/";

	// The prefix usually used for this vocabulary: 'fb'.
	public static final String PREFIX = "fb";

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
//	public static final IRI COME = getIRI("Come");

	/**
	 * Creates a new {@link IRI} with this vocabulary's namespace for the given
	 * local name.
	 *
	 * @param localName a local name of an IRI, e.g. 'creatorOf', 'name', 'Artist',
	 *                  etc.
	 * @return an IRI using the http://example.org/ namespace and the given local
	 *         name.
	 */
	public static IRI getIRI(String localName) {
		return SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName);
	}
	
	public static Literal getLiteral(String localName) {
		return SimpleValueFactory.getInstance().createLiteral(NAMESPACE, localName);
	}
}
