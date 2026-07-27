/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
  StringBuilder sb = new StringBuilder();

public String serialize(TreeNode root) {
    if (root == null) {
        sb.append("null,");
        return sb.toString();
    }

    sb.append(root.val).append(",");
    serialize(root.left);
    serialize(root.right);

    return sb.toString();
}
    // Decodes your encoded data to tree.
     int idx = 0;

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;
        return helperDeserialize(arr);
    }

    private TreeNode helperDeserialize(String[] arr) {
        if (arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = helperDeserialize(arr);
        root.right = helperDeserialize(arr);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));