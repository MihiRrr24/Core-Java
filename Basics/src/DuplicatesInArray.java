// FIND ALL THE DUPLICATES AND COUNT OF ALL DUPLICATES IN AN ARRAY


import java.util.*;

public class DuplicatesInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

//        HashMap<Integer, Integer> hash= new HashMap<>();          T.c and S.c = O(N)
//        for(int i=0; i<arr.length; i++){
//            arr[i] = in.nextInt();
//            hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
//        }
//
//        int count = 0;
//        for(int key: hash.keySet()){
//            if(hash.get(key) > 1){
//                System.out.print(key+" ");
//                count++;
//            }
//        }
//        System.out.println(count);


        //T>C = O(N2) and S.c = O(1)
        for(int i=0; i<n; i++){
            arr[i]=in.nextInt();
        }
        int count=0;
        for(int i =0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    System.out.print(arr[i]+" ");
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
