public class RobHouse {

  public static int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1)
      return nums[0];

    if (nums.length == 2)
      return Math.max(nums[0], nums[1]);

    int a = 0; //odd
    int b = 0; //even

    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        b = b + nums[i]; //keeps track of even indices amt
        b = Math.max(a,
            b); //b is an even i and gets current max of all odd indices and even indices till i
      } else {
        a = a + nums[i]; //keeps track of odd indices amt
        a = Math.max(a,
            b);//a is an odd i and gets current max of all odd indices and even indices till i
      }
    }

    return Math.max(a, b); //return max of a and b
  }
    //T O(n) S O(1)
    //1,3,2,4,4 b=1; a=3, b=2,b=3; a=7; b=7; return 7
public static int robHouseDP(int nums[]){
         int[] global = new int[nums.length];
         global[0] = nums[0];
         global[1] = Math.max(nums[0],nums[1]);

         for(int i = 2; i < nums.length; i++) {
             global[i] = Math.max(global[i-2] + nums[i], global[i-1]);
         }
         for(int k=0;k<nums.length;k++){
           System.out.print(global[k]+" ");
         }
         return global[nums.length - 1];

//         //TO(n) S O(n)
  }

  public static void main (String args[]){
    int nums[] = {5,7,9,2,1,10};
    System.out.println("Value:"+robHouseDP(nums));
  }
}
