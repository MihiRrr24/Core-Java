// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

import java.util.Arrays;

public class NoOfSubstrWith3Chars {
    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println(numberOfSubstrings(str));
    }

    public static int numberOfSubstrings(String s) {
        // BRUTEFORCE
        // int[] hash = new int[3];
        // int count = 0;

        // for(int i=0; i<s.length(); i++){
        //     Arrays.fill(hash, 0);

        //     for(int j=i; j<s.length(); j++){
        //         hash[s.charAt(j) - 'a'] = 1;

        //         if(hash[0]+hash[1]+hash[2] == 3){
        //             count += (s.length()-j);
        //             break;
        //         }
        //     }
        // }
        // return count;




        // OPTIMAL -> O(n)
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        int count = 0;

        for(int i=0; i<s.length(); i++){
            // update the index for each char
            lastSeen[s.charAt(i) - 'a'] = i;
            // count valid last seen windows from a char
            count += (1 + Math.min( lastSeen[0], Math.min(lastSeen[1], lastSeen[2]) ));
        }

        return count;
    }
}
