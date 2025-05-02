package challenges.problem2;

import datastructures.BinaryTreeNode;

public class Problem2 {
    private static int maxProfit;
    public static int maxGamblingProfit(BinaryTreeNode root) {
        maxProfit = Integer.MIN_VALUE;
        dfs(root, 0);
        return Math.max(maxProfit, 0);
    }
    private static void dfs(BinaryTreeNode node, int currentSum) {
        if (node == null) return;

        currentSum += node.getValue();

        // Check for leaf node
        if (node.getLeft() == null && node.getRight() == null) {
            maxProfit = Math.max(maxProfit, currentSum);
            return;
        }

        dfs(node.getLeft(), currentSum);
        dfs(node.getRight(), currentSum);
    }

}
