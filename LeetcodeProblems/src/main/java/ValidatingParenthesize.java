import java.util.HashMap;

public class ValidatingParenthesize {
  public static void reduction(char[] orig, int[][] math){
    // if given only one character, answer true only if that character is 'a'
    if(orig.length == 1){
      boolean ans =  (orig[0] == 'a');
      System.out.println("single character result: " + ans);
      return;
    }

    // hashmap used to convert string of characters into integers
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('a', 0);
    map.put('b', 1);
    map.put('c', 2);
    //Convert input string to string of numbers
    int[] string = new int[orig.length];
    for(int i = 0; i< orig.length; i++) {
      string[i] = map.get(orig[i]);
    }

    boolean[][] result = new boolean[string.length][3];
    //> base case 1. if only one character, row is true if character == row
    //> base case 2. if only two character, row is true if 1st * 2nd == row
    for(int i = 0; i< 3; i++){
      result[0][i] = (string[0] == i);        // only if that character is equal to the row char
      System.out.println("For result[0][i]:"+ result[0][i] +" "+ string[0]+ "  i:"+ i);
      result[1][i] = (math[string[0]][string[1]] == i);   //if the two characters multiplied are equal to the row
      System.out.println("For result[1][i]:"+ result[1][i]+" "+ string[0]+ " "+string[1]+" i:"+ i);

    }

    //> for all other characters, you check 2 cases: 1. ([you-1] * you) || 2. ([you-2] * (you x you-1))
    for(int j = 2; j<string.length;j++) {   //if the string ended in the ith character
      for (int k = 0; k < 3; k++) {       // could it end in a a(0), b(1), or c(2) ?
        for (int l = 0; l < 3; l++) {   // for each type (a, b, c) check if the previous column is true
          if (result[j - 1][l]) {         // indicating that the prev subsequence can result in that letter
            result[j][k] = ((math[l][string[j]]) == k) || result[j][k]; // first case
            if(j==4 && k==0){
              System.out.println("Get:"+result[j - 1][l]+ " l:"+l);
            }
          }
          if (result[j - 2][l]) {                                         // second case
            result[j][k] = ((math[l][math[string[j - 1]][string[j]]]) == k) || result[j][k];
          }
        }
      }
    }
    for(int x=0;x<string.length;x++){
      System.out.println();
      for(int y=0;y < 3; y++){
        if(x==string.length-1 && y ==0) {
          System.out.print(result[x][y] + "* ");
        } else {
          System.out.print(result[x][y] + " ");
        }
      }
    }
    // check the last column, row a if it is true.
    boolean answer = result[string.length-1][0];

    if(answer){
      System.out.println("\nYou entered a string that can result in an a!");
    }else{
      System.out.println("\nThe string you entered can not result in an a.");
    }
  }

  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//

  public static void main(String[] args) {
    int[][] multi = new int[3][3];
    multi[0][0] = 1;
    multi[0][1] = 1;
    multi[0][2] = 0;
    multi[1][0] = 2;
    multi[1][1] = 1;
    multi[1][2] = 0;
    multi[2][0] = 0;
    multi[2][1] = 2;
    multi[2][2] = 2;

    //reduction("bbbbac".toCharArray(),multi);
    reduction("abcab".toCharArray(),multi);
  }

}
