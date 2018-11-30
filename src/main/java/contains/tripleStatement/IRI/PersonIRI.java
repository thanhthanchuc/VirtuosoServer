package contains.tripleStatement.IRI;

import java.io.FileNotFoundException;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.Person;
import rdservice.model.RandomPersonGenerator;

public class PersonIRI {
	private RandomPersonGenerator rp;
	private Person p;
	
	public PersonIRI() {
		try {
			rp = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p = rp.generateRandomPerson();
	}
	
	public IRI NAME = Variable.getIRI(p.Name());
	public IRI POSITION = Variable.getIRI(p.Position());
	public IRI DETAIL = Variable.getIRI(p.Detail());
}
