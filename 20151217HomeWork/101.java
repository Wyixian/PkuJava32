/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*public class Solution {
//这种做法的基本思想是将所有节点都存在字符串s中，再将s反转得到sb，判断s是否和sb相等，但是这样做会产生错误，比如[1,1]会返回错误的结果true
    static String s = "";
    public boolean isSymmetric(TreeNode root) {
        medOrder(root);
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.equals(sb.toString());
    }
    public static void medOrder(TreeNode root) {
    	if(root == null) return;
    	medOrder(root.left);
    	s = s + root.val;
    	medOrder(root.right);
    }
}*/ 
/*public class Solution {
    static String s1 = "", s2 = "";
    public boolean isSymmetric(TreeNode root) {
    	lmrOrder(root);
        rmlOrder(root);
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }
    public static void lmrOrder(TreeNode root) {
    	if(root == null) return;
    	lmrOrder(root.left);
    	s1 = s1 + root.val;
    	lmrOrder(root.right);
    }
    public static void rmlOrder(TreeNode root) {
    	if(root == null) return;
    	rmlOrder(root.right);
    	s2 = s2 + root.val;
    	rmlOrder(root.left);
    }
}*/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val) return isSymmetric(left.left, right.right)
        		&& isSymmetric(left.right, right.left);
        return false;
    }
}
/*public class Solution {
    public boolean isSymmetricTree(TreeNode p,TreeNode q){
         if(p == null&&q == null)
            return true;
         if(p == null||q == null)
            return false;
         return (p.val == q.val) && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null) 
            return true;
            
        return isSymmetricTree(root.left,root.right);
    }
}*/