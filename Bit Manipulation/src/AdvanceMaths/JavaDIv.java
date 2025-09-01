package AdvanceMaths;

public class JavaDIv {
    public static void main(String[] args) {
        int n = 36;
        divisions(n);
    }

    public static void divisions(int n){
        /* NOOB APPROACH */
//        for(int i=1; i<=n; i++){
//            if(n%i==0){
//                System.out.print(i+" ");
//            }
//        }

        /* MODIFIED APPROACH */
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0) {
                System.out.print(i + " ");
                if (i != (n/i)) {
                    System.out.print((n / i) + " ");
                }
            }
        }
    }

    /* STORING ARRAYLIST TO STORE ELEMENTS  NINJAS
    public static List< Integer > printDivisors(int n) {
        ArrayList<Integer> ls = new ArrayList<>();

        for(int i=1; i*i<=n; i++){
            if(n%i==0) {
                ls.add(i);
                if (i != (n/i)) {
                    ls.add(n / i);
                }
            }
        }

        Collections.sort(ls);
        return ls;
    } */
}
