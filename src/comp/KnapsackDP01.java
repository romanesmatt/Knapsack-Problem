package comp;

/**
 * This class tackles the classic Knapsack Problem using Dynamic Programming.
 * Includes a main method which will act a test case for the algorithm
 * implemented in this class.
 *
 * For Part 2 of the assignment.
 *
 * @author Matt Romanes
 */
public class KnapsackDP01 {


    /**
     * Compares two given integers and returns the larger value integer.
     * @param a
     * @param b
     * @return larger value integer
     */
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }

    /**
     * The algorithm that tackles the 0-1 knapsack problem
     * using Dynamic Programing techniques.
     *
     * @param capacity - capacity of knapsack
     * @param weight - weight of item
     * @param value - value of item
     * @param n - length of array
     * @return maximum value that can be put in a knapsack of given capacity
     */
    public static void knapsackDP(int capacity, int weight[], int value[], int n){
        //Setting up barometer
        long start = System.nanoTime();
        int barometerCount = 0; //Variable used to count the number of operations

        int valTable[][] = new int[n + 1][capacity + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                //Make the first row and column cells equal to zero
                if(i == 0 || j == 0){
                    valTable[i][j] = 0;
                }
                //Check that weight does not exceed capacity
                else if(weight[i - 1] <= j){
                    barometerCount++;

                    //Take the max of the new value and the old value
                    valTable[i][j] = max(value[i - 1] + valTable[i -1][j - weight[i - 1]], (valTable[i - 1][j]));

                }else{
                    valTable[i][j] = valTable[i - 1][j];
                    barometerCount++;
                }
            }
        }

        long end = System.nanoTime();
        double totalTime = end - start;

        System.out.println(barometerCount + " operations performed.");
        System.out.println();
        System.out.println("Best value achieved: " + valTable[n][capacity]);
        System.out.println("Maximum expected complexity (n * capacity): " + n + " " +"*" + " "+ capacity);
        System.out.println("Actual complexity: " + n * capacity);
        System.out.println("Time taken to execute: " + totalTime + " nanoseconds.");
        System.out.println("==============================================");
    }



    public static void main(String[] args){
        //Test case generator
        int value[] = new int[] {70, 90,60, 120, 150, 40, 70, 50, 60, 30 };
        int weight[] = new int[] { 20, 60, 40,80, 20, 70, 30, 10, 50, 90};
        int capacity = 600;
        int n = value.length;

        knapsackDP(capacity, weight, value, n);
    }


}
