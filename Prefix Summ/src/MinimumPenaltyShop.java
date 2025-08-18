// https://leetcode.com/problems/minimum-penalty-for-a-shop/

public class MinimumPenaltyShop {
    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
    }

    public static int bestClosingTime(String customers) {
        // Prefix Suffix Approach
        // char[] c = customers.toCharArray();
        // int n = c.length;
        // int[] prefix = new int[n+1];
        // int[] suffix = new int[n+1];

        // for(int i=1; i<=n; i++){
        //     if(c[i-1] == 'N'){
        //         prefix[i] = prefix[i-1]+1;
        //     }
        //     else{
        //         prefix[i] = prefix[i-1];
        //     }
        // }

        // for(int i=n-1; i>=0; i--){
        //     if(c[i] == 'Y'){
        //         suffix[i] = suffix[i+1]+1;
        //     }
        //     else{
        //         suffix[i] = suffix[i+1];
        //     }
        // }

        // int minPenalty = Integer.MAX_VALUE;
        // int minHour = Integer.MAX_VALUE;
        // for(int i=0; i<=n; i++){
        //     int currPenalty = prefix[i]+suffix[i];

        //     if(currPenalty < minPenalty){
        //         minPenalty = currPenalty;
        //         minHour = i;
        //     }
        // }
        // return minHour;







        // OPTIMAL SPACE
        int countY = 0;
        // for(char c:customers.toCharArray()){
        //     if(c=='Y') countY++;
        // }

        // // int currPenalty = countY;
        int minPenalty = countY;
        int minHour = 0;

        for(int i=0; i<customers.length(); i++){
            if(customers.charAt(i)=='Y'){
                countY--;
            }
            else{
                countY++;
            }

            if(countY < minPenalty){
                minPenalty = countY;
                minHour = i+1;
            }
        }

        return minHour;
    }
}
