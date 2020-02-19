public class TestBinaryTree {
    static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public Node root = null;
    //插入节点
    public void insert(int key){
        Node node = new Node(key);
        if(root == null){
            root = node;
            return;
        }
        //1.//找叶子节点 即可以插入的节点
        Node cur = root;
        Node parent = null;
        while(cur!=null){
            if(cur.data<key){
                parent = cur;
                cur = cur.right;
            }else if(cur.data>key){
                parent = cur;
                cur = cur.left;
            }else{
                return;
            }
        }
        //2.开始插入
        if(parent.data>key){
            parent.left = node;
        }else{
            parent.right = node;
        }
    }
    //查找
    public Node search(int key){
        Node cur = root;
        while(cur!=null){
            if(cur.data==key){
                return cur;
            }else if(cur.data<key){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return null;
    }
    //删除关键字为key的节点
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.data == key) {
                //找到了要删除的节点
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }
    public void removeNode(Node parent,Node cur){
        if(cur.left==null){
            if(cur==root){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else{//cur == parent.right
                parent.right = cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else{//cur == parent.right
                parent.right = cur.left;
            }
        }else{//cur的左右都不为空 找左边的最大值，或者找右边的最小值
            //在右边找最小值
            Node targetParent = cur;//要删除节点的父亲节点（替罪羊的父亲
            //在右边找最小值
            Node target = cur.right;
            while(target.left!=null){
                targetParent = target;
                target = target.left;
            }
            cur.data = target.data;
            //target的左肯定是空的
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
    public void preOrder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

}
