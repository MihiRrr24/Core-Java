// https://leetcode.com/problems/sum-of-subarray-ranges/

package Questions;

import java.util.Stack;

public class SumofSubarrayranges {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        long ans = subArrayRanges(nums);
        System.out.println(ans);
    }

    public static long subArrayRanges(int[] nums) {
        // BRUTEFORCE
//        long sum = 0;
//
//        for(int i=0; i<nums.length; i++){
//            int mini = nums[i],maxi = nums[i];
//
//            for(int j=i; j<nums.length; j++){
//                mini = Math.min(mini, nums[j]);
//                maxi = Math.max(maxi, nums[j]);
//                sum += (maxi-mini);
//            }
//        }
//        return sum;





        // OPTIMAL
        long sum = 0;
        int[] nse = findNSE(nums);
        int[] psee = findPSEE(nums);
        int[] nge = findNGE(nums);
        int[] pgee = findPGEE(nums);

        for(int i=0; i<nums.length; i++){
            int lSmall = i-psee[i];
            int rSmall = nse[i]-i;
            long leftSum = (long) lSmall*rSmall*nums[i];

            int lLarge = i-pgee[i];
            int rLarge = nge[i]-i;
            long rightSum = (long) lLarge*rLarge*nums[i];

            sum += (rightSum-leftSum);
        }
        return sum;
    }

    public static int[] findNSE(int[] arr){
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    public static int[] findPSEE(int[] arr){
        int[] psee = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    public static int[] findNGE(int[] arr){
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            nge[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nge;
    }

    public static int[] findPGEE(int[] arr){
        int[] pgee = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }

            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
    }
}
