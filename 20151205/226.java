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
    public TreeNode invertTree(TreeNode root) {
        //递归的方法：
        // TreeNode current = root;
        // if(root == null){
        //     return null;
        // }
        //     TreeNode temp = null;
        //     temp = current.left;
        //     current.left = current.right;
        //     current.right = temp;
        //     invertTree(current.left);
        //     invertTree(current.right);
        // return root;
        
        //非递归的方法
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(stack.size() != 0){
            TreeNode current = stack.pop();
            //System.out.println("current"+current.val);
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left != null){
                //System.out.println("current.left"+current.left.val);
                stack.push(current.left);
            }
            if(current.right != null){
                //System.out.println("current.right"+current.right.val);
                stack.push(current.right);
            }
        }
        return root;
        
    }
    
}