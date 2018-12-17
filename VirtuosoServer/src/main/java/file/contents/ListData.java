package file.contents;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import model.Country;

public class ListData {
	private static ArrayList<String> listFirstName;
	private static ArrayList<String> listLastName;
	private static ArrayList<String> position;
	private static ArrayList<String> listDetailPerson;

	private static ArrayList<String> listOrganization;
	private static ArrayList<String> listOrganizationDetail;

	private static ArrayList<String> listCity;
	private static ArrayList<String> listLocationDetail;

	private static ArrayList<String> listEvent;
	private static ArrayList<String> listEventDetail;

	private static ArrayList<String> listTime;

	private static ArrayList<String> listRelatioship;

	private static ArrayList<String> listLink;
	
	/*----------------------------Person----------------------------*/
	public static ArrayList<String> ListFirstNames() throws FileNotFoundException {
		ListData.listFirstName = getFileContents.getListFiles(getPathFile.pathFirstName);
		return listFirstName;
	}
	public static ArrayList<String> ListLastNames() throws FileNotFoundException {
		ListData.listLastName = getFileContents.getListFiles(getPathFile.pathLastName);
		return listLastName;
	}
	public static ArrayList<String> ListPositions() throws FileNotFoundException {
		ListData.position = getFileContents.getListFiles(getPathFile.pathPosition);
		return position;
	}
	public static ArrayList<String> listDetailPerson() {
		listDetailPerson = getFileContents.getListFiles(getPathFile.pathDetailPerson);
		return listDetailPerson;
	}
	/*---------------------------Organization ---------------------*/
	public static ArrayList<String> listOrganization() {
		listOrganization = getFileContents.getListFiles(getPathFile.pathOrganization);
		return listOrganization;
	}
	
	public static ArrayList<String> listOrganizationDetail() {
		listOrganizationDetail = getFileContents.getListFiles(getPathFile.pathOrganizationDetail);
		return listOrganizationDetail;
	}
	/*-----------------------------Location------------------------*/
	public static ArrayList<String> ListCitys() throws FileNotFoundException {
		listCity = getFileContents.getListFiles(getPathFile.pathCity);
		return listCity;
	}

	public static ArrayList<String> listLocationDetail() throws FileNotFoundException {
		listLocationDetail = getFileContents.getListFiles(getPathFile.pathLocationDetail);
		return listLocationDetail;
	}
	/*----------------------------Country----------------------------*/

	/**
	 * Vì số lượng có hạn và mỗi country lại gắn luôn với 1 detail nên ta sẽ ghép Country với detail luôn
	 * @return
	 */
	public static ArrayList<Country> country() {
		String[] arr = { "Ashia", "Athea", "Covania", "Emain", "Ogria", "Omen", "Osium", "Oxtrad", "Toria", "Udro",
				"USA", "Viet Nam" };
		ArrayList<String> listDetail = new ArrayList<>();
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathAshiaDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathAtheaDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathCovaniaDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathEmainDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathOgriaDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathOmenDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathOsiumDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathOxtradDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathToriaDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathUderDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathUsaDetail));
		listDetail.add(getFileContents.getCountryDetail(getPathFile.pathVietnamDetail));
		ArrayList<Country> list = new ArrayList<>();
		for (int i = 0; i < listDetail.size(); i++) {
			list.add(new Country(arr[i], listDetail.get(i), link(),time()));
		}
		return list;
	}
	/*----------------------------Event----------------------------------*/
	public static ArrayList<String> listEvent() {
		listEvent = getFileContents.getListFiles(getPathFile.pathEvent);
		return listEvent;
	}
	
	public static ArrayList<String> listEventDetail() {
		listEventDetail = getFileContents.getListFiles(getPathFile.pathEventDetail);
		return listEventDetail;
	}
	/*----------------------------Time------------------------------------*/
	public static ArrayList<String> listTime() {
		listTime = getFileContents.getListFiles(getPathFile.pathTime);
		return listTime;
	}
	/**
	 * Time này là thực thể nội trú tại event
	 * @return
	 */
	private static String time() {
		Random rd = new Random();
		int n = rd.nextInt(listTime().size());
		return listTime().get(n);
	}
	/*----------------------------Link------------------------------------*/
	public static ArrayList<String> listLink() {
		listLink = getFileContents.getListFiles(getPathFile.pathLink);
		return listLink;
	}
	/**
	 * Link này là link trích rút cho event
	 * @return
	 */
	private static String link() {
		Random rd = new Random();
		int n = rd.nextInt(listLink().size());
		return listLink().get(n);
	}
	/*----------------------------Relationship----------------------------*/
	public static ArrayList<String> listRelatioship() {
		listRelatioship = getFileContents.getListFiles(getPathFile.pathRelationship);
		return listRelatioship;
	}
}
