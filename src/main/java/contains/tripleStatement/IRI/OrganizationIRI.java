package contains.tripleStatement.IRI;

import org.eclipse.rdf4j.model.IRI;

import contains.variable.Variable;
import model.Organization;
import rdservice.model.RandomOrganizationGenerator;

public class OrganizationIRI {
	private final String NAMESPACE = "http://example.org/Organization/";
	private RandomOrganizationGenerator rd;
	private Organization organization;
	public IRI NAME;
	public IRI DETAIL;
	
	private IRI IRI(String context) {
		return Variable.getIRI(NAMESPACE, context);
	}
	
	public OrganizationIRI() {
		rd = new RandomOrganizationGenerator();
		organization = rd.generateOrganization();
		NAME = IRI(organization.Name());
		DETAIL = IRI(organization.Detail());
	}
}
