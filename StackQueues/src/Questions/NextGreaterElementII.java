// https://leetcode.com/problems/next-greater-element-ii/

package Questions;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] ans = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] nextGreaterElements(int[] nums) {
        // BRUTEFORCE
//         int[] ans = new int[nums.length];
//
//         for(int i=0; i<nums.length; i++){
//             int num = nums[i];
//             ans[i] = -1;
//             boolean found = false;
//
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[j] > num){
//                     ans[i] = nums[j];
//                     found = true;
//                     break;
//                 }
//             }
//
//             if(!found){
//                 for(int j=0; j<i; j++){
//                     if(nums[j] > num){
//                         ans[i] = nums[j];
//                         break;
//                     }
//                 }
//             }
//         }
//         return ans;






        // Better (Circular Array Concept)
//        int[] ans = new int[nums.length];
//        for(int i=0; i< nums.length; i++){
//            ans[i] = -1;
//
//            for(int j=i+1; j<i+nums.length; j++){
//                int index = j%nums.length;
//                if(nums[index] > nums[i]){
//                    ans[i] = nums[index];
//                    break;
//                }
//            }
//        }
//        return ans;






        // OPTIMAL
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }

            if(i<n) ans[i] = st.isEmpty() ? -1:st.peek();
            st.push(nums[i%n]);
        }
        return ans;
    }
}
