package Project.Virtuoso;

import java.util.Random;

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
    	RandomPushToDb add;
    	Random rd;
    	
    	//Add 10000 random record
    	for(int i = 0; i<10000; i++) {
    		add = new RandomPushToDb();
    		rd = new Random();
    		int num = rd.nextInt(3);
    		add.randomData(num);
    		if(i%1000 == 0)
    			System.out.println(i);
    	}
    }
}
