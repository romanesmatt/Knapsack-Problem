package comp;

import java.util.Comparator;

/**
 * This class will be used to compare two Node objects.
 *
 * For Part 5 of the assignment.
 *
 * @author Matt Romanes
 */
public class NodeComparator implements Comparator<Node>{


    public int compare(Node x, Node y){
        if(x.getValue() > y.getValue()){
            return 1;
        }else if(x.getValue() < y.getValue()){
            return -1;
        }
        return 0;
    }


}
