package Tree;

public class Node {
    public Node left;
    public Node right;
    public int val;

    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val){
        this.val = val;
    }
}
