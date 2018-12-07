package contains.tripleStatement.IRI;

import java.io.FileNotFoundException;
import java.util.Random;

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
	public IRI LINK;
	private Random rd;

	public PersonIRI() {
		try {
			rp = new RandomPersonGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p = rp.generateRandomPerson();
		NAME = Variable.getIRI(NAMESPACE + "Name/", p.Name());
		POSITION = Variable.getIRI(NAMESPACE + "Position/", p.Position());
		DETAIL = Variable.getIRI(NAMESPACE + "Detail/", p.Detail());
		LINK = Variable.getIRI(NAMESPACE + "Link/", p.Link());
	}

	public IRI getPersonIRI() {
		rd = new Random();
		int next = rd.nextInt(3) + 1;
		return next == 1 ? NAME : next == 2 ? POSITION : DETAIL;
	}
}
