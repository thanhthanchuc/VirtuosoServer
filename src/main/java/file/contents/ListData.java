package file.contents;

import java.awt.Event;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.Country;

public class ListData {
	private static ArrayList<String> listCity;
	private static ArrayList<String> listCountry;
	private static ArrayList<String> listFirstName;
	private static ArrayList<String> listLastName;
	private static ArrayList<String> position;
	private static ArrayList<String> listVerbForIRI;
	private static ArrayList<String> listDetailPerson;

	public static ArrayList<String> ListVerbForIRIs() {
		return listVerbForIRI;
	}

//	public static void setListVerbForIRI() throws FileNotFoundException {
//		getList.listVerbForIRI = getFileContent.getFiles(getPathFile.pathVerbForIRI);
//	}

	//Khong can thiet set method. Khi goi out ham nay, data se tu dong duoc tao tu file txt.
	//Hoac co the tao construcor de thay the cach nay
	public static ArrayList<String> ListCitys() throws FileNotFoundException {
		listCity = getFileContents.getListFiles(getPathFile.pathCity);
		return listCity;
	}
	
	public static ArrayList<String> listDetailPerson() {
		listDetailPerson = getFileContents.getListFiles(getPathFile.pathDetailPerson);
		return listDetailPerson;
	}

	public static ArrayList<String> ListPositions() throws FileNotFoundException {
		ListData.position = getFileContents.getListFiles(getPathFile.pathPosition);
		return position;
	}
	
	public static ArrayList<String> ListCountrys() throws FileNotFoundException {
		ListData.listCountry = getFileContents.getListFiles(getPathFile.pathCountry);
		return listCountry;
	}

	public static ArrayList<String> ListFirstNames() throws FileNotFoundException {
		ListData.listFirstName = getFileContents.getListFiles(getPathFile.pathFirstName);
		return listFirstName;
	}

	public static ArrayList<String> ListLastNames() throws FileNotFoundException {
		ListData.listLastName = getFileContents.getListFiles(getPathFile.pathLastName);
		return listLastName;
	}
	
	//Vi so luong country co han va lai it detail nen ta se tao luon list country o day va se khong random country nua.
	public static ArrayList<Country> country() {
		String[] arr = {"Ashia", "Athea", "Covania", "Emain", "Ogria", "Omen", "Osium", "Oxtrad", "Toria", "Udro", "USA", "Viet Nam"};
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
		for(int i = 0; i<listDetail.size(); i++) {
			list.add(new Country(arr[i], listDetail.get(i)));
		}
		return list;
	}
	
	public static ArrayList<String> listEvent() {
		return getFileContents.getListFiles(getPathFile.pathEvent);
	}
	
	public static ArrayList<String> listTime() {
		return getFileContents.getListFiles(getPathFile.pathTime);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		for (Country country : country()) {
			System.out.println(country.Name() + " " +country.Detail());
		}
	}
}
