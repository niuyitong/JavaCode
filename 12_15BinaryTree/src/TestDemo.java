public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        int ret = binaryTree.getSize(root);
        System.out.println(ret);

        ret = binaryTree.getLeafSize(root);
        System.out.println(ret);

        ret =binaryTree.getKLevelSize(root,3);
        System.out.println(ret);

        TreeNode node = binaryTree.find(root,'u');
        System.out.println(node.value);

    }
}