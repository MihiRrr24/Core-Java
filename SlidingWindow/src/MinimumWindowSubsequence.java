// https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "eksrg";
        System.out.println(minWindow(s1, s2));
    }

    public static String minWindow(String S, String T) {
        int sLen = S.length(), tLen = T.length();
        int minLen = Integer.MAX_VALUE;
        int start = -1;

        for (int i = 0; i < sLen; i++) {
            if (S.charAt(i) != T.charAt(0)) continue;

            int sPtr = i, tPtr = 0;

            // Step 1: Forward match to find end
            while (sPtr < sLen && tPtr < tLen) {
                if (S.charAt(sPtr) == T.charAt(tPtr)) {
                    tPtr++;
                }
                sPtr++;
            }

            if (tPtr < tLen) break; // Not matched

            // Step 2: Backtrack to find start of window
            int end = sPtr - 1;
            tPtr = tLen - 1;
            while (end >= 0) {
                if (S.charAt(end) == T.charAt(tPtr)) {
                    tPtr--;
                    if (tPtr < 0) break;
                }
                end--;
            }

            int windowStart = end;
            int windowLen = sPtr - windowStart;

            if (windowLen < minLen) {
                minLen = windowLen;
                start = windowStart;
            }
        }

        return (start == -1) ? "" : S.substring(start, start + minLen);
    }
}
