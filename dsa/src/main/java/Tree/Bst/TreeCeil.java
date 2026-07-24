package Tree.Bst;

import Tree.Node;

public class TreeCeil {

    public Node getCeilV1(Node root, int nodeVal){
        Node res = null;
        while(root!=null){

            if(root.val >= nodeVal && (res == null || (res!=null && root.val<res.val)))
                res = root;

            if(root.val<nodeVal)
                root = root.right;
            else{
                root = root.left;
            }
        }
        return res;
    }

    public Node getCeilV2(Node root, int nodeVal){
        Node res = null;
        while(root!=null){

            if(root.val<nodeVal)
                root = root.right;
            else{
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public static Node buildSpecificTree(){
        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(13);

        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);

        root.left.right.right = new Node(9); // 6's right child, no left child

        root.right.left = new Node(11);
        root.right.right = new Node(14);

        return root;
    }

    public static void main(String[] args){
        TreeCeil ceil = new TreeCeil();
        System.out.println(ceil.getCeilV1(buildSpecificTree(), 8).val);
        System.out.println(ceil.getCeilV2(buildSpecificTree(), 8).val);
    }
}
