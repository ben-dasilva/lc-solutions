package training.wcontest.wc131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer[] tree) {
        Queue<TreeNode> level = new LinkedList<>();

        TreeNode root = new TreeNode(tree[0]);

        level.add(root);

        for (int i = 1; i < tree.length; i+=2) {
            TreeNode node = level.remove();
            if (tree[i] != null) {
                TreeNode left = new TreeNode(tree[i]);
                level.add(left);
                node.left = left;
            }
            if (i+1 < tree.length && tree[i+1] != null) {
                TreeNode right = new TreeNode(tree[i + 1]);
                level.add(right);
                node.right = right;
            }
        }

        return root;
    }

    public static TreeNode of(int[] tree, int root, int[] next) {
        if (root >= tree.length) return null;

        TreeNode rootNode = new TreeNode(tree[root]);
        next[0]++;
        rootNode.left  = of(tree, next[0], next);

        next[0]++;
        rootNode.right = of(tree, next[0], next);

        return rootNode;
    }

    @Override
    public String toString() {
        if (left == null && right == null) return "{ " + val + " }";

        return "{" +
                "" + val +
                ", l:" + left +
                ", r:" + right +
                "}";
    }
}

public class Solution_5017 {
    public int sumRootToLeaf(TreeNode root) {
        List<Long> toSum = new ArrayList<>();

        findLeaf(root, toSum, 0);

        long total = 0;

        for (Long i : toSum) {
            total += (i % 1000000007L);
            // System.out.printf("Adding [%10d] [%10d]...\n", i % 1000000007L, total % 1000000007L);
        }

        return (int) (total % 1000000007L);
        // return (int) (total % 1000000007);
    }

    private void findLeaf(TreeNode root, List<Long> sum, long leafInt) {
        long newInt = (leafInt << 1) | root.val;
        newInt %= 1000000007;
        boolean isLeaf = root.left == null && root.right == null;

        if (isLeaf) {
            // System.out.println("newInt = " + Long.toBinaryString(newInt));
            sum.add(newInt);
        } else {
            if (root.left  != null) findLeaf(root.left, sum, newInt);
            if (root.right != null) findLeaf(root.right, sum, newInt);
        }
    }
}
