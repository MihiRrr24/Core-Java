// https://leetcode.com/problems/first-bad-version/?envType=problem-list-v2&envId=binary-search

public class BadVersions {
    public static int firstBadVersion(int n) {
        int start = 1, end = n;

        while(start<end){
            int mid = start + (end-start)/2;

//            if(isBadVersion(mid)){
//                end = mid;
//            }
//            else{
//                start = mid+1;
//            }
        }
        return start;
    }
}
