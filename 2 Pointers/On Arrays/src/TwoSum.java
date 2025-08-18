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
//        int[] ans = new int[2];
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0; i<nums.length; i++){
//            int diff = target-nums[i];
//            if(map.containsKey(diff)){
//                ans[0]=map.get(diff);
//                ans[1] = i;
//            }
//            else map.put(nums[i], i);
//        }
//
//        return ans;





        // Create an array of pairs to store values and their original indices
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i]; // Value
            indexedNums[i][1] = i;      // Original index
        }

        // Sort the array based on values
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers
        int i = 0, j = nums.length - 1;

        // Two-pointer logic
        while (i < j) {
            int sum = indexedNums[i][0] + indexedNums[j][0];

            if (sum == target) {
                // Return the original indices
                return new int[] { indexedNums[i][1], indexedNums[j][1] };
            } else if (sum < target) {
                i++; // Move the left pointer to the right
            } else {
                j--; // Move the right pointer to the left
            }
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }
}
