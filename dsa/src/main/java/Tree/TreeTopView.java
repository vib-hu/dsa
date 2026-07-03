package Tree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

record NodePos(Node node, int pos){}

public class TreeTopView {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    TreeMap<Integer, int[]> map1 = new TreeMap<>();

    public void printTopViewWithBfs(Node root){
        bfs(root);
        map.values().forEach((a)-> System.out.print(a));
    }

    public void printTopViewWithBfsAndRecord(Node root){
        bfsWithRecord(root);
        map.values().forEach((a)-> System.out.print(a));
    }

    public void printTopViewWithDfs(Node root){
        dfs(root, 0, 0);
        map.values().forEach((a)-> System.out.print(a));
    }

    private void bfsWithRecord(Node root){
        ArrayDeque<NodePos> queue = new ArrayDeque<>();
        queue.offer(new NodePos(root, 0));

        while(!queue.isEmpty()){
            NodePos nodePos = queue.poll();
            Node node = nodePos.node();
            int pos = nodePos.pos();

            if(!map.containsKey(pos))
                map.put(pos, node.val);

            if(node.left != null) queue.offer(new NodePos(node.left, pos-1));
            if(node.right != null) queue.offer(new NodePos(node.right, pos+1));
        }
    }

    private void bfs(Node root){
        ArrayDeque<Map.Entry<Node, Integer>> queue = new ArrayDeque<>();
        queue.offer(Map.entry(root, 0));

        while(!queue.isEmpty()){
            Map.Entry<Node, Integer> curr = queue.poll();
            Node node = curr.getKey();
            int col = curr.getValue();

            map.putIfAbsent(col, node.val);

            if(node.left != null) queue.offer(Map.entry(node.left, col-1));
            if(node.right != null) queue.offer(Map.entry(node.right, col+1));
        }
    }

    private void dfs(Node node, int row, int col){
        if(node == null)
            return;

        if(!map1.containsKey(col) || row < map1.get(col)[0])
            map1.put(col, new int[] {row, node.val});

        dfs(node.left, row+1, col-1);
        dfs(node.right, row+1, col+1);
    }

    public static void main(String[] args){
        TreeTopView topView = new TreeTopView();
        topView.printTopViewWithBfs(Node.buildTree(3));
        System.out.println("");
        topView.printTopViewWithDfs(Node.buildTree(3));
        System.out.println("");
        topView.printTopViewWithBfsAndRecord(Node.buildTree(3));
    }
}
