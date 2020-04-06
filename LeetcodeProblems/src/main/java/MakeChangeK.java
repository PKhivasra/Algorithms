public class MakeChangeK {
  public static void makeChange3(int[] values, int V, int max) {
    boolean[][] C = new boolean[max + 1][V + 1];
    // base case: if value is 0, you can make change
    for (int k = 0; k <= max; k++) {
      C[k][0] = true;
    }
    for (int k = 1; k <= max; k++) {
      for (int j = 1; j <= V; j++) {
        C[k][j] = C[k - 1][j];
        for (int m = 0; m < values.length; m++) {
          if (values[m] <= j && C[k - 1][j - values[m]]) {
            C[k][j] = true;
          }
        }
      }
    }

    for(int a= 0;a<=max;a++){
      System.out.println();
      for(int b= 0; b<=V;b++){
        System.out.print(C[a][b]+" ");
      }
    }

    System.out.printf("Is it possible to make change for %s?   %b\n", V, C[max][V]);
  }

  public static void main(String args[]){
    int values[]={5,10};
    int k = 2;
    int V= 15;
    makeChange3(values,V,k);
  }
}
