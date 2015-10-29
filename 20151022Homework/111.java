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
    //sollution 1
    /*public int minDepth(TreeNode root) {
        return minDep(root, 0);
    }
    public int minDep(TreeNode root, int curDep) {
        if(root == null) return curDep;
        curDep++;
        if(root.left != null && root.right != null)     //�������������Ϊ��
            return Math.min(minDep(root.left, curDep), minDep(root.right, curDep));
        if(root.left != null) return minDep(root.left, curDep);     //�����������Ϊ�գ�������Ϊ��
        return minDep(root.right, curDep);      //�����������Ϊ�գ�������Ϊ��
    }*/
    //sollution 2
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        if(root.left != null) return minDepth(root.left) + 1;
        return minDepth(root.right) + 1;
    }
}