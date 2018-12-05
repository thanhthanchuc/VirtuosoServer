package Project.Virtuoso;

import contains.tripleStatement.IRI.CityLocationIRI;
import contains.tripleStatement.IRI.CountryIRI;
import contains.tripleStatement.IRI.EventIRI;
import contains.tripleStatement.IRI.OrganizationIRI;
import contains.tripleStatement.IRI.PersonIRI;
import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import virtuoso.connectivity.VirtuosoConnector;

public class RandomPushToDb {
	private VirtuosoConnector vc;
	private PersonIRI p;
	private EventIRI event;
	private CityLocationIRI city;
	private CountryIRI country;
	private OrganizationIRI organization;
	
	public RandomPushToDb() {
		vc = new VirtuosoConnector(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
		p = new PersonIRI();
		event = new EventIRI();
		city = new CityLocationIRI();
		country = new CountryIRI();
		organization = new OrganizationIRI();
	}
	
	public void  randomData(int num) {
		switch (num) {
		case 1:
			//Ong xxx to tham thanh pho yyy;
			vc.addRescourse(p.NAME, Variable.COME, city.NAME);
			break;
		case 2:
			//Person xxx tham gia event yyy
			vc.addRescourse(p.NAME, Variable.ATTEND, event.NAME);
			break;
		case 3:
			//event xxx duoc to chuc vao luc yyy
			vc.addRescourse(event.NAME, Variable.TIME, event.TIME);
			break;
		case 4:
			//event to chuc o city
			vc.addRescourse(event.NAME, Variable.WHERE, city.NAME);
			break;
		case 5:
			vc.addRescourse(p.NAME, Variable.DETAIL, p.DETAIL);
			break;
		case 6:
			vc.addRescourse(event.NAME, Variable.DETAIL, event.DETAIL);
			break;
		case 7:
			vc.addRescourse(country.NAME, Variable.DETAIL, country.DETAIL);
			break;
		case 8:
			vc.addRescourse(city.NAME, Variable.DETAIL, city.DETAIL);
			break;
		case 9: 
			vc.addRescourse(organization.NAME, Variable.DETAIL, organization.DETAIL);
			break;
		case 10:
			//Person co chuc vu ...
			vc.addRescourse(p.NAME, Variable.POSITION, p.POSITION);
			break;
		}
	}
}
