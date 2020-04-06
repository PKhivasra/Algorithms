import java.util.ArrayList;
import java.util.List;

public class RemoveVowelsFromString {

  public static void main(String args[]){
    String checkMe = "Hello this is a new world";
    List<Character> vowels = new ArrayList<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    String res="";
    for(char c: checkMe.toCharArray()){
      if(!vowels.contains(c)){
        res = res+ (c);
      }
    }
    System.out.println(res);
  }

}
