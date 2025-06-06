// https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return i;
    }
}
