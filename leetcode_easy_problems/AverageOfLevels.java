
import java.util.*;

public class AverageOfLevels {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            queue.offer(root);

            while (!queue.isEmpty()) {
                int Levelsize = queue.size();
                double levelAverage = 0;
                for (int i = 0; i < Levelsize; i++) {
                    TreeNode current = queue.poll();
                    levelAverage += current.val;
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                levelAverage /= Levelsize;
                ans.add(levelAverage);
            }
            return ans;

        }
    }
}
