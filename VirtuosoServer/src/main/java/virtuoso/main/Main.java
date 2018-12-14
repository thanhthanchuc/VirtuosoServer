package virtuoso.main;

import virtuoso.connection.VirtuosoConnector;
/**
 * Hello world!
 *
 */
public class Main {
	private static VirtuosoConnector vc = new VirtuosoConnector();
	private static GenerateNEntityMRelationship generate = new GenerateNEntityMRelationship();
	
	public static void main(String[] args) {
//		Query q = new Query();
		long start_time = System.currentTimeMillis();
//		q.basicQuery1("2036");
		generate.generateNM(15000000, 17000000, vc.conn, vc.vf);
		long end_time = System.currentTimeMillis();
		System.out.println(end_time - start_time + "ms");
	}
}

