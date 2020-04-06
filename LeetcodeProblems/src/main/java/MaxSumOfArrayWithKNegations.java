import java.util.Arrays;

class Solution {

  public Solution() {
  }

  public int largestSumAfterKNegations(int[] A, int K) {
    Arrays.sort(A);
    int i = 0;
    int k = 0;

    while (k < K && i < A.length) {
      if (A[i] < 0) {
        A[i] = -1 * A[i];
        i++;
      } else if (A[i] == 0) {
        k++;
      } else {
        Arrays.sort(A);
        while (k<K){
          A[0]=-1*A[0];
          k++;
        }
      }
      k++;
    }

    Arrays.stream(A).forEach(val -> System.out.println(val));
    int total = 0;
    for (int element : A) {
      total += element;
    }
    return total;
  }
}

public class MaxSumOfArrayWithKNegations {

  public static void main(String args[]) {

  int A[] = {3, -1, 0, 2};
  int k = 3;
  int result = (new Solution()).largestSumAfterKNegations(A,k);
  System.out.println("Output:" +result);
}
}
