import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceValidWords {
public static void main(String args[]) {
  List<String> dict = new ArrayList<>();
  dict.add("It");
  dict.add("was");
  dict.add("best");
  dict.add("I");
  dict.add("time");
  dict.add("times");
System.out.println("Count:"+ reconstitute("Itwasbesttimes",dict));

}


  private static int reconstitute(String s, List<String> dict) {
    int E[] = new int[s.length()+1];
    int wordInd[] = new int[s.length()+1];
    Arrays.fill(wordInd,0);
    E[0] = 1;
    for (int j = 1; j <= s.length(); j++) {
      E[j] = 0;
      for (int i = 1; i <= j+1; i++) {
      //  System.out.println(s.substring(i, j));
        /*int si = j-1;
        int sj= i-1;*/
        if (dict.contains(s.substring(i-1, j)) && (E[i-1] == 1)) {
          E[j] = 1;
          wordInd[i-1] = j;
          System.out.println(s.substring(i-1, j));

        }
      }
    }
    for(int k: wordInd){
      System.out.print(k+ " ");
    }
    System.out.println();
    int previous=0;
    for (int i:wordInd){
      if(i!=0){
        System.out.print(s.substring(previous, i)+" ");
        previous = i;
      }
    }

    return E[s.length()];
  }
  }
