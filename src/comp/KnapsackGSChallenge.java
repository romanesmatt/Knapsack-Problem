package comp;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class KnapsackGSChallenge {

    private static Node root;
    private static int capacity = 100; //capacity of the knapsack
    private static int bestValue;
    private static int bestWeight;
    private static String best;

    /**
     * Builds the tree that the algorithm will be executed on.
     * @param n - the node that the tree will be built upon.
     */
    public static void buildTree(Node n){
        //Checks if the given node exceeds the knapsack's capacity
        if(n.getWeight() >= capacity){
//            System.out.println(n.getWeight()); //for debugging
        }else{
            //Creating the children's nodes
            Node left = new Node(n.getS() + 1, n.getR(), n.getP());
            Node right = new Node(n.getS(), n.getR() + 1, n.getP());
            Node middle = new Node(n.getS(), n.getR(), n.getP() + 1);

            //Setting the children of the child nodes
            n.setLeft(left);
            n.setRight(right);
            n.setMiddle(middle);

            //Calling the method recursively
            buildTree(left);
            buildTree(right);
            buildTree(middle);

        }

    }

    /**
     * The implementation of the algorithm that tackles the
     * knapsack problem using graph search techniques.
     * @param root - the root node
     */
    public static void knapsackGSChallenge(Node root){

        NodeComparator nodeComparator = new NodeComparator();

        Queue<Node> nodeQueue = new PriorityQueue<>(1000, nodeComparator);
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            //Extracting node from queue for examination
            Node temporaryNode = nodeQueue.poll();

            if(temporaryNode.getWeight() > capacity){
                temporaryNode = null;
            }

            if(temporaryNode != null){
//                System.out.println(temporaryNode.getWeight()); //for debugging

                if(temporaryNode.getWeight() < capacity && temporaryNode.getValue() > bestValue){
                    bestWeight = temporaryNode.getWeight();
                    bestValue = temporaryNode.getValue();
                    best = temporaryNode.toString();
                }

                //Adding the children to the node
                if(temporaryNode.getLeft() != null){
                    nodeQueue.add(temporaryNode.getLeft());

                }

                if(temporaryNode.getMiddle() != null){
                    nodeQueue.add(temporaryNode.getMiddle());

                }

                if(temporaryNode.getRight() != null){
                    nodeQueue.add(temporaryNode.getRight());

                }


            }

        }

    }

    /**
     * Runs the test case generator for the algorithm in this class.
     */
    public static void main(String[] args){
        Node rootNode = new Node(0, 0, 0);
        root = rootNode;
        buildTree(rootNode);

        long start = System.nanoTime();
        knapsackGSChallenge(rootNode);
        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Time taken to execute: " + duration + " nanoseconds.");
        System.out.println("Best combination: " + best);
        System.out.println("Best value: " + bestValue);
        System.out.println("Best weight: " + bestWeight);

    }

}
