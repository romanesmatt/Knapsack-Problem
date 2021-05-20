package comp;

import java.util.ArrayList;

/**
 * This class tackles the 0-N Knapsack problem using brute force algorithm techniques.
 *
 * For Part 3 of the assignment.
 *
 * @author Matt Romanes
 */
public class KnapsackBF0N {

    private static int weightConstraint = randomNumberGenerator(3, 12);
    private static ArrayList<Integer> bestValues = new ArrayList<>();
    private static int bestValue = 0;
    private static ArrayList<Item> itemsUsed = new ArrayList<>(); //For items already 'visited'
    private static int numOfItems = 0;

    /**
     *
     * @param target
     * @param temporary
     * @param items
     * @param index
     * @param last
     * @param first
     */
    public static void knapsackBF(int target, int temporary[], Item items[], int index, int last, int first){
        if(index == target){
            int totalWeight = 0;
            int totalValue = 0;

            ArrayList<Integer> listOfItems = new ArrayList<>();

            for(int i = 0; i < target; i++){
                totalWeight += items[temporary[i]].weight;
                totalValue += items[temporary[i]].value;
                listOfItems.add(items[temporary[i]].getId());
            }

            if(totalWeight <= weightConstraint){
                if(totalValue > bestValue){
                    bestValue = totalValue;
                    bestValues = listOfItems;
                }
            }
            return;
        }

        for(int i = first; i <= last; i++){
            temporary[index] = i;
            int newIndex = index + 1;
            knapsackBF(target, temporary, items, newIndex, last, i);
        }

        return;
    }

    /**
     * The method that will run the test case generator for the Knapsack brute force algorithm.
     */
    public static void main(String[] args){
        long startTime = System.nanoTime();
        //executing the test process
        run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Time taken to execute in nanoseconds: " + duration + ".");
        System.out.println("Weight constraint: " + weightConstraint + ".");
        System.out.println("Number of items: " + numOfItems);
        System.out.println("Best value obtained: " + bestValue + ".");
        System.out.println("Items used in the best combination: ");
        for(int i: bestValues){
            System.out.println("Item: " + i + ".");
        }

        System.out.println("=============================================="); //separating the sections


        System.out.println("List of all items used: ");
        for(Item i: itemsUsed){
            System.out.println("Item ID: " + i.id + ". " + "Item weight: " + i.weight + ". " + "Item value: " + i.value + ".");
        }
    }



//============================================================================================
    //ADDITIONAL CLASSES AND METHODS
//============================================================================================

    /**
     * The test case generator for the knapsack brute force algorithm.
     * @param items
     * @param i
     * @param current
     */
    public static void knapsackRun(Item items[], int i, int current){
        int temporary[] = new int[current + 1];
        int index = 0;
        int last = 0;
        int j = i - 1;

        knapsackBF(current, temporary, items, index, last, j);
    }

    /**
     * Creates a new array of knapsack items, and calls the method that runs
     * the knapsack brute force algorithm and passes along the newly created array.
     */
    public static void run(){
        int numberOfItems= randomNumberGenerator(1, 9);

        Item items[] = createItems(numberOfItems);
        numOfItems = items.length;
        for(Item i: items){
            itemsUsed.add(i);
        }

        int num = items.length;

        for(int i = 0; i < items.length; i++){
            knapsackRun(items, num, i);
        }

    }


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
     * Creates a new array of knapsack items.
     * @param randomNumber
     * @return array of newly created knapsack items
     */
    public static Item[] createItems(int randomNumber){
        Item[] listOfItems = new Item[randomNumber];

        for(int i = 0; i < randomNumber; i++){
            int id = i;
            int weight = randomNumberGenerator(2, 5);
            int value = randomNumberGenerator(10, 50);

            Item newItem = new Item(id, weight, value);
            listOfItems[i] = newItem;
        }

        return listOfItems;
    }



    /**
     * This class represents every item that may or may not be included in the Knapsack.
     */
    private static class Item{
        int weight;
        int value;
        int id;

        public Item(int id, int weight, int value){
            this.weight = weight;
            this.id = id;
            this.value = value;
        }

        public int getId(){
            return this.id;
        }


    }



}
