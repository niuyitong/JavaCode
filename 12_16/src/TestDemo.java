public class TestDemo {
    /*
    力扣 前序遍历：
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        System.out.print(root.val+" ");
        list.add(root.val);
        List<Integer> list1 = preorderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2 =preorderTraversal(root.right);
        list.addAll(list2);
        return list;
    }
}
*/
    /*
    力扣 中序遍历：
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        List<Integer> list1 = inorderTraversal(root.left);
        list.addAll(list1);

        System.out.print(root.val+" ");
        list.add(root.val);

        List<Integer> list2 =inorderTraversal(root.right);
        list.addAll(list2);
        return list;
    }
}

     */
    /*
    力扣 后序遍历：
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        List<Integer> list1 = postorderTraversal(root.left);
        list.addAll(list1);


        List<Integer> list2 =postorderTraversal(root.right);
        list.addAll(list2);


        System.out.print(root.val+" ");
        list.add(root.val);
        return list;
    }
}
     */
    /*
    力扣 判断是否是相同的树：
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
		//判断结构
        if(p == null && q != null  || p != null && q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
		//判断值
        if(p.val != q.val) {
            return false;
        }
        return
        isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
     */
    /*
    力扣 判断t是否是s的子树：
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q != null  || p != null && q == null) {
                return false;
            }
            if(p == null && q == null) {
                return true;
            }

            if(p.val != q.val) {
                return false;
            }
            return
                    isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s == null || t == null) {
                return false;
            }
            if(isSameTree(s,t)) return true;
            if(isSubtree(s.left,t)) return true;
            if(isSubtree(s.right,t)) return true;
            return false;
        }
*/
}
