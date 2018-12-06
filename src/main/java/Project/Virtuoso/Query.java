package Project.Virtuoso;

import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.repository.Repository;

import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class Query {
	public static void main(String[] args) {
		Repository myRepository = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME , VirtuosoVariable.PASSWORD);
		String queryString = "PREFIX ex: <http://example.org/> \n";
	    queryString += "SELECT ?s ?n \n";
	    queryString += "WHERE { \n";
	    queryString += "    ?s a ex:Manager Deparment; \n";
	    queryString += "       ex:Detail ?n . \n";
	    queryString += "}";
			// ?s a ex:Artist; foar:firstName ?n.
	}
}
