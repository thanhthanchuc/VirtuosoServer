package contains.tripleStatement.Literal;

import java.io.FileNotFoundException;

import org.eclipse.rdf4j.model.Literal;

import contains.variable.Variable;
import model.Person;
import rdservice.model.RandomPersonGenerator;

public class PersonLiteral {
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
	
	public Literal NAME = Variable.getLiteral(p.Name());
	public Literal POSITION = Variable.getLiteral(p.Position());
	public Literal DETAIL = Variable.getLiteral(p.Detail());
}
