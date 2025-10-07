// https://leetcode.com/problems/sliding-window-maximum/

package Questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // List<Integer> res = new ArrayList<>();

        // for(int i=0; i<=nums.length-k; i++){
        //     int maxi = nums[i];

        //     for(int j=i; j<=i+k-1; j++){
        //         maxi = Math.max(maxi, nums[j]);
        //     }
        //     res.add(maxi);
        // }
        // return res.stream().mapToInt(Integer::intValue).toArray();





        // OPTIMAL
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for(int i=0; i<nums.length; i++){
            if(!dq.isEmpty() && dq.getFirst()<=i-k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i>=k-1) res[idx++] = nums[dq.getFirst()];
        }
        return res;
    }
}
