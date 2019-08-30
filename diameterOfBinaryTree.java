    # 类似求最大路径和
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }   
    public int depth(TreeNode root){
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(left+right, max);
        return Math.max(left,right)+1;
    }
