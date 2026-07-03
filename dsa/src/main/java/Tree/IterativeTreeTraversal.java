package Tree;

import java.util.ArrayDeque;

public class IterativeTreeTraversal {

    public void preorderTraversal(Node root){
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.val);
            System.out.print(",");

            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
    }

    public void inorderTraversal(Node root){
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node node = root;

        while(true){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            if(stack.isEmpty())
                break;

            Node curr = stack.pop();
            System.out.print(curr.val+",");
            node = curr.right;
        }
    }

    public static void main(String[] args){
        IterativeTreeTraversal traversal = new IterativeTreeTraversal();
        traversal.preorderTraversal(Node.buildTree(3));
        System.out.println("");
        traversal.inorderTraversal(Node.buildTree(3));
    }
}
