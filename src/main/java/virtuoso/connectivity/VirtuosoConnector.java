package virtuoso.connectivity;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.variable.VirtuosoVariable;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoConnector {
	private static ValueFactory vf;
	private RepositoryConnection conn;
	
	public VirtuosoConnector(Repository rep) {
		conn = rep.getConnection();
		vf = SimpleValueFactory.getInstance();
	}
	
	public void Close() {
		conn.close();
	}
	public Boolean addRescourse(IRI subject, IRI predicate, IRI object) {
		try {
			conn.add(vf.createStatement(subject, predicate, object));
			return true;
		} catch (Throwable th) {
			return false;
		}
	}
	
	public boolean addRescourse(IRI subject, IRI predicate, Literal object) {
		try {
			conn.add(vf.createStatement(subject, predicate, object));
			return true;
		} catch (Throwable th) {
			return false;
		}
	}
}
