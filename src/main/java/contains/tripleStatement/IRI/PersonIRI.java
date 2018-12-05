package contains.tripleStatement.IRI;

import java.io.FileNotFoundException;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.Person;
import rdservice.model.RandomPersonGenerator;

public class PersonIRI {
	private final String NAMESPACE = "http://example.org/Person/";
	private RandomPersonGenerator rp;
	private Person p;
	public IRI NAME;
	public IRI POSITION;
	public IRI DETAIL;
	
	public PersonIRI() {
		try {
			rp = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p = rp.generateRandomPerson();
		NAME = Variable.getIRI(NAMESPACE, p.Name());
		POSITION = Variable.getIRI(NAMESPACE, p.Position());
		DETAIL = Variable.getIRI(NAMESPACE, p.Detail());
	}
}
