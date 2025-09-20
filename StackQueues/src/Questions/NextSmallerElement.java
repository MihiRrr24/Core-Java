// https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
package Questions;

import java.util.*;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        ArrayList<Integer> ans = nextSmallerEle(nums);
        System.out.println(ans);
    }

    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() >= arr[i]) st.pop();
            if(!st.isEmpty()) ans.set(i, st.peek());
            st.push(arr[i]);
        }
        return ans;
    }
}
