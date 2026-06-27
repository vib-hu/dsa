package Tree;
import java.util.*;

public class LevelOrderTraversal {

    public void queueBased(Node root){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.push(root);

        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                System.out.print("Value is "+node.val+" Level is "+level+" ");
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            level = level+1;
            System.out.println("");
        }
    }

    public static void main(String[] args){
        LevelOrderTraversal traversals = new LevelOrderTraversal();
        traversals.queueBased(Node.buildTree(4));
    }
}
