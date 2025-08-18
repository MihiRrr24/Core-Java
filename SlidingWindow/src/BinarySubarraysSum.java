// https://leetcode.com/problems/binary-subarrays-with-sum/

public class BinarySubarraysSum {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        int goal = 0;
        System.out.println(numSubarraysWithSum(arr, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        // Bruteforce
        // int count = 0;
        // for(int i=0; i<nums.length; i++){
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++){
        //         sum+=nums[j];
        //         if(sum>goal) break;  // remove in -ve nos case
        //         if(sum==goal) count++;
        //     }
        // }
        // return count;


        // Optimal -> O(n log n) -> works for every nos
        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // int sum = 0, count = 0;

        // for(int i=0; i<nums.length; i++){
        //     sum+=nums[i];
        //     count+=map.getOrDefault((sum-goal), 0);
        //     map.put(sum, map.getOrDefault(sum, 0)+1);
        // }

        // return count;




        // optimal -> O(N) ->works for only +ve and 0's
        return solve(nums,goal) - solve(nums,goal-1);
    }


    public static int solve(int[] nums, int goal){
        int left = 0, right = 0, sum = 0, count = 0;
        if(goal<0) return 0;

        while(right < nums.length){
            sum += nums[right];

            while(sum > goal){
                sum -= nums[left];
                left++;
            }

            count += (right-left+1);
            right++;
        }

        return count;
    }
}
