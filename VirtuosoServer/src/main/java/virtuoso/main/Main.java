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
//		long start_time = System.currentTimeMillis();
//		generate.generateNM(150000, 170000, vc.conn, vc.vf);
//		long end_time = System.currentTimeMillis();
//		System.out.println(end_time - start_time + "ms");

		/*
		 * Đây sẽ là phần BasicQuery
		 */
//		BasicQuery bq = new BasicQuery();
//		bq.basicQuery1("Person100");
//		bq.basicQuery2("Organization100");
//		bq.basicQuery3("Location100");
//		bq.basicQuery4("Viet Nam");
//		bq.basicQuery5("Event100");
//		bq.basicQuery6("Bach Khoa Open Day");
//		bq.basicQuery7("Bach Khoa Open Day");
//		bq.basicQuery8("Bach Khoa Open Day");
//		bq.basicQuery9("Bach Khoa Open Day");
//		bq.basicQuery10("Honda");

		/*
		 * Đây sẽ là phần AdvancedQuery
		 * 
		 */
		AdvancedQuery aq = new AdvancedQuery();
		aq.AdvancedQuery1("Chưa biết làm gì cả !");

	}
}
