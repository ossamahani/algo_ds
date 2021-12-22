package algo.ds.Interview;

import java.util.HashMap;
import java.util.Map;

/*


from Waman Isloor to everyone:    12:34 PM
1. Problem Description
Given the input string arrays, print out to the console the sentence, in the order given by the index value of each word.
 
2. Input
Each array element is of the format "<index>:<word>".
String part1[] = { " 9: dog ", " 2 :quick ", "4: fox", " 7: the ", "5: jumps" }; 
String part2[] = { "3 :brown", " 1 : the", " 6:over", "8 :lazy", "10: this", " 11 : morning" };


3. Output
the quick brown fox jumps over the lazy dog this morning. 



*/

public class Test {

    public static void main(String[] args) {


        String part1[] = { " 9: dog ", " 2 :quick ", "4: fox", " 7: the ", "5: jumps" }; 
        String part2[] = { "3 :brown", " 1 : the", " 6:over", "8 :lazy", "10: this", " 11 : morning" };

        Map<Integer, String> map = new HashMap<>();
        fillMap(part1, map);
        fillMap(part2, map);

        for(int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }


    private static void fillMap(String[] part, Map<Integer, String> map ) {
        for(String str : part) {
            String[] data = str.split(":");
            int key = Integer.parseInt(data[0].trim());
            String value = data[1].trim();
            map.put(key, value);
        }
    }
    
}
