public class Pattern2 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 10, 10};
        int k = 14;
        System.out.println("Longest Subarray Sum <=k Is :-> "+optimaL(arr, k));
    }

    public static int bruteForce(int[] arr, int k) {
        // generate all subarrays with calculating sum concurrently
        // and check if <=k hence keep track of maxLen
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];

                if (sum <= k) {

                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else {
                    break;
                }
            }
        }

        return maxLen;
    }


    public static int betteR(int[] arr, int k){
        int left = 0, right = 0, sum = 0, maxLen = 0;

        while(right <  arr.length){
            sum += arr[right];

            while(sum > k){
                sum -= arr[left];
                left++;
            }

            if(sum<=k) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }


    public static int optimaL(int[] arr, int k){
        int left = 0, right = 0, sum = 0, maxLen = 0;

        while(right <  arr.length){
            sum += arr[right];

            // instead of shrinking every time to space <maxLen and again going to that maxLen
            // just shrink by 1 -> this keeps maxLen track and not going < than it size agin

            if(sum > k){
                sum -= arr[left];
                left++;
            }

            if(sum<=k) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }
}
