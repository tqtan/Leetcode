    # 符合条件的结点：左子树！=null，左子树的左右子树==null，则其左子树为左叶子结点
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null){
            if (root.left != null && root.left.left == null && root.left.right == null)  
                res = res + root.left.val;
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);    
        }
        return res;
    }
