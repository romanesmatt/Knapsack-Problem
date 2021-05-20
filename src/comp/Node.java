package comp;

/**
 * This class represents each item in the tree that will be built for
 * tackling the knapsack problem using graph search techniques.
 *
 * For Parts 5 and 6 of the assignment.
 *
 * @author Matt Romanes
 */
public class Node{
    private int weight;
    private int value;
    private int s; //sapphire
    private int r; //ruby
    private int p; //pearl

    //Additional fields
    //Sapphire
    private int sValue = 10;
    private int sWeight = 50;
    //Ruby
    private int rValue = 5;
    private int rWeight = 30;
    //Pearl
    private int pValue = 7;
    private int pWeight = 40;

    //Fields that represent the children nodes
    Node left;
    Node right;
    Node middle;

    /**
     * The constructor for the comp.Node class.
     * @param s - sapphire
     * @param r - ruby
     * @param p - pearl
     */
    public Node(int s, int r, int p){
        this.s = s;
        this.r = r;
        this.p = p;

        //Computing weight
        this.value = (this.s * this.sValue) + (this.r * this.rValue) + (this.p * this.pValue);
        this.weight = (this.s * this.sWeight) + (this.r * this.rWeight) + (this.p * this.pWeight);
    }

    //Getter methods
    public int getWeight(){
        return this.weight;
    }

    public int getValue(){
        return this.value;
    }

    public int getS(){
        return this.s;
    }

    public int getR(){
        return this.r;
    }
    public int getP(){
        return this.p;
    }

    //Getter methods for the children nodes

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public Node getMiddle(){
        return this.middle;
    }

    //Setter methods for the children nodes
    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public void setMiddle(Node middle){
        this.middle = middle;
    }

    public String toString(){
        return this.s + " " + this.r + " " + this.p + " ";
    }


}