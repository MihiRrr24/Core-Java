// https://leetcode.com/problems/find-good-days-to-rob-the-bank/

import java.util.*;

public class FindGoodDaysToRob {
    public static void main(String[] args) {
        int[] security = {5,3,3,3,5,6,2};
        int time = 2;

        List<Integer> ans = goodDaysToRobBank(security, time);
        System.out.println(ans);
    }

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        // Arrays to store the count of consecutive non-increasing (decreasing) and non-decreasing days
        int[] incr = new int[security.length]; // Tracks increasing trend from right to left
        int[] decr = new int[security.length]; // Tracks decreasing trend from left to right

        // Initialize the first element of the decreasing array
        decr[0] = 0;

        // Compute the decreasing trend for each day
        for(int i = 1; i < security.length; i++){
            if(security[i] <= security[i - 1]){
                decr[i] = decr[i - 1] + 1; // Increment count if current is less than or equal to previous
            } else {
                decr[i] = 0; // Reset count if trend breaks
            }
        }

        // Initialize the last element of the increasing array
        incr[security.length - 1] = 0;

        // Compute the increasing trend for each day (from right to left)
        for(int j = security.length - 2; j >= 0; j--){
            if(security[j] <= security[j + 1]){
                incr[j] = incr[j + 1] + 1; // Increment count if current is less than or equal to next
            } else {
                incr[j] = 0; // Reset count if trend breaks
            }
        }

        // List to store the valid days to rob the bank
        List<Integer> ans = new ArrayList<>();

        // Iterate over days that have at least `time` days before and after them
        for(int i = time; i < security.length - time; i++){
            // A valid day must have `time` decreasing days before and `time` increasing days after
            if(decr[i] >= time && incr[i] >= time){
                ans.add(i); // Add the valid day to the list
            }
        }

        // Return the list of good days to rob the bank
        return ans;
    }
}
