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
    public List<Integer> inorderTraversal(TreeNode root) {
        //非递归中序遍历 
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> hash = new HashSet<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(stack.size() != 0){
            TreeNode node = stack.pop();
            if(hash.contains(node)){
                result.add(node.val);
                continue;
            }
            hash.add(node);
            if(node.right != null){
                stack.push(node.right);
                //stack.push(node);
            }
            stack.push(node);
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
    
    //超时的算法
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     //非递归中序遍历
    //     List<Integer> result = new ArrayList<Integer>();
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     if(root == null){
    //         return result;
    //     }
    //     stack.push(root);
    //     while(!stack.empty()){
    //         TreeNode current = stack.pop();
    //         if(current.left != null){
    //             stack.push(current);
    //             stack.push(current.left);
    //         }
    //         else {
    //             result.add(current.val);
    //             if(current.right != null){
    //                 stack.push(current.right);
    //             }
    //             else {
    //                 if(!stack.empty()){
    //                     current = stack.pop();
    //                     result.add(current.val);
    //                     if(current.right != null){
    //                         stack.push(current.right);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return result;
    // }
    
    //蠢哭了的算法
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     //非递归中序遍历
    //     List<Integer> result = new ArrayList<Integer>();
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     if(root == null){
    //         return result;
    //     }
    //     //List<TreeNode> onelevel = new ArrayList<TreeNode>();
    //     //onelevel.add(root);
    //     //while(onelevel.size() != 0){
    //         //List<TreeNode> nextlevel = new ArrayList<TreeNode>();
    //         //for(int i=0;i<onelevel.size();i++){
    //             //TreeNode current = onelevel.get(i);
    //         while(current != null){
    //             //该节点有左子树，继续遍历其左子树,且将该节点入栈
    //             if(current.left != null){
    //                 //nextlevel.add(current.left);
    //                 //onelevel = nextlevel;
    //                 stack.push(current);
    //                 current = current.left;
    //             }
    //             //该节点无左子树,则输出该节点
    //             if(current.left == null){
    //                 result.add(current.val);
    //                 //该节点有右子树，继续遍历其右子树
    //                 if(current.right != null){
    //                     //nextlevel.add(current.right);
    //                     //onelevel = nextlevel;
    //                     stack.push(current);
    //                     current = current.right;
    //                 }
    //                 //该节点无左子树也无右子树,输出该节点的父节点
    //                 if(current.right == null){
    //                     if(stack.size() == 0){
    //                         return result;
    //                     }else{
    //                         // result.add(stack.pop().val);
    //                         // if(stack.size() == 0){
    //                         //     return result;
    //                         // }else{
    //                         //     //向上父节点
    //                              TreeNode temp = stack.pop();
    //                              result.add(temp.val);
    //                         //     //向上父节点有右子树
    //                              current = temp;
    //                              if(current.right != null){
    //                         //         //nextlevel.add(current.right);
    //                         //         //onelevel = nextlevel;
    
    //                         //     }
    //                         // }
    //                     }
    //                 }
    //             }
    //         }
    //         //}
    //     //}
    //     return result;
    // }
}