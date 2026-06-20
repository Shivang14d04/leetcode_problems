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
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int v = p.vertical;
            int l = p.level;
            map.putIfAbsent(v, new TreeMap<>());
            map.get(v).putIfAbsent(l, new PriorityQueue<>());
            map.get(v).get(l).offer(node.val);
            if (node.left != null) {
                q.offer(new Pair(node.left, v - 1, l + 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, v + 1, l + 1));
            }
        }
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            List<Integer> col = new ArrayList<>();

            for (PriorityQueue<Integer> pq : entry.getValue().values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }

            ans.add(col);
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int vertical;
    int level;

    Pair(TreeNode n, int v, int l) {
        this.node = n;
        this.vertical = v;
        this.level = l;
    }
}