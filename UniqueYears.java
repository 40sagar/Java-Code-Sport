/*  This program will find unique years mentioned in String */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UniqueYears{
  public static int getCountOfUniqueYears(String input) {
		String pattern = "\\d\\d-\\d\\d-\\d\\d\\d\\d";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(input);
		Set<Integer> uniqueYears = new HashSet<>();
		while (m.find()) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate ld = LocalDate.parse(m.group().toString(), format);
			uniqueYears.add(ld.getYear());
		}
		return uniqueYears.size();
	}

	public static void main(String[] args) {
		String line = "UN Resolution passed on 19-08-1945 and Indian independence on 15-08-1947 16-09-1947";
		System.out.println(getCountOfUniqueYears(line) + " unique Years found");
	}
}
