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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftDep = 0;
        int rightDep = 0;

        int depthOfLeft = getDepth(root.left, 1);
        int depthOfRight = getDepth(root.right, 1);
        
        if(Math.abs(depthOfRight-depthOfLeft) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getDepth(TreeNode root, int currentDep) {
        if(root == null)
            return currentDep;
        return Math.max(getDepth(root.left, currentDep+1),
                getDepth(root.right, currentDep+1));
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}