package algo.ds.String;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	private static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits.length() > 0) {
			helper(digits, "", list);
		}
		return list;
	}

	private static void helper(String ques, String ans, List<String> list) {
		if (ques.length() == 0) {
			list.add(ans);
			return;
		}
		char ch = ques.charAt(0);
		String rem = ques.substring(1);
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			helper(rem, ans + code.charAt(i), list);
		}
	}

	public static void main(String[] args) {
		List<String> result = letterCombinations("23");
		result.forEach(System.out::println);
	}

	private static String getCode(char ch) {
		switch (ch) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		default:
			return "";
		}
	}
}
