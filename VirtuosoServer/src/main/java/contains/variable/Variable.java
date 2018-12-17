package contains.variable;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class Variable {

	public static IRI getIRI(String namespace, String localName) {
		return SimpleValueFactory.getInstance().createIRI(namespace, localName);
	}

	public static Literal getLiteral(String namespace, String localName) {
		return SimpleValueFactory.getInstance().createLiteral(namespace, localName);
	}
}
