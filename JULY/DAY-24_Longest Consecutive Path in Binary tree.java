/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    int max = 1;

    public int longestConsecutive(Node root) {
        if (root == null) return -1;

        dfs(root, root.data - 1, 0);

        return max == 1 ? -1 : max;
    }

    private void dfs(Node node, int parentValue, int length) {
        if (node == null) return;

        if (node.data == parentValue + 1) {
            length++;
        } else {
            length = 1;
        }

        max = Math.max(max, length);

        dfs(node.left, node.data, length);
        dfs(node.right, node.data, length);
    }
}
