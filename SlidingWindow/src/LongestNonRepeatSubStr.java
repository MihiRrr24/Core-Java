// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class LongestNonRepeatSubStr {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        // O(n2) and O(256)
//        int[] arr = new int[256];
//        int max = 0;
//        int n = s.length();
//
//        for (int i = 0; i < n; i++) {
//            // Reset the array for each new starting point
//            Arrays.fill(arr, 0);
//
//            for (int j = i; j < n; j++) {
//                // If character at j has been seen, break the loop
//                if (arr[s.charAt(j)] == 1) {
//                    break;
//                }
//
//                // Otherwise, add the character to substring
//                int len = j - i + 1;
//                max = Math.max(max, len);
//                // Remember it
//                arr[s.charAt(j)] = 1;
//            }
//        }
//        return max;


        // OPTIMIZED -> O(n) and O(256)
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {

            if (hash[s.charAt(right)] != -1) {
                // means that character is already present in our hashmap

                // check if the new repeating char is in range then place left after the repeating char
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }

            // ok we got substring just find maxLen
            maxLen = Math.max(maxLen, right - left + 1);

            // place right also in array simultaneously
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;


    // Optimial 2 -> using set O(n) and O(n)
//    Set<Character> st = new HashSet<>();
//
//    int left = 0, right = 0, maxLen = 0;
//        while(right<s.length())
//
//    {
//        if (!st.contains(s.charAt(right))) {
//            st.add(s.charAt(right));
//            right++;
//            maxLen = Math.max(maxLen, st.size());
//        } else {
//            st.remove(s.charAt(left));
//            left++;
//        }
//    }
//
//        return maxLen;
    }
}
