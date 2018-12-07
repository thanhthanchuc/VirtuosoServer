package blanknodetomodel;

import java.io.FileNotFoundException;

import javax.security.auth.Subject;

import org.eclipse.rdf4j.model.BNode;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import rdservice.model.RandomCityLocationGenerator;
import rdservice.model.RandomEventGenerator;
import rdservice.model.RandomPersonGenerator;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class BlankNoteToModel {
	public static void main(String[] arg) throws FileNotFoundException {
		Repository myRep = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
		
		try (RepositoryConnection conn = myRep.getConnection()) {
			RandomPersonGenerator rd = null;
			try {
				rd = new RandomPersonGenerator();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RandomCityLocationGenerator rdcity = new RandomCityLocationGenerator();
			RandomEventGenerator rdevent = new RandomEventGenerator();
			ValueFactory vf = SimpleValueFactory.getInstance();
			
			//link to event
			BNode event = vf.createBNode();
			//link to location
			BNode city = vf.createBNode();
			//Use ModelBuilder
			ModelBuilder builder = new ModelBuilder();
			
			
			//build model
			//Manger Deparment Nguyen Thanh tham du BK Open Day tai City Name vao luc Time gio;
			builder
				.setNamespace("ex", "http://example.org/")
				.subject("ex:Thanh Nguyen")
					.add(Variable.POSITION, "ex:Manager Deparment")
					.add(Variable.DETAIL, rd.generateRandomPerson().getDetail())
					//Link to blank node
					.add("ex:BK Open Day", event)
				.subject(event)
					.add(Variable.LOCATION, rdcity.generateRandomCityLication().Name())
					.add(Variable.TIME, rdevent.generateRandomEvent().Time());
			Model model = builder.build();
			conn.add(model);
			
			System.out.println(model);
		}
	}
}
