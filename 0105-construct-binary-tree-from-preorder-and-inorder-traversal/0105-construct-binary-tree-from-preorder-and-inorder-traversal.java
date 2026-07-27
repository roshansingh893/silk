/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int preIdx = 0; 

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return help(preorder, 0, preorder.length - 1);
    }

    public TreeNode help(int[] preorder, int start, int end) {
if(start < 0 || end > preorder.length || start > end) return null;   
        TreeNode node = new TreeNode(preorder[preIdx++]);
        int index = map.get(node.val);
        node.left = help(preorder, start, index - 1);
        node.right = help(preorder, index + 1, end);

        return node;
    }
}
