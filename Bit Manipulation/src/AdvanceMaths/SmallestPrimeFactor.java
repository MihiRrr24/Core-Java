// https://www.geeksforgeeks.org/problems/prime-factorization-using-sieve/0

package AdvanceMaths;

import java.util.ArrayList;
import java.util.List;

public class SmallestPrimeFactor {
    public static void main(String[] args) {
        int N = 12246;
        sieve();
        List<Integer> ans = findPrimeFactors(N);
        System.out.println(ans);
    }

    public static int N = 200000;
    public static int[] spf = new int[N+1];

    public static void sieve() {
        for (int i = 1; i <= N; i++){
            spf[i] = i;
        }

        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }

    public static List<Integer> findPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        while (n > 1) {
            factors.add(spf[n]);
            n /= spf[n];
        }
        return factors;
    }
}
