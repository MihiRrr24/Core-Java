// https://leetcode.com/problems/kth-missing-positive-number/?envType=problem-list-v2&envId=binary-search

public int findKthPositive(int[] arr, int k) {
        // HashSet<Integer> set = new HashSet<>();

        // for(int num:arr){
        //     set.add(num);
        // }

        // int mis=1;
        // int pos=0;
        // while(pos<k){
        //     if(!set.contains(mis)){
        //     pos = pos+1;
        // }
        // mis = mis+1;
        // }
        // return mis-1;

        int left=0, right=arr.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            int mis = arr[mid] - (mid);

            if(mis<=k){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return left+k;
    }
