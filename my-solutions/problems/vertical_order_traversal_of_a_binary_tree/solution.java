/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
     TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();
     Queue<Pair> q = new LinkedList<>();
     q.offer(new Pair(root,0,0));
     while(!q.isEmpty()){
        Pair temp = q.poll();
        TreeNode node  = temp.node;
        int x = temp.vertical;
        int y = temp.level;
        nodes.putIfAbsent(x, new TreeMap<>());
        nodes.get(x).putIfAbsent(y, new PriorityQueue<>());
        nodes.get(x).get(y).offer(node.val);
        if(node.left != null){
            q.offer(new Pair(node.left, x-1, y+1));
        }
        if(node.right != null){
            q.offer(new Pair(node.right, x+1, y+1));
        }
     }  
     List<List<Integer>> result = new ArrayList<>();
     for(TreeMap<Integer, PriorityQueue<Integer>> values: nodes.values()){
        List<Integer> col = new ArrayList<>();
        for(PriorityQueue<Integer> ys: values.values()){
            while(!ys.isEmpty()){
                col.add(ys.poll());
            }
        }
        result.add(col);

     } 
     return result;
    }
}
class Pair{
    TreeNode node;
    int vertical;
    int level;
    Pair(TreeNode n , int v , int l){
        node = n;
        vertical = v;
        level = l;
    }
}