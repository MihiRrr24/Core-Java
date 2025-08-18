// https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountain {
    /*
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakElement = peakIndex(mountainArr);
        int search = orderAgnostic(mountainArr, target, 0, peakElement);

        if(search != -1){
            return search;
        }
        else{
            return orderAgnostic(mountainArr, target, peakElement+1, mountainArr.length()-1);
        }
    }

    public int peakIndex(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length()-1;

        while(start < end){
            int mid = start+(end-start)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return end;
    }

    public int orderAgnostic(MountainArray mountainArr, int key, int start, int end){
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);

        while(start<=end){
            int mid = start+(end-start)/2;

            if(mountainArr.get(mid) == key){
                return mid;
            }

            if(isAsc){
                if(key > mountainArr.get(mid)){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }

            else{
                if(key > mountainArr.get(mid)){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }

        return -1;
    }
    */
}
