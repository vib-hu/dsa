package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TreeLeftSideView {

    public void leftSideView(Node root){
        List<Node> result = bfs(root);
        result.forEach(p->System.out.println(p.val));
    }

    public List<Node> bfs(Node root){
        if(root==null)
            return List.of();

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Node> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(i==0)
                    result.add(node);
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeLeftSideView bottomView = new TreeLeftSideView();
        bottomView.leftSideView(Node.buildTree(4));
    }
}
