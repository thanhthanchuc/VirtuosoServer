package virtuoso.main;

import virtuoso.connection.VirtuosoConnector;

/**
 * Hello world!
 *
 */
public class Main {
	private static VirtuosoConnector vc = new VirtuosoConnector();

	public static void main(String[] args) {
		/*
		 * Phần này sinh dữ liệu giả lập. Hãy sinh trk khi query nếu muốn nó có nghĩa
		 */
//		GenerateNEntityMRelationship generate = new GenerateNEntityMRelationship();
//		long start_time = System.currentTimeMillis();
//		generate.generateNM(100000, 1000000, vc.conn, vc.vf);
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
//		aq.AdvancedQuery1();
//		aq.AdvancedQuery2();
//		aq.AdvancedQuery3();
//		aq.AdvancedQuery4();
//		aq.AdvancedQuery5();
//		aq.AdvancedQuery6();
//		aq.AdvancedQuery7("Bach Khoa Open Day");
//		aq.AdvancedQuery8();
//		aq.AdvancedQuery9();
		aq.AdvancedQuery10();// Hãy làm điều gì đó thú vị ở đây
	}
}
