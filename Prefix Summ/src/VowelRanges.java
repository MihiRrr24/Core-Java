// https://leetcode.com/problems/count-vowel-strings-in-ranges/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelRanges {

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};

        int[] ans = vowelStrings(words, queries);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] prefix = new int[words.length+1];

        // int sum = 0;
        for(int i=0; i<words.length; i++){
            // char first = words[i].charAt(0);
            // char last = words[i].charAt(words[i].length()-1);

            prefix[i+1] = prefix[i];
            if( vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length()-1)) ){
                prefix[i+1]++;
            }
        }

        int[] ans = new int[queries.length];
        for(int j=0; j<queries.length; j++){
            // int left = queries[j][0];
            // int right = queries[j][1];

            ans[j] = prefix[queries[j][1]+1] - prefix[queries[j][0]];
        }

        return ans;
    }
}
