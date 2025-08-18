// https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

public class RemoveDuplicatesI {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums){
        int i=0;

        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }

        return i+1;
    }
}
