package virtuoso.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import rdservice.model.RandomCityLocationGenerator;
import rdservice.model.RandomCountryGenerator;
import rdservice.model.RandomEventGenerator;
import rdservice.model.RandomOrganizationGenerator;
import rdservice.model.RandomPersonGenerator;
import rdservice.model.RandomRelationshipGenerator;
import virtuoso.connection.VirtuosoConnector;

public class GenerateNEntityMRelationship {
	VirtuosoConnector vc = new VirtuosoConnector();
	private RandomPersonGenerator rdP;
	private RandomOrganizationGenerator rdO;
	private RandomCityLocationGenerator rdL;
	private RandomCountryGenerator rdC;
	private RandomEventGenerator rdE;
	private RandomRelationshipGenerator rdR;
	private static int countP, countO, countL, countE;

	public GenerateNEntityMRelationship() {
		try {
			rdP = new RandomPersonGenerator();
			countP = rdP.countPerson(vc.conn);
			rdO = new RandomOrganizationGenerator();
			countO = rdO.countOrganization(vc.conn);
			rdL = new RandomCityLocationGenerator();
			countL = rdL.countLocation(vc.conn);
			rdC = new RandomCountryGenerator();
			rdE = new RandomEventGenerator();
			countE = rdE.countEvent(vc.conn);
			rdR = new RandomRelationshipGenerator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private IRI ramdomEntity(RepositoryConnection conn, ValueFactory vf, Model model) {
		Random rd = new Random();
		IRI entity = null;
		int k = rd.nextInt(5) + 1;
		switch (k) {
		case 1:
			entity = rdP.createIriEntity(vf, model, ++countP);
			break;
		case 2:
			entity = rdO.createIriEntity(vf, model, ++countO);
			break;
		case 3:
			entity = rdL.createIriEntity(vf, model, ++countL);
			break;
		case 4:
			entity = rdC.createIriEntity(vf, model);
			break;
		case 5:
			entity = rdE.createIriEntity(vf, model, ++countE);
			break;
		}
		return entity;
	}

	/**
	 * Hàm này sẽ tạo ra hệ số chia nhỏ k nếu như n và m quá lớn
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	private int divide(int n, int m) {
		int k = 1;
		int c = 1;
		if (n <= 15000 && m <= 15000) {
			return 1;
		} else {
			if (n > m) {
				c = n % 10000 == 0 ? n / 10000 : n / 10000 + 1;
				for (int t = c; t >= 1; t--) {
					if (m % t == 0 && n % t == 0) {
						k = t;
						break;
					}
				}

			} else {
				c = m % 10000 == 0 ? m / 10000 : m / 10000 + 1;
				for (int t = c; t >= 1; t--) {
					if (m % t == 0 && n % t == 0) {
						k = t;
						break;
					}
				}
			}
		}
		return k;
	}

	/**
	 * @param n    = số thực thể
	 * @param m    = số quan hệ gán cho cặp thực thể bất kì
	 * @param conn
	 * @param vf
	 */
	public void generateNM(int n, int m, RepositoryConnection conn, ValueFactory vf) {
		int k = divide(n, m);
		Random rd = new Random();
		Model model = new TreeModel();
		ArrayList<IRI> listEntity = new ArrayList<>();
		IRI entity1 = null;
		IRI entity2 = null;
		IRI rel = null;
		int sn = n / k;
		int sm = m / k;
		for (int i = 0; i < k; i++) {
			for (int j = 1; j <= sn; j++) {
				/**
				 * add Entity vào model Đồng thời add định danh vào listEntity
				 */
				listEntity.add(ramdomEntity(conn, vf, model));
				if ((i * sn + j) % 1000 == 0) {
					System.out.println(i * sn + j);
				}
			}
			for (int t = 0; t < sm; t++) {
				int c1 = rd.nextInt(listEntity.size());
				entity1 = listEntity.get(c1);
				int c2 = 0;
				do {
					c2 = rd.nextInt(listEntity.size());
				} while (c2 == c1);
				entity2 = listEntity.get(c2);
				rel = rdR.generateRelationship();
				model.add(vf.createStatement(entity1, rel, entity2));
//				System.out.println(entity1 + "\n" + rel + "\n" + entity2 + "\n");
			}
			conn.add(model); // add model
			model.clear(); // reset model
			listEntity.clear(); // reset listEntity before create new listEntity
		}
		conn.close();
	}
}
