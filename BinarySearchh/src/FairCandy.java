// https://leetcode.com/problems/fair-candy-swap/?envType=problem-list-v2&envId=binary-search

import java.util.*;

public class FairCandy {
    public static void main(String[] args) {
        int[] aliceSizes = {1,1};
        int[] bobSizes = {2,2};

        int[] result = fairCandySwap(aliceSizes, bobSizes);
        System.out.println(Arrays.toString(result));
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> st = new HashSet<>();
        int totalA = 0, totalB = 0;

        for(int a:aliceSizes){
            totalA+=a;
        }
        for(int b:bobSizes){
            totalB+=b;
            st.add(b);
        }

        int diff = (totalB-totalA)/2;
        for(int a:aliceSizes){
            if(st.contains(a+diff)){
                return new int[] {a, a+diff};
            }
        }

        return new int[0];
    }
}
