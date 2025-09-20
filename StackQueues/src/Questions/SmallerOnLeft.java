// https://www.geeksforgeeks.org/problems/smaller-on-left20360700/1
package Questions;

import java.util.Arrays;
import java.util.TreeSet;

public class SmallerOnLeft {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        int[] ans = Smallestonleft(nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] Smallestonleft(int arr[], int n) {
        int[] ans = new int[n];
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            Integer smaller = ts.lower(arr[i]);
            ans[i] = (smaller == null) ? -1 : smaller;

            ts.add(arr[i]);
        }

        return ans;
    }
}
