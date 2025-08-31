// https://leetcode.com/problems/xor-operation-in-an-array/

package Questions;

public class XORopinarr {

    public static void main(String[] args) {
        int n = 5, start = 0;
        System.out.println(xorOperation(n, start));
    }

    public static int xorOperation(int n, int start) {
        // int[] nums = new int[n];
        // int xor = 0;

        // for(int i=0; i<n; i++){
        //     nums[i] = start+2*i;
        //     xor ^= nums[i];
        // }

        // return xor;



        int xor = 0;
        for(int i=0; i<n; i++) xor ^= (start+2*i);
        return xor;
    }
}
