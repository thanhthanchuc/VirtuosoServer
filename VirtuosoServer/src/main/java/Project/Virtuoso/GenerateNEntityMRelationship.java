package Project.Virtuoso;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.jline.reader.impl.DefaultParser.ArgumentList;

import rdservice.model.RandomCityLocationGenerator;
import rdservice.model.RandomCountryGenerator;
import rdservice.model.RandomEventGenerator;
import rdservice.model.RandomOrganizationGenerator;
import rdservice.model.RandomPersonGenerator;
import rdservice.model.RandomRelationshipGenerator;
import virtuoso.connectivity.VirtuosoConnector;

public class GenerateNEntityMRelationship {
	private RandomPersonGenerator rdP;
	private RandomOrganizationGenerator rdO;
	private RandomCityLocationGenerator rdL;
	private RandomCountryGenerator rdC;
	private RandomEventGenerator rdE;
	private RandomRelationshipGenerator rdR;

	public GenerateNEntityMRelationship() {
		try {
			rdP = new RandomPersonGenerator();
			rdO = new RandomOrganizationGenerator();
			rdL = new RandomCityLocationGenerator();
			rdC = new RandomCountryGenerator();
			rdE = new RandomEventGenerator();
			rdR = new RandomRelationshipGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private IRI ramdomEntity(RepositoryConnection conn, ValueFactory vf) {
		Random rd = new Random();
		IRI entity = null;
		int k = rd.nextInt(5) + 1;
		switch (k) {
		case 1:
			int countP = rdP.countPerson(conn);
			entity = rdP.createIriAndPush(conn, vf, countP);
			break;
		case 2:
			entity = rdO.createIriAndPush(conn, vf);
			break;
		case 3:
			entity = rdL.createIriAndPush(conn, vf);
			break;
		case 4:
			entity = rdC.createIriAndPush(conn, vf);
			break;
		case 5:
			entity = rdE.createIriAndPush(conn, vf);
			break;
		}
		return entity;
	}

	/**
	 * 
	 * @param n    = số thực thể
	 * @param      m: số quan hệ gán cho cặp thực thể bất kì
	 * @param      k: chỉ số chia nhỏ. Khi n lớn ArrayList có thể bị quá tải nên cần
	 *             chia nhỏ. Ở đây sẽ lấy k là ước của n và m. 1 số phù hợp ko to cũng ko nhỏ quá
	 * @param conn
	 * @param vf
	 */
	public void generateNM(int n, int m, int k, RepositoryConnection conn, ValueFactory vf) {
		Random rd = new Random();
		IRI entity1 = null;
		IRI entity2 = null;
		IRI rel = null;
		ArrayList<IRI> listEntity = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				listEntity.add(ramdomEntity(conn, vf));
			}
			for (int t = 0; t < m / k; t++) {
				int c1 = rd.nextInt(listEntity.size());
				entity1 = listEntity.get(c1);
				int c2 = 0;
				do {
					c2 = rd.nextInt(listEntity.size());
					/**
					 * Hãy làm điều gì hay ho ở đây để quan hệ có nghĩa hơn
					 */
				} while (c2 == c1);
				entity2 = listEntity.get(c2);
				rel = rdR.generateRelationship();
				conn.add(vf.createStatement(entity1, rel, entity2));
				System.out.println(entity1 + "\n" + rel + "\n" + entity2 + "\n");
			}
		}
		listEntity.clear(); // reset list and create new list
	}
}
