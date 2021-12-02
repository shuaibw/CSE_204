import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        test1();
//        test2();
    }

    private static void test1() {
        System.out.println("-------------------Test 1----------------------");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] data = new int[]{20, 10, 30, 5, 15, 25, 31, 4, 6, 13, 14};
        for (int i : data) {
            bst.insertItem(i);
        }
        System.out.println("In order traversal: ");
        bst.printInOrder();
        System.out.println("Pre order traversal: ");
        bst.printPreOrder();
        System.out.println("Post order traversal: ");
        bst.printPostOrder();
        for (int i : data) {
            System.out.println(i + "->Successor: " + bst.getInOrderSuccessor(i) + ", Predecessor: " + bst.getInOrderPredecessor(i));
        }
        System.out.println(bst.getItemDepth(20));
        bst.delete(20);
        bst.delete(20);
        bst.delete(20);
        bst.printInOrder();
        bst.delete(30);
        bst.delete(30);
        bst.delete(30);
        bst.printInOrder();
        bst.delete(6);
        bst.delete(6);
        bst.delete(6);
        bst.printInOrder();
        System.out.println(bst.getSize());
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        for (int i = 0; i < 1000; i++) {
            bst2.insertItem(i);
        }
        System.out.println(bst2.getHeight());
    }

    private static void test2() {
        System.out.println("-------------------Test 2----------------------");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random(1);
        for (int i = 0; i < 250; i++) bst.insertItem(random.nextInt(700));
        bst.printInOrder();
        System.out.println(bst.getSize());
        for (int i = 0; i < 1000; i += 30 + random.nextInt(30)) {
            bst.searchItem(i);
        }
        for (int i = 0; i < 60; i++) {
            bst.searchItem(i);
            System.out.println("Successor: " + bst.getInOrderSuccessor(i) + ", Predecessor: " + bst.getInOrderPredecessor(i));
        }
    }
}
