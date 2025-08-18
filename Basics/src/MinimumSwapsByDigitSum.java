import java.util.*;

public class MinimumSwapsByDigitSum {

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;

        // Create sorted array based on digit sum, then by value
        Integer[] sorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            return (sumA == sumB) ? Integer.compare(a, b):Integer.compare(sumA, sumB);
        });

        // Map from value to original index
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(nums[i], i);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || sorted[i] == nums[i])
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = valueToIndex.get(sorted[j]);
                cycleSize++;
            }

            if (cycleSize > 1) {
                cnt += (cycleSize - 1);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {37, 100};
        System.out.println(minSwaps(nums));
    }
}
