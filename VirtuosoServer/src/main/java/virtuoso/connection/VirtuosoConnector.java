package virtuoso.connection;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoConnector {
	private static final String HOST = "jdbc:virtuoso://localhost:1111/";
	private static final String USERNAME = "dba";
	private static final String PASSWORD = "dba";
	public RepositoryConnection conn;
	public ValueFactory vf;

	public VirtuosoConnector() {
		Repository myRep = new VirtuosoRepository(HOST, USERNAME, PASSWORD);
		conn = myRep.getConnection();
		vf = conn.getValueFactory();
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
