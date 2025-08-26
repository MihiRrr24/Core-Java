package Tricks;

public class SetIBit {
    public static void main(String[] args) {
        int n = 9, i = 2;

        System.out.println(n | (1 << i));
    }
}
