package Tree;

public class RecursiveTreeTraversals {

    public void preOrder(Node node){
        if(node == null)
            return;
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node == null)
            return;
        preOrder(node.left);
        System.out.print(node.val);
        preOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.val);
    }

    public static void main(String[] args){
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        RecursiveTreeTraversals traversals = new RecursiveTreeTraversals();
        traversals.preOrder(root);
        traversals.inOrder(root);
        traversals.postOrder(root);
    }
}
