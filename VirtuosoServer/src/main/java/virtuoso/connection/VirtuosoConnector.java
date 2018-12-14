package virtuoso.connection;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import contains.variable.VirtuosoVariable;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoConnector {
	public  RepositoryConnection conn;
	public  ValueFactory vf ;
	public VirtuosoConnector() {
		Repository myRep = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
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
