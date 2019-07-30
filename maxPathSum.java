    # 二叉树中的最大路径和  O(n)  O(logn)
    # 当前结点的最大路径和只有两种情况：当前结点+左右子树中路径和最大的一边、当前结点单独作为最终路劲的根结点（当前结点+左子树+右子树）
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return sum;
    }
    public int maxPath(TreeNode root){
        if (root == null) return 0;
        int maxleft = Math.max(maxPath(root.left),0);
        int maxright = Math.max(maxPath(root.right),0);
        sum = Math.max((root.val+maxleft+maxright),sum);
        return root.val+Math.max(maxleft,maxright);
    }
