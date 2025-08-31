// https://leetcode.com/problems/single-number-ii/

package Questions;

public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        // Better
        // int ans=0;
        // for(int bitIndex=0; bitIndex<32; bitIndex++){
        //     int cnt = 0;

        //     for(int j=0; j<nums.length; j++){
        //         if( (nums[j] & (1<<bitIndex)) != 0) cnt++;
        //     }

        //     // if constraints change (say "every number appears 5 times except one"), then the remainder might not be exactly 1. That’s why != 0 is often written.
        //     if(cnt % 3 != 0){
        //         ans = ans | (1<<bitIndex);
        //     }
        // }
        // return ans;




        // OPTIMAL
        // Arrays.sort(nums);
        // for(int i=1; i<nums.length; i=i+3){
        //     if(nums[i] != nums[i-1]){
        //         return nums[i-1];
        //     }
        // }
        // return nums[nums.length-1];





        // MOST OPTIMAL
        int ones = 0, twos = 0;
        for(int i:nums){
            ones = (ones^i) & ~twos;
            twos = (twos^i) & ~ones;
        }
        return ones;
    }
}
