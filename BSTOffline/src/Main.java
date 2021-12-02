import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Scanner scanner = new Scanner(System.in);
        String[] commands = new String[]{
                "1. Insert",
                "2. Search",
                "3. InOrderSuccessor",
                "4. InOrderPredecessor",
                "5. Delete item",
                "6. Item depth",
                "7. Max",
                "8. Min",
                "9. Height",
                "10. Traverse in order",
                "11. Traverse pre order",
                "12. Traverse post order",
                "13. Size"
        };
        while (true) {
            for (String s : commands) System.out.println("\u001b[38;5;11m" + s + "\u001b[0m");
            int cmd;
            try {
                cmd = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input");
                continue;
            }
            try {
                switch (cmd) {
                    case 1:
                        String input = scanner.nextLine();
                        for (String s : input.split(" ")) bst.insertItem(Integer.parseInt(s));
                        break;
                    case 2:
                        bst.searchItem(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println(bst.getInOrderSuccessor(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 4:
                        System.out.println(bst.getInOrderPredecessor(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 5:
                        bst.delete(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println(bst.getItemDepth(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 7:
                        System.out.println(bst.getMaxItem());
                        break;
                    case 8:
                        System.out.println(bst.getMinItem());
                        break;
                    case 9:
                        System.out.println(bst.getHeight());
                        break;
                    case 10:
                        bst.printInOrder();
                        break;
                    case 11:
                        bst.printPreOrder();
                        break;
                    case 12:
                        bst.printPostOrder();
                        break;
                    case 13:
                        System.out.println(bst.getSize());
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
