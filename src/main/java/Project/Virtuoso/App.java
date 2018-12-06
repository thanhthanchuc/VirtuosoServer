  package Project.Virtuoso;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.tripleStatement.IRI.RandomIRI;
import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import file.contents.ListData;
import rdservice.model.RandomPersonGenerator;
import virtuoso.rdf4j.driver.VirtuosoRepository;


/**
 * Hello world!
 *
 */
public class App 
{
	private static RandomIRI randomIRI;
	private static RepositoryConnection conn;
	private static ValueFactory vf;
    public static void main( String[] args )
    {
    	Repository myRep = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
    	
    	conn = myRep.getConnection();
    	
    	vf = conn.getValueFactory();
    	
    	//Nguoi dung nhap
    	statement(200, 100);
    }
    
    private static void statement(int m, int n) {
    	for(int i = 0; i< n; i++) {
    		IRI entity1 = randomIRI().randomIRI();
    		IRI entity2 = randomIRI().randomIRI();
    		IRI rela = Variable.VerIRI(m);
    		conn.add(vf.createStatement(entity1, rela, entity2));
    	}
    }
    
    private static RandomIRI randomIRI() {
    	randomIRI = new RandomIRI();
    	return randomIRI;
    }
}
