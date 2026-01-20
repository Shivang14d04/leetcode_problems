/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        mapPrents(root, map);
        return bfs(target, map,k);

        
    }
    public void mapPrents(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                map.put(node.left, node);
            }

            if(node.right != null){
                q.offer(node.right);
                map.put(node.right, node);
            }
        }
    }

    public List<Integer> bfs(TreeNode target,Map<TreeNode, TreeNode> map, int k  ){
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currentLevel =0;

        while(!q.isEmpty()){
            int size = q.size();            
            if(currentLevel++ == k)break;
            for(int i = 0;i<size;i++){
            TreeNode node = q.poll();

            if(node.left != null && !visited.contains(node.left)){
                q.add(node.left);
                visited.add(node.left);
            }
            if(node.right != null && !visited.contains(node.right)){
                q.add(node.right);
                visited.add(node.right);
            }

            if(map.containsKey(node) && !visited.contains(map.get(node))){
                visited.add(map.get(node));
                q.add(map.get(node));
            }
            }

        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}