package AdvanceMaths;

public class JavaCount {
    public static void main(String[] args) {
        int n=484;
        System.out.println(count(n));
    }

    public static int count(int n){
//        int cnt =0;
//        while(n>0){
//            cnt++;
//            n/=10;
//        }
                // OR
        int cnt = (int) Math.log10(n)+1;
        return cnt;
    }
}
