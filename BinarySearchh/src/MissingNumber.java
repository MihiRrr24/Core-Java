// https://leetcode.com/problems/missing-number/?envType=problem-list-v2&envId=binary-search

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int n=nums.length;

        int xor1=0;
        int xor2=0;
        for(int i=0; i<n; i++){
            xor2=xor2^nums[i];
            xor1=xor1^(i);
        }

        return xor1^xor2^n;



//        Arrays.sort(nums);
//        int left = 0, right = nums.length, mid= (left + right)/2;
//        while(left<right){
//            mid = (left + right)/2;
//            if(nums[mid]>mid) right = mid;
//            else left = mid+1;
//        }
//        return left;
    }
}
