package Project.Virtuoso;

import org.apache.solr.client.solrj.request.CollectionAdminRequest.Create;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import contains.tripleStatement.IRI.CityLocationIRI;
import contains.tripleStatement.IRI.CountryIRI;
import contains.tripleStatement.IRI.EventIRI;
import contains.tripleStatement.IRI.OrganizationIRI;
import contains.tripleStatement.IRI.PersonIRI;
import contains.tripleStatement.IRI.RandomIRI;
import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class RandomPushToDb {
	private static Repository rep;
	private PersonIRI p;
	private EventIRI event;
	private CityLocationIRI city;
	private CountryIRI country;
	private OrganizationIRI organization;
	private RandomIRI random;

	public RandomPushToDb() {
		random = new RandomIRI();
		p = new PersonIRI();
		event = new EventIRI();
		city = new CityLocationIRI();
		country = new CountryIRI();
		organization = new OrganizationIRI();
	}

	public static Repository getRep() {
		return rep;
	}

	public static void setRep() {
		RandomPushToDb.rep = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME,
				VirtuosoVariable.PASSWORD);
	}

//	public void  randomData(int num, RepositoryConnection vc, ValueFactory vf) {
//		switch (num) {
//		case 1:
//			//Ong xxx to tham thanh pho yyy;
//			vc.add(vf.createStatement((p.NAME, Variable.COME, city.NAME)));
//			break;
//		case 2:
//			//Person xxx tham gia event yyy
//			vc.addRescourse(p.NAME, Variable.ATTEND, event.NAME);
//			break;
//		case 3:
//			//event xxx duoc to chuc vao luc yyy
//			vc.addRescourse(event.NAME, Variable.TIME, event.TIME);
//			break;
//		case 4:
//			//event to chuc o city
//			vc.addRescourse(event.NAME, Variable.WHERE, city.NAME);
//			break;
//		case 5:
//			vc.addRescourse(p.NAME, Variable.DETAIL, p.DETAIL);
//			break;
//		case 6:
//			vc.addRescourse(event.NAME, Variable.DETAIL, event.DETAIL);
//			break;
//		case 7:
//			vc.addRescourse(country.NAME, Variable.DETAIL, country.DETAIL);
//			break;
//		case 8:
//			vc.addRescourse(city.NAME, Variable.DETAIL, city.DETAIL);
//			break;
//		case 9: 
//			vc.addRescourse(organization.NAME, Variable.DETAIL, organization.DETAIL);
//			break;
//		default:
//			//Person co chuc vu ...
//			vc.addRescourse(p.NAME, Variable.POSITION, p.POSITION);
//			break;
//		}

	public static void main(String[] args) {
			RandomPushToDb rdp = null;
			int num = 0;
			Repository myRepository = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
			
			try(RepositoryConnection conn = myRepository.getConnection()) {
				ValueFactory vf = SimpleValueFactory.getInstance();
				java.util.Random rd = null;
				for(int i = 0; i<1000000; i++) {
					rdp = new RandomPushToDb();
					rd = new java.util.Random();
					num = rd.nextInt(11) + 1;
					switch (num) {
					case 1:
						//Ong xxx to tham thanh pho yyy;
						conn.add(vf.createStatement(rdp.p.NAME, Variable.COME, rdp.city.NAME));
						break;
					case 2:
						//Person xxx tham gia event yyy
						conn.add(vf.createStatement(rdp.p.NAME, Variable.ATTEND, rdp.event.NAME));
						break;
					case 3:
						//event xxx duoc to chuc vao luc yyy
						conn.add(vf.createStatement(rdp.event.NAME, Variable.TIME, rdp.event.TIME));
						break;
					case 4:
						//event to chuc o city
						conn.add(vf.createStatement(rdp.event.NAME, Variable.WHERE, rdp.city.NAME));
						break;
					case 5:
						conn.add(vf.createStatement(rdp.p.NAME, Variable.DETAIL, rdp.p.DETAIL));
						break;
					case 6:
						conn.add(vf.createStatement(rdp.event.NAME, Variable.DETAIL, rdp.event.DETAIL));
						break;
					case 7:
						conn.add(vf.createStatement(rdp.country.NAME, Variable.DETAIL, rdp.country.DETAIL));
						break;
					case 8:
						conn.add(vf.createStatement(rdp.city.NAME, Variable.DETAIL, rdp.city.DETAIL));
						break;
					case 9: 
						conn.add(vf.createStatement(rdp.organization.NAME, Variable.DETAIL, rdp.organization.DETAIL));
						break;
					case 10:
						//Person co chuc vu ...
						conn.add(vf.createStatement(rdp.p.NAME, Variable.POSITION, rdp.p.POSITION));
						break;
						//Random everything
					case 11:
						conn.add((vf.createStatement(rdp.random.randomIRI(), Variable.VerIRI(), rdp.random.randomIRI())));
						break;
					case 12:
						conn.add(vf.createStatement(rdp.p.NAME, Variable.COME, rdp.event.TIME));
						break;
					case 13:
						conn.add(vf.createStatement(rdp.country.NAME, Variable.COME, rdp.event.TIME));
					}
					if(i%10000 ==0 )
						System.out.println(i + " lan");
			}
		}
//		RandomPushToDb rdp = null;
//		int num = 0;
//		Repository myRepository = new VirtuosoRepository(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME,
//				VirtuosoVariable.PASSWORD);
//
//		try (RepositoryConnection conn = myRepository.getConnection()) {
//			ValueFactory vf = SimpleValueFactory.getInstance();
//			java.util.Random rd = null;
//			for (int i = 0; i < 100; i++) {
//				rdp = new RandomPushToDb();
//				rd = new java.util.Random();
//				num = rd.nextInt(3) + 1;
//				switch (num) {
//				case 1:
//					// Ong xxx to tham thanh pho yyy;
//					System.out.println((vf.createStatement(rdp.p.NAME, Variable.COME, rdp.city.NAME)));
//					break;
//				case 2:
//					// Person xxx tham gia event yyy
//					System.out.println((vf.createStatement(rdp.p.NAME, Variable.ATTEND, rdp.event.NAME)));
//					break;
//					default:
//						System.out.println();
//						break;
//				}
//			}
//		}
	}
}
