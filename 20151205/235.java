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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //最近的公有祖先
        //BST树是左小右大的
        
        //递归方法：
        // if(Math.min(p.val,q.val) > root.val){
        //     return lowestCommonAncestor(root.right,p,q);
        // }else if(Math.max(p.val,q.val) < root.val){
        //     return lowestCommonAncestor(root.left,p,q);
        // }else{
        //     return root;
        // }
        
        //非递归方法：
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode current = null;
        while(stack.size() != 0){
            current = stack.pop();
            if(Math.min(p.val,q.val) > current.val){
                stack.push(current.right);
            }else if(Math.max(p.val,q.val) < current.val){
                stack.push(current.left);
            }else{
                break;
            }
        }
        return current;
    }
}