public class Solution {
    public int minDepth(TreeNode root) {
        //非递归方法,参照第三次作业讲解中彭正宇的思路
        if(root == null){
            return 0;
        }
        int depth = 1;
        List<TreeNode> onelevel = new ArrayList<TreeNode>();
        onelevel.add(root);
        while(onelevel.size()!=0){
            List<TreeNode> nextlevel = new ArrayList<TreeNode>();
            for(int i=0;i<onelevel.size();i++){
                TreeNode current = onelevel.get(i);
                if(current.left == null && current.right == null){
                    return depth;
                }
                if(current.left != null){
                    nextlevel.add(current.left);
                }
                if(current.right != null){
                    nextlevel.add(current.right);
                }
            }
            depth++;
            if(nextlevel.size() == 0){
                break;
            }else{
                onelevel=nextlevel;
            }
        }
        return depth;
    }
}