/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //对于树的遍历问题还未掌握，因此该方法是参照大神的！！！
        //二叉树的遍历方式有两种：递归和非递归，本题也有两种解法。
        //计算二叉树的深度，简单的前序遍历即可。
        int depth = 0;
        if(root != null){
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            depth++;
            if(leftDepth > rightDepth){
                depth += leftDepth;
            }else{
                depth += rightDepth;
            }
        }
        // if(leftDepth > rightDepth){
        //     depth += leftDepth;
        // }else{
        //     depth += rightDepth;
        // }
        return depth;
    }
}