package file.contents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class getFileContents {
	/**
	 * 
	 * @param fileName: Đường dẫn tương đối đến file
	 * @return: ArrayList chứa dữ liệu 
	 */
	public static ArrayList<String> getListFiles(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		File file = new File(fileName);
		try (Scanner inputStream = new Scanner(file)) {
			while (inputStream.hasNext()) {
				String data = inputStream.nextLine();
				//Truong hop data co dang chua ki tu ". VD: "HaNoi"
				if(data.length() != 2 && data.endsWith("\"")) {
					data = data.substring(1, data.length() - 1);
					list.add(data);
					continue;
				}
				if(data.length() != 0) {
					list.add(data);
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size() == 1) {
			String s = list.get(0);
			return new ArrayList<String>(Arrays.asList(s.split(",")));
		}
		return list;
	}
	/**
	 * 
	 * @param fileName: Đường dẫn tương đối đến file mô tả chi tiết Country
	 * @return: Mô tả chi tiết Country
	 */
	public static String getCountryDetail(String fileName) {
		String data = "";
		File file = new File(fileName);
		try(Scanner inputStream = new Scanner(file)) {
			while (inputStream.hasNext()) {
				data += inputStream.nextLine();
				//Truong hop data co dang chua ki tu ". VD: "HaNoi"
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
