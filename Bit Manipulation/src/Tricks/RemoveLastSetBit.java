package Tricks;

public class RemoveLastSetBit {
    public static void main(String[] args) {
        int n = 12;

        System.out.println(n & (n-1));
    }
}
