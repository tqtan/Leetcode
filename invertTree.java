    # 声明临时结点，交换左右孩子，非空时分别递归左右孩子
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    public void invert(TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) invert(root.left);
        if (root.right != null) invert(root.right);
    }
