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
    //对称的二叉树
    //迭代iteratively
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stackLeft = new Stack<TreeNode>();
        Stack<TreeNode> stackRight = new Stack<TreeNode>();
        stackLeft.push(root.left);
        stackRight.push(root.right);
        while(stackLeft.size()>0 && stackRight.size()>0){
            TreeNode currentLeft = stackLeft.pop();
            TreeNode currentRight = stackRight.pop();
            if(currentLeft == null && currentRight == null){
                //return true;
                continue;
            }else if(currentLeft == null || currentRight == null){
                return false;
            }else if(currentLeft.val != currentRight.val){
                return false;
            }else{
                stackLeft.push(currentLeft.left);
                stackLeft.push(currentLeft.right);
                stackRight.push(currentRight.right);
                stackRight.push(currentRight.left);
            }
        }
        return true;
    }
    
    
    // //递归recursively
    // public boolean isSymmetric(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }
    //     return isSymmetric(root.left,root.right);
    // }
    //     public boolean isSymmetric(TreeNode left,TreeNode right){
    //         if(left == null && right == null){
    //             return true; 
    //         }else if(left == null || right == null){
    //             return false;
    //         }else if(left.val != right.val){
    //             return false;
    //         }else{
    //             return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    //         } 
    //     }
}        
        
        
        
