package Tricks;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 13;

        // normal modulo approach
//        int cnt = 0;
//        while(n > 0){
//            if(n%2 == 1) cnt++;
//            n = n/2;
//        }



        // bit operations
//        int cnt = 0;
//        while(n > 0){
//            cnt += (n&1);
//            n = n>>1;
//        }



        // More optimized way SLIGHTLY
//        int cnt = 0;
//        while (n != 0){
//            n = n&(n-1);
//            cnt++;
//        }



        // One hand
        int cnt = Integer.bitCount(n);
        System.out.println(cnt);
    }
}
