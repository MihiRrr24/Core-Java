// https://leetcode.com/problems/next-greater-element-i/

package Questions;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // BRUTEFORCE
//        int[] ans  = new int[nums1.length];
//
//        for(int i=0; i<nums1.length; i++){
//            int num = nums1[i];
//            for(int j=0; j<nums2.length; j++){
//
//                if(num == nums2[j]){
//                    int k=j+1;
//                    ans[i] = -1;
//                    while(k<nums2.length){
//                        if(nums2[k] > nums2[j]){
//                            ans[i] = nums2[k];
//                            break;
//                        }
//                        k++;
//                    }
//                }
//            }
//        }
//        return ans;



        
        // OPTIMAL
        int[] ans  = new int[100000];
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }

            ans[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        for(int j=0; j<nums1.length; j++){
            nums1[j] = ans[nums1[j]];
        }
        return nums1;
    }
}
