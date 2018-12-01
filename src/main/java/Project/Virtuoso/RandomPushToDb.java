package Project.Virtuoso;

import contains.tripleStatement.IRI.CityLocationIRI;
import contains.tripleStatement.IRI.EventIRI;
import contains.tripleStatement.IRI.PersonIRI;
import contains.variable.Variable;
import contains.variable.VirtuosoVariable;
import virtuoso.connectivity.VirtuosoConnector;

public class RandomPushToDb {
	private VirtuosoConnector vc;
	private PersonIRI p;
	private EventIRI event;
	private CityLocationIRI city;
	
	public RandomPushToDb() {
		vc = new VirtuosoConnector(VirtuosoVariable.HOST, VirtuosoVariable.USERNAME, VirtuosoVariable.PASSWORD);
		p = new PersonIRI();
		event = new EventIRI();
		city = new CityLocationIRI();
	}
	
	public void  randomData(int num) {
		switch (num) {
		case 1:
			//Ong xxx to tham thanh pho yyy;
			vc.addRescourse(p.NAME, Variable.COME, city.NAME);
			break;
		case 2:
			vc.addRescourse(p.NAME, Variable.ATTEND, event.NAME);
			break;
		default:
			vc.addRescourse(event.NAME, Variable.TIME, event.TIME);
			break;
		}
	}
}
