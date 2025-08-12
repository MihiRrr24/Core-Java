public class Pattern1 {
    public static void main(String[] args) {
        int[] arr = {-1, 9, -5, 3, 8, 5, -1};
        int k = 4;
        System.out.println("Max Sum -> "+constantWindow(arr, k));
    }

    public static int constantWindow(int[] arr, int k)
    {
        int sum = 0;

        // Step 1 -> compute sum first till initial window size
        for(int i=0; i<k; i++){
            sum+=arr[i];
        }

        // Step 2 -> now check for next max sums
        int left = 0, right = k-1;
        int maxSum = sum;              // might be our possible ans
        while(right < arr.length-1)
        {
            sum -= arr[left];
            left++;

            right++;
            sum+=arr[right];

            // keep track of maxSum
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}