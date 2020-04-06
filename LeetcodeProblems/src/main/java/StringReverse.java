import java.util.Stack;
import java.util.stream.IntStream;

public class StringReverse {

  public static void main(String args[]) {
    Integer x = 12345;
    String intString = (Integer.toString(12345));
    String res = "";

    Integer number = 23453;
    Integer reminder = 0;
    Integer reverse = 0;

    for (int i = intString.length(); i > 0; i--) {
      res = res + intString.charAt(i - 1);
    }
    System.out.println(res);

    while (number > 0) {
      reminder = number % 10;
      reverse = reverse * 10 + reminder;
      number = number / 10;
    }
    System.out.println(reverse);
  }
}
