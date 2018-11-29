package file.list.contents;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ListData {
	private static ArrayList<String> listCity;
	private static ArrayList<String> listCountry;
	private static ArrayList<String> listFirstName;
	private static ArrayList<String> listLastName;
	private static ArrayList<String> listVerbForIRI;

	public static ArrayList<String> ListVerbForIRIs() {
		return listVerbForIRI;
	}

//	public static void setListVerbForIRI() throws FileNotFoundException {
//		getList.listVerbForIRI = getFileContent.getFiles(getPathFile.pathVerbForIRI);
//	}

	public static ArrayList<String> ListCitys() {
		return listCity;
	}

	public static void setListCity() throws FileNotFoundException {
		ListData.listCity = getFileContents.getListFiles(getPathFile.pathCity);
	}

	public static ArrayList<String> ListCountrys() {
		return listCountry;
	}

	public static void setListCountry() throws FileNotFoundException {
		ListData.listCountry = getFileContents.getListFiles(getPathFile.pathCountry);
	}

	public static ArrayList<String> ListFirstNames() {
		return listFirstName;
	}

	public static void setListFirstName() throws FileNotFoundException {
		ListData.listFirstName = getFileContents.getListFiles(getPathFile.pathFirstName);
	}

	public static ArrayList<String> ListLastNames() {
		return listLastName;
	}

	public static void setListLastName() throws FileNotFoundException {
		ListData.listLastName = getFileContents.getListFiles(getPathFile.pathLastName);
	}
	
	//Goi ham nay de add data to list.
	public static void addToList() throws FileNotFoundException {
		setListCity();
		setListCountry();
		setListFirstName();
		setListLastName();
		//setListVerbForIRI();
	}
}
