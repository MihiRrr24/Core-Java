// https://leetcode.com/problems/sum-of-subarray-minimums/

package Questions;

import java.util.Stack;

public class SubarrayMinimum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        // BRUTEFORCE
//        int sum = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            int mini = arr[i];
//
//            for (int j = i; j < arr.length; j++) {
//                mini = Math.min(mini, arr[j]);
//                sum = (sum+mini)%1000000007;
//            }
//        }
//
//        return sum;


        //OPTIMAL
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            sum = (sum + ((long) right * left * arr[i]) % 1000000007) % 1000000007;
        }
        return (int) sum;
    }

    public static int[] findNSE(int[] res) {
        int[] nse = new int[res.length];
        Stack<Integer> st = new Stack<>();

        for (int i = res.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && res[st.peek()] >= res[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? res.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    public static int[] findPSEE(int[] res) {
        int[] psee = new int[res.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < res.length; i++) {
            while (!st.isEmpty() && res[st.peek()] > res[i]) {
                st.pop();
            }

            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}
