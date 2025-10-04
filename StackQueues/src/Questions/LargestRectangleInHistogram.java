// https://leetcode.com/problems/largest-rectangle-in-histogram/

package Questions;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        // BRUTEFORCE
        // int ans = Integer.MIN_VALUE;

        // for(int i=0; i<heights.length; i++){
        //     int currHeight = heights[i];
        //     int left = i, right = i;

        //     while(left>0 && heights[left-1]>=currHeight) left--;
        //     while(right<heights.length-1 && heights[right+1]>=currHeight) right++;

        //     int width = right-left+1;
        //     ans = Math.max(ans, currHeight*width);
        // }
        // return ans;


        // NAIVE
        // int[] nse = findNSE(heights);
        // int[] pse = findPSEE(heights);
        // int maxi = Integer.MIN_VALUE;

        // for(int i=0; i<heights.length; i++){
        //     maxi = Math.max(maxi, heights[i]*(nse[i]-pse[i]-1));
        // }
        // return maxi;




        // OPTIMAL
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = heights.length;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
        }
        return maxArea;
    }

    // public int[] findNSE(int[] arr){
    //     int[] nse = new int[arr.length];
    //     Stack<Integer> st = new Stack<>();

    //     for(int i=arr.length-1; i>=0; i--){
    //         while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
    //             st.pop();
    //         }

    //         nse[i] = st.isEmpty() ? arr.length : st.peek();
    //         st.push(i);
    //     }
    //     return nse;
    // }

    // public int[] findPSEE(int[] arr){
    //     int[] psee = new int[arr.length];
    //     Stack<Integer> st = new Stack<>();

    //     for(int i=0; i<arr.length; i++){
    //         while(!st.isEmpty() && arr[st.peek()]>arr[i]){
    //             st.pop();
    //         }

    //         psee[i] = st.isEmpty() ? -1 : st.peek();
    //         st.push(i);
    //     }
    //     return psee;
    // }
}
