package tests;

import datastructures.BinaryTreeNode;
import org.junit.Test;

import static challenges.Problem2.maxGamblingProfit;
import static org.junit.Assert.assertEquals;

public class TestProblem2 {
    @Test
    public void testBasicTree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeft(new BinaryTreeNode(3));
        root.setRight(new BinaryTreeNode(-4));
        root.getLeft().setLeft(new BinaryTreeNode(10));
        root.getLeft().setRight(new BinaryTreeNode(2));
        root.getRight().setRight(new BinaryTreeNode(1));

        assertEquals(18, maxGamblingProfit(root)); // 5 -> 3 -> 10
    }

    @Test
    public void testAllNegative() {
        BinaryTreeNode root = new BinaryTreeNode(-10);
        root.setLeft(new BinaryTreeNode(-5));
        root.setRight(new BinaryTreeNode(-20));

        assertEquals(0, maxGamblingProfit(root)); // No positive path
    }

    @Test
    public void testSingleNodePositive() {
        BinaryTreeNode root = new BinaryTreeNode(42);
        assertEquals(42, maxGamblingProfit(root));
    }

    @Test
    public void testSingleNodeNegative() {
        BinaryTreeNode root = new BinaryTreeNode(-5);
        assertEquals(0, maxGamblingProfit(root));
    }

    @Test
    public void testZeroValueLeafs() {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.setLeft(new BinaryTreeNode(0));
        root.setRight(new BinaryTreeNode(0));

        assertEquals(3, maxGamblingProfit(root)); // Both paths equal: 3 -> 0
    }

    @Test
    public void testDeepUnbalancedTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode deep = root;
        for (int i = 2; i <= 10; i++) {
            BinaryTreeNode next = new BinaryTreeNode(i);
            deep.setRight(next);
            deep = next;
        }
        // Path: 1 + 2 + ... + 10 = 55
        assertEquals(55, maxGamblingProfit(root));
    }
    @Test
    public void testMultipleMaxProfitPaths() {
        // Structure:
        //         10
        //        /  \
        //      5     5
        //     / \   / \
        //    4  3  3   4
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.setLeft(new BinaryTreeNode(5, new BinaryTreeNode(4), new BinaryTreeNode(3)));
        root.setRight(new BinaryTreeNode(5, new BinaryTreeNode(3), new BinaryTreeNode(4)));

        // All root-to-leaf paths = 10+5+4 = 19, 10+5+3 = 18, etc.
        assertEquals(19, maxGamblingProfit(root));
    }

    @Test
    public void testDeepPathWithNegativeTrap() {
        // Structure:
        //         5
        //        /
        //       10
        //      /
        //    -30
        //     \
        //     100
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode left1 = new BinaryTreeNode(10);
        BinaryTreeNode left2 = new BinaryTreeNode(-30);
        BinaryTreeNode leaf = new BinaryTreeNode(100);

        root.setLeft(left1);
        left1.setLeft(left2);
        left2.setRight(leaf);

        // Path = 5 + 10 - 30 + 100 = 85
        assertEquals(85, maxGamblingProfit(root));
    }

    @Test
    public void testZigZagPath() {
        // Structure:
        //        2
        //         \
        //          4
        //         /
        //        6
        //         \
        //          8
        BinaryTreeNode root = new BinaryTreeNode(2);
        BinaryTreeNode n1 = new BinaryTreeNode(4);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(8);

        root.setRight(n1);
        n1.setLeft(n2);
        n2.setRight(n3);

        // Path = 2 → 4 → 6 → 8 = 20
        assertEquals(20, maxGamblingProfit(root));
    }

    @Test
    public void testEarlyHighProfitButBadLeaf() {
        // Structure:
        //         10
        //        /  \
        //      100   5
        //         \
        //         -50
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode left = new BinaryTreeNode(100);
        BinaryTreeNode right = new BinaryTreeNode(5);
        BinaryTreeNode badLeaf = new BinaryTreeNode(-50);

        root.setLeft(left);
        root.setRight(right);
        right.setRight(badLeaf);

        // Paths:
        // 10 → 100 = 110
        // 10 → 5 → -50 = -35
        assertEquals(110, maxGamblingProfit(root));
    }

    @Test
    public void testBalancedNegativeSubtrees() {
        // Structure:
        //         0
        //        / \
        //      -1  -1
        //     /      \
        //   -2       -2
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode left = new BinaryTreeNode(-1, new BinaryTreeNode(-2), null);
        BinaryTreeNode right = new BinaryTreeNode(-1, null, new BinaryTreeNode(-2));
        root.setLeft(left);
        root.setRight(right);

        // All paths are negative
        assertEquals(0, maxGamblingProfit(root));
    }

    @Test
    public void testComplexTree() {
        BinaryTreeNode root = new BinaryTreeNode(-10);
        BinaryTreeNode left = new BinaryTreeNode(-5, new BinaryTreeNode(-3), new BinaryTreeNode(-4));
        BinaryTreeNode right = new BinaryTreeNode(-1, new BinaryTreeNode(100), new BinaryTreeNode(-20));
        BinaryTreeNode leftLeft = new BinaryTreeNode(-50, new BinaryTreeNode(-60), null);
        root.setLeft(left);
        left.setLeft(leftLeft);
        root.setRight(right);

        assertEquals(89, maxGamblingProfit(root)); // Path: -10 -> -5 -> -3 -> 100
    }

}
