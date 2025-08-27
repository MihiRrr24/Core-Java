// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

package Questions;

public class MinimumBitFlips {
    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(minBitFlips(start, goal));
    }

    public static int minBitFlips(int start, int goal) {
        int convert = start^goal;

        int ans = 0;
        while(convert != 0){
            convert &= (convert-1);
            ans++;
        }
        return ans;
    }
}
