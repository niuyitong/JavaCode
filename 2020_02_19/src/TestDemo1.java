public class TestDemo1 {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        testBinaryTree.insert(10);
        testBinaryTree.insert(8);
        testBinaryTree.insert(12);
        testBinaryTree.insert(5);
        testBinaryTree.insert(9);
        testBinaryTree.insert(7);
        testBinaryTree.insert(15);

        testBinaryTree.inOrder(testBinaryTree.root);
        System.out.println();
        testBinaryTree.preOrder(testBinaryTree.root);
        System.out.println("");
        testBinaryTree.remove(9);
        testBinaryTree.inOrder(testBinaryTree.root);
        System.out.println();
        testBinaryTree.preOrder(testBinaryTree.root);
    }
}
