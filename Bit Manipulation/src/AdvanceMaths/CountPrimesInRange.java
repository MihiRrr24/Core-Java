// https://www.geeksforgeeks.org/problems/count-primes-in-range1604/1

package AdvanceMaths;

public class CountPrimesInRange {
    public static void main(String[] args) {
        int l = 1, r = 10;
        System.out.println(countPrimes(l, r));
    }

    public static int countPrimes(int L, int R) {
        // naive
//        int[] prime = getSieve(R);
//
//        int cnt = 0;
//        for(int i=L; i<=R; i++){
//            if(prime[i] == 1) cnt++;
//        }
//        return cnt;





        // OPTIMAL
        int[] prime = getSieve(R);
        int cnt = 0;

        for(int i=2; i<=R; i++){
            cnt += prime[i];
            prime[i] = cnt;
        }

        if(L < 2) L=2;                  // safety check just as 0 and 1 are not prime
        return prime[R] - prime[L-1];
    }

    public static int[] getSieve(int n) {
        int[] prime = new int[n+1];

        for(int i=2; i<=n; i++){
            prime[i] = 1;
        }

        for(int i=2; i*i<=n; i++){
            if(prime[i] == 1){
                for(int j=i*i; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }

        return prime;
    }
}
