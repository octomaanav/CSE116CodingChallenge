import datastructures.BinaryTreeNode;
import datastructures.LinkedListNode;

public class Solutions {
    public static String decodePassword(String encodedPassword, int luckyNumber) {
        StringBuilder decoded = new StringBuilder();

        for (char c : encodedPassword.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int originalIndex = c - 'a';
                int shiftedIndex = (originalIndex + luckyNumber) % 26;

                // Handle negative wrap-around
                if (shiftedIndex < 0) {
                    shiftedIndex += 26;
                }

                char decodedChar = (char) ('a' + shiftedIndex);
                decoded.append(decodedChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

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

    public static boolean detectCycle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        // Step 1: Determine whether a cycle exists
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // Cycle detected
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static LinkedListNode findStartofCycle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Step 1: Determine whether a cycle exists
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                return slow;
            }
        }

        return null;
    }
}
