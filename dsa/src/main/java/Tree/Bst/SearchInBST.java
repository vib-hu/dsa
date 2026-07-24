package Tree.Bst;

import Tree.Node;

public class SearchInBST {


    public void search(Node root, int num){
        while(root!=null && root.val != num){
            System.out.print(root.val+",");
            root = root.val<num?root.right:root.left;
        }

        if(root==null)
            System.out.println(num + " not found");
        else
            System.out.println(num + " found");
    }

    public static void main(String[] args){
        SearchInBST search = new SearchInBST();
        search.search(Node.buildBST(5),15);
    }
}
