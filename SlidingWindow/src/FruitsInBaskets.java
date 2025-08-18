// https://leetcode.com/problems/fruit-into-baskets/

import java.util.*;

public class FruitsInBaskets {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits){
        // bruteforce -> O(n2) and O(3)~O(1)
//        int maxLen = 0;
//        for(int i=0; i<fruits.length; i++){
//            Set<Integer> st = new HashSet<>();
//
//            for(int j=i; j<fruits.length; j++){
//                st.add(fruits[j]);
//
//                if(st.size() <= 2){
//                    maxLen = Math.max(maxLen, j-i+1);
//                }
//                else break;
//            }
//        }
//
//        return maxLen;


        // better and optimal
        Map<Integer, Integer> fruitsCount = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

        while(right < fruits.length){
            // keep adding fruits with keeping count of them
            fruitsCount.put(fruits[right],
                    fruitsCount.getOrDefault(fruits[right], 0) + 1);

            // if new fruit comes than 2 baskets
            // while(fruitsCount.size() > 2){
            if(fruitsCount.size() > 2){
                // decrement count for the first fruit or say shrink the window
                fruitsCount.put(fruits[left], fruitsCount.get(fruits[left])-1);

                // if the count get 0 so remove that element for new one to add
                if(fruitsCount.get(fruits[left]) == 0){
                    fruitsCount.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
