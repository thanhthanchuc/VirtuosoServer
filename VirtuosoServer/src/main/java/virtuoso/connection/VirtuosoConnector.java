package virtuoso.connection;

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
}
