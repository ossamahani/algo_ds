package algo.ds.String;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	
	private static List<String> getPerm(String s) {
		List<String> result = new ArrayList<>();
		helper("",s, result);
		return result;
	}
	
	
	
	private static void helper(String perfix, String suffix, List<String> result) {
		if(suffix.length() == 0) {
			result.add(perfix);
			return;
		}
		
		for(int i=0; i<suffix.length(); i++) {
			helper(perfix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, suffix.length()), result);
		}
		
	}



	public static void main(String[] args) {
		List<String> perms = getPerm("abc");
		perms.forEach(System.out::println);
	}

}
