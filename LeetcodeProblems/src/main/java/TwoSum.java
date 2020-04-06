import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionTwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      Integer diff = (Integer) (target - nums[i]);
      if (hash.containsKey(diff)) {
        int toReturn[] = {hash.get(diff), i};
        return toReturn;
      }

      hash.put(nums[i], i);

    }

    return null;
  }
}


public class TwoSum {
  public static void main(String args[]) {
    int[] nums = {2, 11, 7, 9};
    int target = 18;
    int res[] =new SolutionTwoSum().twoSum(nums, target);
    System.out.println(res);
  }
}