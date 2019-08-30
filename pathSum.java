    # 不一定以root开头 不一定以leaf结尾
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int path(TreeNode root, int sum){
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res++;
        res = res + path(root.left, sum-root.val) + path(root.right, sum-root.val);
        return res;
    }
