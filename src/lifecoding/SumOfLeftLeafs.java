package lifecoding;

import newAlgorithms.trees.N104MaximumDepthOfBinaryTree;

public class SumOfLeftLeafs {
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

    public int countLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            return dfs(root, false);
        }

        private int dfs(TreeNode node, boolean isLeft) {
            if (node == null) return 0;

            // если это лист
            if (node.left == null && node.right == null) {
                return isLeft ? 1 : 0;
            }

            int left = dfs(node.left, true);
            int right = dfs(node.right, false);

            return left + right;
        }
    }
