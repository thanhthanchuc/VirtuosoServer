package virtuoso.connectivity;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoConnector {
	private static ValueFactory vf;
	private Repository myRepository;
	private RepositoryConnection conn;

	public VirtuosoConnector(String host, String username, String password) {
		myRepository = new VirtuosoRepository(host, username, password);
		conn = myRepository.getConnection();
		vf = SimpleValueFactory.getInstance();
	}

	public Boolean addRescourse(IRI subject, IRI predicate, IRI object) {
		try {
			conn.add(vf.createStatement(subject, predicate, object));
			return true;
		} catch (Throwable th) {
			return false;
		}
	}

	public boolean addLiteral(IRI subject, IRI predicate, Literal object) {
		try {
			conn.add(vf.createStatement(subject, predicate, object));
			return true;
		} catch (Throwable th) {
			return false;
		}
	}
}
