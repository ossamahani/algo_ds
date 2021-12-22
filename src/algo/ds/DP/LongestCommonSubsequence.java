package algo.ds.DP;

import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List<Character> result = lcs1("ZXVVYZW", "XKYKZPW");
        System.out.println(result);
    }


    private static List<Character> lcs1(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        String[][] dp = new String[n + 1][m + 1];
        for(int i = 0; i<m+1; i++) {
            for(int j=0;j<n+1; j++) {
                if(i == 0 || j==0) {
                    dp[i][j] = "";
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + "" + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }
        return dp[m][n].chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }

    private static List<Character> lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        String[][] dp = new String[m + 1][n + 1];
        for(int i = 0; i<m+1; i++) {
            for(int j=0;j<n+1; j++) {
                if(i == 0 || j==0) {
                    dp[i][j] = "";
                }
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + "" + str1.charAt(j - 1);
                } else {
                    dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }
        return dp[m][n].chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }
}
