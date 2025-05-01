// https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=problem-list-v2&envId=binary-search

public boolean checkIfExist(int[] arr) {
        // BruteForce
        // for(int i=0; i<arr.length; i++){
        //     for(int j=0; j<arr.length; j++){
        //         if(i!=j && arr[i] == 2*arr[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        // Better
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i);
        }

        for(int j=0; j<arr.length; j++){
            int jnum = 2 * arr[j];

            if(map.containsKey(jnum) && map.get(jnum)!=j){
                return true;
            }
        }
        return false;
    }
