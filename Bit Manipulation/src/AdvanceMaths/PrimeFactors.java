// https://www.geeksforgeeks.org/problems/prime-factors5052/1

package AdvanceMaths;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactors {
    public static void main(String[] args) {
        int n = 36;
        ArrayList<Integer> ans = primeFac(n);
        System.out.println(ans);
    }

    public static ArrayList<Integer> primeFac(int n) {
        // code here
        ArrayList<Integer> ls = new ArrayList<>();

        for(int i=2; i*i<=n; i++){
            if(n%i == 0){
                ls.add(i);

                while(n%i==0) n=n/i;
            }
        }

        if(n != 1) ls.add(n);
        return ls;
    }
}
