// https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1

package Questions;

public class XORinrange {

    public static void main(String[] args) {
        int l = 4, r = 8;
        System.out.println(findXOR(l, r));
    }

    public static int getXOR(int x){
        if(x % 4 == 1) return 1;
        else if(x % 4 == 2) return x+1;
        else if(x % 4 == 3) return 0;

        return x;
    }

    public static int findXOR(int l, int r)
    {
        return getXOR(l-1) ^ getXOR(r);
    }
}
