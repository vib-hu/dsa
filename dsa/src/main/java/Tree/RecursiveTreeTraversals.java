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
        inOrder(node.left);
        System.out.print(node.val);
        inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }

    public static void main(String[] args){

        RecursiveTreeTraversals traversals = new RecursiveTreeTraversals();
        traversals.preOrder(Node.buildTree(3));
        traversals.inOrder(Node.buildTree(3));
        traversals.postOrder(Node.buildTree(3));
    }
}
