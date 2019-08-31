    # 法一：中序遍历存为列表，将L~R中的数相加
    public int rangeSumBST(TreeNode root, int L, int R) {
        preorder(root);
        int i = 0;
        int res = 0;
        while (order.get(i) != L) i++;
        while (order.get(i) != R) res += order.get(i++);
        res += order.get(i);
        return res;
    }
    public void preorder(TreeNode root){
        if (root != null){
            preorder(root.left);
            order.add(root.val);
            preorder(root.right);
        }
    }
    
    # 法二：递归 root.val <= L,搜索右子树；root.val >= R，搜索左子树；L<root.val<R，搜索所有子树
    private int res;
    public int rangeSumBST(TreeNode root, int L, int R) {
        res = 0;
        sum(root,L,R);
        return res;
    }
    
    public void sum(TreeNode root, int L, int R){
        if (root != null){
            if (L <= root.val && root.val <= R)
                res += root.val;
            if (L < root.val) 
                sum(root.left, L, R); 
            if (root.val < R) 
                sum(root.right, L, R); 
        } 
    }
