    # 若为叶子结点则加入列表，否则访问非空左孩子/右孩子；
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        paths(res,"",root);
        return res;
    }
    public void paths(List res,String path,TreeNode root){
        if (root != null){
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null)
                res.add(path);
            else{
                path += "->";
                if (root.left != null) paths(res,path,root.left);
                if (root.right != null) paths(res,path,root.right);
            }         
        }
    }
