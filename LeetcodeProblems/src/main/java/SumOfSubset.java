public class SumOfSubset {
  public static void subsetSum(int[] values, int t) {
    boolean[][] C = new boolean[values.length + 1][t + 1];
    // Base case: if t is 0, you can sum to it.
    for (int i = 0; i <= values.length; i++) {
      C[i][0] = true;
    }
    for (int i = 1; i <= values.length; i++) {
      for (int j = 1; j <= t; j++) {
        C[i][j] = C[i - 1][j];
        if (values[i - 1] <= j && C[i - 1][j - values[i - 1]]) {
          C[i][j] = true;
        }
      }
    }
    // traversing last column to find a true
    boolean result = false;
    for (int l = 0; l <= values.length; l++) {
      result = result || C[l][t];
    }
    System.out.printf("Is it possible to make change for %s?   %b\n", t, result);

    for(int x = 0;x<= values.length;x++){
      System.out.println();
      for(int y=0;y<=t;y++){
        System.out.print(C[x][y]+ " ");
      }
    }
  }

  public static void  main(String args[]){
    int A[] =  {2,5,3,9};
    int t = 11;
    subsetSum(A,t);

  }
}
