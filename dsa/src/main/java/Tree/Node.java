package Tree;

import java.util.ArrayDeque;

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

    public static Node buildTree(int level){
        int counter = 1;
        Node root = new Node(counter++);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int currentLevel = 1;
        while(currentLevel != level){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                node.left = new Node(counter++);
                node.right = new Node(counter++);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            currentLevel++;
        }
        return root;
    }
}
