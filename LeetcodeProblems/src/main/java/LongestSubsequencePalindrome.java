public class LongestSubsequencePalindrome{

  public static void main(String []args){
    char x[] = {'A','C','G','T','G','T','C','A','A','A','A','T','C','G'};
    System.out.println("Length:"+ x.length);
    int n = x.length;
    int i,j;
    int L[][]= new int[n][n];

    for (i =0; i<n; i++){
      L[i][i] = 1;
    }

    for (i = n-1;i>=0;i--){
      System.out.println("i:"+i);
      for(j=i+1; j<n;j++){
        System.out.println("j:"+j);
        System.out.println("x[i]:"+x[i]+" x[j]:"+x[j]);
        if(x[i]==x[j]){
          System.out.println("*L[i][j]:"+L[i][j]);
          L[i][j] = (L[i+1][j-1])+2;
        } else {
          L[i][j]= Math.max(L[i+1][j],L[i][j-1]);
        }
        System.out.println("L[i][j]:"+L[i][j]);
      }
    }

    for (i = 0; i<n; i++){
      System.out.println();
      for(j=0;j<n;j++){
        System.out.print(" "+L[i][j]+" ");
      }
    }
    System.out.println("Palindrome Length:"+ L[0][n-1]);
  }
}