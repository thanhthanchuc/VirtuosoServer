  package Project.Virtuoso;

import java.io.FileNotFoundException;
import java.util.Random;

import org.eclipse.rdf4j.repository.Repository;

import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import rdservice.model.RandomPersonGenerator;
import virtuoso.rdf4j.driver.VirtuosoRepository;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Random rd;
		
			rd = new Random();
		
    	for(int i = 0; i<100; i++) {
    		System.out.println(rd.nextInt(5) + 1);
    	}
    }
}
