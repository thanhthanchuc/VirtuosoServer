package virtuoso.main;

public class FormatValue {
	protected static String formatString(String str) {
		if (str.substring(0, 1).equals("\"")) {
			return str.substring(1, str.lastIndexOf("\""));
		} else {
			return str.substring(str.lastIndexOf("/") + 1, str.length());
		}
	}
}
