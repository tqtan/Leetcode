    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<Integer>(list));
        } 
        if (root.left != null) pathSum(root.left,sum-root.val);
        if (root.right != null) pathSum(root.right,sum-root.val);
        list.remove(list.size()-1);
        return res;
    }
