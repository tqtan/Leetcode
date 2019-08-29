    # 在最大深度题上每次递归时判断左右子树的差值是否>1
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;
    }
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left,right)+1;
    }
