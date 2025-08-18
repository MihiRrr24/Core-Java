//Question Link :- https://leetcode.com/problems/valid-anagram/description/


import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        if(isValidAnagram(s, t)){
            System.out.println("Yes its a valid Anagram");
        }
        else System.out.println("No! its not a valid Anagram");
    }

    public static boolean isValidAnagram(String s, String t){
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//        return Arrays.equals(sChars, tChars);                 // T.C  ==  O(N log N)




        // T.C == O(N)
        Map<Character, Integer> hash = new HashMap<>();

        // Count the frequency of characters in string s   and increment
        for(char x : s.toCharArray()){
            hash.put(x, hash.getOrDefault(x, 0)+1);
        }

        // Count the frequency of characters in string s   and increment
        for(char y : t.toCharArray()){
            hash.put(y, hash.getOrDefault(y, 0)-1);
        }

        // Check if any character has non-zero frequency
        for(int freq : hash.values()){
            if(freq!=0) return false;
        }
        return true;
    }
}
