
import java.util.*;

public class BinaryTreeRightSideView {

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

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return list;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                // list.add(((LinkedList<TreeNode>) queue).getLast().val);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = queue.poll();

                    if (i == levelSize - 1) {
                        list.add(current.val);
                    }

                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }

            }
            return list;
        }
    }
}
