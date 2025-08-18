public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;

        System.out.println("Split Array Sum -> "+splitArray(nums,k));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        while(start < end){
            // try for the middle as potential ans
            int mid = start+(end-start)/2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int parts = 1;
            for(int n : nums){
                if(sum+n > mid){
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = n and split parts++
                    sum = n;
                    parts++;
                }
                else{
                    sum+=n;
                }
            }

            if(parts<=k){
                end=mid;
            }
            else{
                start = mid+1;
            }
        }

        return start; // end
    }
}
