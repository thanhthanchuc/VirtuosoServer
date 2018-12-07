package contains.tripleStatement.Literal;

import java.io.FileNotFoundException;

import org.eclipse.rdf4j.model.Literal;

import contains.variable.Variable;
import model.Person;
import rdservice.model.RandomPersonGenerator;

public class PersonLiteral {
	private final String NAMESPACE = "http://example.com/Person/";
	private RandomPersonGenerator rp;
	private Person p;
	
	public PersonLiteral() {
		try {
			rp = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p = rp.generateRandomPerson();
	}
	public Literal DETAIL = Variable.getLiteral(NAMESPACE, p.getDetail());
}
