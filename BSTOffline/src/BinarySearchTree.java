import java.util.Stack;

public class BinarySearchTree<Item extends Comparable<Item>> {
    private class Node {
        Item item;
        Node left;
        Node right;

        private Node(Item item) {
            this.item = item;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    public void searchItem(Item t) {
        Node node = search(t);
        System.out.println(t + " has " + (node == null ? "not " : " ") + "been found");
    }

    private Node search(Item t) {
        Node cur = root;
        while (cur != null) {
            int cmp = t.compareTo(cur.item);
            if (cmp < 0) cur = cur.left;
            else if (cmp > 0) cur = cur.right;
            else return cur;
        }
        return null;
    }

    public void insertItem(Item t) {
        if (t == null) throw new IllegalArgumentException("Null item passed to insertItem");
        root = insert(root, t);
    }

    private Node insert(Node cur, Item t) {
        if (cur == null) return new Node(t);
        int cmp = t.compareTo(cur.item);
        if (cmp < 0) cur.left = insert(cur.left, t);
        else if (cmp > 0) cur.right = insert(cur.right, t);
        else cur.item = t;
        return cur;
    }

    public Item getInOrderSuccessor(Item t) {
        if (t == null) throw new IllegalArgumentException("Null item passed to getInorderSuccessor");
        Node node = search(t);
        if (node == null) return null;
        if (node.right != null) return min(node.right).item;
        Node cur = root;
        Node successor = null;
        while (cur != null) {
            int cmp = t.compareTo(cur.item);
            if (cmp < 0) {
                successor = cur;
                cur = cur.left;
            } else if (cmp > 0) cur = cur.right;
            else break;
        }
        return successor != null ? successor.item : null;
    }

    private Node min(Node cur) {
        if (cur == null) return null;
        while (cur.left != null) cur = cur.left;
        return cur;
    }

    public Item getInOrderPredecessor(Item t) {
        if (t == null) throw new IllegalArgumentException("Null item passed to getInOrderPredecessor");
        Node node = search(t);
        if (node == null) return null;
        if (node.left != null) return max(node.left).item;
        Node cur = root;
        Node predecessor = null;
        while (cur != null) {
            int cmp = t.compareTo(cur.item);
            if (cmp < 0) cur = cur.left;
            else if (cmp > 0) {
                predecessor = cur;
                cur = cur.right;
            } else break;
        }
        return predecessor != null ? predecessor.item : null;
    }

    private Node max(Node cur) {
        if (cur == null) return null;
        while (cur.right != null) cur = cur.right;
        return cur;
    }

    private Node delMin(Node cur) {
        if (cur.left == null) return cur.right;
        cur.left = delMin(cur.left);
        return cur;
    }

    private Node delete(Node cur, Item t) {
        if (cur == null) return null; // if no such item, then do nothing
        int cmp = t.compareTo(cur.item);
        if (cmp < 0) cur.left = delete(cur.left, t);
        else if (cmp > 0) cur.right = delete(cur.right, t);
        else {
            if (cur.right == null) return cur.left; // if only one child on left, return that
            if (cur.left == null) return cur.right; // if only one child on right, return that
            Node temp = cur; // if two children
            cur = min(temp.right);
            cur.right = delMin(temp.right); // delete successor
            cur.left = temp.left;
        }
        return cur;
    }

    public void delete(Item t) {
        if (t == null) throw new IllegalArgumentException("Null item passed to delete");
        root = delete(root, t);
    }

    public int getItemDepth(Item t) {
        if (t == null) throw new IllegalArgumentException("Null item passed to getItemDepth");
        Node cur = root;
        int depth = 0;
        while (cur != null) {
            int cmp = t.compareTo(cur.item);
            if (cmp == 0) return depth;
            else if (cmp < 0) cur = cur.left;
            else cur = cur.right;
            depth++;
        }
        return -1;
    }

    public Item getMaxItem() {
        Node maxNode = max(root);
        return maxNode != null ? maxNode.item : null;
    }

    public Item getMinItem() {
        Node minNode = min(root);
        return minNode != null ? minNode.item : null;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node cur) {
        if (cur == null) return -1;
        int left = getHeight(cur.left);
        int right = getHeight(cur.right);
        if (left > right) return left + 1;
        return right + 1;
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node cur) {
//        if (cur == null) return;
//        printInOrder(cur.left);
//        System.out.print(cur.item + " ");
//        printInOrder(cur.right);
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.item + " ");
            cur = cur.right;
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node cur) {
        if (cur == null) return;
        System.out.print(cur.item + " ");
        printInOrder(cur.left);
        printInOrder(cur.right);
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node cur) {
        if (cur == null) return;
        printInOrder(cur.left);
        printInOrder(cur.right);
        System.out.print(cur.item + " ");
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node cur) {
        if (cur == null) return 0;
        return 1 + getSize(cur.left) + getSize(cur.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        bst.insertItem(9);
        bst.insertItem(10);
//        for(int i=1;i<=10;i++) bst.insertItem(i);
    }
}
