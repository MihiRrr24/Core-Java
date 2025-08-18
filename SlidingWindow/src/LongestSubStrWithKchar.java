// https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM
// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithKchar {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s,k));
    }

    public static int longestKSubstr(String s, int k) {
        // BRUTEFORCE
//        Map<Character, Integer> mpp = new HashMap<>();
//        int maxLen = 0;
//
//        for(int i=0; i<s.length(); i++){
//            mpp.clear();
//
//            for(int j=i; j<s.length(); j++){
//                mpp.put(s.charAt(j), j);
//
//                if(mpp.size() <= k){
//                    maxLen = Math.max(maxLen, j-i+1);
//                }
//                else break;
//            }
//        }
//        return maxLen;



        //Better Or optimal -> O(n) + O(log 256) and O(256)
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);

            if(map.size() > k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0)-1);

                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
