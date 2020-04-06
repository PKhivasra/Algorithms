public class MinimumAsciiDeleteSum {
  public static int minimumDeleteSum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = m - 1; i >= 0; i--) {
      dp[i][n] = dp[i+1][n] + s1.codePointAt(i);
      System.out.print(dp[i][n]+" ");
    }
    System.out.println();
    for (int j = n - 1; j >= 0; j--) {
      dp[m][j] = dp[m][j+1] + s2.codePointAt(j);
      System.out.print(dp[m][j]+" ");
    }

    System.out.println("Stage3:");
    for(int k =0 ;k<=m;k++){
      System.out.println();
      for(int l= 0; l<=n;l++){
        System.out.print(dp[k][l]+" ");
      }
    }
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (s1.charAt(i) == s2.charAt(j)) {
          dp[i][j] = dp[i+1][j+1];
        } else {
          dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i),
              dp[i][j+1] + s2.codePointAt(j));
        }
      }
    }
    System.out.println("Stage:");
    for(int k =0 ;k<=m;k++){
      System.out.println();
      for(int l= 0; l<=n;l++){
        System.out.print(dp[k][l]+" ");
      }
    }
    return dp[0][0];
  }

  public static void main(String args[]){
    //ASCII: [97-112] a= 97, e=101, l=108, t=116
    System.out.println("Answer:"+ minimumDeleteSum("sea","eat"));
  }

}
