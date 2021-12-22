package algo.ds.Interview;

import java.util.ArrayList;
import java.util.List;

/*

After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['c', 'c', 'x', 't', 'i', 'b'],
    ['c', 'c', 'a', 't', 'n', 'i'],
    ['a', 'c', 'n', 'n', 't', 't'],
    ['t', 'c', 's', 'i', 'p', 't'],
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['o', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'c', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "bit"
word5 = "aoi"
word6 = "ki"
word7 = "aaa"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 1), (1, 1), (2, 1), (3, 1)]
    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
    OR [(1, 0), (1, 1), (2, 1), (3, 1)]
find_word_location(grid1, word3) => [(3, 2)]
find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

r = number of rows
c = number of columns
w = length of the word

*/

public class FindWordLocation {
    public static void main(String[] args) {

        char[][] grid1 = {
            {'c', 'c', 'x', 't', 'i', 'b'},
            {'c', 'c', 'a', 't', 'n', 'i'},
            {'a', 'c', 'n', 'n', 't', 't'},
            {'t', 'c', 's', 'i', 'p', 't'},
            {'a', 'o', 'o', 'o', 'a', 'a'},
            {'o', 'a', 'a', 'a', 'o', 'o'},
            {'k', 'a', 'i', 'c', 'k', 'i'}
        };

        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "bit";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaa";
        String word8 = "ooo";
    
        char[][] grid2 = {{'a'}};
        String word9 = "a";

        List<Point> result = findWordLocation(grid1, "cki");
        for(int i=result.size()-1; i>=0; i--) {
            Point p = result.get(i);
            System.out.println(p.x + "," + p.y);
        }
    
}

public static List<Point> findWordLocation(char[][] grid, String word) {
    List<Point> result = new ArrayList<>();
    
    outer : for(int i=0; i<grid.length; i++) {
        for(int j=0; j<grid[0].length; j++){
            if(dfs(grid, i, j, word, 0, result)) {
                break outer;
            }
        }
    }
    return result;
}

public static boolean dfs(char[][] grid, int i, int j, String word, int index,  List<Point> result) {
    if(index == word.length()) {
        return true;
    }
    
    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) {
        return false;
    }
   
    if(word.charAt(index) != grid[i][j]) {
        return false;
    }

    if (dfs(grid, i+1, j, word, index+1, result)) {
        result.add(new Point(i, j));
        return true;
    } 

    if(dfs(grid, i, j+1, word, index+1, result)) {
        result.add(new Point(i, j));
        return true;
    }

    return false;
}

static class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

}


