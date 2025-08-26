package Tricks;

public class CheckIBitSet {

    public static void main(String[] args) {
        int n = 13, i=2;

        // using left shift
        System.out.println( (n & (1<<i)) != 0 );

        // using right shift
        System.out.println( ((n>>i) & 1) != 0 );
    }
}
