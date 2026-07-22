package Tree;

public class ChildrenSumTree {

    public void buildChildrenSumTree(Node root){
        if (root == null || (root.left == null && root.right == null))
            return; // leaf nodes are untouched

        int childSum = (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);

        if (childSum < root.val) {
            // Push the deficit down onto one child instead of overwriting both
            int diff = root.val - childSum;
            if (root.left != null) {
                root.left.val += diff;
            } else if (root.right != null) {
                root.right.val += diff;
            }
            // (If both are null we'd have returned already as a leaf.)
        } else {
            // Children already sum to more (or equal) — pull parent up
            root.val = childSum;
        }

        buildChildrenSumTree(root.left);
        buildChildrenSumTree(root.right);

        // Post-order fix-up: recompute now that children are finalized
        int leftVal = root.left != null ? root.left.val : 0;
        int rightVal = root.right != null ? root.right.val : 0;
        root.val = leftVal + rightVal;
    }

    public static void main(String[] args){
        ChildrenSumTree sumTree = new ChildrenSumTree();
        sumTree.buildChildrenSumTree(Node.buildTree(4));
    }
}
