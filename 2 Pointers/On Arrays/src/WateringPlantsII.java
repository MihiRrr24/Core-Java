// https://leetcode.com/problems/watering-plants-ii/description/

public class WateringPlantsII {
    public static void main(String[] args) {
        int[] plants = {2,2,3,3};
        int capacityA = 5, capacityB = 5;
        System.out.println(minimumRefill(plants, capacityA, capacityB));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int canA = capacityA, canB = capacityB;
        int refillA = 0, refillB = 0;
        int i=0, j=plants.length-1;

        while(i<j){
            // IF alice has less water
            if(canA < plants[i]){
                refillA++;             // Then refill
                canA = capacityA;      // Again can fills with initial amount of capacity after refill
            }
            // If Bob has less water
            if(canB < plants[j]){
                refillB++;
                canB = capacityB;
            }

            // In any case we have to water plants so capacity decreases
            canA -= plants[i];
            canB -= plants[j];
            i++;                // Move the pointers
            j--;
        }

        // If both of them are at same plant
        if(i==j){
            // This is cache we have to tell whether we have to refill or not
            // Not who will water the plants
            // And we have to refill only when both have remaining water less
            // than the plant coz both are at same plant so then we will refill

            if(canA<plants[i] && canB<plants[j]){ // i or j (any one)
                refillA++;  // both are equal having less water so no matter A or B
            }
        }

        return refillA+refillB;
    }
}
