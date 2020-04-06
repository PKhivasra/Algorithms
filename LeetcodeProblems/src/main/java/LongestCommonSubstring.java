public class LongestCommonSubstring {
  private static int findLength(char[] A, char[] B) {
    if(A == null || B == null || A.length == 0 || B.length == 0)return 0;
    int Rows = A.length;
    int Cols = B.length;

    // dp[i][j] is the length of longest common subarray ending with A[i-1], B[j-1]
    int[][] dp = new int[Rows + 1][Cols + 1];
    int maxLen = 0;
    for (int i = 1; i <=Rows ; i++) {
      for (int j = 1; j <= Cols; j++) {
        if(A[i -1] == B[j-1])
        {
          dp[i][j] = 1 + dp[i-1][j-1];
          maxLen = Math.max(maxLen, dp[i][j]);
        }
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String a = "WelcomeToClass";
    String b = "WelcomeToWorldClass";
    int maxLcs = findLength(a.toCharArray(),b.toCharArray());
    //int maxLcs = lcs(a.toCharArray(), b.toCharArray(), a.length(), b.length(), 0);
    System.out.println(maxLcs);
  }
/*
  private static int lcs(char[] a, char[] b, int i, int j, int count) {
    if (i == 0 || j == 0)
      return count;
    if (a[i - 1] == b[j - 1]) {
      count = lcs(a, b, i - 1, j - 1, count + 1);
    }
    count = Math.max(count, Math.max(lcs(a, b, i, j - 1, 0), lcs(a, b, i - 1, j, 0)));
    return count;
  }*/
}
