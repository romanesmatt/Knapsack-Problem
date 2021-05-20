package comp;

/**
 * This class tackles the 0N knapsack problem using dynamic programming techniques.
 *
 * For Part 3 of the assignment.
 *
 * @author Matt Romanes
 */
public class KnapsackDP0N {

    /**
     * Runs the test case generator for the knapsack algorithm in this class.
     * @param args
     */
    public static void main(String args[]){
        //Test case generator
        int value[] = new int[] {70, 30, 50, 40, 50, 50};
        int weight[] = new int[] {20, 70, 40, 60, 50, 30};
        int capacity = 50;
        int n = value.length;

        knapsackDP0N(capacity, weight, value, n);
    }

    /**
     *
     * @param capacity
     * @param weights
     * @param values
     * @param length
     */
    public static void knapsackDP0N(int capacity, int weights[], int values[], int length){
        //Setting up barometer
        long start = System.nanoTime();
        int barometerCount = 0; //Variable used to count the number of operations

        //Creating 2D array
        int valTable[][] = new int[length + 1][capacity + 1];

        for(int i = 0; i <= length; i++){
            for(int j = 0; j <= capacity; j++){
                //Make the first row and column cells equal to zero
                if(i == 0 || j == 0){
                    valTable[i][j] = 0;
                }
                //Check that weight does not exceed capacity
                else if(weights[i - 1] <= j){
                    barometerCount++;

                    //Take the max of the new value and the old value
                    valTable[i][j] = max(values[i - 1] + valTable[i -1][j - weights[i - 1]], (valTable[i][j]));

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
        System.out.println("Best value achieved: " + valTable[length][capacity]);
        System.out.println("Maximum expected complexity (n * capacity): " + length + " " +"*" + " "+ capacity);
        System.out.println("Actual complexity: " + length * capacity);
        System.out.println("Time taken to execute: " + totalTime + " nanoseconds.");
        System.out.println("==============================================");

    }

    //============================================================================================
    //ADDITIONAL METHODS
    //============================================================================================

    /**
     * Takes two integer parameters and returns a random number
     * by taking the multiplying the minimum by a binary number (0 or 1)
     * and adding to it by maximum.
     * @param minimum
     * @param maximum
     * @return random number
     */
    public static int randomNumberGenerator(int minimum, int maximum){
        return (int) (minimum * Math.random() + maximum);
    }

    /**
     * Compares two given integers and returns the larger value integer.
     * @param a
     * @param b
     * @return larger value integer
     */
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }

}
