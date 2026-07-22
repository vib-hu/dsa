package Tree;

import java.util.ArrayDeque;
import java.util.TreeMap;

record NodeAndPosition(Node node, int pos){}

public class TreeBottomView {
    // Using tree map for printing column-wise tree left to right
    TreeMap<Integer, Node> map = new TreeMap<>();

    public void bottomView(Node root){
        bfs(root);
        map.values().forEach(p->System.out.print(p.val+","));
    }

    private void bfs(Node root){
        if(root ==null)
            return;
        ArrayDeque<NodeAndPosition> queue = new ArrayDeque<>();
        queue.offer(new NodeAndPosition(root, 0));

        while(!queue.isEmpty()){
            NodeAndPosition nodePos = queue.poll();
            int pos = nodePos.pos();
            Node node = nodePos.node();

            map.put(pos, node);

            if(node.left!=null) queue.offer(new NodeAndPosition(node.left, pos-1));
            if(node.right!=null) queue.offer(new NodeAndPosition(node.right, pos+1));
        }
    }

    public static void main(String[] args){
        TreeBottomView bottomView = new TreeBottomView();
        bottomView.bottomView(Node.buildTree(4));
    }
}
