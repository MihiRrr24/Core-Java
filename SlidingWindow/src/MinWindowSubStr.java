// https://leetcode.com/problems/minimum-window-substring/

import java.util.*;

public class MinWindowSubStr {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        // BRUTEFORCE


        // OPTIMAL
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        int cnt = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;


        for (int i = 0; i < t.length(); i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }


        while (right < s.length()) {
            char ch = s.charAt(right);
            if (mpp.containsKey(ch) && mpp.get(ch) > 0) {
                cnt++;
            }
            mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);


            while (cnt == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                mpp.put(s.charAt(left), mpp.get(s.charAt(left)) + 1);
                if (mpp.get(s.charAt(left)) > 0) {
                    cnt--;
                }
                left++;
            }

            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);



        /* ArraY solution (faster)

        int[] hash = new int[256];

        for (int i = 0; i < t.length(); i++){
            hash[t.charAt(i)] += 1;
        }

        int left = 0, right = 0, startIndex = -1, minLen = Integer.MAX_VALUE, count = 0;

        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0)
                count++;
            hash[s.charAt(right)] -= 1;

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                hash[s.charAt(left)] += 1;
                if (hash[s.charAt(left)] > 0)
                    count--;
                left++;
            }
            right++;
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);

         */
    }
}
