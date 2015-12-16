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
    //平衡二叉树：左右子树深度相差不超过1
    
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }
    //     int depthLeft = depth(root.left);
    //     int depthRight = depth(root.right);
    //     if(depthLeft-depthRight == -1 || depthLeft-depthRight == 0 || depthLeft-depthRight == 1){
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }
        // public int depth(TreeNode current){
        //     if(current == null){
        //         return 0;
        //     }
        //     TreeNode currentLeft = current.left;
        //     TreeNode currentRight = current.right;
        //     int depth = 1;
        //     while(currentLeft != null || currentRight != null){
        //         depth++;
        //         if(currentLeft != null){
        //             currentLeft = currentLeft.left; 
        //         }
        //         if(currentRight != null){
        //             currentRight = currentRight.right;
        //         }
                
        //     }
        //     return depth; 
        // }
       public boolean isBalanced(TreeNode root) {
           if(root == null){
               return true;
           }
           int depthLeft = depth(root.left);
           int depthRight = depth(root.right);
           if(Math.abs(depthLeft - depthRight) > 1){
               return false;
           }else{
               //根节点左右子树深度相差不超过1的同时，左右子树还要分别满足平衡二叉树
               return isBalanced(root.left)&&isBalanced(root.right);
           }
       } 
       
       public int depth(TreeNode current){
           if(current == null){
               return 0;
           }
           return Math.max(depth(current.left),depth(current.right))+1;
       }
        
        
        
    
}