    # 先根+中根构建二叉树 递归 O(n)
    # 每次找到根结点后，其左子树结点个数为i-inindex，则右子树所有开始位置即 原位置+左结点个数+1（根结点）
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return build(preorder,inorder,0,0,preorder.length);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int preindex, int inindex,int count){
        if (count < 1) return null;
        int r = preorder[preindex];
        int i = 0;
        while (r != inorder[i]) i++;
        TreeNode root = new TreeNode(r);
        root.left = build(preorder,inorder,preindex+1,inindex,i-inindex);
        root.right = build(preorder,inorder,preindex+1+i-inindex,i+1,count-i+inindex-1);
        return root;
    }
