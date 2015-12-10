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
		if(root == null)
			return root;
		if(root.left==null && root.right==null) {
			return root;
		}
		TreeNode tmp;
		tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if(root.left != null) {
			invertTree(root.left);
		}
		
		if(root.right != null) {
			invertTree(root.right);
		}
		return root;
	}
	public static void main(String[] args) {
		
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}