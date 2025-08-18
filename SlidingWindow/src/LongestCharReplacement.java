// https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestCharReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        // BRUTEFORCE
        // int[] hash = new int[26];
        // int maxLen = 0;
        // for(int i=0; i<s.length(); i++){
        //     Arrays.fill(hash, 0);
        //     int maxFreq = 0;

        //     for(int j=i; j<s.length(); j++){
        //         hash[s.charAt(j) - 'A']++;
        //         maxFreq = Math.max(maxFreq, hash[s.charAt(j)-'A']);

        //         int changes = (j-i+1) - maxFreq;

        //         if(changes <= k){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
        //         else break;
        //     }
        // }
        // return maxLen;


        // BEtter and OPTIMAL
        int[] hash = new int[26];
        int left = 0, right = 0, maxLen = 0, maxFreq = 0;

        while(right < s.length()){
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right)-'A']);

            // if more than k characters need replacement, shrink window
            if((right-left+1) - maxFreq > k){
                hash[s.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
