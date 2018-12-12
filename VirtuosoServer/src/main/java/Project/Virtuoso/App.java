package Project.Virtuoso;

import virtuoso.connectivity.VirtuosoConnector;
/**
 * Hello world!
 *
 */
public class App {
	private static VirtuosoConnector vc = new VirtuosoConnector();
	private static int n[] = { 100, 1000, 10000, 100000, 1000000 };
	private static int m[] = { 10, 50, 100, 500, 1000 };
	private static GenerateNEntityMRelationship g = new GenerateNEntityMRelationship();
	public static void main(String[] args) {
		long start_time = System.currentTimeMillis();
//		Query q = new Query();
//		q.basicQuery1("2036");
		g.generateNM(n[0], m[1], 1, vc.conn, vc.vf);
		long end_time = System.currentTimeMillis();
		System.out.println(end_time - start_time + "ms");
	}
}
