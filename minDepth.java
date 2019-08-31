    # 注意！！在左/右子树有一个为空时，只能返回非空的深度，不能返回0
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right)+1;
        if (root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
