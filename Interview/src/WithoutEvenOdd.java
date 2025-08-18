import java.util.Arrays;

public class WithoutEvenOdd {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};


        for(int i=0; i<arr.length; i+=2){
//            if(i%2!=0) continue;
            System.out.print(arr[i]+" ");
        }
    }
}
