package file.contents;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ListData {
	private static ArrayList<String> listCity;
	private static ArrayList<String> listCountry;
	private static ArrayList<String> listFirstName;
	private static ArrayList<String> listLastName;
	private static ArrayList<String> position;
	private static ArrayList<String> listVerbForIRI;

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
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(ListPositions());
	}
}
