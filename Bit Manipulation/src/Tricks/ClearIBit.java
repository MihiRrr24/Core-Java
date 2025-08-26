package Tricks;

public class ClearIBit {
    public static void main(String[] args) {
        int n = 13, i = 2;
        System.out.println(n & ~(1<<i));
    }
}
