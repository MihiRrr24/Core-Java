// https://leetcode.com/problems/two-sum/description/

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                ans[0]=map.get(diff);
                ans[1] = i;
            }
            else map.put(nums[i], i);
        }

        return ans;
    }
}
