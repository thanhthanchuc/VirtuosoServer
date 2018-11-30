package Project.Virtuoso;

import contains.tripleStatement.IRI.PersonIRI;
import contains.variable.VirtuosoVariable;
import virtuoso.connectivity.VirtuosoConnector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	VirtuosoConnector vc = new VirtuosoConnector(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
    	PersonIRI p;
    	//Add 100 random record
    	for(int i = 0; i<100; i++) {
    		p = new PersonIRI();
    		vc.addRescourse(p.NAME, p.POSITION, p.DETAIL);
        	System.out.println(p.NAME + " " + p.POSITION + " " + p.DETAIL);
    	}
    }
}
