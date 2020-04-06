public class DistinctSubsequenceCount {
  /*public static int numDistinct(String s, String t) {
    int[] dp = new int[t.length()+1];
    dp[0] = 1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = t.length() - 1; j >= 0; j--) {
        System.out.println("s.i:"+ s.charAt(i)+ " t.j: "+t.charAt(j)+ " DP[j]: "+ dp[j]+ " ");
        if (s.charAt(i) == t.charAt(j)) {
          System.out.println("i:"+ i+ "j: "+j+ "DP[j]: "+ dp[j]+ " ");
          dp[j+1] += dp[j];
        }
      }
    }
    for(int k = 0;k <=t.length();k++){
      System.out.print(dp[k]+ " ");
    }
    return dp[t.length()];
  }*/

  public static int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m+1][n+1];
    dp[0][0] = 1;
    for(int k = 0;k <=m;k++) {
      System.out.println();
      for (int l = 0; l <= n; l++) {
        System.out.print(dp[k][l] + " ");
      }
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = dp[i-1][j];
        if (j > 0 && s.charAt(i-1) == t.charAt(j-1)) {
          dp[i][j] += dp[i-1][j-1];
        }
      }
    }
System.out.println("Later:");
    for(int k = 0;k <=m;k++){
      System.out.println();
      for(int l=0;l<=n;l++) {
        System.out.print(dp[k][l] + " ");
      }
    }

    return dp[m][n];
  }

  public static void main(String args[]){
    int x = numDistinct("rabbbit","rabbit");
   // int x = numDistinct("ABCDE","ACE");
    System.out.println("x:"+ x);
  }
//Approach 2:
public int numDistinct2(String s, String t) {
  int[] dp = new int[t.length()+1];
  dp[0] = 1;
  for (int i = 0; i < s.length(); i++) {
    for (int j = t.length() - 1; j >= 0; j--) {
      if (s.charAt(i) == t.charAt(j)) {
        dp[j+1] += dp[j];
      }
    }
  }
  return dp[t.length()];
}


}
